package Tests;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Algoritms {

    @Test
    public String alg1() {
        String input = "FGFF";
        String reverse = "";
        if (input.length() <= 1) {
            reverse = input;
        } else {
            String[] originalArray = input.split("\\s+");
            for (String item : originalArray) { // this, is, a, test, string
                reverse = item + " " + reverse; // this + "", is + this, a + is this, test + a is this,
                //string + test a is this
            }
        }
        return reverse.trim();
       /*String abd = "ABC";
       StringBuilder sb = new StringBuilder(abd);
       System.out.print(sb.reverse().toString());*/
    }

    private String reverseCharacters(String originalString) {
        String reverse = "";
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reverse = reverse + originalString.charAt(i);
        }
        return reverse;
    }


    @Test
    public void alg3() {
        Algoritms alg = new Algoritms();
        System.out.println(alg.alg1());
//alg.reverseCharacters("ABCDEFG");
        System.out.println(alg.reverseCharacters("ABCDEFG"));
    }

    public void topTwo(int[] numbers) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }

    @Test
    public void alg4() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        topTwo(numbers);
    }

    public void topTwos(int[] numberss) {
        int max1 = 0;
        int max2 = 0;
        for(int number:numberss){
        if (number > max1) {
            max2 = max1;
            max1 = number;
        } else if (number > max2) {
            max2 = number;
        }
    }
        System.out.println(max1);
        System.out.println(max2);
}

    public void topMinTwos(int[] numberss) {
        int max = 0;
        int min = 0;
        for(int number:numberss){
            if (number > max) {
                max = number;
               } else if (max < min) {
                min = number;
            }
        }
        System.out.println(max);
        System.out.println(min);

        int[] nums={6,-1,-2,-3,0,1,2,3,4};
        Arrays.sort(nums);
        System.out.println("Minimum = " + nums[0]);
        System.out.println("Maximum = " + nums[nums.length-1]);
    }

    @Test
    public void alg5(){
        int[] numArr = {2, 4, 6, 2, 34, 23, 12, 55, 99, 7, 56};
        Algoritms alg = new Algoritms();
        alg.topTwos(numArr);
        alg.topMinTwos(numArr);
    }

    @Test
    public void alg6(){
        int maximum = 5;
        int minimum = 1;
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        int randomNum =  minimum + i;
        System.out.print(randomNum);
    }

    @Test
    public void alg7(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter any integer: ");
        int sum=0;
        int x=s.nextInt();
        int y=recursion(x);
        System.out.println("The Sum of the digits is: "+ y);

    }


    public static int recursion(int y) {
        if(y/10>=1) {
            int tempvar =y%10;
            int remain=y/10;
            return tempvar + recursion(remain);
        }
        else {
            return y;
        }

    }

    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    @Test
    public void alg8(){
isPalindrome("ABCDEG");
    }

    public static void numbers (int qnt){
        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0+" "+n1+" ");
        for(int i = 3; i <= qnt; i++){
            n2=n0+n1;
            System.out.print(n2+" ");
            n0=n1;
            n1=n2;
        }
    }

    @Test
    public void alg9(){
       numbers(5);
    }

    @Test
    public void alg10() {
        int[] param = {2, 4, 7, 9, 13, 15, 20, 21};
        for (int i = 0; i < param.length; i++) {
            if (param[i] % 2 != 0) {
                System.out.print("The number is divided by 2: " + param[i]);
            } else if (param[i] % 3 != 0) {
                System.out.print("The number is divided by 3: " + param[i]);
            } else if (param[i] % 5 != 0) {
                System.out.print("The number is divided by 5: " + param[i]);
            } else if (param[i] % 5 != 0 || param[i] % 3 != 0) {
                System.out.print("The number is divided by 5 and 3: " + param[i]);
            }
        }
    }

    @Test
    public void alg11(){

    }
    public static  boolean checktheSum(int givens){
        String s = Integer.toString(givens);
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int digit = Integer.parseInt(s.substring(i, i + 1));
            int countIndex = (int)Math.floor(i * 2 / s.length());
            count[countIndex] += digit;
        }
        int half = s.length() / 2;
        System.out.println("First Sum of " + s.substring(0, half) + ": " + count[0]);
        System.out.println("Second Sum of " + s.substring(half) + ": " + count[1]);
        if(count[0] == count[1]){
 return true;
        }
        return false;
    }



    @Test
    public void alg12(){
        checktheSum(123346);
    }
}
