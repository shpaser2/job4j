package ru.job4j.tracker;

public class MenuOutException extends RuntimeException {
    //принимает сообщение об ошибке и передает его
    //в конструктор родителя.
    public MenuOutException(String msg){
        super(msg);
    }
}
