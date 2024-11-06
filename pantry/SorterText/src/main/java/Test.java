public class Test {

    public static void main(String[] args) {
        String letters = "ABCD";
        String numbers = "1234";
        String mixed = "1ab2";

        System.out.println(containsLetters(letters));     // true
        System.out.println(containsLetters(numbers));     // false
        System.out.println(containsLetters(mixed));       // true
    }

    public static boolean containsLetters(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isLetter(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}
