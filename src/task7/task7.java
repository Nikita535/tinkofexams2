package task7;

import java.util.*;
import java.util.stream.Collectors;

public class task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /** Считываем слово **/
        String word = scanner.nextLine();

        /** Считываем кол-во отрезков **/
        int size = Integer.parseInt(scanner.nextLine());

        /**
         * l - левая граница отрезка
         * r - правая граница отрезка
         * count - кол-во шагов
         * temp - временная переменная для подсчета финальных шагов
         * **/
        int l, r, count, temp;

        /** Циклом считываем все отрезки и берем левое и правое значения
         * этих отрезков
         * **/
        for (int i = 0; i < size; i++) {
            String [] segment=scanner.nextLine().split(" ");
            l = Integer.parseInt(segment[0]);
            r = Integer.parseInt(segment[1]);

            /** Создаём временное хранилище для букв из нужного
             * нам отрезка,
             * сохраняя их индексы в слове!!!
             * **/
            Map<Integer, Character> words = new HashMap<>();
            for (int j = l - 1; j < r; j++) {
                words.put(j + 1, word.charAt(j));
            }

            /** Сортируем наш словарь по алфавиту для того, чтобы было удобнее учитывать порядок алфавита
             * (так проще отслеживать к какой букве надо передвигаться дальше, т.к мы просто
             * идем по словарю)
             * **/
            Map<Integer, Character> letters = words.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue()).
                    collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            count = 0;
            temp = l;
            /** Считаем кол-во шагов count
             * len - длина отрезка
             * **/
            int len = r - l + 1;
            /** Проходимся по словарю **/
            for (Map.Entry<Integer, Character> letter:letters.entrySet()) {
                /** если следующая буква стоит спереди, то просто считаем кол-во шагов до нее **/
                if (temp <= letter.getKey())
                    count += letter.getKey() - temp;
                /** Если буква стоит сзади, то нам нужно пройти весь отрезок и отсчитывать с самого начала **/
                else count += len - temp + letter.getKey();
                /** меняем текущее положение **/
                temp = letter.getKey();
            }
            System.out.println(count);
        }
    }
}
