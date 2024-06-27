package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		//json to string
	String jsoncontent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\purchaseOrder.json"),StandardCharsets.UTF_8);
	//string to hashmap
	ObjectMapper objmap = new ObjectMapper();
	List<HashMap<String, String>> data = objmap.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {});
	return data;
	}
}
