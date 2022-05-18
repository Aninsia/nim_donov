package main.java;


public class Game {
    public static void move(String action) {
        String[] s2_array = action.split("\\D+");
        String[] array = new String[2];
        array[0] = s2_array[1];
        array[1] = s2_array[2];
        check(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

    public static void check(int x, int y) {
        if (User_interface.table[x] >= User_interface.table[y]) {
            User_interface.table[x] -= User_interface.table[y];
            User_interface.table[y] += User_interface.table[y];
        } else {
            User_interface.game_state = state.ERROR;
        }
        if (User_interface.table[0] == User_interface.table[1] && User_interface.table[1] == User_interface.table[2]) {
            User_interface.game_state = state.WIN;
        }
        
    }
}
