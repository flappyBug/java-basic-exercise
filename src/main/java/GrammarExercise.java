import java.util.*;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner scanner = new Scanner(System.in);
        String firstWordList = scanner.nextLine();
        String secondWordList = scanner.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        //按要求输出到命令行
        System.out.println(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        validate(firstWordList);
        validate(secondWordList);
        firstWordList = firstWordList.toUpperCase();
        secondWordList = secondWordList.toUpperCase();
        Set<String> firstGroup = Arrays.stream(firstWordList.split(",")).collect(Collectors.toSet());
        SortedSet<String> commonWords = new TreeSet<>();
        for (String word : secondWordList.split(",")) {
            if (firstGroup.contains(word)) {
                commonWords.add(toSpaced(word));
            }
        }
        return new ArrayList<>(commonWords);
    }

    private static void validate(String s) {
        if (!s.matches("\\w+(,\\w+)*")) {
            throw new RuntimeException("Invalid string list");
        }
    }

    private static String toSpaced(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            stringBuilder.append(' ');
            stringBuilder.append(word.charAt(i));
        }
        return stringBuilder.toString();
    }
}
