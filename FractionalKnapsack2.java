import java.util.Scanner;

class Item {
    int v;  // Value of the item
    int w;  // Weight of the item
    float d;  // Value-to-weight ratio (v/w)

    Item(int v, int w) {
        this.v = v;
        this.w = w;
        this.d = (float) v / w;  // Calculate value-to-weight ratio
    }
}

 class FractionalKnapsack2 {

    public static void input(Item[] items) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < items.length; i++) {
            items[i].v = sc.nextInt();
            items[i].w = sc.nextInt();
            items[i].d = (float) items[i].v / items[i].w;  // Calculate ratio for sorting
        }
    }

    public static void display(Item[] items) {
        System.out.print("Values: ");
        for (Item item : items) {
            System.out.print(item.v + " ");
        }
        System.out.println();

        System.out.print("Weights: ");
        for (Item item : items) {
            System.out.print(item.w + " ");
        }
        System.out.println();
    }

    // Sort the items based on value-to-weight ratio in descending order
    public static void bubbleSort(Item[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - i - 1; j++) {
                if (items[j].d < items[j + 1].d) {
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
    }

    public static float knapsack(Item[] items, int W) {
        float totalValue = 0, totalWeight = 0;

        // Sort items by value-to-weight ratio in descending order
        bubbleSort(items);

        // Select items based on sorted order
        for (Item item : items) {
            if (totalWeight + item.w <= W) {
                totalValue += item.v;
                totalWeight += item.w;
            } else {
                int remainingWeight = W - (int) totalWeight;
                totalValue += remainingWeight * item.d;  // Add fraction of the item
                totalWeight += remainingWeight;
                break;  // The bag is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item[] items = new Item[4];

        // Input the item values and weights
        for (int i = 0; i < 4; i++) {
            items[i] = new Item(sc.nextInt(), sc.nextInt());
        }

        // Display item values and weights
        display(items);

        // Input the maximum weight of the backpack
        int W = sc.nextInt();

        // Calculate the maximum value that can be obtained with the given weight
        float maxValue = knapsack(items, W);

        // Calculate the total weight of items in the knapsack
        float totalWeight = 0;
        for (Item item : items) {
            if (totalWeight + item.w <= W) {
                totalWeight += item.w;
            } else {
                int remainingWeight = W - (int) totalWeight;
                totalWeight += remainingWeight;
                break;
            }
        }

        // Output the total weight and maximum value rounded to 2 decimal places
        System.out.printf("Total weight in bag: %.2f\n", totalWeight);
        System.out.printf("Max value for %d weight is %.2f\n", W, maxValue);
    }
}