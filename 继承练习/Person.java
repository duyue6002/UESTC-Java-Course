/**
 * Created by duyue on 2016/10/17.
 */

class Person {
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setData(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getData() {
        return "Name:" + name + "\nSex:" + sex + "\nAge:" + age;
    }

}
