import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) {

        // Somme des 10 premiers entiers
        System.out.println(IntStream.rangeClosed(1, 10).sum());

        final List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(li.stream().filter(e -> e % 2 == 0).collect(Collectors.toList()));

        int[] tab = IntStream.rangeClosed(1, 10)
                              .filter(x -> x > 3)
                              .toArray();

        for (int e : tab) {System.out.print(e + ", "); }
        System.out.println();

        final List<Integer> li2 = IntStream.rangeClosed(1, 10)
                                           .boxed()               // pour convertir les int en Integer
                                           .filter(x -> x > 3)
                                           .collect(Collectors.toList());
        System.out.println("li2 : " + li2);

        tab = IntStream.range(1, 11).map(x -> x * x).toArray();
        for (int e : tab) {System.out.print(e + ", "); }
        System.out.println();



    }
}