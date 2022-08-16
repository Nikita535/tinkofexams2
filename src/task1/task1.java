package task1;

import java.util.*;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * Создаём два списка для координат по x и по y
         **/
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        /**
         * 1)Заполняем списки: четный индекс - добавляем в x
         * 2) нечетный индекс - добавляем в y
         **/

        for (int i = 0; i < 4; i++)
        {
            x.add(scanner.nextInt());
            y.add(scanner.nextInt());
        }

        /**
         * 1) Для того, чтобы понять, какой итоговый квадрат нам нужен, мы можем просто
         *      посчитать разницу между максимальной координатой по x и y
         * 2) После чего сравнить полученные длины. Максимальная длина и будет стороной нужного квадрата.
         * 3) После чего возводим в квадрат
         **/

        int lengthX = Collections.max(x) - Collections.min(x);
        int lengthY = Collections.max(y) - Collections.min(y);
        if (lengthX > lengthY)
            System.out.print((int)Math.pow(lengthX, 2));
        else
            System.out.print((int)Math.pow(lengthY, 2));
    }
}
