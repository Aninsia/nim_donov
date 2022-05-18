package test.java;

import main.java.Game;
import main.java.User_interface;
import main.java.state;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GameTest {

    @Test
    void move() {
        new User_interface();
        User_interface.table = new int[]{11, 7, 6};
        Game.move("(0,1)");
        assertEquals(User_interface.game_state, state.START);
        Game.move("(1,2)");
        assertEquals(User_interface.game_state, state.START);
        Game.move("(2,0)");
        assertEquals(User_interface.game_state, state.WIN);
        User_interface.table = new int[]{5, 5, 5};
        assertEquals(User_interface.game_state, state.WIN);
        User_interface.table = new int[]{11, 7, 6};
        Game.move("(1,0)");
        assertEquals(User_interface.game_state, state.ERROR);
        User_interface.table = new int[]{11, 7, 6};
        Game.move("(2,0)");
        assertEquals(User_interface.game_state, state.ERROR);
        User_interface.table = new int[]{11, 7, 6};
        Game.move("(2,1)");
        assertEquals(User_interface.game_state, state.ERROR);
    }

    @Test
    void check() {
        new User_interface();
        User_interface.table = new int[]{0, 0, 0};
        Game.check(0, 1);
        assertEquals(User_interface.game_state, state.WIN);
        User_interface.table = new int[]{1, 1, 1};
        Game.check(0, 1);
        assertEquals(User_interface.game_state, state.WIN);
        User_interface.table = new int[]{4, 8, 12};
        Game.check(2, 0);
        assertEquals(User_interface.game_state, state.WIN);
        User_interface.table = new int[]{3, 4, 5};
        Game.check(0, 1);
        assertEquals(User_interface.game_state, state.ERROR);
        User_interface.table = new int[]{3, 4, 5};
        Game.check(1, 2);
        assertEquals(User_interface.game_state, state.ERROR);
    }
}