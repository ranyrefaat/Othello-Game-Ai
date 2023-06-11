package Classes.PlayerPackage;

import java.awt.*;

public abstract class Player {

    public int id;
    public Player(int id_l){
        id = id_l;
    }

    abstract public String get_player_name();

    abstract public boolean is_user();

    abstract public Point play_move(int[][] current_board_l);

}
