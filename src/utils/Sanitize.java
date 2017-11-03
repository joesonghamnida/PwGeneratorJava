package utils;

import java.util.ArrayList;

public class Sanitize {

    public static String removeForbiddenCharacters(String forbiddenCharacters, String password) {
        ArrayList<String> passwordArray = new ArrayList<>();
        ArrayList<String> forbiddenArray = new ArrayList<>();

        forbiddenArray = loadForbiddenArray(forbiddenArray, forbiddenCharacters);
        passwordArray = loadPasswordArray(passwordArray, password);

        passwordArray = stripForbiddenCharacters(passwordArray, forbiddenArray);
        password = recreatePassword(passwordArray);

        return password;
    }

    public static ArrayList<String> loadForbiddenArray(ArrayList<String> forbiddenArray, String forbiddenCharacters) {

        for (int i = 0; i < forbiddenCharacters.length(); i++) {
            forbiddenArray.add(Character.toString(forbiddenCharacters.toCharArray()[i]));
        }

        return forbiddenArray;
    }

    public static ArrayList<String> loadPasswordArray(ArrayList<String> passwordArray, String password) {

        for (int j = 0; j < password.length(); j++) {
            passwordArray.add(Character.toString(password.toCharArray()[j]));
        }

        return passwordArray;
    }

    public static ArrayList<Integer> markForbiddenCharacters(ArrayList<String> forbiddenArray, ArrayList<String> passwordArray, ArrayList<Integer> removedIndexes) {
        for (int i = 0; i < passwordArray.size(); i++) {
            for (int marker = 0; marker < forbiddenArray.size(); marker++) {
                if (passwordArray.get(i).equals(forbiddenArray.get(marker))) {
                    removedIndexes.add(i);
                }
            }
        }
        return removedIndexes;
    }
    
    //TODO: bug with forbidden characters in array and forbidden characters in password not being in the
    //TODO: same order
    public static ArrayList<String> stripForbiddenCharacters(ArrayList<String> passwordArray, ArrayList<String> forbiddenCharacters) {
        ArrayList<String> cleanedPassword = new ArrayList<>();

        for (String character : passwordArray) {

            for (String forbidden : forbiddenCharacters) {
                if (character.equals(forbidden)) {
                    cleanedPassword.add(character + " ");
                } else {
                    cleanedPassword.add(character);
                }
            }
        }

        for (String index : cleanedPassword) {
            if (index.contains(" ")) {
                passwordArray.remove(cleanedPassword.indexOf(index));
            }
        }

        return passwordArray;
    }

    public static String recreatePassword(ArrayList<String> passwordArray) {
        String password = "";

        for (String letter : passwordArray) {
            password = password + letter;
        }

        return password;
    }

}



