// Ashan - BubbleSort.java
public class BubbleSort {
    public static SortResult sort(int[] arr) {
        int[] data = arr.clone();
        int n = data.length;
        int steps = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        return new SortResult(data, (endTime - startTime) / 1000000, steps, "Bubble Sort");
    }
}