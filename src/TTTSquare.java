import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import static java.lang.System.exit;

public class TTTSquare extends JButton{
    public boolean notClicked;
    public boolean player1Square, player2Square,win = false;
    int row, col;
    public static boolean [][] openSquares;
    public static int count;
    TicTacToe game;
    public TTTSquare() {
        notClicked = true;
        addMouseListener(new TTTSquareListener());
    }

    public void rand(){
        int randRow = ((int) (Math.random()*3));
        int randCol = ((int) (Math.random()*3));
        if (openSquares[randRow][randCol]){
            openSquares[randRow][randCol] = false;
            game.board[randRow][randCol].setBackground(Color.WHITE);
            game.board[randRow][randCol].setText("O");
            game.board[randRow][randCol].setFont(new Font("Ariel", Font.PLAIN, 100));
            game.board[randRow][randCol].notClicked = false;
            game.board[randRow][randCol].player2Square = true;
            count++;
        }
        else{
            rand();
        }
    }

//    public void horizontal(){
//        test = 0;
//        for (int j=0; j<3; j++) {
//            if (!(notClicked))
//                if ((game.board[row][j].player1Square) || (game.board[row][j].player2Square)) {
//                    continue;
//                }
//                else {
//                    test++;
//                    return;
//                }
//            else{
//                test++;
//            }
//        }
//        System.out.println("Horizontal: " + test);
//        if (test<=0) {
//            if (player1Square) {
//                JOptionPane.showMessageDialog(null, "Player 1 Wins! (horizontal)");
//            }
//            else if (player2Square){
//                JOptionPane.showMessageDialog(null, "Player 2 Wins! (horizontal)");
//            }
//        }
//    }
//    public void vertical(){
//        for (int i=0; i<3; i++) {
//            if (!(notClicked))
//                if ((game.board[i][col].player1Square) || (game.board[i][col].player2Square)) {
//                    continue;
//                }
//            else {
//                test++;
//                return;
//                }
//            else {
//                test++;
//            }
//        }
//        if (test<=0) {
//            if (player1Square) {
//                JOptionPane.showMessageDialog(null, "Player 1 Wins (Vert)!");
//            }
//            else if (player2Square) {
//                JOptionPane.showMessageDialog(null, "Player 2 Wins (Vert)!");
//            }
//        }
//    }
    class TTTSquareListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            setBackground(Color.white);
            if ((notClicked) && (count%2==0)) {
                setFont(new Font("Ariel", Font.PLAIN, 50));
                setText("X");
                player1Square = true;
                notClicked = false;
                openSquares[row][col] = false;
                count++;
                //vertical
                if (((game.board[0][0].player1Square)
                        && (game.board[1][0].player1Square)
                        && (game.board[2][0].player1Square))
                        || ((game.board[0][1].player1Square)
                        && (game.board[1][1].player1Square)
                        && (game.board[2][1].player1Square))
                        || ((game.board[0][2].player1Square)
                        && (game.board[1][2].player1Square)
                        && (game.board[2][2].player1Square))){
                    game.info.setText("Game Over - X Wins!");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Player 1 Wins (Vertical)");
                }
                //horizontal
                else if (((game.board[0][0].player1Square)
                        && (game.board[0][1].player1Square)
                        && (game.board[0][2].player1Square))
                        || ((game.board[1][0].player1Square)
                        && (game.board[1][1].player1Square)
                        && (game.board[1][2].player1Square))
                        || ((game.board[2][0].player1Square)
                        && (game.board[2][1].player1Square)
                        && (game.board[2][2].player1Square))){
                    game.info.setText("Game Over - X Wins!");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Player 1 Wins (Horizontal)");
                }
                //diagonal Left
                else if ((game.board[0][0].player1Square)
                        && (game.board[1][1].player1Square)
                        && (game.board[2][2].player1Square)){
                    game.info.setText("Game Over - X Wins!");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Player 1 Wins (Diagonal Left)");
                }
                //diagonal Right
                else if ((game.board[2][0].player1Square)
                        && (game.board[1][1].player1Square)
                        && (game.board[0][2].player1Square)){
                    game.info.setText("Game Over - X Wins!");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Player 1 Wins (Diagonal Right)");
                }
                //AI bot with random move choice
//                rand();
//                //vertical
//                if (((game.board[0][0].player2Square) && (game.board[1][0].player2Square) && (game.board[2][0].player2Square)) || ((game.board[0][1].player2Square) && (game.board[1][1].player2Square) && (game.board[2][1].player2Square)) || ((game.board[0][2].player2Square) && (game.board[1][2].player2Square) && (game.board[2][2].player2Square))){
//                    game.info.setText("Game Over - X Wins!");
//                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Vertical)");
//                }
//                //horizontal
//                if (((game.board[0][0].player2Square) && (game.board[0][1].player2Square) && (game.board[0][2].player2Square)) || ((game.board[1][0].player2Square) && (game.board[1][1].player2Square) && (game.board[1][2].player2Square)) || ((game.board[2][0].player2Square) && (game.board[2][1].player2Square) && (game.board[2][2].player2Square))){
//                    game.info.setText("Game Over - X Wins!");
//                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Horizontal)");
//                }
//                //diagonal L
//                if ((game.board[0][0].player2Square) && (game.board[1][1].player2Square) && (game.board[2][2].player2Square)){
//                    game.info.setText("Game Over - X Wins!");
//                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Diagonal L)");
//                }
//                //diagonal R
//                if ((game.board[2][0].player2Square) && (game.board[1][1].player2Square) && (game.board[0][2].player2Square)){
//                    game.info.setText("Game Over - X Wins!");
//                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Diagonal R)");
//                }
                //tie
                else if ((!(game.board[0][0].notClicked))
                        && (!(game.board[0][1].notClicked))
                        && (!(game.board[0][2].notClicked))
                        && (!(game.board[1][0].notClicked))
                        && (!(game.board[1][1].notClicked))
                        && (!(game.board[1][2].notClicked))
                        && (!(game.board[2][0].notClicked))
                        && (!(game.board[2][1].notClicked))
                        && (!(game.board[2][2].notClicked))){
                    game.info.setText("Game Over - Tie");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Tie! \nNobody wins :(");
                }

            }

            else if ((notClicked) && (count%2==1)){
                setFont(new Font("Ariel", Font.PLAIN, 50));
                setText("O");
                notClicked = false;
                player2Square = true;
                count++;

                //vertical
                if (((game.board[0][0].player2Square)
                        && (game.board[1][0].player2Square)
                        && (game.board[2][0].player2Square))
                        || ((game.board[0][1].player2Square)
                        && (game.board[1][1].player2Square)
                        && (game.board[2][1].player2Square))
                        || ((game.board[0][2].player2Square)
                        && (game.board[1][2].player2Square)
                        && (game.board[2][2].player2Square))){
                    game.info.setText("Game Over - O Wins!");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Vertical)");
                }
                //horizontal
                else if (((game.board[0][0].player2Square)
                        && (game.board[0][1].player2Square)
                        && (game.board[0][2].player2Square))
                        || ((game.board[1][0].player2Square)
                        && (game.board[1][1].player2Square)
                        && (game.board[1][2].player2Square))
                        || ((game.board[2][0].player2Square)
                        && (game.board[2][1].player2Square)
                        && (game.board[2][2].player2Square))){
                    game.info.setText("Game Over - O Wins!");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Horizontal)");
                }
                //diagonal L
                else if ((game.board[0][0].player2Square)
                        && (game.board[1][1].player2Square)
                        && (game.board[2][2].player2Square)){
                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Diagonal L)");
                    game.info.setText("Game Over - O Wins!");
                    win=true;
                }
                //diagonal R
                else if ((game.board[2][0].player2Square)
                        && (game.board[1][1].player2Square)
                        && (game.board[0][2].player2Square)){
                    JOptionPane.showMessageDialog(null, "Player 2 Wins (Diagonal R)");
                    game.info.setText("Game Over - O Wins!");
                    win=true;
                }
                //tie
                else if ((!(game.board[0][0].notClicked))
                        && (!(game.board[0][1].notClicked))
                        && (!(game.board[0][2].notClicked))
                        && (!(game.board[1][0].notClicked))
                        && (!(game.board[1][1].notClicked))
                        && (!(game.board[1][2].notClicked))
                        && (!(game.board[2][0].notClicked))
                        && (!(game.board[2][1].notClicked))
                        && (!(game.board[2][2].notClicked))){
                    game.info.setText("Game Over - Tie");
                    win=true;
                    JOptionPane.showMessageDialog(null, "Tie! \nNobody wins :(");
                }
                //horizontal();vertical();
            }
            if (!(win)) game.info.setText("Player " + (((TTTSquare.count)%2)+1) + "'s Turn --- (P1-X) (P2-O)");
        }
        @Override
        public void mousePressed(MouseEvent e) {
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
}
