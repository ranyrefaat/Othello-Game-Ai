package Classes.BoardPackage;

import Classes.PlayerPackage.Player;
import Classes.UtilityPackage.UtilityFunctions;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GameBoard extends JPanel {

    // Define Players
    Player player_one ;
    Player player_two ;

    // Variables For Swing
    Cell[][] cells;
    JLabel player_one_score;
    JLabel player_two_score;

    int player_one_total_score = 0;
    int player_two_total_score = 0;

    JLabel player_one_total_score_label;
    JLabel player_two_total_score_label;

    JLabel turn_label;

    // Main Game Board
    int[][] board;

    // Defines for Black and White
    private static final int BLACK = 1;
    private static final int WHITE = 2;

    // Variable for player's turn, initialized to Black
    int turn = BLACK;

    // Boolean to wait for user click
    private boolean wait_for_user_click = false;

    // Timers for AI
    Timer Ai_player_one_timer;
    Timer Ai_player_two_timer;

    // A flag to check if the game should continue or not
    public class PlayFlag {
        public int flag;
        public PlayFlag(){
            flag = 1;
        }
        public void set_flag(int flag_l)
        {
            flag = flag_l;
        }
    }

    public PlayFlag play_flag = new PlayFlag();
    public GameBoard(Player p1 , Player p2, JButton back){
        // Set the two players objects to either Human or AI
        player_one = p1;
        player_two = p2;

        // Initialize Timers for AI
        initialize_timers();
        initialize_cells();

        // Set the Panel Layout to Border Layout
        this.setLayout(new BorderLayout());
        // Create Main Game Board Panel
        JPanel game_board = create_game_panel();

        // Create a panel for the scores
        JPanel score_window = create_score_panel(back);

        this.add(score_window,BorderLayout.NORTH);
        this.add(game_board,BorderLayout.SOUTH);

        refresh_scores();
        refresh_total_scores();

        advance_play();
    }

    private void initialize_cells(){
        // Initialize all the board cells to 0 in the beginning
        board = new int[8][8];
        for (int rows = 0; rows < 8; rows++) {
            for (int cols = 0; cols < 8; cols++) {
                board[rows][cols]=0;
            }
        }
        // Initialize the four middle cells in the beginning
        set_board_value(3,3,WHITE);
        set_board_value(3,4,BLACK);
        set_board_value(4,3,BLACK);
        set_board_value(4,4,WHITE);
    }
    private void initialize_timers(){
        // Timer for AI
        // Timer for AI 1 if exists
        Ai_player_one_timer = new Timer(700,(ActionEvent e) -> {
            ai_play_move(player_one);
            Ai_player_one_timer.stop();
            advance_play();
        });

        // Timer for AI 2 if exists
        Ai_player_two_timer = new Timer(700,(ActionEvent e) -> {
            ai_play_move(player_two);
            Ai_player_two_timer.stop();
            advance_play();
        });
    }

    private JPanel create_game_panel(){
        JPanel game_board = new JPanel();
        // Set background color to green
        game_board.setBackground(new Color(25,110, 140));
        // Set Layout to 8 x 8
        game_board.setLayout(new GridLayout(8,8));
        // Set size by 500 x 500
        game_board.setPreferredSize(new Dimension(500,500));
        // Initialize Game Board Cells Objects
        cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(this,game_board,i,j);
                game_board.add(cells[i][j]);
            }
        }
        return game_board;
    }

    private JPanel create_score_panel(JButton back){
        JPanel score_window = new JPanel();
        GridLayout grid = new GridLayout(2,3);
        grid.setHgap(70);
        score_window.setLayout(grid);


        // Create Labels for scores
        player_one_score = new JLabel("Player 1 Score");
        player_two_score = new JLabel("Player 2 Score");
        player_one_total_score_label = new JLabel("Player 1 Total Score");
        player_two_total_score_label = new JLabel("Player 2 Total Score");
        turn_label = new JLabel("Turn");
        turn_label.setText("");


        score_window.add(player_one_score);
        JPanel test = new JPanel();
        test.setLayout(new BoxLayout(test,BoxLayout.Y_AXIS));
        test.add(back);
        score_window.add(test);
        score_window.add(player_two_score);
        score_window.add(player_one_total_score_label);
        score_window.add(turn_label);
        score_window.add(player_two_total_score_label);

        return score_window;
    }

    public void advance_play() {
        if(play_flag.flag == 1){        // Check if the current player has a valid move
            if (UtilityFunctions.get_valid_moves(board, BLACK) ||
                    UtilityFunctions.get_valid_moves(board, WHITE)) {
                // There is a valid move available
                make_next_move();
            } else {
                // The game is finished
                int winner = UtilityFunctions.get_winner(board);
                if (winner == BLACK) {
                    player_one_total_score++;
                    JOptionPane.showMessageDialog(this, "Black Won!");
                } else if (winner == WHITE) {
                    player_two_total_score++;
                    JOptionPane.showMessageDialog(this, "White Won!");
                }
                refresh_total_scores();


                board = new int[8][8];
                for (int rows = 0; rows < 8; rows++) {
                    for (int cols = 0; cols < 8; cols++) {
                        board[rows][cols] = 0;
                    }
                }
                // Initialize the four middle cells in the beginning
                set_board_value(3, 3, WHITE);
                set_board_value(3, 4, BLACK);
                set_board_value(4, 3, BLACK);
                set_board_value(4, 4, WHITE);
                turn = BLACK;

                repaint();

                make_next_move();
            }
        }
    }

    private void make_next_move() {
        refresh_scores();
        if (turn == BLACK) {
            if(UtilityFunctions.get_valid_moves(board,BLACK)) {
                turn_label.setText("Black's Turn");
                if (player_one.is_user()) {
                    wait_for_user_click = true;
                } else {
                    Ai_player_one_timer.start();
                }
            }else{
                // Black can't move
                turn = WHITE;
                advance_play();
            }
        } else {
            if(UtilityFunctions.get_valid_moves(board,2)) {
                turn_label.setText("White's Turn");
                if (player_two.is_user()) {
                    wait_for_user_click = true;
                } else {
                    Ai_player_two_timer.start();
                }
            }else{
                // White can't move
                turn = BLACK;
                advance_play();
            }
        }
    }

    public void refresh_scores(){

        int player_one_current_score = 0;
        int player_two_current_score = 0;

        for (int row = 0; row < 8; row++) {
            for (int cols = 0; cols < 8; cols++) {
                if(board[row][cols] == 1) player_one_current_score++;
                if(board[row][cols] == 2) player_two_current_score++;

                if(UtilityFunctions.is_playable(board,turn,row,cols)){
                    cells[row][cols].highlightedCell = 1;
                }else{
                    cells[row][cols].highlightedCell = 0;
                }
            }
        }

        player_one_score.setText("Black Score : " + player_one_current_score);
        player_two_score.setText("White Score : " + player_two_current_score);
    }

    public void refresh_total_scores(){
        player_one_total_score_label.setText("Black Total Score : " + player_one_total_score);
        player_two_total_score_label.setText("White Total Score : " + player_two_total_score);
    }

    public void ai_play_move(Player ai){
        // Get the move to play
        Point point_to_play = ai.play_move(board);
        // Get x and y coordinates
        int x = point_to_play.x;
        int y = point_to_play.y;

        //update board
        board = UtilityFunctions.get_new_board_state(board,point_to_play,turn);

        // Choose the next player to play
        turn = (turn == BLACK) ? WHITE : BLACK;

        repaint();
    }

    public void handleClick(int i,int j){
        if(wait_for_user_click && UtilityFunctions.is_playable(board,turn,i,j)){

            //update board
            board = UtilityFunctions.get_new_board_state(board,new Point(i,j),turn);

            //advance turn
            turn = (turn == BLACK) ? WHITE : BLACK;

            repaint();
            wait_for_user_click = false;

            // Advance the gameplay
            advance_play();
        }
    }

    public int get_board_value(int row, int col){
        return board[row][col];
    }

    public void set_board_value(int row, int col, int val){
        board[row][col] = val;
    }

}
