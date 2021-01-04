public class FizzBuzzmain {

    public static void main(String args[]) {

        FizzBuzz test = new FizzBuzz();
        String result = test.fizzBuzz(3);
        System.out.println(result);
        result = test.fizzBuzz(5);
        System.out.println(result);
        result = test.fizzBuzz(15);
        System.out.println(result);
        result = test.fizzBuzz(2);
        System.out.println(result);
    }
}