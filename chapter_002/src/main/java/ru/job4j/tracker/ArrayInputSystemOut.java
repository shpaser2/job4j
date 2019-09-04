package ru.job4j.tracker;

public class ArrayInputSystemOut extends StubInput {

    public ArrayInputSystemOut(String[] answers) {
        super(answers);
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }
}
