package ru.job4j.tracker;

/**
 * Class StartUI содержит меню пользователя и методы для работы с хранилищем заявок.
 *
 * @author Sergey Shpakovsky
 * @version 0.2
 * @since 20.02.2019
 */
public class StartUI {

    private boolean working = true;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions(this);
        do{
            menu.show();
            menu.select(Integer.valueOf(input.ask("Select: ")));
        }while (this.working);
    }

    public void stop(){
        this.working = false;
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}