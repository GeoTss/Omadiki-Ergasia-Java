import java.util.ArrayList;

abstract public class WriterProg<T> {
    protected ArrayList<T> InputToWrite;

    ArrayList<T> getInputToWrite() { return InputToWrite; }

    abstract void write(String filepath);
}
