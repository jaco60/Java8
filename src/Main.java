import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static int sommeDiviseursPropres(final int nbre) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(nbre))
                 .filter(d -> nbre % d == 0)  // On ne garde que les diviseurs de nbre
                 .map(d -> d + nbre/d)        // On les remplace par leur somme avec nbre/d
                 .sum() + 1;                  // On fait leur somme et on ajoute 1
    }

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
                                           .filter(x -> x > 3)
                                           .boxed()               // pour convertir les int en Integer
                                           .collect(Collectors.toList());
        System.out.println("li2 : " + li2);

        tab = IntStream.range(1, 11).map(x -> x * x).toArray();
        for (int e : tab) {System.out.print(e + ", "); }
        System.out.println();

        // Liste des nombres parfaits < 1000
        System.out.println(IntStream.rangeClosed(2, 1000)
                                     .filter(n -> sommeDiviseursPropres(n) == n)
                                     .boxed()
                                     .collect(Collectors.toList()));

    }
}