package com.stockinvest.excel;
/*
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
*/
public class ExcelReader {
/*
    public static void main(String[] args) {
        try {
            InputStream excelFile = ExcelReader.class.getClassLoader().getResourceAsStream("nas-27.06.18.xlsx");
            //FileInputStream excelFile = new FileInputStream(new File());
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        if (HSSFDateUtil.isCellDateFormatted(currentCell)) {
                            System.out.print(currentCell.getDateCellValue()+"--");
                        } else {
                            System.out.print(currentCell.getNumericCellValue() + "--");
                        }
                    }


                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    */
}
