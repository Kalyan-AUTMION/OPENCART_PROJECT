package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException 
    {
        String excelPath = ".\\testData\\Opencart_Logindata.xlsx";  // Path to the Excel file
        String sheetName = "Sheet1";  // Ensure the sheet name is correct
        
        ExcelUtility excelUtil = new ExcelUtility(excelPath);
        
        int rowCount = excelUtil.getRowCount(sheetName);
        int cellCount = excelUtil.getCellCount(sheetName, 0);  // Assuming all rows have the same number of columns

        Object[][] logindata = new Object[rowCount][cellCount];
        
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                logindata[i][j] = excelUtil.getCellData(sheetName, i + 1, j); // Read data from the Excel sheet
            }
        }
        return logindata;
    }
}
