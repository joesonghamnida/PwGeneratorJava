package utils;

import java.util.ArrayList;

public class Sanitize {

    /***
     *
     * have something to mark the forbidden characters and their indexes, and mark them as not legit.
     * regenerate random number to pick
     *
     * */

    //TODO: this doesn't work with multiple forbidden characters. fix this

    public static String removeForbiddenCharacters(String forbiddenCharacters ,String password){
        ArrayList<String> passwordArray = new ArrayList<>();
        ArrayList<String> permittedLetters = passwordArray;

        //TODO: make this into a char array
        ArrayList<String> forbiddenArray = new ArrayList<>();

        for(int i = 0;i<forbiddenCharacters.length();i++){
            forbiddenArray.add(Character.toString(forbiddenCharacters.toCharArray()[i]));
        }

        for(int j = 0;j<password.length();j++){
            passwordArray.add(Character.toString(password.toCharArray()[j]));
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
