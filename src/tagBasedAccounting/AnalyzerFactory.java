package tagBasedAccounting;

public class AnalyzerFactory {

  public static Analyzer analyzer(){
    Analyzer analyzer = new AnalyzerSimple();
    return analyzer;
  }
}

class AnalyzerSimple implements Analyzer{

  @Override
  public void evaluate(String expression) {

  }
}
