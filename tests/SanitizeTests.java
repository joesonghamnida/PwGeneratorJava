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

    //TODO: fix this
    @Test
    public void StripSingleForbiddenCharacter(){
        String password = "abc#";
        ArrayList<String> passwordArray = new ArrayList<>();
        passwordArray = Sanitize.loadPasswordArray(passwordArray, password);

        String forbiddenCharacters = "#";
        ArrayList<String> forbiddenArray = new ArrayList<>();
        forbiddenArray = Sanitize.loadForbiddenArray(forbiddenArray, forbiddenCharacters);

        passwordArray = Sanitize.stripForbiddenCharacters(passwordArray, forbiddenArray);
        Assert.assertEquals(3, passwordArray.size());
    }

    @Test
    public void StripMultipleForbiddenCharacters(){}

    @Test
    public void RecreatePassword(){}
}
