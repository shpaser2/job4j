package ru.job4j.tracker;

public class MenuTracker {

    private  Input input;
    private  Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init(){
        //how to fill it.
    }

    public void fillActions(){
        this.actions[0] = new AddItem();
    }

    public void  select(int key){
       this.actions[key].execute(this.input, this.tracker);
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
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
//            String name = input.ask("Please, enter the task's name: ");
//            String name = input.ask("Please, enter the task's name: ");
//            tracker.add(new Task(name, desc));
            String name = input.ask("Введите название заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item. ");
        }
    }
}
