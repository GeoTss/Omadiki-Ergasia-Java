import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class productList {
    ArrayList<Product> myList = new ArrayList<Product>();

    productList() {
        myList = new ArrayList<>();
    }

    productList(ArrayList<Product> p){
        myList = p;
    }

    public void insertProduct(Product _Product) {
        myList.add(_Product);
    }
    public Product get(int index) {
        return myList.get(index);
    }
    public ArrayList<Product> getArray() {
        return myList;
    }
    public void displayProductList() {
        for (Product pr: myList) {
            System.out.println(pr);
        }
    }
    void writeToFile(String filepath) {
        try{
            FileWriter file = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(file);
            
            bw.write("PRODUCT_LIST\n{\n");
            for(Product p : myList)
                bw.write("\n\tITEM\n\t{\n" + p.genFileFormat() + "\n\t}\n");
            bw.write("\n}");
            bw.close();

        }catch(IOException ex){}
    }
}
