package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирует методы StartUI не связанные с выводом на консоль для пользователя
 * с помощью класса StubInput.
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 04.03.2019
 */
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name2", "desc2"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"0", "test name", "desc", "2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasOneItemLess() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим удаление заявки и запись новой)
        Input input = new StubInput(new String[]{"3", item.getId(), "0", "test name2", "удалили первую заявку", "6"});
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        // проверяем, что нулевой элемент массива в трекере содержит имя, добавленное вторым в хранилище заявок.
        assertThat(tracker.findAll()[0].getName(), is("test name2")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

}
