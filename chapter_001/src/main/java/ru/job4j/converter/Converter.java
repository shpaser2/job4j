package ru.job4j.converter;

/**
 *Class Конвертер валюты.
 *@author Sergey Shpakovsky
 *@since 23.11.2018
 *@version 0.1
 */
public class Converter {
	private final int Rub2Dol = 60;
	private final int Rub2Eur = 70;
	
	/**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / this.Rub2Eur);
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return (value / this.Rub2Dol);
    }
	
	/**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return (value * this.Rub2Eur);
    }
	
	/**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        return (value * this.Rub2Dol);
    }
		
}