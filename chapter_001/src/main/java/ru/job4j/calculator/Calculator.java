package ru.job4j.calculator;

/**
 *Class Simple calculator.
 *@author Sergey Shpakovsky
 *@since 22.11.2018
 *@version 0.1
 */

public class Calculator {
    private double result;

    /**
     * Method add two numbers and save the result.
     * @param first first value for addition.
     * @param second second value for addition.
     */
    public void add(double first, double second){
        this.result = first + second;
    }

    /**
     * Method subtract two numbers and save the result.
     * @param first first value for subtraction.
     * @param second second value for subtraction.
     */
    public void subtract(double first, double second){
        this.result = first - second;
    }

    /**
     * Method devides two numbers and save the result.
     * @param first first value for division.
     * @param second second value for division.
     */
    public void div(double first, double second){
        this.result = first / second;
    }

    /**
     * Method multiplies two numbers and save the result.
     * @param first first value for multiplication.
     * @param second second value for multiplication.
     */
    public void multiple(double first, double second){
        this.result = first * second;
    }

    /**
     * Method for return result of the calculations.
     * @return result of the calculations.
     */
    public double getResult(){
        return this.result;
    }

}