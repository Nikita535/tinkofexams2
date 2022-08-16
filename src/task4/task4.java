package task4;

import java.util.*;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentLine;
        Long level = 1L;



        Map<String, Map<Long, Long>> variables = new HashMap<>();

        while (true){
            currentLine = scanner.nextLine();

            if (Objects.equals(currentLine, ""))
                break; // strange

            if (Objects.equals(currentLine, "{"))
            {
                level ++;
                for (Map.Entry<String, Map<Long, Long>> variable : variables.entrySet())
                {
                    Map<Long, Long> help1 = variable.getValue();
                    help1.put(level, help1.get(level - 1));
                    variables.put(variable.getKey(), help1);
                }
            }
            else if (Objects.equals(currentLine, "}")) {
                for (Map.Entry<String, Map<Long, Long>> variable : variables.entrySet())
                {
                    Map<Long, Long> value = variable.getValue();
                    value.remove(level);
                }
                level--;
            }
            else {

                List<String> help = Arrays.stream(currentLine.split("=")).toList();

                if (!help.get(1).matches("[-+]?\\d+")) {
                    Long valueFrom = 0L;
                    if (variables.containsKey(help.get(1)))
                        valueFrom = variables.get(help.get(1)).get(level);

                    if (!variables.containsKey(help.get(0))) {
                        Map<Long, Long> test4 = new HashMap<>();
                        test4.put(level, valueFrom);
                        variables.put(help.get(0), test4);
                    }else {
                        Map<Long, Long> test = variables.get(help.get(0));
                        test.put(level, valueFrom);
                        variables.put(help.get(0), test);
                    }
                    System.out.println(valueFrom);
                }else {
                    if (variables.containsKey(help.get(0))) {
                        Map<Long, Long> valueTo = variables.get(help.get(0));
                        valueTo.put(level, Long.parseLong(help.get(1)));
                        variables.put(help.get(0), valueTo);

                    }else {
                        Map<Long, Long> valueTo = new HashMap<>();
                        valueTo.put(level, Long.parseLong(help.get(1)));
                        variables.put(help.get(0), valueTo);
                    }
                }
            }
        }
    }
}
