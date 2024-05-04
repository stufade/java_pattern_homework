package hw_2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HumanApp {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human(28, "Алиса", "Смирнова", LocalDate.of(1993, 6, 20), 65),
                new Human(34, "Борис", "Иванов", LocalDate.of(1987, 3, 24), 78),
                new Human(23, "Владимир", "Петров", LocalDate.of(1998, 11, 3), 58),
                new Human(45, "Дмитрий", "Сидоров", LocalDate.of(1976, 8, 11), 80),
                new Human(30, "Елена", "Кузнецова", LocalDate.of(1991, 7, 30), 62));

        System.out.println("Исходный список:");
        humans.forEach(System.out::println);

        // Сортировка по второй букве имени в обратном порядке
        List<Human> sortedBySecondLetter = humans.stream()
                .sorted(Comparator.comparing((Human h) -> h.getFirstName().charAt(1)).reversed())
                .collect(Collectors.toList());

        System.out.println("\nОтсортировано по второй букве имени в обратном порядке:");
        sortedBySecondLetter.forEach(System.out::println);

        // Фильтрация по весу больше 60
        List<Human> filteredByWeight = sortedBySecondLetter.stream()
                .filter(h -> h.getWeight() > 60)
                .collect(Collectors.toList());

        System.out.println("\nОтфильтровано по весу больше 60:");
        filteredByWeight.forEach(System.out::println);

        // Сортировка по возрасту
        List<Human> sortedByAge = humans.stream()
                .sorted(Comparator.comparing(Human::getAge))
                .collect(Collectors.toList());

        System.out.println("\nОтсортировано по возрасту:");
        sortedByAge.forEach(System.out::println);

        // Произведение всех возрастов
        int ageProduct = humans.stream()
                .mapToInt(Human::getAge)
                .reduce(1, (a, b) -> a * b);

        System.out.println("\nПроизведение всех возрастов: " + ageProduct);
    }
}
