package Classes.UtilityPackage;

import java.awt.*;
import java.util.ArrayList;

public class UtilityFunctions {

    public static boolean is_game_over (int[][] board){
        boolean over = true;

        if(get_valid_moves(board,1) || get_valid_moves(board,2))
        {
            over = false;
        }

        return over;
    }

    public static int get_winner(int[][] board) {
        //game is not over yet
        if(!is_game_over(board))
            return -1;
        else{
            //count coins of each player
            int maximizerCoins = count_player_coins(board,1);
            int minimizerCoins = count_player_coins(board,2);

            if(maximizerCoins == minimizerCoins){
                //Draw
                return 0;
            }else if(maximizerCoins > minimizerCoins){
                //Player wins
                return 1;
            }else{
                //Opponent wins
                return 2;
            }
        }
    }

    public static int count_player_coins(int[][] board, int player) {
        int coins = 0;
        for (int rows = 0; rows < 8; rows++) {
            for (int cols = 0; cols < 8; cols++) {
                if(board[rows][cols] == player) coins++;
            }
        }
        return coins;
    }

    public static boolean get_valid_moves(int[][] board, int player) {
        return get_all_valid_moves(board,player).size() > 0;
    }

    public static ArrayList<Point> get_all_valid_moves(int[][] board, int player) {
        ArrayList<Point> result = new ArrayList<>();
        for (int rows = 0; rows < 8; rows++) {
            for (int cols = 0; cols < 8; cols++) {
                if(is_playable(board,player,rows,cols)){
                    result.add(new Point(rows,cols));
                }
            }
        }
        return result;
    }

    public static boolean is_playable(int[][] board, int player, int i, int j) {

        if(board[i][j] != 0) return false;

        int mi , mj , coins;

        int opponent;
        if(player == 1)
        {
            opponent = 2;
        }
        else{
            opponent = 1;
        }

        //move up
        mi = i - 1;
        mj = j;
        coins = 0;
        while(mi > 0 && board[mi][mj] == opponent){
            mi--;
            coins++;
        }
        if(mi >= 0 && board[mi][mj] == player && coins > 0) return true;

        //move down
        mi = i + 1;
        mj = j;
        coins = 0;
        while(mi < 7 && board[mi][mj] == opponent){
            mi++;
            coins++;
        }
        if(mi <= 7 && board[mi][mj] == player && coins > 0) return true;

        //move left
        mi = i;
        mj = j - 1;
        coins = 0;
        while(mj > 0 && board[mi][mj] == opponent){
            mj--;
            coins++;
        }
        if(mj >= 0 && board[mi][mj] == player && coins > 0) return true;

        //move right
        mi = i;
        mj = j + 1;
        coins = 0;
        while(mj < 7 && board[mi][mj] == opponent){
            mj++;
            coins++;
        }
        if(mj <= 7 && board[mi][mj] == player && coins > 0) return true;

        //move up left
        mi = i - 1;
        mj = j - 1;
        coins = 0;
        while(mi > 0 && mj > 0 && board[mi][mj] == opponent){
            mi--;
            mj--;
            coins++;
        }
        if(mi >= 0 && mj >= 0 && board[mi][mj] == player && coins > 0) return true;

        //move up right
        mi = i - 1;
        mj = j + 1;
        coins = 0;
        while(mi > 0 && mj < 7 && board[mi][mj] == opponent){
            mi--;
            mj++;
            coins++;
        }
        if(mi >= 0 && mj <= 7 && board[mi][mj] == player && coins > 0) return true;

        //move down left
        mi = i + 1;
        mj = j - 1;
        coins = 0;
        while(mi < 7 && mj > 0 && board[mi][mj] == opponent){
            mi++;
            mj--;
            coins++;
        }
        if(mi <= 7 && mj >= 0 && board[mi][mj] == player && coins > 0) return true;

        //move down right
        mi = i + 1;
        mj = j + 1;
        coins = 0;
        while(mi < 7 && mj < 7 && board[mi][mj] == opponent){
            mi++;
            mj++;
            coins++;
        }
        if(mi <= 7 && mj <= 7 && board[mi][mj] == player && coins > 0) return true;

        //when all hopes fade away
        return false;
    }

