package tagBasedAccounting.Data;

import java.util.List;

public interface Tag {

  long id();

  List<Tag> leaders();

  void setLeaders(List<Tag> leaders);

}
