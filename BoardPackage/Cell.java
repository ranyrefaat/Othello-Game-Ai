package Classes.BoardPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JLabel implements MouseListener {

    int width;
    int height;
    GameBoard gb;
    JPanel parent;
    public int highlightedCell = 0;
    public Cell(GameBoard gb , JPanel parent, int width, int height){
        this.gb = gb;
        this.parent = parent;
        this.width = width;
        this.height = height;
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics G) {

        int leftMargin = this.getWidth() / 10;
        int topMargin = this.getHeight() / 10;

        //draw highlight
        if(highlightedCell == 1) {
            G.setColor(new Color(93, 248, 109));
            G.fillRect(0, 0, this.getWidth(), this.getHeight());
            G.setColor(parent.getBackground());
            G.fillRect(4, 4, this.getWidth() - 8, this.getHeight() - 8);
        }
        //draw border
        G.setColor(Color.BLACK);
        G.drawRect(0,0,this.getWidth(),this.getHeight());

        //draw piece
        int boardValue = gb.get_board_value(width,height);
        if(boardValue == 1){
            G.setColor(Color.BLACK);
            G.fillOval(leftMargin,topMargin,this.getWidth()-2*leftMargin,this.getHeight()-2*topMargin);
        }
        else if(boardValue == 2) {
            G.setColor(Color.WHITE);
            G.fillOval(leftMargin,topMargin,this.getWidth()-2*leftMargin,this.getHeight()-2*topMargin);
        }

        super.paint(G);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gb.handleClick(width,height);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}