package de.anoraganingrum.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HelloWorldParseLegalTimeTest {
	private String input;
	private String result;

	public HelloWorldParseLegalTimeTest(String input, String result) {
		this.input = input;
		this.result = result;
	}

	@Parameters(name = "testParseLegalTime(\"{0}\")")
	public static Iterable<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ "00:00",   "00:00" },
				{ "0:00",    "00:00" },
				{ "04:09",   "04:09" },
				{ "4:09",    "04:09" },
				{ " 4:09",   "04:09" },
				{ "4:09 ",   "04:09" },
				{ "10:00",   "10:00" },
				{ "12:34",   "12:34" },
				{ " 12:34",  "12:34" },
				{ "12:34 ",  "12:34" },
				{ " 12:34 ", "12:34" },
				{ "00:59",   "00:59" },
				{ "0:59",    "00:59" },
				{ " 0:59",   "00:59" },
				{ "23:59",   "23:59" },
				{ "21:25",   "21:25" },
			}
		);
	}

	@Test
	public void testParseLegalTime() throws Exception {
		assertEquals(result, HelloWorld.parseTime(input));
	}
}
