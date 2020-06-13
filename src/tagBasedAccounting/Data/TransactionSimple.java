package tagBasedAccounting.Data;

import org.json.simple.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

class TransactionSimple implements Transaction, JSONinfyable{

  private long id;
  private double amount;
  private Date creationDate;
  private Date bookingDate;
  private String note;
  private boolean usageIsExpenditure;
  private List<Tag> description;
  private Map<Tag, Long> account; // if amount should be transaction-amount it will indicated with '-1'
  private Map<Tag, Long> usage;

  @Override
  public JSONObject toJSONObject() {
    JSONObject object = new JSONObject();

    object.put("id", id);
    object.put("amount", amount);
    object.put("creationDate", creationDate);
    object.put("bookingDate", bookingDate);
    object.put("note", note);
    object.put("usageIsExpenditure", usageIsExpenditure);
    object.put("description", description);
    object.put("account", account);
    object.put("usage", usage);

    return object;
  }
}
