package org.wbl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

//Identify testcases column by scanning the entire 1st row
//one column is identified then scan entire testcase column to identify purchase testcase row
//after you grap purchase row pull all the data for that row and feed into test
public class DataDriven1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\ganu1\\Documents\\Demodata.xlsx");

//XSSWorkbook access file input stream as argument

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheets = workbook.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {

                XSSFSheet sheet = workbook.getSheetAt(i);//sheet is collection of rows
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();//row is nothing but collection of cells
                int k = 0;
                int column = 0;
                //hasNext will tell that next cell is present or not

                while (ce.hasNext()) {
                    Cell value = ce.next();//Testcases
                    value.getStringCellValue().equalsIgnoreCase("Data1");//here Data1 is not equal to testcases
                    {
                        //desired column value
                        column = k;//first index


                    }
                    k++;
                }
                System.out.println(column);
            }
        }
    }}