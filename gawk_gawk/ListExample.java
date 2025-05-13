import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Using ArrayList (dynamically resizable array)
        List<String> arrayList = new ArrayList<>();
        System.out.println("ArrayList Example:");
        performListOperations(arrayList);
        System.out.println("\n--------------------\n");
        // Using LinkedList (doubly-linked list)
        List<String> linkedList = new LinkedList<>();
        System.out.println("LinkedList Example:");
        performListOperations(linkedList);
    }

    public static void performListOperations(List<String> list) {
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println("Initial list: " + list);
    
        list.add(1, "Mango");
        System.out.println("List after adding at index 1: " + list);
        
        String elementAtIndex2 = list.get(2);
        System.out.println("Element at index 2: " + elementAtIndex2);
        
        boolean containsBanana = list.contains("Banana");
        System.out.println("Does the list contain 'Banana'? " + containsBanana);
        
        int indexOfOrange = list.indexOf("Orange");
        System.out.println("Index of 'Orange': " + indexOfOrange);
        
        int size = list.size();
        System.out.println("Size of the list: " + size);
        
        System.out.println("Elements in the list:");
        for (String fruit : list) {
            System.out.println(fruit);
        }
        
        list.remove("Banana");
        System.out.println("List after removing 'Banana': " + list);
        
        list.remove(0);
        System.out.println("List after removing element at index 0: " + list);
        
        list.clear();
        System.out.println("List after clearing: " + list);
        
        boolean isEmpty = list.isEmpty();
        System.out.println("Is the list empty? " + isEmpty);
    }
}
