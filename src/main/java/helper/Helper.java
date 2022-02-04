package helper;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Helper {
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void writeToCsv(String allpromotions) throws IOException {
        String csv = "target/test-classes/output.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        writer.writeNext(new String[]{allpromotions});
        writer.close();
    }
}
