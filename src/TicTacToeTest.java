import static org.junit.Assert.*;
import org.junit.*;


public class TicTacToeTest {
    @Test
    public void initialStatusMustBeUndecided() {
        TicTacToeModel m = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
    }

}
