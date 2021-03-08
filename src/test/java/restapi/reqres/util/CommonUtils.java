package restapi.reqres.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Properties;

public class CommonUtils {
	public static Properties prop = null;
	private static final String propertyFilePrefix = "application";

	private static final String propertyFileExt = ".properties";
	private static final String resourcesFolder = ".\\src\\test\\resources\\";

	public static String EncodeText(String value) {
		String base64encodedString = "";
		// basic encoding using basic encoder
		try {
			base64encodedString = Base64.getEncoder().encodeToString(value.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return base64encodedString;
	}

	public static String DecodeText(String base64encodedString) {
		// decoding
		byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

		try {
			return new String(base64decodedBytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static void loadPropertyFile(String fileName) throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(fileName));
	}

	public static void loadPropertyFile() throws FileNotFoundException, IOException {
		loadPropertyFile(resourcesFolder+propertyFilePrefix + (System.getProperty("TestEnv") == null?"DIT": System.getProperty("TestEnv"))  + propertyFileExt);
	}

	public static String getProperty(String key) throws FileNotFoundException, IOException {
		if (prop == null) {
			loadPropertyFile();
		}
		System.out.println(key + "\t:\t" + prop.getProperty(key));
		return prop.getProperty(key);
	}
	
	public static String getProperty(Class<?> class1, String variableName) throws FileNotFoundException, IOException {
		return getProperty(class1.getCanonicalName()+"."+variableName);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(EncodeText("cityslicka"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
