package ru.job4j.calculator;

/**
 *Class Simple calculator.
 *@author Sergey Shpakovsky
 *@since 22.11.2018
 *@version 0.1
 */
 
public class Calculator {
	private double result;
	
	public void add(double first, double second){
		this.result = first + second;
	}
	
	public void subtract(double first, double second){
		this.result = first - second;
	}
	
	public void div(double first, double second){
		this.result = first / second;
	}

	public void multiple(double first, double second){
		this.result = first * second;
	}	
	
	public double getResult(){
		return this.result;
	}
		
}