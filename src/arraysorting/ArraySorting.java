package arraysorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraySorting {

    public static void main(String[] args) {
        String[] inputArray = {"1, 2, 0", "4, 5"};
        String result = sortArray(inputArray);
        System.out.println(result);
    }

    public static String sortArray(String[] inputArray) {
        return Arrays.stream(inputArray)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
