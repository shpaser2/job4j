package ru.job4j.tracker;

public class ArrayInputSystemOut implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public ArrayInputSystemOut(final String[] value) { this.value = value; }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }
}
