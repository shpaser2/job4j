package ru.job4j.Tracker;

public class Item {
    private String name;
    private String description;
    private long number;
    private String id;

    Item(String name, String description, long number){
        this.name = name;
        this.description = description;
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public long getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
