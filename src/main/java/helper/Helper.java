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

}
