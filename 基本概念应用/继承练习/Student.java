/**
 * 子类
 */

class Student extends Person {
    int sID;
    int classNO;

    public Student(String name, char sex, int age) {
        super(name, sex, age);
        sID = 0;
        classNO = 0;
    }

    public void setData(String name, char sex, int age, int sID, int classNO) {
        super.setData(name, sex, age);
        this.sID = sID;
        this.classNO = classNO;
    }

    public String getData() {
        return super.getData() + "\nsID:" + sID + "\nclassNO:" + classNO;
    }
}