    public static ArrayList<Point> get_reversed_coin_positions(int[][] board, int player, int i, int j) {

        ArrayList<Point> reversedPoints = new ArrayList<>();
        ArrayList<Point> points = new ArrayList<>();

        int mi , mj;
        int opponent = ((player == 1) ? 2 : 1);

        //move up
        mi = i - 1;
        mj = j;
        while(mi>0 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mi--;
        }
        if(mi>=0 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        points.clear();
        //move down
        mi = i + 1;
        mj = j;
        while(mi<7 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mi++;
        }
        if(mi<=7 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        points.clear();
        //move left
        mi = i;
        mj = j - 1;
        while(mj>0 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mj--;
        }
        if(mj>=0 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        points.clear();
        //move right
        mi = i;
        mj = j + 1;
        while(mj<7 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mj++;
        }
        if(mj<=7 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        points.clear();
        //move up left
        mi = i - 1;
        mj = j - 1;
        while(mi>0 && mj>0 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mi--;
            mj--;
        }
        if(mi>=0 && mj>=0 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        points.clear();
        //move up right
        mi = i - 1;
        mj = j + 1;
        while(mi>0 && mj<7 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mi--;
            mj++;
        }
        if(mi>=0 && mj<=7 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        points.clear();
        //move down left
        mi = i + 1;
        mj = j - 1;
        while(mi<7 && mj>0 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mi++;
            mj--;
        }
        if(mi<=7 && mj>=0 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        points.clear();
        //move down right
        mi = i + 1;
        mj = j + 1;
        while(mi<7 && mj<7 && board[mi][mj] == opponent){
            points.add(new Point(mi,mj));
            mi++;
            mj++;
        }
        if(mi<=7 && mj<=7 && board[mi][mj] == player && points.size()>0){
            reversedPoints.addAll(points);
        }

        return reversedPoints;
    }

    public static int[][] get_new_board_state(int[][] board, Point move , int player){
        //Copy old board
        int[][] newboard = new int[8][8];
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                newboard[k][l] = board[k][l];
            }
        }

        //place the coin
        newboard[move.x][move.y] = player;
        //reverse pieces
        ArrayList<Point> rev = UtilityFunctions.get_reversed_coin_positions(newboard,player,move.x,move.y);
        for(Point pt : rev){
            newboard[pt.x][pt.y] = player;
        }

        return newboard;
    }

    public static ArrayList<Point> get_stable_disk_position(int[][] board, int player, int i, int j) {

        ArrayList<Point> stableDiscsPositions = new ArrayList<>();
        ArrayList<Point> points = new ArrayList<>();

        int move_i, move_j;
        int opponent = ((player == 1) ? 2 : 1);

        //move up
        move_i = i - 1;
        move_j = j;
        while(move_i > 0 && board[move_i][move_j] == player){
            points.add(new Point(move_i, move_j));
            move_i--;
        }
        //if redundant point then do not add it
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        points.clear();

        //move down
        move_i = i + 1;
        move_j = j;
        while(move_i < 7 && board[move_i][move_j] == opponent){
            points.add(new Point(move_i, move_j));
            move_i++;
        }
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        points.clear();
        //move left
        move_i = i;
        move_j = j - 1;
        while(move_j > 0 && board[move_i][move_j] == opponent){
            points.add(new Point(move_i, move_j));
            move_j--;
        }
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        points.clear();
        //move right
        move_i = i;
        move_j = j + 1;
        while(move_j <7 && board[move_i][move_j] == opponent){
            points.add(new Point(move_i, move_j));
            move_j++;
        }
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        points.clear();
        //move up left
        move_i = i - 1;
        move_j = j - 1;
        while(move_i > 0 && move_j > 0 && board[move_i][move_j] == opponent){
            points.add(new Point(move_i, move_j));
            move_i--;
            move_j--;
        }
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        points.clear();
        //move up right
        move_i = i - 1;
        move_j = j + 1;
        while(move_i > 0 && move_j < 7 && board[move_i][move_j] == opponent){
            points.add(new Point(move_i, move_j));
            move_i--;
            move_j++;
        }
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        points.clear();
        //move down left
        move_i = i + 1;
        move_j = j - 1;
        while(move_i < 7 && move_j > 0 && board[move_i][move_j] == opponent){
            points.add(new Point(move_i, move_j));
            move_i++;
            move_j--;
        }
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        points.clear();
        //move down right
        move_i = i + 1;
        move_j = j + 1;
        while(move_i < 7 && move_j < 7 && board[move_i][move_j] == opponent){
            points.add(new Point(move_i, move_j));
            move_i++;
            move_j++;
        }
        for(Point sd : points){
            boolean redundant = false;
            for(Point stableDisc : stableDiscsPositions){
                if(sd.equals(stableDisc)){
                    redundant = true;
                    break;
                }
            }
            if(!redundant) stableDiscsPositions.add(sd);
        }

        return stableDiscsPositions;
    }

}
