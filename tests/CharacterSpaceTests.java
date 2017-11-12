import org.junit.Assert;
import org.junit.Test;
import utils.Generate;

import java.util.ArrayList;


public class CharacterSpaceTests {

    @Test
    public void AppendNumbers() {
        ArrayList<String> numbers = Generate.loadNumbers();
        Assert.assertTrue(10 == numbers.size());
    }

    @Test
    public void AppendAllLowerCaseCharacters() {

        ArrayList<String> letters = Generate.loadLowerCaseLetters();
        Assert.assertTrue(26 == letters.size());

    }

    @Test
    public void AppendAllUpperCaseCharacters() {

        ArrayList<String> letters = Generate.loadLowerCaseLetters();
        Assert.assertTrue(26 == letters.size());

        letters = Generate.loadUpperCaseLetters(letters);
        Assert.assertTrue(52 == letters.size());
    }

    @Test
    public void AppendCharacters() {

        ArrayList<String> characters = Generate.loadCharacters();
        Assert.assertTrue(22 == characters.size());
    }

    @Test
    public void AppendAllLists() {
        ArrayList<String> numbers = Generate.loadNumbers();
        Assert.assertTrue(10 == numbers.size());

        ArrayList<String> letters = Generate.loadLowerCaseLetters();
        Assert.assertTrue(26 == letters.size());

        letters = Generate.loadUpperCaseLetters(letters);
        Assert.assertTrue(52 == letters.size());

        ArrayList<String> characters = Generate.loadCharacters();
        Assert.assertTrue(22 == characters.size());

        int total = numbers.size() + letters.size() + characters.size();

        Assert.assertTrue(total == Generate.createCharacterSpace("", numbers, letters, characters).size());
    }

    @Test
    public void AppendListsWithOneCharacterRemoved() {
        ArrayList<String> numbers = Generate.loadNumbers();
        ArrayList<String> letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        ArrayList<String> characters = Generate.loadCharacters();

        int total = numbers.size() + letters.size() + characters.size() - 1;

        Assert.assertTrue(total == Generate.createCharacterSpace("a", numbers, letters, characters).size());
        System.out.println("one");

        numbers = Generate.loadNumbers();
        letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        characters = Generate.loadCharacters();
        Assert.assertTrue(total == Generate.createCharacterSpace("A", numbers, letters, characters).size());
        System.out.println("two");

        numbers = Generate.loadNumbers();
        letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        characters = Generate.loadCharacters();
        Assert.assertTrue(total == Generate.createCharacterSpace("f", numbers, letters, characters).size());
        System.out.println("three");

        numbers = Generate.loadNumbers();
        letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        characters = Generate.loadCharacters();
        Assert.assertTrue(total == Generate.createCharacterSpace("3", numbers, letters, characters).size());
        System.out.println("four");

        numbers = Generate.loadNumbers();
        letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        characters = Generate.loadCharacters();
        Assert.assertTrue(total == Generate.createCharacterSpace("]", numbers, letters, characters).size());
        System.out.println("five");

        numbers = Generate.loadNumbers();
        letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        characters = Generate.loadCharacters();
        Assert.assertTrue(total == Generate.createCharacterSpace("%", numbers, letters, characters).size());
        System.out.println("six");

        numbers = Generate.loadNumbers();
        letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        characters = Generate.loadCharacters();
        Assert.assertFalse(total == Generate.createCharacterSpace("a4", numbers, letters, characters).size());
        System.out.println("seven");
    }

    //TODO: I know this will break with multiple same input: Ex: "aaa"
    @Test
    public void RemoveMultipleForbiddenCharacters(){
        ArrayList<String> numbers = Generate.loadNumbers();
        ArrayList<String> letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        ArrayList<String> characters = Generate.loadCharacters();

        String forbiddenCharacters = "a^0";

        int total = numbers.size() + letters.size() + characters.size() - forbiddenCharacters.length();

        Assert.assertTrue(total == Generate.createCharacterSpace(forbiddenCharacters, numbers, letters, characters).size());
        System.out.println("one");

        numbers = Generate.loadNumbers();
        letters = Generate.loadLowerCaseLetters();
        letters = Generate.loadUpperCaseLetters(letters);
        characters = Generate.loadCharacters();
        forbiddenCharacters = "a^0#$2";
        total = numbers.size() + letters.size() + characters.size() - forbiddenCharacters.length();
        Assert.assertTrue(total == Generate.createCharacterSpace(forbiddenCharacters, numbers, letters, characters).size());
        System.out.println("two");
    }
}
