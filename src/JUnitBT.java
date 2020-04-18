import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JUnitBT {

	@Test
	void Translate() {
		String txt = "hello world";
		String[] enw = {"hello", "world"};
		String[] esw = {"hola", "mundo"};
		Map<String, String> valid = new Hashtable<String, String>();
		Map<String, String> dictionary = new Hashtable<String, String>();
		
		valid.put("hello", "hola");
		valid.put("mundo", "mundo");
		
		assertEquals(dictionary.equals(valid),true);
	}

}
