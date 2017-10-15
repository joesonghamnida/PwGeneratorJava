import java.util.*;

public class Main {

    private static Random randInt = new Random();
    private static Scanner keyboard = new Scanner(System.in);

    private static char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        System.out.println("Please enter the desired size or press zero for the default");
        String input = keyboard.nextLine();
        input = checkInput(input);
        String password = generate(Integer.valueOf(input));

        //TODO: finish this and come up with a way for it to fill in the missing letters if the amount is less than the desired size
        //TODO: refactoring. this desperately needs refactoring
        System.out.println("Please enter forbidden characters");
        String forbiddenCharacters = keyboard.nextLine();

        password = removeForbiddenCharacters(forbiddenCharacters, password);

        //TODO: make this better
        System.out.println(password);
        System.out.println("Password length: "+password.length());

    }

    private static String checkInput(String input) {

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

    private static String generate(int input) {
        String pw = "";

        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] characters = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '(', ')'};

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

    //TODO: this doesn't work with multiple forbidden characters. fix this
    public static String removeForbiddenCharacters(String forbiddenCharacters ,String password){

        ArrayList<String> passwordArray = new ArrayList<>();
        ArrayList<String> permittedLetters = passwordArray;

        //TODO: make this into a char array
        ArrayList<String> forbiddenArray = new ArrayList<>();

        for(int i = 0;i<forbiddenCharacters.length();i++){
            forbiddenArray.add(Character.toString(forbiddenCharacters.charAt(i)));
        }

        for(int j = 0;j<password.length();j++){
            passwordArray.add(Character.toString(password.charAt(j)));
        }

        for(String a : passwordArray){
            String blank = "";
            for(String b : forbiddenArray){
                if(a.equals(b)){
                    blank = password.replace(b, "");
                    blank.trim();
                }else{
                    blank = password;
                }
            }
            password = blank;
        }
        return password;
    }

}
