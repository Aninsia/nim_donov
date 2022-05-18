package main.java;


public class Game {
    public static void move(String action) {
        String[] s2_array = action.split("\\D+");
        String[] array = new String[2];
        array[0] = s2_array[1];
        array[1] = s2_array[2];
        check(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

}
