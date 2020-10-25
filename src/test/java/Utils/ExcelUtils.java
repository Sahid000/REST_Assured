package Utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    public void getRowCount(){

        try {
        String excelPath = "./data/TestData.xlsx";

            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
}
