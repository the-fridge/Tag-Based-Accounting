package tagBasedAccounting.Data;

//import org.json.simple.JSONObject;

public class Factory {

    public static Transaction transaction(){
        Transaction transaction = new TransactionSimple();
        return transaction;
    }

   /* public static Transaction transaction(JSONObject object){
        Transaction transaction = new TransactionSimple();
        return transaction;
    }*/

    public static Tag tag(){
        Tag tag = new TagSimple();
        return tag;
    }

   /* public static Tag tag(JSONObject object){
        Tag tag = new TagSimple();
        return tag;
    }*/
}
