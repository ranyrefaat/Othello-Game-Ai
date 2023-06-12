package Classes.AiLogicPackage;

import Classes.UtilityPackage.UtilityFunctions;

public class EvaluationFunction {

    public static int cornersCaptured(int[][] board, int player){
        int opponent = (player==1) ? 2 : 1;

        int maximizerCorners = 0;
        int minimizerCorners = 0;

        if(board[0][0]==player) maximizerCorners++;
        if(board[7][0]==player) maximizerCorners++;
        if(board[0][7]==player) maximizerCorners++;
        if(board[7][7]==player) maximizerCorners++;

        if(board[0][0]==opponent) minimizerCorners++;
        if(board[7][0]==opponent) minimizerCorners++;
        if(board[0][7]==opponent) minimizerCorners++;
        if(board[7][7]==opponent) minimizerCorners++;

        if((maximizerCorners + minimizerCorners) != 0)
        {
            return 100 * (maximizerCorners - minimizerCorners) / (maximizerCorners + minimizerCorners);
        }
        else
        {
            return 0;
        }
    }

    public static int stability(int[][] board, int player){
        int opponent = (player==1) ? 2 : 1;

        int maximizerStability = 0;
        int minimizerStability = 0;

        if(board[0][0] == player) maximizerStability += UtilityFunctions.get_stable_disk_position(board,player,0,0).size();
        if(board[0][7] == player) maximizerStability += UtilityFunctions.get_stable_disk_position(board,player,0,7).size();
        if(board[7][0] == player) maximizerStability += UtilityFunctions.get_stable_disk_position(board,player,7,0).size();
        if(board[7][7] == player) maximizerStability += UtilityFunctions.get_stable_disk_position(board,player,7,7).size();

        if(board[0][0] == opponent) minimizerStability += UtilityFunctions.get_stable_disk_position(board,opponent,0,0).size();
        if(board[0][7] == opponent) minimizerStability += UtilityFunctions.get_stable_disk_position(board,opponent,0,7).size();
        if(board[7][0] == opponent) minimizerStability += UtilityFunctions.get_stable_disk_position(board,opponent,7,0).size();
        if(board[7][7] == opponent) minimizerStability += UtilityFunctions.get_stable_disk_position(board,opponent,7,7).size();

        if((maximizerStability + minimizerStability) != 0)
        {
            return 100 * (maximizerStability - minimizerStability) / (maximizerStability + minimizerStability);
        }
        else
        {
            return 0;
        }
    }

    public static int coinParity(int[][] board, int player){
        int opponent = (player==1) ? 2 : 1;

        int maximizerCoins = UtilityFunctions.count_player_coins(board,player);
        int minimizerCoins = UtilityFunctions.count_player_coins(board,opponent);

        return 100 * (maximizerCoins - minimizerCoins) / (maximizerCoins + minimizerCoins);
    }

    public static int mobility(int[][] board, int player){
        int opponent = (player==1) ? 2 : 1;

        int maximizerMoves = UtilityFunctions.get_all_valid_moves(board,player).size();
        int minimizerMoves = UtilityFunctions.get_all_valid_moves(board,opponent).size();

        if((maximizerMoves + minimizerMoves) != 0)
        {
            return 100 * (maximizerMoves - minimizerMoves) / (maximizerMoves + minimizerMoves);
        }
        else
        {
            return 0;
        }

    }

}
