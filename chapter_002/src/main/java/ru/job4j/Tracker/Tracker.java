package ru.job4j.Tracker;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        int min = 1;
        int max = 999;
        Random rnd = new Random(System.currentTimeMillis());
        int number = min + rnd.nextInt(max - min + 1);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return (timeStamp + String.format(" %d", number));
    }

    /**
     * Replace the item cell in the array with selected Id.
     * @param id if item to replace with other data
     * @param item new data for item, which will be replace
     */
    public boolean replace(String id, Item item){
        boolean result = false;
        for(int i = 0; i < (this.items.length - 1); i++ ){
            if(this.items[i].getId().equals(item.getId())){
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * It will delete item with selected Id.
     * @param id of the item wich will be delete
     * @return true if item deleted succesfully, false in otherwise
     */
    public boolean delete(String id){
        boolean result = false;
        for(int index = 0; index < (this.items.length - 1); index++ ){
            if(this.items[index].getId().equals(id)){
                System.arraycopy(items, index+1, items, index, items.length - 1);
                result = true;
                this.position--;
                break;
            }
        }
        return result;
    }

    /**
     * It returns copy of  array with items without empty items.
     * @return array Item[] without empty items.
     */
    public Item[] findAll(){
        return Arrays.copyOf(this.items, position);
    }

    /**
     * It returns all items with name that match selected key.
     * @param key name for search in items array.
     * @return array with items wich name match key.
     */
    public Item[] findByName(String key){
        Item[] copy = new Item[0];
        int indexOfCopy = 0;
        for(int index = 0; index < (this.items.length - 1); index++ ){
            if(this.items[index].getName().equals(key)){
                copy[indexOfCopy] = this.items[index];
                indexOfCopy++;
            }
        }
        return copy;
    }

    /**
     * it will try to find item with selected Id and return it.
     * @param id for item search
     * @return item, that match by Id, or null, if there are no item with that Id.
     */
    public Item findById(String id){
        Item copy = null;
        for(int index = 0; index < (this.items.length - 1); index++ ){
            if(this.items[index].getId().equals(id)){
                copy = this.items[index];
                break;
            }
        }
        return copy;
    }

}


