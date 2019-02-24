package ru.job4j.Tracker;

/**
 * Class StartUI содержит меню пользователя и методы для работы с хранилищем заявок.
 *
 * @author Sergey Shpakovsky
 * @version 0.2
 * @since 20.02.2019
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ShowAll = "1";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String EditItem = "2";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String DeleteItem = "3";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String FindById = "4";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String FindByName = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
     * @param input ввод данных.
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (ShowAll.equals(answer)) {
                this.ShowAllItems();
            } else if (EditItem.equals(answer)) {
                this.EditItem();
            } else if (DeleteItem.equals(answer)) {
                this.DeleteItem();
            } else if (FindById.equals(answer)) {
                this.FindById();
            } else if (FindByName.equals(answer)) {
                this.FindByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует изменение заявки в хранилище.
     */
    private void EditItem() {
        System.out.println("------------ Изменение заявки в хранилище --------------");
        String Id = this.input.ask("Введите Id редактируемой заявки :");
        Item item = this.tracker.findById(Id);
        if(!item.equals(null)){
            item.setName(this.input.ask("Введите новое имя заявки"));
            item.setDescription(this.input.ask("Введите новое описание заявки"));
        }else{
            this.input.print("Заявки с введенным Id не существует");
        }
        System.out.println("------------ Изменение заявки в хранилище завершено --------------");
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void DeleteItem() {
        System.out.println("------------ Удаление заявки в хранилище --------------");
        String Id = this.input.ask("Введите Id удаляемой заявки :");
        Item item = this.tracker.findById(Id);
        if(!item.equals(null)){
            this.tracker.delete(Id);
            this.input.print("Заявка с введенным Id найдена и удалена");
        }else{
            this.input.print("Заявка с введенным Id не существует");
        }
        System.out.println("------------ Удаление заявки в хранилище завершено --------------");
    }

    /**
     * Метод реализует поиск заявки в хранилище по Id.
     */
    private void FindById() {
        System.out.println("------------ Поиск заявки в хранилище по id --------------");
        String Id = this.input.ask("Введите Id заявки :");
        Item item = this.tracker.findById(Id);
        if(!(item.equals(null))){
            this.input.print("Заявка с введенным Id найдена");
        }else{
            this.input.print("Заявка с введенным Id не существует");
        }
        System.out.println("------------ Поиск заявки в хранилище по id завершен --------------");
    }


    /**
     * Метод реализует поиск заявки в хранилище по названию.
     */
    private void FindByName() {
        System.out.println("------------ Поиск заявки в хранилище по совпадению названия --------------");
        String name = this.input.ask("Введите Id заявки :");
        Item[] items = this.tracker.findByName(name);
        if(!items.equals(null)){
            this.input.print("Заявки с совпадающим именем найдены");
        }else{
            this.input.print("Заявки с совпадающим именем не найдены");
        }
        System.out.println("------------ Поиск заявки в хранилище по совпадению названия завершен --------------");
    }

    /**
     * Метод реализует отображение всех имеющихся заявок в хранилище.
     */
    private void ShowAllItems() {
        System.out.println("------------ Отображение всех заявок в хранилище --------------");
        Item[] items = this.tracker.findAll();
        for(Item it: items){
            this.input.print("Название заявки " + it.getName());
            this.input.print("Описание заявки " + it.getDescription());
            this.input.print("Id заявки " + it.getId());
        }
        System.out.println("------------ Отображение всех заявок в хранилище завершено --------------");
    }

    /**
     * Вывод меню программы в консоль
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Изменить заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по номеру");
        System.out.println("5. Найти заявки по названию");
        System.out.println("6. Выйти из программы");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}