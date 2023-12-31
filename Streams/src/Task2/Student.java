package Task2;

public class Student {
    private String fullName;
    private int age;
    private String group;
    int points;

    public Student(String fullName, int age, String group, int points) {
        this.fullName = fullName;
        this.age = age;
        this.group = group;
        this.points = points;
    }


    // методы для получения отдельных частей полного имени
    public String getSurname() {
        String[] nameParts = fullName.split(" ");
        return nameParts.length > 0 ? nameParts[0] : "";
    }

    public String getName() {
        String[] nameParts = fullName.split(" ");
        return nameParts.length > 1 ? nameParts[1] : "";
    }

    public String getPatronymic() {
        String[] nameParts = fullName.split(" ");
        return nameParts.length > 2 ? nameParts[2] : "";
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                ", points=" + points +
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

    public int getPoints() {
        return points;
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

    public void setPoints(int points) {
        this.points = points;
    }
}
