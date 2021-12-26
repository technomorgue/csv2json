import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Csv2Json {
    public static void main(String... args) throws IOException {
        //Get config properties
        ConfigProperties myProperties = new ConfigProperties("./config.properties");

        //String file = myProperties.getPropertyValue("revenue_input_csv");
        String file = "D:\\Projects\\backlog\\CSI_Backlog_FY22_local.csv";
        //String outFile =  myProperties.getPropertyValue("revenue_output_json");
        String outFile = "D:\\Projects\\backlog\\CSI_Backlog_FY22_local.json";
        String fileDelimiter =  myProperties.getPropertyValue("revenue_csv_delimiter");

        CsvParser csvRecords = new CsvParser(file, "\\|");

        ArrayList<Backlog> backlog = csvRecords.parseCSVRecords();

        Writer writer = new FileWriter(outFile);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(backlog, writer);

        System.out.println("Json File created at: " + outFile);
    }
}
