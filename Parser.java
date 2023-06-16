import java.util.ArrayList;
import java.util.Stack;

abstract public class Parser<T> {
    protected Stack<Boolean> angleStack;
    protected ArrayList<T> parsedOutput;

    ArrayList<T> getParsedOutput() { return parsedOutput; }

    void printParsedOutput(){
        for(T elem: parsedOutput)
            System.out.println(elem);
    }

    abstract void parse(String filepath);
}
