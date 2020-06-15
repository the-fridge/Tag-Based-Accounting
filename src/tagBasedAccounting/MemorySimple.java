package tagBasedAccounting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tagBasedAccounting.Data.Tag;
import tagBasedAccounting.Data.TagType;
import tagBasedAccounting.Data.Transaction;

import java.io.*;
import java.util.List;
import java.util.Map;

class MemorySimple implements Memory{

  private static String dataLocation = "./";
  private static String dataFileName = "data.json";

  private List<Transaction> transactions;
  private Map<TagType, List<Tag>> tags;

  private void loadData(){

    JSONObject object = new JSONObject();
    File file = new File(dataLocation + dataFileName);
    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      String raw = "";
      while ((line = br.readLine()) != null){
        raw += line;
      }
      JSONParser parser = new JSONParser();
      object = (JSONObject) parser.parse(raw);
    } catch (ParseException | FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    for(JSONObject obj : object.get("transactions")){
      
    }

  }

  private void saveData(){

    JSONObject tagContainer = new JSONObject();
    for(TagType type : this.tags.keySet()){
      JSONArray tags = new JSONArray();
      for(Tag tag : this.tags.get(type)){
        tags.add(tag.asJSONifyable().toJSONObject());
      }
      tagContainer.put(type, tags);
    }

    JSONArray transactions = new JSONArray();
    for(Transaction transaction : this.transactions){
      transactions.add(transaction.asJSONifyable().toJSONObject());
    }

    JSONObject object = new JSONObject();
    object.put("tags", tagContainer);
    object.put("transactions", transactions);

    File file = new File(dataLocation + dataFileName);
    try(FileWriter fw = new FileWriter(file)){

      fw.write(object.toJSONString());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void getData() {

  }
}
