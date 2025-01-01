package com.mystore.dataprovider;

import com.mystore.utility.ExcelLibrary;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

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

    @DataProvider(name = "newAcountDetailsData")
    public Object[][] accountCreation() {

        // Totals rows count
        int rows = excelLibrary.getRowCount("Signup");
        // Total Columns
        int column = excelLibrary.getColumnCount("Signup");
        int actRows = rows - 1;
        //Created an object of array to store data
        Object[][] data = new Object[actRows][1];

        for (int i = 0; i < actRows; i++) {
            Map<String, String> hashMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                hashMap.put(excelLibrary.getCellData("Signup", j, 1),
                        excelLibrary.getCellData("Signup", j, i + 2));
            }
            data[i][0]=hashMap;
        }
        return data;
    }
}
