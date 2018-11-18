package ru.job4j.calculate;


/**
* Class Return on console "Hello world" plus echo with writed name.
* @author Sergey Shpakovsky
* @since 16.11.2018
* @version 1
*/
public class Calculate
{	
	/**
	* Main. Вывод в консоль "Hello world".
	* @param args - args.
	*/
	public static void main(String[] args)
	{
		System.out.println("Hello world");
	}
	
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}
