package main.java.com.playtika.lesson_one;

/**
 * Created by rfilipchak on 9/18/2017.
 */
public class Main_lesson_one {
    public static void main(String[] args) {

        Cat cat = new Cat(5, "Tom");//Cntr+alt +V Variable
        cat.color = "red";

        cat.call(", Brys");
        print(cat);


        String val = "startend"; //строку поменять нельзя
        String newVal = val.replace('s', 'g');//кнтр + q дока , кнтр +шифт + i реализацмя
        System.out.println(newVal);

        int i = 5;
        double a = 0.5d;//правилом хорошего тона указівать  букву в типах
        boolean b = false;
        char ch = 'r';
        float f = 3.4f;
        long l = 45L;
        byte by = 8;
        short sh = 6;// не рекомендовано использовать
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

    }

    private static void print(Animal animal) {
        System.out.println(animal);
    }
}
