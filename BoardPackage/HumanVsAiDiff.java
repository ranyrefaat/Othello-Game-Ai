package Classes.BoardPackage;

import Classes.PlayerPackage.HumanPlayer;
import Classes.PlayerPackage.AiPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanVsAiDiff extends JFrame {
    JRadioButton lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7;

    JButton next,back;

    HumanVsAiDiff(){
        lvl1 = new JRadioButton("Level 1");
        lvl1.setBounds(50, 50, 100, 30);
        lvl2 = new JRadioButton("Level 2");
        lvl2.setBounds(50, 100, 100, 30);
        lvl3 = new JRadioButton("Level 3");
        lvl3.setBounds(50, 150, 100, 30);
        lvl4 = new JRadioButton("Level 4");
        lvl4.setBounds(150, 50, 100, 30);
        lvl5 = new JRadioButton("Level 5");
        lvl5.setBounds(150, 100, 100, 30);
        lvl6 = new JRadioButton("Level 6");
        lvl6.setBounds(150, 150, 100, 30);
        lvl7 = new JRadioButton("Level 7");
        lvl7.setBounds(250, 50, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(lvl1);
        bg.add(lvl2);
        bg.add(lvl3);
        bg.add(lvl4);
        bg.add(lvl5);
        bg.add(lvl6);
        bg.add(lvl7);
        next = new JButton("Next");
        next.setBounds(400, 200, 150, 30);
        back = new JButton("Back");
        back.setBounds(50, 200, 150, 30);
        add(lvl1);
        add(lvl2);
        add(lvl3);
        add(lvl4);
        add(lvl5);
        add(lvl6);
        add(lvl7);
        add(next);
        add(back);
        setSize(700, 300);
        setLayout(null);
        setVisible(true);
        setTitle("Difficulty");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600,400);

        next.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for Button 1
                if(diffCheck()){
                    JOptionPane.showMessageDialog(getParent(), "Please Choose Difficulty");
                }
                else{
                    if (lvl1.isSelected()) {
                        new GameWindow(new HumanPlayer(1),new AiPlayer(2,1) );
                        setVisible(false);
                    }
                    else if (lvl2.isSelected()) {
                        new GameWindow(new HumanPlayer(1) ,new AiPlayer(2,2) );
                        setVisible(false);
                    }
                    else if (lvl3.isSelected()) {
                        new GameWindow(new HumanPlayer(1) ,new AiPlayer(2,3) );
                        setVisible(false);
                    }
                    else if (lvl4.isSelected()) {
                        new GameWindow(new HumanPlayer(1),new AiPlayer(2,4) );
                        setVisible(false);
                    }
                    else if (lvl5.isSelected()) {
                        new GameWindow(new HumanPlayer(1) ,new AiPlayer(2,5) );
                        setVisible(false);
                    }
                    else if (lvl6.isSelected()) {
                        new GameWindow(new HumanPlayer(1) ,new AiPlayer(2,6) );
                        setVisible(false);
                    }
                    else if (lvl7.isSelected()) {
                        new GameWindow(new HumanPlayer(1) ,new AiPlayer(2,7) );
                        setVisible(false);
                    }
                }
            }
        });

        back.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
                setVisible(false);
            }
        });
    }

    public boolean diffCheck () {

        if(!lvl1.isSelected()&&!lvl2.isSelected()&&!lvl3.isSelected()&&!lvl5.isSelected()&&!lvl4.isSelected()
                &&!lvl6.isSelected()&&!lvl7.isSelected()){
            return true;
        }
        return false;
    }

}