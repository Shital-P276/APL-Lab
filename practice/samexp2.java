
import java.util.Arrays;
import java.util.Scanner;

public class samexp2 {
    public static void main(String[] args) {
        System.out.println("welcome to array operation: ");
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int size = scn.nextInt();
        int[] array = new int[size];

        System.out.println("Enter Elements in the array: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element"+(i+1)+":");
            array[i]=scn.nextInt();
        }
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        int choice;
        do { 
            System.out.println("\nChoose an operation:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("6. Merge Sort");
            System.out.println("7. Quick Sort");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            choice = scn.nextInt();
            scn.nextLine();
            switch (choice) {
                case 1:linearSearch(array, size);
                break;
                case 2:binarySearch(array, size);
                break;
                case 3:bubbleSort(array);
                break;
                case 4:selectionSort(array);
                break;
                case 5:insertionSort(array);
                break;
                case 6:mergeSort(array, 0, array.length - 1);
                    System.out.println("Array after Merge Sort: " + Arrays.toString(array));
                break;
                case 7:quickSort(array, 0, array.length - 1);
                System.out.println("Array after Quick Sort: " + Arrays.toString(array));
                break;
                case 8:
                System.out.println("Exiting the program.");
                break;
                default:
                System.out.println("Enter valid Input");
            }
        } while (choice != 8);

    }
    public static int linearSearch(int[] arr, int size) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter element to search: ");
        int target = scn.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int size) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter element to search: ");
        int target = scn.nextInt();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
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

