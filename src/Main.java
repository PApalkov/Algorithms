import Recursive.*;
import Recursive.DynamicProgramming.BagPacking;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        bagPackingTest(10, 100);
    }

    public static void bagPackingTest(int N, int capacity){

        BagPacking.Item[] items = new BagPacking.Item[N];


        Random rand = new Random();

        int size, value;
        for (int i = 0; i < items.length; i++) {
            size = rand.nextInt(capacity / 2);
            value = rand.nextInt(capacity / 2);

            items[i] = new BagPacking.Item(size, value);
        }

        try {

            System.out.println("Max value DP: " + BagPacking.DynamicProgrammingCount(capacity, items));
            System.out.println("Max value BF: " + BagPacking.BruteForceCount(capacity, items));

        } catch (StackOverflowError e){
            System.err.println(e);
        }

        for (BagPacking.Item e: items) {
            e.print();
        }

       /*
        int size, value;
        Scanner in  = new Scanner(System.in);
        for (int i = 0; i < items.length; i++) {
            size = in.nextInt();
            value = in.nextInt();
            items[i] = new BagPacking.Item(size, value);
        }

        System.out.println("Max value: " + BagPacking.BruteForceCount(capacity, items));
        System.out.println("Max value: " + BagPacking.DynamicProgrammingCount(capacity, items));


        */
    }


    public static void recursiveTest(int N, int step){
        ArrayList<int[]> positions = Recursive.hanoi(N);

        for (int[] el: positions) {
            for (int disk: el) {
                System.out.print(disk + " ");
            }
            System.out.println();
        }

        Recursive.print_hanoi(positions.get(step));
    }
}

