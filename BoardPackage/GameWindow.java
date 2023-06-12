package Classes.BoardPackage;

import Classes.PlayerPackage.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    public GameWindow(Player p1 , Player p2) {
        JButton back = new JButton("Back");
        GameBoard gp = new GameBoard(p1,p2, back);
        back.setPreferredSize(new Dimension(50, 15));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
                dispose();
                gp.play_flag.set_flag(0);
            }
        });
        this.add(gp);
        this.setTitle("Othello Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        setResizable(false);
        setLocation(600,300);

    }

}
