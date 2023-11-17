import static org.junit.Assert.*;
import org.junit.*;


public class TicTacToeTest {
    @Test
    public void initialStatusMustBeUndecided() {
        TicTacToeModel m = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
    }

    @Test
    public void getPosition(){
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);//X
        m.play(1,1);//O
        m.play(1,0);//X
        m.play(2,1);//O
        assertEquals("X", m.getPosition(0,0));
        assertEquals("O", m.getPosition(1,1));
        assertEquals("X", m.getPosition(1,0));
        assertEquals("O", m.getPosition(2,1));
    }


    @Test
    public void checkVertical(){
        TicTacToeModel model = new TicTacToeModel();
        model.play(0,0); //X
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(1,1); //O
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(2,0); //X
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(1,2); //0
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(1,0); //X
        assertEquals("X Wins", TicTacToeModel.Status.X_WON, model.getStatus());
    }

    @Test
    public void checkHorizontal() {
        TicTacToeModel model = new TicTacToeModel();
        model.play(0,0); //X
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(1,0); //O
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(0,1); //X
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(1,1); //O
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(2,1); //X
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
        model.play(1,2); //O
        assertEquals("O Wins", TicTacToeModel.Status.O_WON, model.getStatus());
    }



    @Test
    public void getStatus() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(1,1);//X
        m.play(0,1);//O
        m.play(0,2);//X
        m.play(0,0);//O
        m.play(2,0);//X
        assertEquals("X Wins", TicTacToeModel.Status.X_WON, m.getStatus());

        TicTacToeModel m2 = new TicTacToeModel();
        m2.play(0,1);//X
        m2.play(1,1);//O
        m2.play(2,2);//X
        m2.play(1,0);//O
        m2.play(0,0);//X
        m2.play(1,2);//O
        assertEquals("O Wins", TicTacToeModel.Status.O_WON, m2.getStatus());

        TicTacToeModel m3 = new TicTacToeModel();
        m3.play(0,0);//X
        m3.play(1,2);//O
        m3.play(2,2);//X
        m3.play(1,1);//O
        m3.play(1,0);//X
        m3.play(2,0);//O
        m3.play(2,1);//X
        assertEquals("TIE", TicTacToeModel.Status.TIE, m3.getStatus());

    }

}
