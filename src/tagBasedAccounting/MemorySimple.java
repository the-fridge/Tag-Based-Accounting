package tagBasedAccounting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import tagBasedAccounting.Data.JSONinfyable;
import tagBasedAccounting.Data.Tag;
import tagBasedAccounting.Data.TagType;
import tagBasedAccounting.Data.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class MemorySimple implements Memory{

  private static String dataLocation = "./";
  private static String dataFileName = "data.json";

  private List<Transaction> transactions;
  private Map<TagType, List<Tag>> tags;

  private void saveData(){

    JSONArray tags = new JSONArray();
    for(TagType type : this.tags.keySet()){
      for(Tag tag : this.tags.get(type)){
        if(tag instanceof JSONinfyable){
          tags.add(((JSONinfyable) tag).toJSONObject());
        }
      }
    }

    JSONArray transactions = new JSONArray();
    for(Transaction transaction : this.transactions){
      if(transaction instanceof JSONinfyable){
        transactions.add(((JSONinfyable) transaction).toJSONObject());
      }
    }

    JSONObject object = new JSONObject();
    object.put("tags", tags);
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
