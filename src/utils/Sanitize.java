package utils;

import java.util.ArrayList;

public class Sanitize {
    
    public static String removeForbiddenCharacters(String forbiddenCharacters, String password) {
        ArrayList<String> passwordArray = new ArrayList<>();
        ArrayList<String> forbiddenArray = new ArrayList<>();
        ArrayList<Integer> removedIndexes = new ArrayList<>();

        forbiddenArray = loadForbiddenArray(forbiddenArray, forbiddenCharacters);
        passwordArray = loadPasswordArray(passwordArray, password);

        removedIndexes = markForbiddenCharacters(forbiddenArray, passwordArray, removedIndexes);
        passwordArray = stripForbiddenCharacters(passwordArray, removedIndexes);
        password = recreatePassword(passwordArray);

        return password;
    }

    private static ArrayList<String> loadForbiddenArray(ArrayList<String> forbiddenArray, String forbiddenCharacters) {

        for (int i = 0; i < forbiddenCharacters.length(); i++) {
            forbiddenArray.add(Character.toString(forbiddenCharacters.toCharArray()[i]));
        }

        return forbiddenArray;
    }

    private static ArrayList<String> loadPasswordArray(ArrayList<String> passwordArray, String password) {

        for (int j = 0; j < password.length(); j++) {
            passwordArray.add(Character.toString(password.toCharArray()[j]));
        }

        return passwordArray;
    }

    private static ArrayList<Integer> markForbiddenCharacters(ArrayList<String> forbiddenArray, ArrayList<String> passwordArray, ArrayList<Integer> removedIndexes) {
        for (int i = 0; i < passwordArray.size(); i++) {
            for (int marker = 0; marker < forbiddenArray.size(); marker++) {
                if (passwordArray.get(i).equals(forbiddenArray.get(marker))) {
                    removedIndexes.add(i);
                }
            }
        }
        return removedIndexes;
    }

    private static ArrayList<String> stripForbiddenCharacters(ArrayList<String> passwordArray, ArrayList<Integer> removedIndexes){
        ArrayList<String> swapArray = passwordArray;

        for(Integer index : removedIndexes){
            swapArray.remove(index);
        }

        passwordArray = swapArray;

        return passwordArray;
    }

    private static String recreatePassword(ArrayList<String> passwordArray){
        String password = "";

        for(String letter : passwordArray){
            password = password + letter;
        }

        return password;
    }

}



