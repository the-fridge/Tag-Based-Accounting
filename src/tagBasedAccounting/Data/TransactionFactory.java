package tagBasedAccounting.Data;

public class TransactionFactory {

  public static Transaction transaction(){
    Transaction transaction = new TransactionSimple();
    return transaction;
  }

}

class TransactionSimple implements Transaction{

}
