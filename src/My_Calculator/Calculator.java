package My_Calculator;

import java.util.Scanner;

import static My_Calculator.Main.calc;


public class Calculator {
    static Converter converter = new Converter();
    static String[] actions = {"+", "-", "/", "*"};
    static String[] regexActions = {"\\+", "-", "/", "\\*"};
    static String[] sim = {","};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }
}