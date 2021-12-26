import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CsvParser {
    private static String file;
    private static String fileDelimiter;
    private static List<String> csvHeader;

    //ArrayList<backlog> backlogRec = new ArrayList<backlog>();

    // Setters
    public static void setFilePath(String filePath) {
        file = filePath;
    }

    public static void setFileDelimiter(String delimiter) {
        fileDelimiter = delimiter;
    }

    // Set CSV Headers
    public void setCSVHeader(List<String> header) throws IOException {
        csvHeader = header;
    }

    // Getters
    public String getFilePath() {
        return file;
    }

    public String getFileDelimiter() {
        return fileDelimiter;
    }

    public List<String> getCSVHeader() {
        return csvHeader;
    }

    public CsvParser(String filePath, String fileDelimiter) {
        CsvParser.file = filePath;
        CsvParser.fileDelimiter = fileDelimiter;
    }

    // Parse the CSV file record by record
    public ArrayList<Backlog> parseCSVRecords() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String csvRecordString = br.readLine();

        // Arraylist to store the csv data
        ArrayList<Backlog> backlog = new ArrayList<>();

        //set the first record as file header.
        csvHeader = Arrays.stream(csvRecordString.split(fileDelimiter)).toList();

        // Loop through the rest of the records
        csvRecordString = br.readLine();
        while (csvRecordString != null) {
            String[] fields = csvRecordString.split(fileDelimiter);
            HashMap<String, String> map = new HashMap<>();

            //Create hashmap of header and values
            for (int index = 0; index < fields.length; index++) {
                map.put(csvHeader.get(index), fields[index]);
            }

            backlog.add(new Backlog(map));
            csvRecordString = br.readLine();
        }

/*        for (Backlog row : backlog) {
            row.printBacklog();
        }
        System.out.println("No. of records in backlog: " + (long) backlog.size());*/

        return backlog;
    }
}
