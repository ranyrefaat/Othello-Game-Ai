package Classes.PlayerPackage;

import Classes.PlayerPackage.Player;

import java.awt.*;

public class HumanPlayer extends Player {

    public HumanPlayer(int id_l) {
        super(id_l);
    }

    @Override
    public boolean is_user() {
        return true;
    }

    @Override
    public String get_player_name() {
        return "User" ;
    }

    @Override
    public Point play_move(int[][] current_board_l) {
        return null;
    }

}
