package utils;

public class Input {

    public static String Verify(char[] numbers, String input) {

        if (!input.equals("") || input.equals("0")) {
            char[] inputArray = input.toCharArray();

            //so three char input * 10 = 30
            int numbersTimesInput = numbers.length * input.length();

            //loops through input and compares each char to number array
            //if char doesn't match, subtracts one from total
            //example of successful match: input length = 3, numbersXinput after the loop = 3
            //example of invalid match: input.length = 3, numbersXinput after loop = 2

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
            //32 is the default size
            input = "32";
        }

        return input;
    }

}
