import org.junit.Assert;
import org.junit.Test;

import utils.Sanitize;
import utils.Sanitize.*;

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
        Assert.assertEquals(3, Sanitize.loadPasswordArray(passwordArray, password).size());
    }

    @Test
    public void MarkSingleForbiddenCharacter(){}

    @Test
    public void MarkMultipleForbiddenCharacters(){}

    @Test
    public void StripSingleForbiddenCharacter(){}

    @Test
    public void StripMultipleForbiddenCharacters(){}

    @Test
    public void RecreatePassword(){}
}
