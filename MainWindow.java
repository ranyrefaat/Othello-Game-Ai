package Classes.BoardPackage;

import Classes.PlayerPackage.HumanPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame  {

    JRadioButton rb1, rb2, rb3;
    JButton hVSh, hVSa, aVSa;

    MainWindow() {
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        hVSh = new JButton("Human VS Human");
        hVSh.setBounds(50, 100, 150, 30);

        hVSa = new JButton("Human VS AI");
        hVSa.setBounds(250, 100, 150, 30);

        aVSa = new JButton("AI VS AI");
        aVSa.setBounds(450, 100, 150, 30);

        add(hVSh);
        add(hVSa);
        add(aVSa);
        setSize(700, 300);
        setLayout(null);
        setVisible(true);
        setTitle("Main Window");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600,400);

        hVSh.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameWindow(new HumanPlayer(1) ,new HumanPlayer(2) );
                setVisible(false);
            }
        });

        hVSa.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HumanVsAiDiff();
                setVisible(false);
            }
        });

        aVSa.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AiVsAiDifficulty();
                setVisible(false);
            }
        });

    }


    public static void main(String[] args) {
        new MainWindow();
    }

}