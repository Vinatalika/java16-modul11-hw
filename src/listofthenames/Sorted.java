package listofthenames;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sorted {

    public static void main(String[] args) {

        List<String> names = List.of("Ivan", "Vova", "Roman", "Anna", "Mike", "Peter", "Eva");
        List<String> uppercaseSortedStrings = SortStrings(names);
        System.out.println(uppercaseSortedStrings);
    }

    public static List<String> SortStrings(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }
}
