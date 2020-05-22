package tagBasedAccounting;

public class BookkeeperFactory {

  public static Bookkeeper bookkeeper(Memory memory){
    Bookkeeper bookkeeper = new BookkeeperSimple();
    return bookkeeper;
  }
}

class BookkeeperSimple implements Bookkeeper{

  @Override
  public void createTransaction() {

  }

  @Override
  public void updateTransaction() {

  }

  @Override
  public void deleteTransaction() {

  }

  @Override
  public void createTag() {

  }

  @Override
  public void updateTag() {

  }

  @Override
  public void deleteTag() {

  }

  @Override
  public void groupTag() {

  }
}
