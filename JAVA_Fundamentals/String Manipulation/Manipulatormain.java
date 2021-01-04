public class Manipulatormain{
    public static void main(String args[]) {

        StringManipulator test = new StringManipulator();
        String result = test.trimAndConcat("  Hello  ", "   World  ");
        System.out.println(result);

        char letter = 'o';
        Integer a = test.getIndexOrNull("Coding", letter);
        Integer b = test.getIndexOrNull("Hello World", letter);
        Integer c = test.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c);

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer a1 = test.getIndexOrNull(word, subString);
        Integer b1 = test.getIndexOrNull(word, notSubString);
        System.out.println(a1); // 2
        System.out.println(b1);


        String word1 = test.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word1); // eworld
    }


}