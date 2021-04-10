import com.ajirasoft.challenge.MainApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainTest {

    private ObjectMapper mapper = new ObjectMapper();
    @Test
    public void test_case1() throws IOException {
        String inputFile = "./src/test/resources/static/case1/inputfile.csv";
        String configuration = "./src/test/resources/static/case1/configuration.csv";
        String actual = "./src/test/resources/static/case1/actual/outfile.csv";
        String expected = "./src/test/resources/static/case1/expected/outfile.csv";
        String [] args = new String[3];
        args[0] = inputFile;
        args[1] = configuration;
        args[2] = actual;
        MainApplication.main(args);
        Assertions.assertTrue(Comparator.compare(actual, expected));
        Files.deleteIfExists(Paths.get(actual));
    }

    @Test
    public void test_case2() throws IOException {
        String inputFile = "./src/test/resources/static/case2/inputfile.csv";
        String configuration = "./src/test/resources/static/case2/configuration.csv";
        String actual = "./src/test/resources/static/case2/actual/outfile.csv";
        String expected = "./src/test/resources/static/case2/expected/outfile.csv";
        String [] args = new String[3];
        args[0] = inputFile;
        args[1] = configuration;
        args[2] = actual;
        MainApplication.main(args);
        Assertions.assertTrue(Comparator.compare(actual, expected));
        Files.deleteIfExists(Paths.get(actual));
    }

    @Test
    public void test_case3() throws IOException {
        String inputFile = "./src/test/resources/static/case3/inputfile.csv";
        String configuration = "./src/test/resources/static/case3/configuration.csv";
        String actual = "./src/test/resources/static/case3/actual/outfile.csv";
        String expected = "./src/test/resources/static/case3/expected/outfile.csv";
        String [] args = new String[3];
        args[0] = inputFile;
        args[1] = configuration;
        args[2] = actual;
        MainApplication.main(args);
        Assertions.assertTrue(Comparator.compare(actual, expected));
        Files.deleteIfExists(Paths.get(actual));
    }

    @Test
    public void test_case4() throws IOException {
        String inputFile = "./src/test/resources/static/case4/inputfile.csv";
        String configuration = "./src/test/resources/static/case4/configuration.csv";
        String actual = "./src/test/resources/static/case4/actual/outfile.csv";
        String expected = "./src/test/resources/static/case4/expected/outfile.csv";
        String [] args = new String[3];
        args[0] = inputFile;
        args[1] = configuration;
        args[2] = actual;
        MainApplication.main(args);
        Assertions.assertTrue(Comparator.compare(actual, expected));
        Files.deleteIfExists(Paths.get(actual));
    }
}
