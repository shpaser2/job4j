package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирует методы StartUI не связанные с выводом на консоль для пользователя
 * с помощью класса StubInput.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 04.03.2019
 */
public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    // стандартная строка отображения меню
    private final String MenuString = "0. Добавление новой заявки. " +
            System.lineSeparator() +
            "1. Отображение всех заявок в хранилище. " +
            System.lineSeparator() +
            "2. Изменение заявки в хранилище. " +
            System.lineSeparator() +
            "3. Удаление заявки в хранилище. " +
            System.lineSeparator() +
            "4. Поиск заявки в хранилище по id. " +
            System.lineSeparator() +
            "5. Поиск заявки в хранилище по совпадению названия. " +
            System.lineSeparator() +
            "6. Выход из программы. ";

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void checkShowAllForTwoAddedItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 2 заявки
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        //создаём StubInput с вызовом ShowAllItems и Exit
        Input input = new ArrayInputSystemOut(new String[]{"1", "6"});
        //создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что выведены две завяки.
        assertThat(this.out.toString(),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(MenuString)
                        .add("Отображение всех заявок в хранилище. ")
                        .add("Название заявки " + item.getName())
                        .add("Описание заявки " + item.getDescription())
                        .add("Id заявки " + item.getId())
                        .add("Название заявки " + item2.getName())
                        .add("Описание заявки " + item2.getDescription())
                        .add("Id заявки " + item2.getId())
                        .add("Отображение всех заявок в хранилище завершено. ")
                        .add(MenuString)
                        .add("Выход из программы. ")
                        .toString()
        ));
    }

    @Test
    public void checkFindByIdForTwoAddedItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с вызовом FindById и Exit
        Input input = new ArrayInputSystemOut(new String[]{"4", item.getId(), "4", tracker.generateId(), "6"});
        //создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что выведены оба случая поиска завяки.
        assertThat(this.out.toString(),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(MenuString)
                        .add("Поиск заявки в хранилище по id. ")
                        .add("Заявка с введенным id найдена")
                        .add("Поиск заявки в хранилище по id завершен. ")
                        .add(MenuString)
                        .add("Поиск заявки в хранилище по id. ")
                        .add("Заявка с введенным id не существует")
                        .add("Поиск заявки в хранилище по id завершен. ")
                        .add(MenuString)
                        .add("Выход из программы. ")
                        .toString()
                ));
    }

    @Test
    public void checkFindByNameForTwoAddedItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с вызовом FindById и Exit
        Input input = new ArrayInputSystemOut(new String[]{"5", item.getName(), "5", "test name2", "6"});
        //создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что выведены оба случая поиска завяки.
        assertThat(this.out.toString(),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(MenuString)
                        .add("Поиск заявки в хранилище по совпадению названия. ")
                        .add("Заявки с совпадающим именем найдены")
                        .add("Поиск заявки в хранилище по совпадению названия завершен. ")
                        .add(MenuString)
                        .add("Поиск заявки в хранилище по совпадению названия. ")
                        .add("Заявки с совпадающим именем не найдены")
                        .add("Поиск заявки в хранилище по совпадению названия завершен. ")
                        .add(MenuString)
                        .add("Выход из программы. ")
                        .toString()
                ));
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

    @Test
    public void whenReplaceItemWhichNotExistResultIsNotThisItem() {
        //создаём Tracker
        Tracker tracker = new Tracker();
        //создаем заявку не в хранилище
        Item item = new Item("test name2", "desc2");
        item.setId(tracker.generateId());
        //создаём StubInput с последовательностью действий(производим изменение не существующей заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "изменили несуществующую в хранилище заявку", "6"});
        //создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        //проверяем, что нулевой элемент массива в трекере не содержит имя, введенное при попытке изменении заявки.
        assertThat(tracker.getPosition(), is(0));
    }

    @Test
    public void whenEnterWrongMenuKeyProgramContinuesRun(){
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим удаление заявки и запись новой)
        Input input = new StubInput(new String[]{"99", "d", "3", item.getId(), "0", "test name2", "удалили первую заявку", "6"});
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        // проверяем, что нулевой элемент массива в трекере содержит имя, добавленное вторым в хранилище заявок.
        assertThat(tracker.findAll()[0].getName(), is("test name2")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
}
