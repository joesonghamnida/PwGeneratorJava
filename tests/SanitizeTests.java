import org.junit.Assert;
import org.junit.Test;

import utils.Sanitize;

import java.util.ArrayList;

public class SanitizeTests {

    @Test
    public void LoadForbiddenArray(){
        String forbiddenCharacters = "#$%";
        ArrayList<String> forbiddenArray = new ArrayList<>();
        Assert.assertEquals(3, Sanitize.loadForbiddenArray(forbiddenArray, forbiddenCharacters).size());
    }

    @Test
    public void LoadPasswordArray(){
        String password = "abc";
        ArrayList<String> passwordArray = new ArrayList<>();
        passwordArray = Sanitize.loadPasswordArray(passwordArray, password);
        Assert.assertEquals(3, passwordArray.size());
    }

    @Test
    public void MarkSingleForbiddenCharacter(){
        String password = "abc#";
        ArrayList<String> passwordArray = new ArrayList<>();
        passwordArray = Sanitize.loadPasswordArray(passwordArray, password);

        String forbiddenCharacters = "#";
        ArrayList<String> forbiddenArray = new ArrayList<>();
        forbiddenArray = Sanitize.loadForbiddenArray(forbiddenArray, forbiddenCharacters);

        ArrayList<Integer> removedIndexes = new ArrayList<>();
        removedIndexes = Sanitize.markForbiddenCharacters(forbiddenArray, passwordArray, removedIndexes);
        Assert.assertEquals(1, removedIndexes.size());
    }

    @Test
    public void MarkMultipleForbiddenCharacters(){
        String password = "@abc#";
        ArrayList<String> passwordArray = new ArrayList<>();
        passwordArray = Sanitize.loadPasswordArray(passwordArray, password);

        String forbiddenCharacters = "#a@";
        ArrayList<String> forbiddenArray = new ArrayList<>();
        forbiddenArray = Sanitize.loadForbiddenArray(forbiddenArray, forbiddenCharacters);

        ArrayList<Integer> removedIndexes = new ArrayList<>();
        removedIndexes = Sanitize.markForbiddenCharacters(forbiddenArray, passwordArray, removedIndexes);
        Assert.assertEquals(3, removedIndexes.size());
    }

    @Test
    public void StripSingleForbiddenCharacter(){

        String forbiddenCharacters = "#";
        ArrayList<String> forbiddenArray = new ArrayList<>();
        forbiddenArray = Sanitize.loadForbiddenArray(forbiddenArray, forbiddenCharacters);

        String password = "abc#";
        ArrayList<String> passwordArray = new ArrayList<>();
        passwordArray = Sanitize.loadPasswordArray(passwordArray, password);

        passwordArray = Sanitize.stripForbiddenCharacters(passwordArray, forbiddenArray);
        Assert.assertEquals(3, passwordArray.size());
        System.out.println("One");

        password = "#abc";
        ArrayList<String> passwordArrayTwo = new ArrayList<>();
        passwordArrayTwo = Sanitize.loadPasswordArray(passwordArrayTwo, password);
        passwordArrayTwo = Sanitize.stripForbiddenCharacters(passwordArrayTwo, forbiddenArray);
        Assert.assertEquals(3, passwordArrayTwo.size());
        System.out.println("Two");

        password = "ab#c";
        ArrayList<String> passwordArrayThree = new ArrayList<>();
        passwordArrayThree = Sanitize.loadPasswordArray(passwordArrayThree, password);
        passwordArrayThree = Sanitize.stripForbiddenCharacters(passwordArrayThree, forbiddenArray);
        Assert.assertEquals(3, passwordArrayThree.size());
        System.out.println("Three");
    }

    //TODO: bug with forbidden characters in array and forbidden characters in password not being in the
    //TODO: same order
    @Test
    public void StripMultipleForbiddenCharacters(){

        String password = "a@ER^bc#";
        ArrayList<String> passwordArray = new ArrayList<>();
        passwordArray = Sanitize.loadPasswordArray(passwordArray, password);

        String forbiddenCharacters = "#@^";
        ArrayList<String> forbiddenArray = new ArrayList<>();
        forbiddenArray = Sanitize.loadForbiddenArray(forbiddenArray, forbiddenCharacters);

        passwordArray = Sanitize.stripForbiddenCharacters(passwordArray, forbiddenArray);
        Assert.assertEquals(5, passwordArray.size());
    }

    @Test
    public void RecreatePassword(){}
}
