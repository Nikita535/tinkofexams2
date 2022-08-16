package task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /** Считываем ко-во закупленных доменов и кол-во покупателей **/
        List<Integer> lens = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

        List<String> listOfDomain = new ArrayList<>();

        /** считываем и заполняем список с доменами **/
        for (int i = 0; i < lens.get(0); i++) {
            listOfDomain.add(scanner.nextLine());
        }

        /**
         * 1) считываем и заполняем список с префиксами и постфиксами
         * 2) с помощью streamApi оставляем в списке доменов только те, которые
         * включают в себя нужный префикс и постфикс и подсчитываем их кол-во
         * **/
        for (int i = 0; i < lens.get(1); i++) {
            List<String> prAndPf = Arrays.stream(scanner.nextLine().split(" ")).toList();

            System.out.println(
                    listOfDomain.stream().filter(elem -> elem.startsWith(prAndPf.get(0)) &&
                            elem.endsWith(prAndPf.get(1))).count()
            );
        }
    }
}
