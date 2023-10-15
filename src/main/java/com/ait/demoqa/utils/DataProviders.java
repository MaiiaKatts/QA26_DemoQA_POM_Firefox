package com.ait.demoqa.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewVampireFromCSV() throws IOException {
        List<Object[]> vampireData = new ArrayList<Object[]>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(DataProviders
                        .class
                        .getResourceAsStream("/data.csv")))) {
            String line = reader.readLine();

            while (line != null) {
                vampireData.add(line.split(","));
                line = reader.readLine();
            }
            reader.close();
        }
        return vampireData.iterator();
    }
}
