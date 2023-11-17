package streamzip;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShuffleStreams {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> stream2 = Stream.of(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);

        Stream<Integer> shuffledStream = zip(stream1, stream2);
        System.out.println(shuffledStream.collect(Collectors.toList()));
    }

    public static <T> Stream<T> zip (Stream<T> first, Stream<T> second) {
        List<T> list1 = first.collect(Collectors.toList());
        List<T> list2 = second.collect(Collectors.toList());

        int size1 = list1.size();
        int size2 = list2.size();
        int size3 = Math.min(size1, size2);

        return Stream.iterate(0, i -> i + 1)
                .limit(size3)
                .flatMap(i -> Stream.of(
                                (i < size1) ? list1.get(i) : null,
                                (i < size2) ? list2.get(i) : null)
                        .filter(element -> element != null)
                );
    }
}
