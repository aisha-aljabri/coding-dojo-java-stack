import java.util.*;
public class BasicJava{
    public static void main(String[] args){
        print255();
        printodd();
        sum();
        Iterating();
        max();
        average();
        oddNum();
        GreaterY();
        Square();
        Negative();
        MaxMinAvg();
    }

    public static void print255(){
        for (int i = 1; i < 256; i++) {
            System.out.println(i);
        }
    }

    public static void printodd(){
        for (int i = 1; i < 256; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    public static void sum(){
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            System.out.print("New number: " + i);
            System.out.println(" Sum: " + (sum += i));
        }
    }

    public static void Iterating(){
        int[] arr = {1,3,5,7,9,13};
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void max(){
        int[] arr = {-3, -5, -7};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println( max);
    }

    public static void average(){
        int[] arr = {2, 10, 3};
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println((double)sum / arr.length);
    }


    public static void oddNum(){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < 256; i++){
            if (i % 2 == 1){
                arr.add(i);
            }
        }
        System.out.println(arr);
    }

    public static void GreaterY(){
        int[] arr = {1, 3, 5, 7};
        int y = 3;
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > y){
                count ++;
            }
        }
        System.out.println(count);
    }

    public static void Square(){
        int[] arr = {1, 5, 10, -2};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        System.out.print(Arrays.toString(arr));
    }

    public static void Negative(){
        int[] arr = {1, 5, 10, 0};
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                arr[i] = 0;
            }
            System.out.println(arr[i] + ",");
        }
    }

    public static void MaxMinAvg() {
        int[] arr = {1, 5, 10, -2};
        int[] result=new int[3];
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
            sum += arr[i];
        }
        
        result[0]=max;
        result[1]=min;
        result[2]=sum / arr.length;
        System.out.println(max+" "+min+" "+sum);
    }



}
