package ru.job4j.Tracker;

/**
 * interface Input определяет названия методов интерфейса для работы
 * с меню класса StartUI.
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 23.02.2019
 */
interface Input {

    String ask(String question);

    void print(String data);
}
