package tagBasedAccounting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

  private void loadData(){
    

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
