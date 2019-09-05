package ru.job4j.tracker;

/**
 * Своя RuntimeException для того, чтобы не менять существующий код особо
 * и добавить свою исключительную ситуацию.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 03.09.2019
 */
public class MenuOutException extends RuntimeException {
    //принимает сообщение об ошибке и передает его
    //в конструктор родителя.
    public MenuOutException(String msg){
        super(msg);
    }
}
