import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class productParser extends Parser<Product> {
    
    productParser() {
        parsedOutput = new ArrayList<>();
    }

    void printProducts() {
        for (Product p: parsedOutput) {
            System.out.println(p);
        }
    }

    void parse(String filepath) {
        try {
            FileReader file = new FileReader(filepath);
            BufferedReader _buff = new BufferedReader(file);

            StringTokenizer lineTokens;
            String token;
            String line = "";

            String descr = " ", name = " ";

            while(true) {

                line = _buff.readLine();

                if(line == null)
                    break;

                if(line.trim().toUpperCase().equals("ITEM")){

                    line = _buff.readLine();
                    if(line.trim().equals("{")){
                        _buff.mark(2077);
                        while(!line.trim().equals("}")){
                            line = _buff.readLine();

                            lineTokens = new StringTokenizer(line);
                            token = lineTokens.nextToken();
                            if(token.equals("DESCR")){
                                lineTokens.nextToken("\"");
                                descr = lineTokens.nextToken("\"");
                            }
                            else if(token.equals("NAME"))
                                name = lineTokens.nextToken();
                        }

                        parsedOutput.add(new Product(descr, name));
                    }
                }
            }
            _buff.close();
        } 
        catch(IOException ex) {
            Logger.getLogger(CarrierParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
