import java.util.ArrayList;

abstract public class Parser<T> {
    protected ArrayList<T> parsedOutput;

    ArrayList<T> getParsedOutput() { return parsedOutput; }

    void printParsedOutput(){
        for(T elem: parsedOutput)
            System.out.println(elem);
    }

    abstract void parse(String filepath);
}
