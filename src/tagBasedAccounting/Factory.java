package tagBasedAccounting;

import tagBasedAccounting.Data.Memory;
import tagBasedAccounting.Data.MemorySimple;
import tagBasedAccounting.Logic.Analyzer;
import tagBasedAccounting.Logic.AnalyzerSimple;
import tagBasedAccounting.Logic.Bookkeeper;
import tagBasedAccounting.Logic.BookkeeperSimple;

public class Factory {

    public static Memory memory(){
        Memory memory = new MemorySimple();
        return memory;
    }
    public static Bookkeeper bookkeeper(Memory memory){
        Bookkeeper bookkeeper = new BookkeeperSimple();
        return bookkeeper;
    }
    public static Analyzer analyzer(Memory memory){
        Analyzer analyzer = new AnalyzerSimple();
        return analyzer;
    }
}
