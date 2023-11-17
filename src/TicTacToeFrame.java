import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView{

    private JButton[][] buttons;
    public TicTacToeFrame() {

        super("TicTacToe");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));

        TicTacToeModel model = new TicTacToeModel();

        model.addTicTacToeView(this);

        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];

        TicTacToeController tttc = new TicTacToeController(model);
        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                JButton b = new JButton(" ");
                b.setActionCommand(i + " " + j);
                buttons[i][j] = b;
                int finalI = i;
                int finalJ = j;
                b.addActionListener(e->model.play(finalI, finalJ));
                this.add(b);

            }
        }
        this.setVisible(true);
    }
    @Override
    public void update(TicTacToeEvent e) {
        String label = e.isTurn()? "X" : "O";
        buttons[e.getX()][e.getY()].setText(label);
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
