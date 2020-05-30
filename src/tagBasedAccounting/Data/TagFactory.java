package tagBasedAccounting.Data;

import org.json.simple.JSONObject;

import java.util.Date;
import java.util.List;

public class TagFactory {

  public static Tag tag(){
    Tag tag = new TagSimple();
    return tag;
  }
}

class TagSimple implements Tag, JSONinfyable{

  private long id;
  private String name;
  private TagType tagType;
  private Date creationDate;
  private List<Transaction> transactions;
  private List<Tag> tagLeaders;
  private List<Tag> tagSubordinates;

  @Override
  public JSONObject toJSONObject() {
    JSONObject object = new JSONObject();

    object.put("id", id);
    object.put("name", name);
    object.put("tagType", tagType);
    object.put("creationDate", creationDate);
    object.put("transactions", transactions);
    object.put("tagLeaders", tagLeaders);
    object.put("tagSubordinates", tagSubordinates);

    return object;
  }
}
