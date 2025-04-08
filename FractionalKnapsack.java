import java.util.*;

class FractionalKnapsack {

    static class Item {
        int weight;
        int value;
        double ratio;
        int index;

        Item(int weight, int value, int index) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
            this.index = index;
        }
    }

    // Comparator to sort the items based on their ratio in descending order
    static class ItemComparator implements Comparator<Item> {
        
        public int compare(Item a, Item b) {
            return Double.compare(b.ratio, a.ratio); // descending order
        }
    }

    // Function to calculate the maximum value in the fractional knapsack
    public static double fractionalKnapsack(int N, int W, int[] weights, int[] values) {
        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            items[i] = new Item(weights[i], values[i], i + 1);
        }

        // Sort items by value-to-weight ratio
        Arrays.sort(items, new ItemComparator());

        double totalValue = 0.0;
        int remainingCapacity = W;

        for (int i = 0; i < N; i++) {
            if (remainingCapacity == 0) break;

            if (items[i].weight <= remainingCapacity) {
                remainingCapacity -= items[i].weight;
                totalValue += items[i].value;
            } else {
                totalValue += items[i].value * ((double) remainingCapacity / items[i].weight);
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of items and the capacity of the knapsack
        int N = sc.nextInt();
        int W = sc.nextInt();
        
        int[] weights = new int[N];
        int[] values = new int[N];

        // Read the weights of the items
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        // Read the values of the items
        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }

        // Calculate the maximum value that can be obtained
        double maxValue = fractionalKnapsack(N, W, weights, values);

        // Print the result
        System.out.printf("%.2f\n", maxValue);

        sc.close();
    }
}