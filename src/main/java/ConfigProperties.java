import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigProperties {
    private String propFileName;
    private String result;
    InputStream inputStream;

    public String getPropFileName() {
        return propFileName;
    }

    public void setPropFileName(String propFileName) {
        this.propFileName = propFileName;
    }

    public ConfigProperties(String configFile){
        this.propFileName = configFile;
    }



    public HashMap<String, String> getPropertyValues() throws IOException {
        Properties prop = new Properties();
        HashMap<String, String> propMap = new HashMap<String, String>();

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if(inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("Property File " + propFileName + " not found !");
        }

        for(String name: prop.stringPropertyNames()) {
            propMap.put(name, prop.getProperty(name));
        }

        return propMap;
    }



    public String getPropertyValue(String name) throws IOException {
        Properties prop = new Properties();

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if(inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("Property File " + propFileName + " not found !");
        }

        return prop.get(name).toString();
    }
}
