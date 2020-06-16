package tagBasedAccounting.Data;

public class DummyTag implements Tag{

  private long id;

  public DummyTag(long id){
    this.id = id;
  }
  private DummyTag(){}

  public long getId() {
    return id;
  }

  @Override
  public JSONifyable asJSONifyable() {
    throw new NullPointerException();
  }
}
