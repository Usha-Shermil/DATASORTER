// Shermil- QuickSort.java
public class QuickSort {
    private static int steps;

    public static SortResult sort(int[] arr) {
        int[] data = arr.clone();
        steps = 0;
        long startTime = System.nanoTime();
        quickSort(data, 0, data.length - 1);
        long endTime = System.nanoTime();

        return new SortResult(data, (endTime - startTime) / 1000000, steps, "Quick Sort");
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            steps++;
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            steps++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
