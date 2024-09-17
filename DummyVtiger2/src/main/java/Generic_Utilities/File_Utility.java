package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	
	public String getpropertiesdata(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData8.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value= pro.getProperty(key);
		return value;
	}

}
