package tagBasedAccounting.Data;

import org.json.simple.JSONObject;

import java.util.Date;
import java.util.List;

class TagSimple implements Tag, JSONifyable {

  private long id;
  private String name;
  private TagType tagType;
  private Date creationDate;
  private List<Transaction> transactions;
  private List<Tag> leaders;
  private List<Tag> subordinates;

  @Override
  public JSONObject toJSONObject() {
    JSONObject object = new JSONObject();

    object.put("id", id);
    object.put("name", name);
    object.put("tagType", tagType);
    object.put("creationDate", creationDate);
    object.put("transactions", transactions);
    object.put("tagLeaders", leaders);
    object.put("tagSubordinates", subordinates);

    return object;
  }

  @Override
  public JSONifyable asJSONifyable() {
    return this;
  }
}
