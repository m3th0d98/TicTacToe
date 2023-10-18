// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe extends JFrame {
    public JTextArea info = new JTextArea("Player " + (((TTTSquare.count)%2)+1) + "'s Turn");
    JPanel boardDisplay = new JPanel();
    TTTSquare[][] board;
    JButton newgame = new JButton("New Game");

    public TicTacToe () {
        int row,col;
        board = new TTTSquare[3][3];
        boolean [][] openSquares = new boolean[3][3];
        for (int i=0; i<openSquares.length; i++){
            for (int j=0; j<openSquares.length;j++){
                openSquares[i][j] = true;
            }
        }
        TTTSquare square;
        setLayout(new BorderLayout());
        setTitle("TicTacToe");
        setSize(3*150,3*150);
        boardDisplay.setLayout(new GridLayout(3,3));
        for (row=0;row<3;row++) {
            for (col=0;col<3;col++) {
                square = new TTTSquare();
                square.row = row;
                square.col = col;
                square.game= this;
                square.openSquares = openSquares;
                boardDisplay.add(square);
                board[row][col]=square;
            }
        }
        add(info,BorderLayout.NORTH);
        add(boardDisplay, BorderLayout.CENTER);
        newgame.addActionListener(new ClearListener());
        add(newgame, BorderLayout.SOUTH);
        info.setText("Player " + (((TTTSquare.count)%2)+1) + "'s Turn --- (P1-X) (P2-O)");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    class ClearListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (int i=0; i<3;i++){
                for (int j=0;j<3;j++){
                    board[i][j].player1Square = false;
                    board[i][j].setText("");
                    board[i][j].setBackground(null);
                    board[i][j].player2Square = false;
                    TTTSquare.count=0;
                    info.setText("Player 1's Turn --- (P1-X) (P2-O)");
                    TTTSquare.openSquares[i][j] = false;
                    board[i][j].notClicked = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        TicTacToe game;
        game = new TicTacToe();

    }

}
