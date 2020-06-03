package helpers;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {

   private String excelPath;
   private Workbook excelDataFile;

    public ExcelReader(String excelPath) throws IOException {
        this.excelPath = excelPath;
        FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
        //read the file as an excel
        this.excelDataFile = new XSSFWorkbook(fileInputStream);

    }
     public Sheet getSheetByName(String sheetName){
        return excelDataFile.getSheet(sheetName);
     }
}