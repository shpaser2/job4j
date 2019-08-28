package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;

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
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
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

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return ADD;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите название заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавление новой заявки. ");
        }
    }


    private class UpdateItem implements UserAction {
        @Override
        public int key() {
            return EDIT_ITEM;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Изменение заявки в хранилище. ");
        }
    }

    private class ShowItems implements UserAction {
        @Override
        public int key() {
            return SHOW_ALL;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Отображение всех заявок в хранилище. ");
        }
    }


    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return DELETE_ITEM;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удаление заявки в хранилище. ");
        }
    }

    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return FIND_BY_ID;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки в хранилище по id. ");
        }
    }

    private class FindItemsByName implements UserAction {
        @Override
        public int key() { return FIND_BY_NAME; }

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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки в хранилище по совпадению названия. ");
        }
    }

    private class ExitProgram implements UserAction {
        @Override
        public int key() { return EXIT; }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Выход из программы пока по \"Exit? y\". ");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выход из программы пока по \"Exit? y\". ");
        }
    }
}
