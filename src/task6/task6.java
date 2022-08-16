package task6;

import java.util.*;
import java.util.stream.Collectors;

public class task6 {

    /** Словарь с ключом - перемещение лифта, значение - кол-во одинаковых путей
     * LinkedHashMap - потому что нам важен порядок
     * **/
    private static final Map<List<Integer>, Integer> AllLiftsWithLength = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /** считываем кол-во лифтов  **/
        int sizeOfLifts = Integer.parseInt(scanner.nextLine());

        /** Список под лифты **/
        List<List<Integer>> AllLifts = new ArrayList<>();

        for (int i = 0; i < sizeOfLifts; i++) {
            /** считываем строку с путями лифта и преобразуем к int **/
            List<Integer> lift = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

            /** Если уже такой лифт есть, то просто увеличиваем значение в словаре
             * Если нет, то кладем новый в словарь
             * **/
            if (AllLiftsWithLength.containsKey(lift) && Objects.equals(lift.get(0), lift.get(1)))
                AllLiftsWithLength.put(lift, AllLiftsWithLength.get(lift) + 1);
            else {
                AllLiftsWithLength.put(lift, 1);
                AllLifts.add(lift);
            }
        }
        /** запуск рекурсивной ф-ии поиска **/
        System.out.println(searchMaxLength(-1, AllLifts, 0));
    }

    
    public static int searchMaxLength(Integer lastElement, List<List<Integer>> AllLifts, Integer count) {
        List<Integer> AllMaximums = new ArrayList<>();
        for (int i = 0; i < AllLifts.size(); i++)
        /** Каждый раз в функцию мы передаем список без прошлого лифта, тем самым
         * Сокращая время поиска длиннейшего пути.
         * lastElement=-1 означает, что это первое заполнение, чтобы проинициализировать словарь,
         * иначе будет ошибка
         * **/
            if (Objects.equals(lastElement, AllLifts.get(i).get(0)) || lastElement == -1) {
                /** создал еще одну переменную I? потому что потоки не принимают старую... **/
                int I = i;
                AllMaximums.add(searchMaxLength(AllLifts.get(i).get(1),
                        new ArrayList<>(AllLifts.stream().filter(elem -> elem !=
                                AllLifts.get(I)).collect(Collectors.toList())),
                        count + AllLiftsWithLength.get(AllLifts.get(i))));
            }
        if (AllMaximums.size() == 0)
            return count;
        return Collections.max(AllMaximums);
    }
}
