package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    
    private Properties properties;
    private String path = "config.properties";
    
    public ReadConfig() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getBrowser() {
        String val = properties.getProperty("browser");
        return val == null ? "chrome" : val;
    }
}

//=================================================================================
//public class ReadConfig {
//	
//	private Properties properties;
//	private String path = "config.properties";
//	
//	public ReadConfig() throws FileNotFoundException {
//		properties = new Properties();
//		FileInputStream fis = new FileInputStream(path);
//		try {
//			properties.load(fis);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		
//	}
//	
//	public String getBrowser() {
//		String val = properties.getProperty("browser");
//		
//		if(val == null) {
//			return "chrome";
//		}
//		
//		return val;
//		
//	}
//
//}



