import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static int sommeDiviseursPropres(final int nbre) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(nbre))
                 .filter(d -> nbre % d == 0)  // On ne garde que les diviseurs de nbre
                 .map(d -> d + nbre/d)        // On les remplace par leur somme avec nbre/d
                 .sum() + 1;                  // On fait leur somme et on ajoute 1
    }

    // Fonctionnelle utilisable avec filter...
    public static Predicate<Integer> divisiblePar(final int d) {
        // renvoie un prédicat... (exigé par filter)
        return nbre -> nbre % d == 0;
    }

    public static void main(String[] args) {

        // nommage d'une lambda utilisable avec filter...
        final Predicate<Integer> pair = nbre -> nbre % 2 == 0;

        // Somme des 10 premiers entiers
        System.out.println(IntStream.rangeClosed(1, 10).sum());

        final List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Liste des éléments de li divisibles par 4
        System.out.println(li.stream().filter(divisiblePar(4)).collect(Collectors.toList()));

        // Liste des éléments pairs de li divisibles par 2
        System.out.println(li.stream().filter(pair).collect(Collectors.toList()));

        System.out.println(li.stream().map(e -> e * e).collect(Collectors.toList()));
        System.out.println(li.stream().mapToInt(e -> e * e).sum());

        // La même chose, en parallèle
        System.out.println(li.parallelStream().map(e -> e * e).collect(Collectors.toList()));
        System.out.println(li.parallelStream().mapToInt(e -> e * e).sum());

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

        // Idem, avec stockage dans un tableau (plus besoin de boxing)
        final int[] parfaits = IntStream.rangeClosed(2, 1000)
                                        .filter(n -> sommeDiviseursPropres(n) == n)
                                        .toArray();
        // vérification
        for (int e : parfaits) {System.out.print(e + ", "); }
        System.out.println();
    }
}