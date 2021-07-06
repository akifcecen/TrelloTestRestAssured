import io.restassured.RestAssured;
import org.junit.Before;

public class BasePage {


    @Before
    public void before(){

        RestAssured.baseURI= "https://api.trello.com/1";

    }

}
