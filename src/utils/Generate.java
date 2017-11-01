package utils;

import java.util.Random;

public class Generate {

    public static String generatePassword(Random randInt, int input, char[] letters, char[] numbers, char[] characters) {
        String pw = "";


        if (input == 0) {
            input = 32;
        }

        for (int i = 0; i < input; i++) {
            int nextChar = randInt.nextInt(3);
            char c = 'a';

            switch (nextChar) {
                case 0:

                    c = letters[randInt.nextInt(letters.length)];

                    int upper = randInt.nextInt(2);
                    if (upper == 1) {
                        c = Character.toUpperCase(c);
                    }

                    break;
                case 1:
                    c = numbers[randInt.nextInt(numbers.length)];
                    break;
                case 2:
                    c = characters[randInt.nextInt(characters.length)];
                    break;
            }

            pw = pw + c;
        }

        return pw;
    }
}
