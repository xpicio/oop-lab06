package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int MIN_INTEGER = 1000;
    private static final int MAX_INTEGER = 2000;
    private static final int NEW_ELEMENTS = 10000;
    private static final int READ_TIMES = 1000;

    private static final long AFRICA_POPULATION = 1110635000L;
    private static final long AMERICAS_POPULATION = 972005000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4298723000L;
    private static final long EUROPE_POPULATION = 742452000L;
    private static final long OCEANIA_POPULATION = 38304000L;

    private UseListsAndMaps() {
    }

    private static void listAddNewElementsPerformance(List<Integer> list, String displayName) {
        System.out.print("\nAdd new elements (" + NEW_ELEMENTS + ") to " + displayName + " ... ");
        long timeTest05 = System.nanoTime();

        for (int i = 0; i <= NEW_ELEMENTS; i++) {
            list.add(0, i);
        }

        timeTest05 = System.nanoTime() - timeTest05;
        final var milliseconds = TimeUnit.NANOSECONDS.toMillis(timeTest05);
        System.out.println("done in " + milliseconds + "ms");
    }

    private static void listReadElementPerformance(List<Integer> list, String displayName) {
        System.out.print("\nRead many times elements (" + READ_TIMES + ") to " + displayName + " ... ");
        long timeTest = System.nanoTime();

        for (int i = 0; i <= READ_TIMES; i++) {
            list.get(list.size() / 2);
        }

        timeTest = System.nanoTime() - timeTest;
        final var milliseconds = TimeUnit.NANOSECONDS.toMillis(timeTest);
        System.out.println("done in " + milliseconds + "ms");
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> al01 = new ArrayList<>();
        for (int i = MIN_INTEGER; i <= MAX_INTEGER; i++) {
            al01.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> ll01 = new LinkedList<>(al01);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmpItemValue = al01.get(al01.size() - 1);
        tmpItemValue = al01.set(0, tmpItemValue);
        al01.set(al01.size() - 1, tmpItemValue);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.print("ArrayList items: [ ");
        for (Integer item : al01) {
            System.out.print(item + " ");
        }
        System.out.println("]");

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        listAddNewElementsPerformance(al01, "ArrayList<Integer>");
        listAddNewElementsPerformance(ll01, "LinkedList<Integer>");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        listReadElementPerformance(al01, "ArrayList<Integer>");
        listReadElementPerformance(ll01, "LinkedList<Integer>");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> continentsPopulation = new HashMap<>();
        continentsPopulation.put("Africa", AFRICA_POPULATION);
        continentsPopulation.put("Americas", AMERICAS_POPULATION);
        continentsPopulation.put("Antarctica", ANTARCTICA_POPULATION);
        continentsPopulation.put("Asia", ASIA_POPULATION);
        continentsPopulation.put("Europe", EUROPE_POPULATION);
        continentsPopulation.put("Oceania", OCEANIA_POPULATION);

        /*
         * 8) Compute the population of the world
         */
        Long globalPopulation = 0L;
        for (String key : continentsPopulation.keySet()) {
            globalPopulation += continentsPopulation.get(key);
        }
        System.out.println("\nGlobal population is: " + String.format("%,d", globalPopulation));
    }
}
