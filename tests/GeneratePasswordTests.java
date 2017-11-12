import org.junit.Assert;
import org.junit.Test;
import utils.Generate;

import java.util.ArrayList;
import java.util.Random;

public class GeneratePasswordTests {

    private static Random randInt = new Random();
    private static ArrayList<String> numbers = Generate.loadNumbers();
    private static ArrayList<String> letters = Generate.loadUpperCaseLetters(Generate.loadLowerCaseLetters());
    private static ArrayList<String> characters = Generate.loadCharacters();
    private static ArrayList<String> allCharacters = Generate.createCharacterSpace("", numbers, letters, characters);

    //TODO: this will break with negative numbers
    @Test
    public void GenerateCorrectLengthPassword(){

        int input = 1;

        ArrayList<String> fullCharacterSpace = Generate.createCharacterSpace("", allCharacters);
        Assert.assertTrue(1 == Generate.generatePassword(randInt, fullCharacterSpace, input).length());

        input = 3;
        fullCharacterSpace = Generate.createCharacterSpace("", allCharacters);
        Assert.assertTrue(3 == Generate.generatePassword(randInt, fullCharacterSpace, input).length());

        input = 32;
        fullCharacterSpace = Generate.createCharacterSpace("", allCharacters);
        Assert.assertTrue(32 == Generate.generatePassword(randInt, fullCharacterSpace, input).length());

        input = 2048;
        fullCharacterSpace = Generate.createCharacterSpace("", allCharacters);
        Assert.assertTrue(2048 == Generate.generatePassword(randInt, fullCharacterSpace, input).length());
    }
}
