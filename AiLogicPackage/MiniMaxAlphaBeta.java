package Classes.AiLogicPackage;

import Classes.UtilityPackage.UtilityFunctions;

import java.awt.*;

public class MiniMaxAlphaBeta {

    // Evaluation Function for leaf nodes
    private static EvaluationFunction evaluate = new EvaluationFunction();
    // Function to get the best move available
    public static Point get_best_move(int[][] current_board_l, int player_id_l, int depth){
        int max_points = Integer.MIN_VALUE;
        Point best_move = null;
        for(Point move : UtilityFunctions.get_all_valid_moves(current_board_l,player_id_l)){
            //create new node
            int[][] new_board = UtilityFunctions.get_new_board_state(current_board_l,move,player_id_l);
            //recursive call
            int childScore = minimax_alpha_beta(new_board, depth-1,Integer.MIN_VALUE,Integer.MAX_VALUE, player_id_l, false);
                if(childScore > max_points) {
                    max_points = childScore;
                    best_move = move;
            }
        }
        return best_move;
    }

    // Mini Max Algorithm with Alpha-Beta Pruning using recursion
    private static int minimax_alpha_beta(int[][] board, int depth, int alpha, int beta, int player, boolean maximizer){
        // Run the Evaluation Function at the leaf nodes
        if(UtilityFunctions.is_game_over(board) || depth == 0){
            return evaluate.evaluateHeuristics(board,player);
        }
        int opponent;
        if(player == 1)
        {
            opponent = 2;
        }
        else{
            opponent = 1;
        }
        // Lose your turn if you have no move to play
        if((!maximizer && !UtilityFunctions.get_valid_moves(board, opponent)) || (maximizer && !UtilityFunctions.get_valid_moves(board,player))){
            return minimax_alpha_beta(board,depth-1,alpha,beta, player, !maximizer);
        }
        int points;
        if(maximizer){
            points = Integer.MIN_VALUE;
            for(Point move : UtilityFunctions.get_all_valid_moves(board,player)){
                // New Board State
                int[][] new_board = UtilityFunctions.get_new_board_state(board,move,player);
                // Call the same function as a minimizer
                int max_children = minimax_alpha_beta(new_board,depth-1,alpha,beta, player, false);
                if(max_children > points) points = max_children;
                if(points > alpha) alpha = points;
                // Pruning occurs here
                if(beta <= alpha) break;
            }
        }else{
            points = Integer.MAX_VALUE;
            for(Point move : UtilityFunctions.get_all_valid_moves(board, opponent)){
                // New Board State
                int[][] newNode = UtilityFunctions.get_new_board_state(board,move, opponent);
                // Call the same function as a maximizer
                int minimum_children = minimax_alpha_beta(newNode,depth-1,alpha,beta, player, true);
                if(minimum_children < points) points = minimum_children;
                if(points < beta) beta = points;
                // Pruning occurs here
                if(beta <= alpha) break;
            }
        }
        return points;
    }

}
