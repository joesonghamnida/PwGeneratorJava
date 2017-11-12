package utils;

public class Input {

    public static boolean Verify(String input) {

        char[] inputArray = input.toCharArray();

        boolean allowed = true;

        for(int i=0;i<input.length();i++){
            if(!Character.isDigit(inputArray[i])){
                allowed = false;
            }
        }

        return allowed;
    }
}
