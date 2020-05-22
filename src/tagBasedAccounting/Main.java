package tagBasedAccounting;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Analyzer analyzer;
    Bookkeeper bookkeeper;
    // Main should not have direct access to the memory
    {
      Memory memory = MemoryFactory.memory();
      analyzer = AnalyzerFactory.analyzer(memory);
      bookkeeper = BookkeeperFactory.bookkeeper(memory);
    }

    Scanner scanner = new Scanner(System.in);
    String input;
    // main loop
    while (true){
      input = scanner.nextLine();
    }


  }


}
