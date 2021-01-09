package tagBasedAccounting;

import tagBasedAccounting.Data.Memory;
import tagBasedAccounting.Logic.Analyzer;
import tagBasedAccounting.Logic.Bookkeeper;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Analyzer analyzer;
    Bookkeeper bookkeeper;
    // Main should not have direct access to the memory
    {
      Memory memory = Factory.memory();
      analyzer = Factory.analyzer(memory);
      bookkeeper = Factory.bookkeeper(memory);
    }

    Scanner scanner = new Scanner(System.in);
    String input;
    // main loop
    while (true){
      input = scanner.nextLine();
    }


  }


}
