package Task2;

public class Student {
    private String fullName;
    private int age;
    private String group;

    public Student(String fullName, int age, String group) {
        this.fullName = fullName;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
