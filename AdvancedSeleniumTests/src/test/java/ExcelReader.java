import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/data/data.xlsx"));
        //read the file as an excel
        Workbook excelDataFile = new XSSFWorkbook(fileInputStream);
        //choose first sheet and first row
        Sheet sheet = excelDataFile.getSheetAt(0);
        Row row = sheet.getRow(0);
        System.out.println(row.getCell(1).getStringCellValue());
    }
}
