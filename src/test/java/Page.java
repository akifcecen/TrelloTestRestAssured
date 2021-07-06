
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Page extends BasePage {

    public static RequestSpecification request;
    public static Response response;
    private String boardID="";
    private List<String> cardID= new ArrayList();

    public static  final String KEY = "961019bbf3c4e0772a20fd84a53c3691";
    public static final String TOKEN = "c70e73d6f567f32ef6f317a21319b4882adf85ee6b06075b870c7a092b01f47b";


    public void createBoard(String boardName){
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token", TOKEN);
        pathParam.put("name", boardName);
        request = RestAssured.given();
        request.header("Content-type", "application/json");
        request.body(pathParam.toString());
        response = request.request(Method.POST,"/boards");
        boardID = response.jsonPath().getString("id");
    }


    public void createCard(String cardName ){
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        pathParam.put("name", cardName);
        pathParam.put("idList", boardID);
        request.header("Content-type", "application/json");
        request.body(pathParam.toString());
        response = request.request(Method.POST,"/cards");
        cardID.add(response.jsonPath().getString("id"));
    }

    public void updateCard(String cardName, int randomCard){

        String id = cardID.get(randomCard);
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        pathParam.put("name", cardName);
        request.header("Content-type", "application/json");
        request.body(pathParam.toString());
        response = request.request(Method.PUT,"/cards/" + id);

    }



    public void deleteCard(int index){
        String id = cardID.get(index);
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        request.header("Content-type", "application/json");
        request.body(pathParam.toString());
        response = request.request(Method.DELETE,"/cards/" + id);
    }
    public void deleteBoard(){
        JSONObject pathParam = new JSONObject();
        pathParam.put("key", KEY);
        pathParam.put("token",TOKEN);
        request.header("Content-type", "application/json");
        request.body(pathParam.toString());
        response = request.request(Method.DELETE,"/boards/" + boardID);
    }

}
