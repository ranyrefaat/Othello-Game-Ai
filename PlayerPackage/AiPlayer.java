package Classes.PlayerPackage;

import Classes.AiLogicPackage.MiniMaxAlphaBeta;
import Classes.UtilityPackage.UtilityFunctions;

import java.awt.*;
import java.util.Random;
import java.util.ArrayList;


public class AiPlayer extends Player {

    private int difficulty;

    public AiPlayer(int id_l, int difficulty_l) {
        super(id_l);
        difficulty = difficulty_l;
    }

    @Override
    public boolean is_user() {
        return false;
    }

    @Override
    public String get_player_name() {
        return "AI (Difficulty " + difficulty + ")";
    }

    @Override
    public Point play_move(int[][] current_board_l) {
        if(difficulty == 1) {
            ArrayList<Point> myPossibleMoves = UtilityFunctions.get_all_valid_moves(current_board_l,id);

            if(myPossibleMoves.size() > 0){
                Random random_generator = new Random();
                return myPossibleMoves.get(random_generator.nextInt(myPossibleMoves.size()));
            }else{
                return null;
            }
        }
        else {
            return MiniMaxAlphaBeta.get_best_move(current_board_l,id,difficulty);
        }

    }
}
