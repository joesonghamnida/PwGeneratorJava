package utils;

public class Input {

    public static String Verify(char[] numbers, String input){

        /***
         * This works by multiplying the numbers array size by the input length to get sumOfNumbers.
         * When a character does not match, 1 is subtracted from sumOfNumbers
         * so sumOfNumbers = sumOfNumbers - 1.
         * After the entire input has been compared to the characters in numbers,
         * if the input length does not match sumOfNumbers, the input is invalid
         */

        if (!input.equals("") || input.equals("0")) {
            char[] inputArray = input.toCharArray();
            int numbersTimesInput = numbers.length * input.length();

            for (Character letter : inputArray) {
                for (char c : numbers) {
                    if (!letter.equals(c)) {
                        numbersTimesInput = numbersTimesInput - 1;
                    }
                }
            }

            if (numbersTimesInput != input.length()) {
                System.out.println("Invalid input detected");
                System.exit(1);
            }

        } else {
            input = "32";
        }

        return input;
    }

}
