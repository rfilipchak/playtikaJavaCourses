package main.java.com.playtika.lesson_one;

/**
 * Created by rfilipchak on 9/18/2017.
 */
class Cat extends Animal {
    private final String name ;


    Cat(int age, String name) {
        super(age);
        this.name = name;
    }
    void call(String command){
        System.out.println(name+" " + command);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append("age=").append(age);
        sb.append(", name='").append(name).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
