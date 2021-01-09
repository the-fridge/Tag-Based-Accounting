package tagBasedAccounting.Data;

import java.util.List;

public class DummyTag implements Tag{

  private long id;

  public DummyTag(long id){
    this.id = id;
  }
  private DummyTag(){}

  @Override
  public long id() {
    return id;
  }

  @Override
  public List<Tag> leaders() {
    throw new NullPointerException();
  }

  @Override
  public void setLeaders(List<Tag> leaders) {
    throw new NullPointerException();
  }

 /* @Override
  public JSONifyable asJSONifyable() {
    throw new NullPointerException();
  }*/
}
