package Classes.AiLogicPackage;

import Classes.UtilityPackage.UtilityFunctions;

public class EvaluationFunction {

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
