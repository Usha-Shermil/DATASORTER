// Prabhavi- Main.java
import java.util.*;

public class Main {
    static int[] numbers = {};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandom();
                case 3 -> displayResult(BubbleSort.sort(numbers));
                case 4 -> displayResult(MergeSort.sort(numbers));
                case 5 -> displayResult(QuickSort.sort(numbers));
                case 6 -> compareAll();
                case 7 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 7);
    }

    private static void enterNumbers() {
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        numbers = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) numbers[i] = sc.nextInt();
    }

    private static void generateRandom() {
        System.out.print("Enter number of random elements: ");
        int n = sc.nextInt();
        numbers = DataGenerator.generate(n);
        System.out.println("Random dataset generated: " + Arrays.toString(numbers));
    }

    private static void displayResult(SortResult result) {
        System.out.println("\nAlgorithm: " + result.name);
        System.out.println("Sorted Output: " + Arrays.toString(result.sortedArray));
        System.out.println("Time Taken: " + result.timeTaken + " ms");
        System.out.println("Steps Count: " + result.steps);
    }

    private static void compareAll() {
        if (numbers.length == 0) {
            System.out.println("No data available. Please input or generate numbers first.");
            return;
        }

        SortResult bubble = BubbleSort.sort(numbers);
        SortResult merge = MergeSort.sort(numbers);
        SortResult quick = QuickSort.sort(numbers);

        System.out.println("\n--- Algorithm Performance Comparison ---");
        System.out.printf("%-15s %-15s %-10s%n", "Algorithm", "Time(ms)", "Steps");
        System.out.println("--------------------------------------------");
        System.out.printf("%-15s %-15d %-10d%n", bubble.name, bubble.timeTaken, bubble.steps);
        System.out.printf("%-15s %-15d %-10d%n", merge.name, merge.timeTaken, merge.steps);
        System.out.printf("%-15s %-15d %-10d%n", quick.name, quick.timeTaken, quick.steps);
    }
}

// Helper class to generate random data
class DataGenerator {
    public static int[] generate(int size) {
        Random r = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = r.nextInt(100); // random 0–99
        }
        return data;
    }
}

// // Result class used by all algorithms
class SortResult {
    int[] sortedArray;
    long timeTaken;
    int steps;
    String name;

    SortResult(int[] sortedArray, long timeTaken, int steps, String name) {
        this.sortedArray = sortedArray;
        this.timeTaken = timeTaken;
        this.steps = steps;
        this.name = name;
    }
}
