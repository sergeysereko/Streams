import Task1.Car;
import Task2.Student;
import Task2.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    private static final String[] CAR_BRANDS = {"Mercedes-Benz", "Volkswagen", "Volvo", "Renault", "Audi"};

    private static final String[] FULL_NAMES = {
            "Иванов Иван Иванович",
            "Петров Петр Петрович",
            "Сидоров Сидр Сидорович",
            "Олегов Олег Олегович",
            "Сергеев Сергей Сергеевич",
            "Игорев Игорь Игоревич"
    };
    public static void main(String[] args) {
        // Список из 100 разных машин
        List<Car> cars = generateCarList(100);

        System.out.println("\n");
        // Выводим информацию только о красных машинах
        System.out.println("Информация о красных машинах:");
        cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("red"))
                .forEach(car -> System.out.println("Машина: " + car.getName() +
                        ", Цвет: " + car.getColor() +
                        ", Максимальная скорость: " + car.getMaxSpeed()));

        // Находим самую быструю машину среди красных
        Car fastestRedCar = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("red"))
                .max((car1, car2) -> Integer.compare(car1.getMaxSpeed(), car2.getMaxSpeed()))
                .orElse(null);

        System.out.println("\n");
        // Результаты
        if (fastestRedCar != null) {
            System.out.println("Самая быстрая красная машина: " + fastestRedCar.getName() +
                    ", цвет: " + fastestRedCar.getColor() +
                    ", максимальная скорость: " + fastestRedCar.getMaxSpeed());
        } else {
            System.out.println("Красных машин не найдено");
        }

      ///////////СТУДЕНТЫ

        // Список из 100 разных студентов с баллами
        List<Student> students = generateStudentListWithPoints(100);


        // Фамилии всех студентов младше 16 лет
        List<String> surnamesUnder16 = students.stream()
                .filter(student -> student.getAge() < 16)
                .map(student -> {
                    String[] nameParts = student.getFullName().split(" ");
                    return nameParts.length > 0 ? nameParts[0] : "";
                })
                .collect(Collectors.toList());

        System.out.println("\n");
        // Выводим результат
        System.out.println("Фамилии студентов младше 16 лет: " + surnamesUnder16);

        // Находим средний бал всех студентов
        double averagePoints = students.stream()
                .mapToDouble(Student::getPoints)
                .average()
                .orElse(0.0);


        System.out.println("\n");
        // Выводим результат
        System.out.println("Средний бал всех студентов: " + averagePoints);


        // Преобразование списка студентов в список работников
        List<Employee> employees = students.stream()
                .map(student -> new Employee(student.getSurname(), student.getName(), student.getPatronymic(), student.getAge()))
                .collect(Collectors.toList());

        System.out.println("\n");
        // Вывод информации о работниках
        System.out.println("Информация о работниках (преобразованных из студентов):");
        employees.forEach(employee -> System.out.println("Имя: " + employee.getName() +
                ", Фамилия: " + employee.getSurname() +
                ", Отчество: " + employee.getPatronymic() +
                ", Возраст: " + employee.getAge()));
    }


    //СТАТИЧЕСКИЕ МЕТОДЫ


    // Генерация списка машин
    private static List<Car> generateCarList(int size) {
        List<Car> cars = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            String name = CAR_BRANDS[random.nextInt(CAR_BRANDS.length)];
            String color = getRandomColor(random);
            int maxSpeed = random.nextInt(200) + 50; // случайная скорость от 50 до 249
            cars.add(new Car(name, color, maxSpeed));
        }

        return cars;
    }

    // Генерация случайного цвета
    private static String getRandomColor(Random random) {
        String[] colors = {"red", "blue", "green", "yellow", "white", "black"};
        return colors[random.nextInt(colors.length)];
    }

    // Генерации списка студентов с баллами
    private static List<Student> generateStudentListWithPoints(int size) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            String fullName = FULL_NAMES[random.nextInt(FULL_NAMES.length)];
            int age = random.nextInt(40); // возраст от 0 до 40
            String group = "Group" + (i % 5); // группы от 0 до 4
            int points = random.nextInt(101); // случайные баллы от 0 до 100
            students.add(new Student(fullName, age, group, points));
        }

        return students;
    }
}