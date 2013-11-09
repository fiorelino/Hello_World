package de.anoraganingrum.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HelloWorldParseLegalTimeTest {
	private String input;
	private Date result;

	public HelloWorldParseLegalTimeTest(String input, Date result) {
		this.input = input;
		this.result = result;
	}

	@Parameters(name = "testParseLegalTime(\"{0}\")")
	public static Iterable<Object[]> data() throws ParseException {
		return Arrays.asList(
			new Object[][] {
				{ "00:00",   new GregorianCalendar(1970, 0, 1,  0,  0, 0).getTime() },
				{ "0:00",    new GregorianCalendar(1970, 0, 1,  0,  0, 0).getTime() },
				{ "04:09",   new GregorianCalendar(1970, 0, 1,  4,  9, 0).getTime() },
				{ "4:09",    new GregorianCalendar(1970, 0, 1,  4,  9, 0).getTime() },
				{ " 4:09",   new GregorianCalendar(1970, 0, 1,  4,  9, 0).getTime() },
				{ "4:09 ",   new GregorianCalendar(1970, 0, 1,  4,  9, 0).getTime() },
				{ "10:00",   new GregorianCalendar(1970, 0, 1, 10,  0, 0).getTime() },
				{ "12:34",   new GregorianCalendar(1970, 0, 1, 12, 34, 0).getTime() },
				{ " 12:34",  new GregorianCalendar(1970, 0, 1, 12, 34, 0).getTime() },
				{ "12:34 ",  new GregorianCalendar(1970, 0, 1, 12, 34, 0).getTime() },
				{ " 12:34 ", new GregorianCalendar(1970, 0, 1, 12, 34, 0).getTime() },
				{ "00:59",   new GregorianCalendar(1970, 0, 1,  0, 59, 0).getTime() },
				{ "0:59",    new GregorianCalendar(1970, 0, 1,  0, 59, 0).getTime() },
				{ " 0:59",   new GregorianCalendar(1970, 0, 1,  0, 59, 0).getTime() },
				{ "23:59",   new GregorianCalendar(1970, 0, 1, 23, 59, 0).getTime() },
				{ "21:25",   new GregorianCalendar(1970, 0, 1, 21, 25, 0).getTime() },
			}
		);
	}

	@Test
	public void testParseLegalTime() throws Exception {
		assertEquals(result, HelloWorld.parseTime(input));
	}
}
