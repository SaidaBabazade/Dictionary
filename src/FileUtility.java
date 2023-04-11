import java.io.*;
import java.util.*;
public class FileUtility {

    public static void appendWriteToFile(String fileName, Map<String, String> text, boolean append) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", append))) {
            bw.write(text.toString());
            bw.newLine();
        }
    }

    public static void writeToFileFalse(String fileName, String text) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", false))) {
            bw.write(text.toString());
            bw.newLine();
        }
    }
    public static void writeToFileTrue(String fileName, String text) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", true))) {
            bw.write(text.toString());
            bw.newLine();
        }
    }

}
