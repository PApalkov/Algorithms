package Recursive.DynamicProgramming;

/**
 * A class with methods solving the pack task
 */
public class BagPacking {

    private static int unknown = -1;

    public static class Item{
        private int size;
        private int value;

        public Item(int size, int value) {
            this.size = size;
            this.value = value;
        }

        public int getSize() {
            return size;
        }

        public int getValue() {
            return value;
        }

        public void print(){
            System.out.println("Size: " + size + "; Value: " + value);
        }
    }

    public static int BruteForceCount(int capacity, Item[] items){
        int  max = 0, t, space;
        int N = items.length;

        for (int i = 0; i < N; i++) {
            space = capacity - items[i].getSize();

            if (space >= 0){
                t = BruteForceCount(space, items) + items[i].getValue();
                if (t > max) max = t;
            }
        }
        return max;
    }

    public static int DynamicProgrammingCount(int capacity, Item[] items){
        int[] maxKnown = new int[capacity + 1];
        for (int i = 0; i < maxKnown.length; i++) {
            maxKnown[i] = unknown;
        }

        return DPCount(capacity, items, maxKnown);
    }

    public static int DPCount(int curr_capacity, Item[] items, int[] maxKmown){
        int  max = 0, t, space;
        int N = items.length;

        if (maxKmown[curr_capacity] != unknown) return maxKmown[curr_capacity];

        for (int i = 0; i < N; i++) {
            space = curr_capacity - items[i].getSize();
            if (space >= 0){
                t = DPCount(space, items, maxKmown) + items[i].getValue();
                if (t > max) max = t;
            }
        }

        maxKmown[curr_capacity] = max;

        return max;
    }

}
