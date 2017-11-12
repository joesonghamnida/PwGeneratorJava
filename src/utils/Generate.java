package utils;

import java.util.ArrayList;
import java.util.Random;

public class Generate {

    public static String generatePassword(Random randInt, ArrayList<String> fullArray, int input) {
        String password = "";

        int counter = 0;

        while (counter < input){
            password = password + fullArray.get(randInt.nextInt(fullArray.size()-1));
            counter++;
        }

        return password;
    }

    public static ArrayList<String> createCharacterSpace(String forbiddenCharacters, ArrayList<String>... elements) {
        ArrayList<String> characterSpace = new ArrayList<>();
        ArrayList<String> permittedChacters = new ArrayList<>();

        for (ArrayList<String> array : elements) {
            characterSpace = array;
            for (int i = 0; i < forbiddenCharacters.length(); i++) {
                String character = Character.toString(forbiddenCharacters.charAt(i));
                if (characterSpace.contains(character)) {
                    int index = characterSpace.indexOf(character);
                    characterSpace.remove(index);
                }
            }
            permittedChacters.addAll(characterSpace);
            }

        return permittedChacters;
    }

    public static ArrayList<String> loadNumbers(){
        ArrayList<String> numbers = new ArrayList<>();

        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
        numbers.add("0");

        return numbers;
    }

    public static ArrayList<String> loadLowerCaseLetters(){
        ArrayList<String> letters = new ArrayList<>();

        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        letters.add("f");
        letters.add("g");
        letters.add("h");
        letters.add("i");
        letters.add("j");
        letters.add("k");
        letters.add("l");
        letters.add("m");
        letters.add("n");
        letters.add("o");
        letters.add("p");
        letters.add("q");
        letters.add("r");
        letters.add("s");
        letters.add("t");
        letters.add("u");
        letters.add("v");
        letters.add("w");
        letters.add("x");
        letters.add("y");
        letters.add("z");

        return letters;
    }

    public static ArrayList<String> loadUpperCaseLetters(ArrayList<String> letters){
        ArrayList<String> upperCase = new ArrayList<>();

        for(String s : letters){
            upperCase.add(s.toUpperCase());
        }

        letters.addAll(upperCase);

        return letters;
    }

    public static ArrayList<String> loadCharacters(){
        ArrayList<String> characters = new ArrayList<>();

        characters.add("!");
        characters.add("@");
        characters.add("#");
        characters.add("$");
        characters.add("%");
        characters.add("^");
        characters.add("&");
        characters.add("*");
        characters.add("(");
        characters.add(")");
        characters.add("_");
        characters.add("-");
        characters.add("+");
        characters.add("+");
        characters.add("[");
        characters.add("]");
        characters.add("{");
        characters.add("}");
        characters.add(">");
        characters.add("<");
        characters.add("?");
        characters.add("~");

        return characters;
    }

}