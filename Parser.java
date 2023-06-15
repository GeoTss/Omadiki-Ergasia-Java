import java.util.ArrayList;

abstract public class Parser<T> {
    protected ArrayList<T> parsedOutput;

    ArrayList<T> getParsedOutput() { return parsedOutput; }

    abstract void parse(String filepath);
}
