package listofthenames;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddIndex {

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Vova", "Roman", "Anna", "Mike", "Peter", "Eva");
        String result = formatOddIndex(names);
        System.out.println(result);
    }

    public static String formatOddIndex(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }
}
