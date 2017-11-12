import org.junit.Assert;
import org.junit.Test;

import utils.Input;

public class InputTests {

    @Test
    public void CheckInputForValidity(){
        String input = "1234567890";

        Assert.assertTrue(Input.Verify(input));

        input = "123$567890";
        Assert.assertFalse(Input.Verify(input));

        input = "!234$%as";
        Assert.assertFalse(Input.Verify(input));

    }
}
