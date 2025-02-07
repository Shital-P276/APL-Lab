import java.util.Arrays;
import java.util.Scanner;

public class Pmkexp2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Array Operations Program!");
        System.out.print("Please enter the size of the array: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        int[] array = new int[size];

        System.out.println("Enter " + size + " integers for the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            scanner.nextLine();
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
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to search for: ");
                    int elementToSearch = scanner.nextInt();
                    scanner.nextLine();
                    int linearSearchResult = linearSearch(array, elementToSearch);
                    if (linearSearchResult == -1) {
                        System.out.println("Linear Search result: Element " + elementToSearch + " not found");
                    } else {
                        System.out.println("Linear Search result: Element " + elementToSearch + " found at index "
                                + linearSearchResult);
                    }
                    break;
                case 2:
                    System.out.print("Enter the element to search for: ");
                    elementToSearch = scanner.nextInt();
                    scanner.nextLine();
                    Arrays.sort(array);
                    int binarySearchResult = binarySearch(array, elementToSearch);
                    if (binarySearchResult == -1) {
                        System.out.println("Binary Search result: Element " + elementToSearch + " not found");
                    } else {
                        System.out.println("Binary Search result: Element " + elementToSearch + " found at index "
                                + binarySearchResult);
                    }
                    break;
                case 3:
                    System.out.println("Array before sorting: " + Arrays.toString(array));
                    bubbleSort(array);
                    System.out.println("Array after Bubble Sort: " + Arrays.toString(array));
                    break;
                case 4:
                    System.out.println("Array before sorting: " + Arrays.toString(array));
                    selectionSort(array);
                    System.out.println("Array after Selection Sort: " + Arrays.toString(array));
                    break;
                case 5:
                    System.out.println("Array before sorting: " + Arrays.toString(array));
                    insertionSort(array);
                    System.out.println("Array after Insertion Sort: " + Arrays.toString(array));
                    break;
                case 6:
                    System.out.println("Array before sorting: " + Arrays.toString(array));
                    mergeSort(array, 0, array.length - 1);
                    System.out.println("Array after Merge Sort: " + Arrays.toString(array));
                    break;
                case 7:
                    System.out.println("Array before sorting: " + Arrays.toString(array));
                    quickSort(array, 0, array.length - 1);
                    System.out.println("Array after Quick Sort: " + Arrays.toString(array));
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);

        System.out.println("Thank you for using the Array Operations Program!");
        scanner.close();
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
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
