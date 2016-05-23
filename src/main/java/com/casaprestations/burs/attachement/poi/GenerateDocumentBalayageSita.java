package com.casaprestations.burs.attachement.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casaprestations.burs.attachement.metier.calcul.BalayageBean;
import com.casaprestations.burs.attachement.metier.calcul.IBalayageMecaniseMetier;
import com.casaprestations.burs.attachement.metier.calcul.KmDataBean;
import com.casaprestations.burs.attachement.metier.calcul.MethodsForMetier;
import com.casaprestations.burs.attachement.metier.calcul.SumBean;

@Service
public class GenerateDocumentBalayageSita {
	@Autowired
	MethodsForMetier methodsForMetier;
	@Autowired
	IBalayageMecaniseMetier balayageMecaniseMetier;
	@Autowired
	MethodsForPoi methodsForPoi;

	public void generateExcel(String dateString) {

		System.out.println(dateString);
		// Date date=methodsForMetier.parseStringToDate(dateString);
		List<BalayageBean> balayageBeans = balayageMecaniseMetier.findBalayagesOfSitaByYearAndMonth(dateString);
		List<SumBean> sumBeans = balayageMecaniseMetier.getSumOfBalayagesBySita(dateString);
		List<Integer> tabDaysOfMonth = balayageMecaniseMetier.getTabDaysMonth(dateString);
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
			methodsForPoi.insertDaysOfMonth(tabDaysOfMonth, rowOfDate, mySheet);

			// Inserer les vehicule + affectation + type + km Captés+ balayages
			List<VehiculeDataBeanForPoi> vehiculesDatas = methodsForPoi.getVehiculesDatas(balayageBeans, sumBeans);
			methodsForPoi.insertSumAndBalayagesCapte(mySheet, vehiculesDatas);

			// Inserer les jours du mois+ une partie fusionnée:Vehicules / Jours
			Row rowOfDate2 = mySheet.createRow(4);
			rowOfDate2.createCell(0).setCellValue("Vehicules / Jours");
			mySheet.addMergedRegion(new CellRangeAddress(4, 5, 0, 3));
			methodsForPoi.insertDaysOfMonth(tabDaysOfMonth, rowOfDate2, mySheet);

			// Inserer les vehicule + affectation + type + km Captés+ balayages
			List<VehiculeDataBeanForPoi> vehiculesDatas = methodsForPoi.getVehiculesDatas(balayageBeans, sumBeans);
			methodsForPoi.insertSumAndBalayagesCapte(mySheet, vehiculesDatas);

			wb.write(out);
			out.close();
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			e.printStackTrace();
		}
	}
}
