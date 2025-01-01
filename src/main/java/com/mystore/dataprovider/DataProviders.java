package com.mystore.dataprovider;

import com.mystore.utility.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataProviders {

    ExcelLibrary excelLibrary = new ExcelLibrary();

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        // Totals rows count
        int rows = excelLibrary.getRowCount("Credentials");
        // Total Columns
        int column = excelLibrary.getColumnCount("Credentials");
        int actRows = rows - 1;

        Object[][] data = new Object[actRows][column];

        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = excelLibrary.getCellData("Credentials", j, i + 2);
            }
        }
        return data;
    }
}
