// Shital M. Patil
// Batch   : B-II
// Roll.No : B-77  
// Program : Expt 01-B (Arrays and flow control statements) 

import java.util.Arrays;
import java.util.Scanner;

public class SearchSort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int choice;
        int size = 0;

        
        while (true) {
            System.out.print("Enter the size of array: ");
            if (scn.hasNextInt()) {
                size = scn.nextInt();
                scn.nextLine();
                break;
            } else {
                System.out.print("Invalid Input , Please enter an integer\n");
                scn.nextLine();// consume the invalid input
            }
        }

        int arr[] = new int[size];

        System.out.println("\nEnter " + size + " elements :");

        for (int i = 0; i < arr.length; i++) {
            while(true){
                System.out.print("Element " + (i + 1) + ": ");
                if (scn.hasNextInt()) {
                    arr[i] = scn.nextInt();
                    scn.nextLine();
                    break;
                } else {
                    System.out.print("Invalid Input , Please enter an integer\n");
                    scn.nextLine();// consume the invalid input
                }
            }
        }

        while (true) {
            System.out.print(
                    "\nMenu: \nChoose an operation\n 1]Linear Search\n 2]Binary Search\n 3]Bubble Sort\n 4]Selection Sort\n 5]Insertion Sort\n 6]Merge Sort\n 7]Quick Sort \n 8]Quit \nEnter an operation: ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to search for: ");
                    int elementToSearch = scn.nextInt();
                    scn.nextLine();
                    int linearSearchResult = linSearch(arr, elementToSearch);
                    if (linearSearchResult == -1) {
                        System.out.println("Linear Search result: Element " + elementToSearch + " not found");
                    } else {
                        System.out.println("Linear Search result: Element " + elementToSearch + " found at index "
                                + linearSearchResult);
                    }
                    break;

                case 2:
                    System.out.print("Enter the element to search for: ");
                    elementToSearch = scn.nextInt();
                    scn.nextLine();
                    Arrays.sort(arr);
                    int binarySearchResult = binarySearch(arr, elementToSearch);
                    if (binarySearchResult == -1) {
                        System.out.println("Binary Search result: Element " + elementToSearch + " not found");
                    } else {
                        System.out.println("Binary Search result: Element " + elementToSearch + " found at index "
                                + binarySearchResult);
                    }
                    break;

                case 3:
                    System.out.println("Array before sorting: " + Arrays.toString(arr));
                    bubbleSort(arr);
                    System.out.println("Array after Bubble Sort: " + Arrays.toString(arr));
                    break;

                case 4:
                    System.out.println("Array before sorting: " + Arrays.toString(arr));
                    selectionSort(arr);
                    System.out.println("Array after Selection Sort: " + Arrays.toString(arr));
                    break;

                case 5:
                    System.out.println("Array before sorting: " + Arrays.toString(arr));
                    insertionSort(arr);
                    System.out.println("Array after Insertion Sort: " + Arrays.toString(arr));
                    break;

                case 6:
                    System.out.println("Array before sorting: " + Arrays.toString(arr));
                    mergeSort(arr, 0, arr.length - 1);
                    System.out.println("Array after Merge Sort: " + Arrays.toString(arr));
                    break;

                case 7:
                    System.out.println("Array before sorting: " + Arrays.toString(arr));
                    quickSort(arr, 0, arr.length - 1);
                    System.out.println("Array after Quick Sort: " + Arrays.toString(arr));
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scn.close();
                    return;

                default:
                    System.out.println("Invalid Choice , Please try again");
                    break;
            }
        }

    }

    public static int linSearch(int a[], int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return i;
        }

        return -1;
    }

    public static int binarySearch(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void selectionSort(int a[]) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min_idx])
                    min_idx = j;
            }

            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

    public static void insertionSort(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int k = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j = j - 1;
            }

            a[j + 1] = k;
        }
    }

    public static void merge(int a[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int a[], int l, int r) {
        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);

            merge(a, l, m, r);
        }
    }

    public static void quickSort(int a[], int l, int h) {
        if (l < h) {
            int pi = partition(a, l, h);

            quickSort(a, l, pi - 1);
            quickSort(a, pi + 1, h);
        }
    }

    public static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (a[j] <= pivot) {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }
}