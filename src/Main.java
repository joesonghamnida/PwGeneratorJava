import java.util.*;

import utils.*;

public class Main {

    private static Random randInt = new Random();
    private static Scanner keyboard = new Scanner(System.in);

    private static char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char[] characters = new char[]{'!', '@', '#', '$', '%', '^', '&', '*', '(', ')'};

    public static void main(String[] args) {
        System.out.println("Please enter the desired size or press zero for the default");
        String input = keyboard.nextLine();
        input = Input.Verify(numbers, input);
        String password = Generate.generatePassword(randInt, Integer.valueOf(input), letters, numbers, characters);

        //TODO: finish this and come up with a way for it to fill in the missing letters if the amount is less than the desired size
        
        System.out.println("Please enter forbidden characters");
        String forbiddenCharacters = keyboard.nextLine();

        password = Sanitize.removeForbiddenCharacters(forbiddenCharacters, password);

        //TODO: make this better
        System.out.println(password);
        System.out.println("Password length: "+password.length());

    }






}
