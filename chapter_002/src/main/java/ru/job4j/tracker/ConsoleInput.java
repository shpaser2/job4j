package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput определяет консольный интерфейс пользователя
 * для работы с меню класса StartUI.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 23.02.2019
 */
public class ConsoleInput implements Input {
    @Override
    public String ask(String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }
}
