package scaler.heaps;

import java.util.ArrayList;

public class Seats {

    public static int seats(String A) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) =='x') {
                indexes.add(i);
            }
        }

        int median;
        if (indexes.size() % 2 != 0) {
            median = indexes.size() / 2;
        } else {
            median = indexes.size() / 2 - 1;
        }

        int startIdx = indexes.get(median), endIdx = indexes.get(median);
        for (int i = startIdx; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                endIdx++;
            } else {
                break;
            }
        }

        int moves = 0;
        for (int i = startIdx - 1; i >= 0; i--) {
            if (A.charAt(i) == 'x') {
                moves += startIdx - i - 1;
                startIdx--;
            }
        }

        for (int i = endIdx; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                moves += i - endIdx;
                endIdx++;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        System.out.println(seats("....x..xx...x.."));
        System.out.println(seats("....xxx"));
        System.out.println(seats(".x..xx...xxx..x."));
        System.out.println(seats(".x.x.x..x"));
    }
}
