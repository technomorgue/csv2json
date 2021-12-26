import java.io.IOException;

public class Csv2jsonTester {
    public static void main(String... args) throws IOException {
        String filePath = "D:\\Projects\\backlog\\CSI_Backlog_FY22_local.csv";
        String fileDelimiter = ",";
        String[] header = null;

        CsvParser csv= new CsvParser(filePath, fileDelimiter);
        //csv.setFilePath(filePath);
        //csv.setFileDelimiter(fileDelimiter);
        //csv.parseCSVRecords();

        /*
        System.out.println(Arrays.toString(header));
        System.out.println("Number of headers: " + header.length);
        */
    }
}
