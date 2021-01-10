package practiseJava;

public class Student {

  Integer roll;
  String name;
  Integer age;

  public Student(int roll, String name, int age) {
    this.roll = roll;
    this.name = name;
    this.age = age;
  }

  public int getRoll() {
    return roll;
  }

  public void setRoll(int roll) {
    this.roll = roll;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
