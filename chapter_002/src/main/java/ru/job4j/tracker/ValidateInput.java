package ru.job4j.tracker;

/**
 * Используется для бесперебойной работы трекера.
 * Использован паттерн Декоратор для работы с методами ConsoleInput,
 * чтобы не связывать жестко этот класс и ConsoleInput наследыванием.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 03.09.2019
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input){
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range){
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Please select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        }while(invalid);
        return value;
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }
}
