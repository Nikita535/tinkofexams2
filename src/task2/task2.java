package task2;

import java.util.*;
import java.util.stream.Collectors;

public class task2 {
    public static void main(String[] args) {
        /** ассоциативный массив с ключом - команда, значением - кол-во встреч таких команд, но в разных составах **/
        Map<List<String>, Integer> AllOneTeam = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        /** считываем кол-во команд **/
        int length = Integer.parseInt(sc.nextLine());

        /** список под одну команду **/
        List<String> OneTeam;

        /** флаг, который отвечает за то, добавили ли мы уже команду или нет **/
        boolean isOneTeamInserted;

        /** наш элемент максимума проинициализированный нулём **/
        int max = 0;

        for (int i = 0; i < length; i++){
            isOneTeamInserted = true;
            /** считываем строку одной команды, сплитим ее по пробелам и собираем в список (stream) **/
            OneTeam = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());

            /** идём по словарю **/
            for(List<String> key: AllOneTeam.keySet())
            {
                /**
                 * 1) если уже такой набор людей содержится, то кладем команду с увеличенным значением
                 * и ставим флаг в false
                 * 2) ищем максимум
                 * **/
                if (new HashSet<>(key).containsAll(OneTeam)) {
                    AllOneTeam.put(key, AllOneTeam.get(key) + 1);
                    isOneTeamInserted = false;
                    if (AllOneTeam.get(key) > max)
                        max = AllOneTeam.get(key);
                }

            }
            /**
             * Если команды такой еще не вставлялось, то добавляем ее со значением 1
             */
            if (isOneTeamInserted)
                AllOneTeam.put(OneTeam, 1);
        }

        System.out.println(max);
    }
}
