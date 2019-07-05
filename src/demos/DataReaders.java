package demos;

import utilities.Excel;

import java.util.List;

public class DataReaders {

    public static void main(String[] args) {
//        readCSV();
        readXLS();
    }

    private static void readCSV() {
        String filename = "src/resources/UserAccounts.csv.csv";
        List<String[]> records = utilities.CSV.get(filename);
//        Iterating through the list
        for (String[] record : records) {
            for (String field : record) {
                System.out.println(field);
            }
        }
    }

    private static void readXLS() {

        String filename = "src/resources/UserLogin.xls.xls";
        String[][] data = Excel.get(filename);
        for (String[] record : data) {
            System.out.println("\nNEW RECORD");
            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
        }
    }
}
