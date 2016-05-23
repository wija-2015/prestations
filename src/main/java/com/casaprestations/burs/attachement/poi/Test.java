/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casaprestations.burs.attachement.poi;
 
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
 
/**
 * Exemple de création d'un document Excel Simple en java
 * @author mesexemples.com
 */
public class Test
{
    public static void main(String []args)throws Exception
    {
        // créer un nouveau fichier excel
        FileOutputStream out = new FileOutputStream("D:\\wij.xls");
        // créer un classeur
        Workbook wb = new HSSFWorkbook();
        // créer une feuille
        Sheet mySheet = wb.createSheet();
 
        // créer une ligne de à l'index 2 dans la feuille Excel
        Row myRow = null;      
        myRow = mySheet.createRow(0);
 
        // Ajouter des données dans les cellules
        myRow.createCell(0).setCellValue("Java Execl");
        myRow.createCell(1).setCellValue("Mesexemple.com");
        myRow.createCell(2).setCellValue("Sakoba Adams");
 
        wb.write(out);
 
        out.close();
    }
}