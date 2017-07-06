package Recursive;

import java.util.ArrayList;

public class Recursive {

    /**
     * the function solves the hanoi task
     * @param N - number of disks
     * @return positions - a resulting array with disks positions on each step
     */

    public static ArrayList<int[]> hanoi(int N){


        int movements_num = (int)Math.pow(2, N) - 1;
        ArrayList<int[]> positions = new ArrayList<>(movements_num);

        //each element means a disk on a rode disks[i]
        int[] disks = new int[N];
        for (int i = 0; i < N; i++) {
            disks[i] = 1;
        }

        hanoi_rec(N - 1, 1, disks, positions);

        return positions;
    }

    private static void hanoi_rec(int disk_number, int d, int[] disks, ArrayList<int[]> positions){

        if (disk_number == -1) return;
        hanoi_rec(disk_number - 1, -d, disks, positions);
        shift(disk_number, d, disks, positions);
        hanoi_rec(disk_number - 1, -d, disks, positions);

    }

    private static void shift(int disk_number, int d, int[] disks, ArrayList<int[]> positions){
        /*shifting disk with number N to rod d
          cycling rods:
          r1 - 1 = r3
          r1 + 1 = r2
        */
        disks[disk_number] = (disks[disk_number] + d) % 3;

        if (disks[disk_number] < 0){
            disks[disk_number] += 3; //3 - disks[disk_number] + 1
        }

        int[] curr = copy(disks);

        positions.add(curr);
    }


    private static int[] copy(int[] a){
        int len = a.length;
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            b[i] = a[i];
        }
        return b;
    }

    public static void print_hanoi(int[] disks){
        int N = disks.length;
        int[][] rods = new int[N][3];

        for (int j = N - 1; j >= 0; j--) {
            int pos = disks[j] - 1;
            int i;
            for (i = N-1; i >= 0 && rods[i][pos] != 0 ; i--);

            rods[i][pos] = j + 1;
        }

        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(rods[i][j] + " ");
            }
            System.out.println();
        }
    }

}
