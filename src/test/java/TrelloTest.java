import org.junit.Test;
import java.util.Random;

public class TrelloTest {

    Page trelloTestApi= new Page();;
    Random rnd = new Random();

    @Test
    public void apiTest(){

        trelloTestApi.createBoard("createBoardTest");
        trelloTestApi.createCard("cardNumberOne");
        trelloTestApi.createCard("cardNumberTwo");
        trelloTestApi.updateCard("newCardName",rnd.nextInt(1));
        trelloTestApi.deleteCard(0);
        trelloTestApi.deleteCard(1);
        trelloTestApi.deleteBoard();

    }
}
