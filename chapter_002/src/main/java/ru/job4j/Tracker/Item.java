package ru.job4j.Tracker;

/**
 * Class Item содержит данные заявки и методы доступа к ним.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 10.02.2019
 */
public class Item {

    /**
     * Name of Item.
     */
    private String name;
    /**
     * Description of Item
     */
    private String description;
    private long number;
    private String id;

    Item(String name, String description){
        this.name = name;
        this.description = description;
    }

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
