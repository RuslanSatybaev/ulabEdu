package homework.task3;

/**
 * Реализовать функцию нечеткого поиска
 * <pre>   {@code
 *   fuzzySearch("car", "ca6$$#_rtwheel"); // true
 *   fuzzySearch("cwhl", "cartwheel"); // true
 *   fuzzySearch("cwhee", "cartwheel"); // true
 *   fuzzySearch("cartwheel", "cartwheel"); // true
 *   fuzzySearch("cwheeel", "cartwheel"); // false
 *   fuzzySearch("lw", "cartwheel"); // false
 *   </pre>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    public static boolean fuzzySearch(String mainWord, String suggest) {
        if (suggest.length() < mainWord.length()) {
            return false;
        }

        int mainWordCount = 0;
        for (int i = 0; i < suggest.length() && mainWordCount < mainWord.length(); i++) {
            if (suggest.charAt(i) == mainWord.charAt(mainWordCount)) {
                mainWordCount++;
            }
        }
        return mainWordCount == mainWord.length();
    }
}
