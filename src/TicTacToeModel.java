import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;
    private List<TicTacToeView> views;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
    }

    public void addTicTacToeView(TicTacToeView v) {
        views.add(v);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    private void updateStatus() {
        char x = 'X';
        char o = 'O';
        // Checking the rows
        for (int i = 0; i < SIZE; i++) {
            if (grid[0][i] == x && grid[1][i] == x && grid[2][i] == x) {
                status = status.X_WON;
                break;
            }
            if (grid[i][0] == o && grid[i][1] == o && grid[i][2] == o) {
                status = Status.O_WON;
                break;
            }

        }

        // checking columns
        for (int i = 0; i < SIZE; i++) {
            if (grid[0][i] == x && grid[1][i] == x && grid[2][i] == x) {
                status = Status.X_WON;
                break;
            }
            if (grid[0][i] == o && grid[1][i] == o && grid[2][i] == o) {
                status = Status.O_WON;
            }
        }

        //Check diagonals for a win
        if (grid[0][0] == x && grid[1][1] == x && grid[2][2] == x) {
            status = Status.X_WON;
        }

        if (grid[0][2] == x && grid[1][1] == x && grid[2][0] == x) {
            status = Status.X_WON;
        }

        if (grid[0][0] == o && grid[1][1] == o && grid[2][2] == o) {
            status = Status.O_WON;
        }

        if (grid[0][2] == o && grid[1][1] == o && grid[2][0] == o) {
            status = Status.O_WON;
        }


        //Check if board is still empty
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    break;

                }
                if (i == (SIZE - 1) && j == (SIZE - 1)) {
                    status = Status.TIE;
                }
            }

        }
    }

    public boolean getTurn() {return turn;}

    public boolean play(int x, int y) {
        if (grid[x][y] != ' ')
            return false;
        grid[x][y] = turn? 'X' : 'O'; //ternary operator
        updateStatus();

        for(TicTacToeView v: views) {v.update(new TicTacToeEvent(this, x, y, turn, status));}

        changeTurn();
        return false;
    }

    public String getPosition(int x, int y){
        return String.valueOf(grid[x][y]);
    }
}

