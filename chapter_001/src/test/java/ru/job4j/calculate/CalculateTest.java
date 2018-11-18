package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Sergey Shpakovsky (shpaser2@yandex.ru)
* @version $Id$
* @since 18.11.2018
*/
public class CalculateTest {
	/**
	* Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Sergey Shpakovsky";
		String expect = "Echo, echo, echo : Sergey Shpakovsky"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
	
}