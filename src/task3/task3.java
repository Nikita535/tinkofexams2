package task3;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /** считываем число дней **/
        int size = Integer.parseInt(sc.nextLine());

        /** инициализируем максимум и минимум для четного и нечетное индекса **/
        int number, maxEven = Integer.MIN_VALUE, minOdd = Integer.MAX_VALUE, sum = 0;

        /**
         * Идея состоит в том, что на четных индексах стоят подписки, а на нечетных отписки
         * Поэтому, чтобы выгода была максимально большой, мы должны менять местами самую большую отписку
         * с самой маленькой подпиской
         * Было: [3
         *       1 3 2]
         *          Результат: 1-3+2=0
         * Стало: [3
         *         1 3 2]
         *          Результат: 3-1+2=4
         *
         */
        for (int i = 0; i < size ; i++){
            number = sc.nextInt();
            if (i % 2 == 0)
            {
                sum += number;
                if (number < minOdd)
                    minOdd = number;
            }else{
                sum -= number;
                if (number > maxEven)
                    maxEven = number;
            }

        }

        /** В выводе мы еще учитываем тот, факт, что эти числа уже были в исходной п-ти и вычитаем и добавляем их удвоенной кол-во **/
        System.out.print(Math.max(sum, sum - 2 * minOdd + 2 * maxEven));

    }
}
