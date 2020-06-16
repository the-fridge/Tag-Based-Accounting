package tagBasedAccounting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tagBasedAccounting.Data.Factory;
import tagBasedAccounting.Data.Tag;
import tagBasedAccounting.Data.TagType;
import tagBasedAccounting.Data.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MemorySimple implements Memory {

  private static String dataLocation = "./";
  private static String dataFileName = "data.json";

  private List<Transaction> transactions;
  private Map<TagType, List<Tag>> tags;

  public MemorySimple(){
    transactions = new ArrayList<>();
    tags = new HashMap<>();
    loadData();
  }

  private void loadData() {

    JSONObject object = new JSONObject();
    File file = new File(dataLocation + dataFileName);
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      String raw = "";
      while ((line = br.readLine()) != null) {
        raw += line;
      }
      JSONParser parser = new JSONParser();
      object = (JSONObject) parser.parse(raw);
    } catch (ParseException | FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    JSONArray jsonTransactions = (JSONArray) object.get("transactions");
    for (Object obj : jsonTransactions) {
      transactions.add(Factory.transaction((JSONObject) obj));
    }

    JSONObject jsonTagcontainer = (JSONObject) object.get("tags");
    for (Object rawTagType : jsonTagcontainer.keySet()) {
      TagType type = TagType.valueOf((String) rawTagType);
      JSONArray rawTagList = (JSONArray) object.get(rawTagType);
      List tagList = new ArrayList();
      for (Object obj : rawTagList){
        tagList.add(Factory.tag((JSONObject) obj));
      }
      tags.put(type, tagList);
    }

    // finalizing -> replacing Dummies with correct Objects
    Map<Long, Tag> tagIndex = new HashMap<>();
    Map<Long, Transaction> transactionIndex = new HashMap<>();

  }

  private void saveData() {

    JSONObject tagContainer = new JSONObject();
    for (TagType type : this.tags.keySet()) {
      JSONArray tags = new JSONArray();
      for (Tag tag : this.tags.get(type)) {
        tags.add(tag.asJSONifyable().toJSONObject());
      }
      tagContainer.put(type, tags);
    }

    JSONArray transactions = new JSONArray();
    for (Transaction transaction : this.transactions) {
      transactions.add(transaction.asJSONifyable().toJSONObject());
    }

    JSONObject object = new JSONObject();
    object.put("tags", tagContainer);
    object.put("transactions", transactions);

    File file = new File(dataLocation + dataFileName);
    try (FileWriter fw = new FileWriter(file)) {

      fw.write(object.toJSONString());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void getData() {

  }
}
