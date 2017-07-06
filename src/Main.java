import Recursive.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<int[]> positions = Recursive.hanoi(5);

        for (int[] el: positions) {
            for (int disk: el) {
                System.out.print(disk + " ");
            }
            System.out.println();
        }


        Recursive.print_hanoi(positions.get(5));
    }



}
