package ru.job4j.tracker;

/**
 * Интерфейс для внутренних классов, составляющих меню трекера.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 03.09.2019
 */
public interface UserAction {

    /**
     * Метод возвращает ключ опции.
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}
