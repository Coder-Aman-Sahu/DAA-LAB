import java.util.*;

public class BinSearch {
    static int comparison = 0;

    public static int binSearch(int[] arr, int i, int l, int x) {
        if (l == i) {
            if (x == arr[i])
                return i;
            else
                return 0;
        } else {
            int mid = (i + l) / 2;
            comparison++;
            if (x == arr[mid])
                return mid;
            else if (x < arr[mid])
                return binSearch(arr, i, mid - 1, x);
            else
                return binSearch(arr, mid + 1, l, x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.println("\nEnter the number to search: ");
        int x = sc.nextInt();
        sc.close();

        System.out.println(binSearch(arr, 0, arr.length - 1, x));
        System.out.println("Number of comparisons: " + comparison);
    }
}