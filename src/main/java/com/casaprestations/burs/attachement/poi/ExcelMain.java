package com.casaprestations.burs.attachement.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casaprestations.burs.attachement.metier.calcul.BalayageBean;
import com.casaprestations.burs.attachement.metier.calcul.IBalayageMecaniseMetier;
import com.casaprestations.burs.attachement.metier.calcul.MethodsForMetier;
import com.casaprestations.burs.attachement.metier.calcul.SumBean;

@Service
public class ExcelMain {
	@Autowired
	MethodsForMetier methodsForMetier;
	@Autowired
	IBalayageMecaniseMetier balayageMecaniseMetier;

	public void generateExcel(String dateString) {

		System.out.println(dateString);
		// Date date=methodsForMetier.parseStringToDate(dateString);
		List<BalayageBean> balayages = balayageMecaniseMetier.findBalayagesOfSitaByYearAndMonth(dateString);
		List<SumBean> sumBeans = balayageMecaniseMetier.getSumOfBalayagesBySita(dateString);
		List<Integer> tabDaysOfMonth = balayageMecaniseMetier.getTabDaysMonth(dateString);
		Integer daysOfMonth = tabDaysOfMonth.size();
		Random generator = new Random();
		int choice = generator.nextInt(100) + 1;

		FileOutputStream out;
		try {
			out = new FileOutputStream("D:\\wijdane" + choice + ".xls");
			Workbook wb = new HSSFWorkbook();
			Sheet mySheet = wb.createSheet();

			// Inserer les jours du mois+ une partie fusionnée:Vehicules / Jours
			Row rowOfDate = mySheet.createRow(4);
			rowOfDate.createCell(0).setCellValue("Vehicules / Jours");
			mySheet.addMergedRegion(new CellRangeAddress(4, 5, 0, 3));
			insertDaysOfMonth(tabDaysOfMonth,rowOfDate, mySheet);
			
			// Inserer les vehicule + affectation + type + km Captés+ balayages 
			
			wb.write(out);
			out.close();
		}catch(

	FileNotFoundException e)

	{
		e.printStackTrace();
	} catch(

	IOException e)

	{
		e.printStackTrace();
	}
}

	private void insertSumAndBalayagesCapte(Sheet mySheet,List<BalayageBean> bals, SumBean sumS3300, Integer numRow) {
		Row rowOfSum = mySheet.createRow(numRow);
		rowOfSum.createCell(0).setCellValue(sumS3300.getNomVehicule());
		rowOfSum.createCell(1).setCellValue(sumS3300.getType());
		rowOfSum.createCell(2).setCellValue(sumS3300.getAffectation());
		rowOfSum.createCell(3).setCellValue(sumS3300.getSumKmCapte());
		Integer cellOfRow = 4;
		for (BalayageBean bal : bals) {
			//rowOfSum.createCell(cellOfRow).setCellValue(bal.getKmCapte());
			cellOfRow++;
		}
	}

	private SumBean getSumOfEachVehicuel(HashSet<SumBean> sumBeans, String nomV) {
		SumBean sumB=new SumBean();
		for(SumBean sum: sumBeans){
			if (sum.getNomVehicule().equals(nomV)) {
				sumB=sum;
			}
		}
		return sumB;
	}
	
	private void insertDaysOfMonth(List<Integer> tabDaysOfMonth,Row rowOfDate , Sheet mySheet) {
		Integer cellOfDate = 4;
		for (Integer day : tabDaysOfMonth) {
			rowOfDate.createCell(cellOfDate).setCellValue(day);
			cellOfDate++;
		}
	}
	
	private void insertRowOfBalayagesTotal(List<BalayageBean> balayages,Integer numRow,  Sheet mySheet) {
		Row row = mySheet.createRow(numRow);
		Integer cellOfRow5 = 4;
		for (BalayageBean bal : balayages) {
			//row.createCell(cellOfRow5).setCellValue(bal.getKmCapte());
			cellOfRow5++;
		}
	}

	private List<BalayageBean> getBalayagesOfVehicule(List<BalayageBean> balayages, String nomVehicule) {
		List<BalayageBean> balOfThisVehicule=new ArrayList<BalayageBean>();
		for (BalayageBean balayageBean : balayages) {
			if (balayageBean.getNomVehicule().equals(nomVehicule)) {
				balOfThisVehicule.add(balayageBean);
			}
		}
		return balOfThisVehicule;
	}

}
