package tagBasedAccounting.Logic;

public interface Bookkeeper {

  void createTransaction();

  void updateTransaction();

  void deleteTransaction();

  void createTag();

  void updateTag();

  void deleteTag();

  void groupTag();

}
