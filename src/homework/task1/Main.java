package homework.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Убрать дубликаты, отсортировать по имени, сгруппировать по имени
 *
 * @Key: Amelia
 * @Value: 4
 * @Key: Emily
 * @Value: 1
 * @Key: Harry
 * @Value: 3
 * @Key: Jack
 * @Value: 1
 */
public class Main {
    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, null), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        print(RAW_DATA);
    }


    private static void print(Person[] persons) {
        if (persons == null || persons.length == 0) {
            System.out.println("Input arguments are equal to null");
        } else {
            Map<String, Integer> map = Arrays.stream(persons)
                    .filter(person -> Objects.nonNull(person.name))
                    .distinct()
                    .sorted(Comparator.comparingInt(Person::getId))
                    .collect(groupingBy(Person::getName, Collectors.reducing(0, (x) -> 1, Integer::sum)));
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.printf("Key: %s  %nValue: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
