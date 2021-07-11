package vo;

public class Student {
    private String name;
    private String age;


    public Student() {
        System.out.println("Student 的构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Student 的setName函数");
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        System.out.println("Student 的setAge函数");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
