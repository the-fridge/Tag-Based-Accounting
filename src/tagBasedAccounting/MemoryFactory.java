package tagBasedAccounting;

public class MemoryFactory {

  public static Memory memory(){
    Memory memory = new MemorySimple();
    return memory;
  }
}

class MemorySimple implements Memory{

  @Override
  public void getData() {

  }
}
