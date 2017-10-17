package main.java.com.playtika.lesson_one;

/**
 * Created by rfilipchak on 9/18/2017.
 */ abstract class Animal{
        final int age;// алт +ентер подсказка для ошибок
         String color;

    Animal(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("age=").append(age);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
