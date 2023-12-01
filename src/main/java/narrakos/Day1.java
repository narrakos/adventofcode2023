package narrakos;

import narrakos.util.ResourceReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    private static final int ASCII_0 = 48;
    private static final int ASCII_9 = 57;
    List<String> lines = ResourceReader.getLines("day1/input");

    public int solvePartOne() {
        return lines.stream()
                .map(String::chars)
                .map(charStream -> charStream.filter(c -> c >= ASCII_0 && c <= ASCII_9))
                .map(charStream -> charStream.mapToObj(c -> ((char) c)).toList())
                .map(line -> line.getFirst().toString() + line.getLast().toString())
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .orElseThrow();
    }

    public int solvePartTwo() {
        return lines.stream()
                .map(this::getIntegersFromLine)
                .map(line -> line.getFirst() * 10 + line.getLast())
                .reduce(Integer::sum)
                .orElseThrow();
    }

    private List<Integer> getIntegersFromLine(String l) {
        boolean[] deletePositionFlag = new boolean[l.length()];
        Map<Integer, SpelledNumber> spelledNumbersInWord = new HashMap<>();
        for (int i = 0; i < l.length(); i++) {
            for (SpelledNumber number : SpelledNumber.values()) {
                if (l.substring(i).startsWith(number.getSpelledNumber())) {
                    spelledNumbersInWord.put(i, number);
                    for (int j = i; j < number.getSpelledNumber().length(); j++) {
                        deletePositionFlag[j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l.length(); i++) {
            if (spelledNumbersInWord.containsKey(i)) {
                sb.append(spelledNumbersInWord.get(i).getNumber());
            }
            if (!deletePositionFlag[i] && Character.isDigit(l.charAt(i))) {
                sb.append(l.charAt(i));
            }
        }

        return sb.chars()
                .map(asciiNum -> asciiNum - ASCII_0)
                .boxed()
                .toList();
    }

}

enum SpelledNumber {

    ZERO("zero", 0),
    ONE("one", 1),
    TWO("two", 2),
    THREE("three", 3),
    FOUR("four", 4),
    FIVE("five", 5),
    SIX("six", 6),
    SEVEN("seven", 7),
    EIGHT("eight", 8),
    NINE("nine", 9);

    private final String spelledNumber;
    private final int number;

    SpelledNumber(String spelledNumber, int number) {
        this.spelledNumber = spelledNumber;
        this.number = number;
    }

    public String getSpelledNumber() {
        return spelledNumber;
    }

    public int getNumber() {
        return number;
    }
}
