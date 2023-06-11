package Classes.BoardPackage;

import Classes.PlayerPackage.AiPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AiVsAiDifficulty extends JFrame {
    JRadioButton lvl11, lvl21, lvl31, lvl41, lvl51, lvl61,lvl71;
    JRadioButton lvl12, lvl22, lvl32, lvl42, lvl52, lvl62,lvl72;
    JButton next ,back;
    JLabel l1 , l2;

    AiVsAiDifficulty() {

        l1=new JLabel();
        l1.setBounds(50,20, 250,20);
        l1.setText("Black Difficulty:");
        l1.setSize(new Dimension(150,30));
        l2=new JLabel();
        l2.setBounds(350,20, 250,20);
        l2.setText("White Difficulty:");
        l2.setSize(new Dimension(150,30));

        lvl11 = new JRadioButton("Level 1");
        lvl11.setBounds(50, 50, 100, 30);
        lvl21 = new JRadioButton("Level 2");
        lvl21.setBounds(50, 100, 100, 30);
        lvl31 = new JRadioButton("Level 3");
        lvl31.setBounds(50, 150, 100, 30);
        lvl41 = new JRadioButton("Level 4");
        lvl41.setBounds(50, 200, 100, 30);
        lvl51 = new JRadioButton("Level 5");
        lvl51.setBounds(150, 50, 100, 30);
        lvl61 = new JRadioButton("Level 6");
        lvl61.setBounds(150, 100, 100, 30);
        lvl71 = new JRadioButton("Level 7");
        lvl71.setBounds(150, 150, 100, 30);

        lvl12 = new JRadioButton("Level 1");
        lvl12.setBounds(350, 50, 100, 30);
        lvl22 = new JRadioButton("Level 2");
        lvl22.setBounds(350, 100, 100, 30);
        lvl32 = new JRadioButton("Level 3");
        lvl32.setBounds(350, 150, 100, 30);
        lvl42 = new JRadioButton("Level 4");
        lvl42.setBounds(350, 200, 100, 30);
        lvl52 = new JRadioButton("Level 5");
        lvl52.setBounds(450, 50, 100, 30);
        lvl62 = new JRadioButton("Level 6");
        lvl62.setBounds(450, 100, 100, 30);
        lvl72 = new JRadioButton("Level 7");
        lvl72.setBounds(450, 150, 100, 30);

        ButtonGroup bg1 = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        bg1.add(lvl11);
        bg1.add(lvl21);
        bg1.add(lvl31);
        bg1.add(lvl41);
        bg1.add(lvl51);
        bg1.add(lvl61);
        bg1.add(lvl71);

        bg2.add(lvl12);
        bg2.add(lvl22);
        bg2.add(lvl32);
        bg2.add(lvl42);
        bg2.add(lvl52);
        bg2.add(lvl62);
        bg2.add(lvl72);

        next = new JButton("Next");
        next.setBounds(350, 250, 150, 30);
        back = new JButton("Back");
        back.setBounds(50, 250, 150, 30);
        add(lvl11);
        add(lvl21);
        add(lvl31);
        add(lvl41);
        add(lvl51);
        add(lvl61);
        add(lvl71);

        add(lvl12);
        add(lvl22);
        add(lvl32);
        add(lvl42);
        add(lvl52);
        add(lvl62);
        add(lvl72);
        add(next);
        add(back);
        add(l1);
        add(l2);
        setSize(600, 350);
        setLayout(null);
        setVisible(true);
        setTitle("Difficulty");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600,400);



        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for Button 1
                if (diffCheck()) {
                    JOptionPane.showMessageDialog(getParent(), "Please Choose Difficulty");
                } else {
                    new GameWindow(new AiPlayer(1, diffOne()), new AiPlayer(2, diffTwo()));
                    setVisible(false);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
                setVisible(false);
            }
        });
    }

    private boolean diffCheck() {
        if(!lvl11.isSelected()&& !lvl21.isSelected()&& !lvl31.isSelected()&&!lvl41.isSelected() &&!lvl51.isSelected()
                && !lvl61.isSelected() && !lvl71.isSelected()){
            return true;
        }
        else if(!lvl12.isSelected()&& !lvl22.isSelected()&& !lvl32.isSelected()&&!lvl42.isSelected()
                &&!lvl52.isSelected() && !lvl62.isSelected() && !lvl72.isSelected()){
            return true;
        }
        return false;
    }

    private int diffOne(){
        int x = 0;
        if(lvl11.isSelected()) x =1;
        else if(lvl21.isSelected()) x =2;
        else if(lvl31.isSelected()) x =3;
        else if(lvl41.isSelected()) x =4;
        else if(lvl51.isSelected()) x =5;
        else if(lvl61.isSelected()) x =6;
        else if(lvl71.isSelected()) x =7;
        return x;
    }

    private int diffTwo(){
        int x = 0;
        if(lvl12.isSelected()) x =1;
        else if(lvl22.isSelected()) x =2;
        else if(lvl32.isSelected()) x =3;
        else if(lvl42.isSelected()) x =4;
        else if(lvl52.isSelected()) x =5;
        else if(lvl62.isSelected()) x =6;
        else if(lvl72.isSelected()) x =7;
        return x;
    }
}