package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Внутренние классы меню трекера.
 *
 * @author Sergey Shpakovsky
 * @version 0.3
 * @since 20.02.2019
 */
public class MenuTracker {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int  ADD = 0;

    /**
     * Константа меню для отображения всех заявок.
     */
    private static final int SHOW_ALL = 1;

    /**
     * Константа меню для редактирования заявки.
     */
    private static final int EDIT_ITEM = 2;

    /**
     * Константа меню для удаления заявки.
     */
    private static final int DELETE_ITEM = 3;

    /**
     * Константа меню для поиска заявки по id.
     */
    private static final int FIND_BY_ID = 4;

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final int FIND_BY_NAME = 5;

    /**
     * Константа меню для выхода из меню программы.
     */
    private static final int EXIT = 6;

    private  Input input;
    private  Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(ADD, "Добавление новой заявки. "));
        this.actions.add(new ShowItems(SHOW_ALL, "Отображение всех заявок в хранилище. "));
        this.actions.add(new UpdateItem(EDIT_ITEM, "Изменение заявки в хранилище. "));
        this.actions.add(new DeleteItem(DELETE_ITEM, "Удаление заявки в хранилище. "));
        this.actions.add(new FindItemById(FIND_BY_ID, "Поиск заявки в хранилище по id. "));
        this.actions.add(new FindItemsByName(FIND_BY_NAME, "Поиск заявки в хранилище по совпадению названия. "));
        ExitProgram exitProgram = new ExitProgram(EXIT, "Выход из программы. ");
        exitProgram.setUi(ui);
        this.actions.add(exitProgram);
    }
    
    public void select(int key){
       this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show(){
        for(UserAction action: this.actions){
            if(action != null){
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(final int key, final String name){
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите название заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }
    }


    private class UpdateItem extends BaseAction {

        public UpdateItem(final int key, final String name){
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Изменение заявки в хранилище. ");
            String id = input.ask("Введите Id редактируемой заявки :");
            String name = input.ask("Введите новое название редактируемой заявки :");
            String description = input.ask("Введите новое описание редактируемой заявки :");
            Item item = new Item(name, description);
            if (tracker.replace(id, item)) {
                input.print("Заявка с введенным Id изменена");
            } else {
                input.print("Заявки с введенным Id не существует");
            }
            System.out.println("Изменение заявки в хранилище завершено. ");
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(final int key, final String name){
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Отображение всех заявок в хранилище. ");
            Item[] items = tracker.findAll();
            for (Item it : items) {
                input.print("Название заявки " + it.getName());
                input.print("Описание заявки " + it.getDescription());
                input.print("Id заявки " + it.getId());
            }
            System.out.println("Отображение всех заявок в хранилище завершено. ");
        }
    }


    private class DeleteItem extends BaseAction {

        public DeleteItem (int key, String name){
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Удаление заявки в хранилище. ");
            String id = input.ask("Введите Id удаляемой заявки :");
            if (tracker.delete(id)) {
                input.print("Заявка с введенным Id найдена и удалена");
            } else {
                input.print("Заявка с введенным Id не существует");
            }
            System.out.println("Удаление заявки в хранилище завершено. ");
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById (int key, String name){
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Поиск заявки в хранилище по id. ");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            if (item != null) { //падает при поиске отсутствуюшего Id и сравнении null с null c java.lang.NullPointerException
                input.print("Заявка с введенным id найдена");
            } else {
                input.print("Заявка с введенным id не существует");
            }
            System.out.println("Поиск заявки в хранилище по id завершен. ");
        }
    }

    private class FindItemsByName extends BaseAction {

        public FindItemsByName (int key, String name){
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Поиск заявки в хранилище по совпадению названия. ");
            String name = input.ask("Введите название заявки :");
            Item[] items = tracker.findByName(name);
            if (items.length > 0) {
                input.print("Заявки с совпадающим именем найдены");
            } else {
                input.print("Заявки с совпадающим именем не найдены");
            }
            System.out.println("Поиск заявки в хранилище по совпадению названия завершен. ");
        }
    }

    private class ExitProgram extends BaseAction {
        private StartUI ui;

        public void setUi(final StartUI ui){
            this.ui = ui;
        }

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Выход из программы. ");
            this.ui.stop();
        }
    }
}
