package config;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.ricommunity.calendar.config.ConfigService;

public class ConfigServiceTest {
	
	@Test
	public void testFallback() {
		String result = ConfigService.getVariable("NonexistentKey", "FallbackValue");
		assertEquals("FallbackValue", result);
	}

}
