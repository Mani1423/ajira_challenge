import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Comparator {

    public static boolean compare(String file1, String file2) {
        boolean isEqual = true;
        try(BufferedReader csvFile1 = new BufferedReader(new FileReader(file1));
            BufferedReader csvFile2 = new BufferedReader(new FileReader(file2))) {
            String data1 = csvFile1.readLine();
            String data2 = csvFile2.readLine();
            while(null != data1 && null != data2) {
                if (!data1.equals(data2)) {
                    isEqual = false;
                    break;
                }
                data1 = csvFile1.readLine();
                data2 = csvFile2.readLine();
            }
        } catch (FileNotFoundException e) {
            isEqual = false;
            e.printStackTrace();
        } catch (IOException e) {
            isEqual = false;
            e.printStackTrace();
        }

        return isEqual;
    }
}
