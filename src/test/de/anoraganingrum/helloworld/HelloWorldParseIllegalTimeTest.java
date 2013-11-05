package de.anoraganingrum.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HelloWorldParseIllegalTimeTest {
	private String input;

	public HelloWorldParseIllegalTimeTest(String input) {
		this.input = input;
	}

	@Parameters(name = "testParseIllegalTime(\"{0}\")")
	public static Iterable<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{null},
				{""},
				{" "},
				{"-10:00"},
				{"-01:59"},
				{"15:-9"},
				{"-09:-45"},
				/*{"0:00"},*/
				{"1:5"},
				{"15:9"},
				{"24:00"},
				{"18:60"},
				{"123:456"}
			}
		);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseIllegalTime() throws Exception {
		HelloWorld.parseTime(input);
	}
}
