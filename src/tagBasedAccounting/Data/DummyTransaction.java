package tagBasedAccounting.Data;

public class DummyTransaction implements Transaction {

  private long id;

  public DummyTransaction(long id){
    this.id = id;
  }

  private DummyTransaction(){}

 /* @Override
  public JSONifyable asJSONifyable() {
    throw new NullPointerException();
  }*/
}
