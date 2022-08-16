package task5;

import java.util.*;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizes = scanner.nextLine().split(" ");
        int sizeOfSurnames = Integer.parseInt(sizes[0]);
        int sizeOfSend = Integer.parseInt(sizes[1]);

        List<String> surnames = new ArrayList<>();

        for (int i = 0; i < sizeOfSurnames; i++) {
            surnames.add(scanner.nextLine());
        }

        //3 a   4
        // 2 ab   4
        //1 b  5

        Collections.sort(surnames);
        System.out.println(surnames);
    }
}
