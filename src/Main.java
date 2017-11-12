import java.util.*;
import utils.*;

public class Main {

    private static Random randInt = new Random();
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter the desired size or press zero for the default");
        String input = keyboard.nextLine();

        if(!Input.Verify(input)){
            System.out.println("Invalid input");
            System.exit(1);
        }

        int pwLength = Integer.valueOf(input);

        System.out.println("Please enter forbidden characters or press the enter key for none");
        String forbiddenCharacters = keyboard.nextLine();

        ArrayList<String> numbers = Generate.loadNumbers();
        ArrayList<String> letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        ArrayList<String> characters = Generate.loadCharacters();
        ArrayList<String> permittedCharacters = Generate.createCharacterSpace(forbiddenCharacters,numbers,letters,characters);

        System.out.println(Generate.generatePassword(randInt, permittedCharacters, pwLength));

    }

}
