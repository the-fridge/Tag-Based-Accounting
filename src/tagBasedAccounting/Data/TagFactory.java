package tagBasedAccounting.Data;

public class TagFactory {

  public static Tag tag(){
    Tag tag = new TagSimple();
    return tag;
  }
}

class TagSimple implements Tag{

}
