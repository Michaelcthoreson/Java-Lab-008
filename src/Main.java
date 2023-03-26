/**
 * @author trevor hartman
 * @author michael thoreson
 * @since 1.0
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner myScanner = new Scanner(System.in);
        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        String input = "";
        while (true) {
            System.out.println("Please enter the path of the file.");
            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File
            Path myPath = Paths.get(myScanner.nextLine());
            File myFile = myPath.toFile();
            // Ask the user if they would like to skip whitespace
            System.out.println("ignore whitespaces? (y)");
            // Create a variable called skipWs that stores the user's response as a boolean
            boolean skipWs = myScanner.nextLine().equalsIgnoreCase("y");
            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats fs = new FileStats(myFile, skipWs);
                // You will need to call the fs.read method, which you need to implement!
                fs.read();
                System.out.printf("%s has %d words, %d characters, and %d lines.%n", fs.getFileName(), fs.getNumWords(),fs.getNumChars(),fs.getNumLines());
                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
