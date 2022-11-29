package My_Calculator;

import static My_Calculator.Calculator.*;

public class Main {

    public static String calc(String input) {


        // Проверяем количество действий в выражении
        int sumActions = 0;
        for (int y = 0; y < input.length(); y++) {
            for (String action : actions) {
                if (input.charAt(y) == action.charAt(0)) {
                    sumActions++;
                }
            }
        }
        if (sumActions > 1) {
            throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        // Ловим вещественные числа
        int simbolIndex = -1;
        for (int i = 0; i < sim.length; i++) {
            if (input.contains(sim[i])) {
                simbolIndex = i;
                break;
            }
        }
        if (simbolIndex == 0) {
            throw new ArithmeticException("т.к. найдено вещественное число!!!");
        }

        // Определяем знак действия
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        // Проверка знака
        if (actionIndex == -1) {
            throw new ArithmeticException("т.к. строка не является математической операцией");
        }

        // Делим по знаку

        String[] data = input.split(regexActions[actionIndex]);

        // Проверка на Римскую систему
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            // Зписываем числа
            int a, b;

            // Определяем Римские числа для конвертации в арабские
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) { // Конвертируем Римские в Арабские Integer
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
                //Если не Римский идем дальше
            } else { // Арабские приводим к формату Integer
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            //Проверяем числа на > 10

                if ((a < 1 || a > 10) | (b < 1 || b > 10)) {
                    throw new RuntimeException("т.к. допустимы числа только от 1 до 10!");
                }
                // Выполняем действие выражения (Среда сократила написание)
                int result = switch (actions[actionIndex]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
                if (isRoman) { // Если введено выражение Римскими числами

                        if (result <= 0) {
                            throw new ArithmeticException("т.к в римской системе нет отрицательных чисел");
                        }
                        //если числа были римские, возвращаем результат в римском числе
                        System.out.println(converter.intToRoman(result));
                    }else{
                        //если числа были арабские, возвращаем результат в арабском числе
                        return (""+result);
                    }
                }else{
                    throw new ArithmeticException("т.к. используются одновременно разные системы счисления");
        }
        return null;
    }
}