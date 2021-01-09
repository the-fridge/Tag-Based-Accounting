package tagBasedAccounting.Data;


import java.util.Date;
import java.util.List;
import java.util.Map;

class TransactionSimple implements Transaction {

  private long id;
  private double amount;
  private Date creationDate;
  private Date bookingDate;
  private String note;
  private boolean usageIsExpenditure;
  private List<Tag> description;
  private Map<Tag, Long> account; // if amount should be transaction-amount it will indicated with '-1'
  private Map<Tag, Long> usage;

}
