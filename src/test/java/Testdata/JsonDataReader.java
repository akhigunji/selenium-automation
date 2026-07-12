package Testdata;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonDataReader {

	    public com.fasterxml.jackson.databind.JsonNode getJsonData() throws IOException {

	        JsonMapper mapper = new JsonMapper();

	        com.fasterxml.jackson.databind.JsonNode data = mapper.readTree(
	                new File(System.getProperty("user.dir")
	                + "\\src\\test\\java\\Testdata\\PurchaseOrder.json")
	        );

	        return data;
	    }
}
