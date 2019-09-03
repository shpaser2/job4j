package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    //переопределяет в себе метод ask с обработкой исключительных
    //ситуаций при помощи блоков try{...}catch{...}
    public int ask(String question, int[] range){
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Please select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        }while(invalid);
        return value;
    }
}
