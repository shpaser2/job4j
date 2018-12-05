package ru.job4j.array;

/**
 * Обертка над строкой.
 *
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 04.12.2018
 */
public class ArrayChar {
    private char[] data;

    /**
     * @param line convert String object to char array.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return true если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        int arrayLength = value.length - 1;
        for (int index = 0; index <= arrayLength; index++) {
            if (value[index] != this.data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}