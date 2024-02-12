package resuableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {
	static Properties prop = new Properties();
	public static String getPropertyValuesbyKey(String key) throws Exception {
		String propfilepath =System.getProperty( "user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(propfilepath);
		//read
		prop.load(fis);
		String value=prop.get(key).toString();
		if(StringUtils.isEmpty(value)) {
			throw new Exception("value is not specified for "+ key + " in properties file");
		}
		return value;
	}
}
