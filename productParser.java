import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductParser extends Parser<Product> {
    
    ProductParser() {
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

            int lineNum = 0;
            
            boolean[] hasElements = new boolean[3];
            String[] elems = new String[3];

            elems[0] = "CODE";
            elems[1] = "CARRIER_AFM";
            elems[2] = "DESCR";

            while(true) {
                ++lineNum;
                line = _buff.readLine();

                if(line == null)
                    break;

                if(line.trim().toUpperCase().equals("ITEM")){
                    line = _buff.readLine();
                    Product p = new Product();

                    if(line.trim().equals("{")){
                        _buff.mark(2077);
                        hasElements[0] = hasElements[1] = hasElements[2] = false;
                        int tempLineNum = 1;
                        
                        while(!line.trim().equals("}") && !line.trim().toUpperCase().equals("ITEM")){
                            line = _buff.readLine();
                            ++tempLineNum;

                            if(line != null && line.isBlank())
                                continue;
                            lineTokens = new StringTokenizer(line);
                            if(lineTokens.countTokens() < 2)
                                continue;

                            token = lineTokens.nextToken();
                            if(token.trim().toUpperCase().equals("CODE")){
                                p.setCode(Integer.parseInt(lineTokens.nextToken()));
                                hasElements[0] = true;
                            }

                            else if(token.trim().toUpperCase().equals("CARRIER_AFM")){
                                p.setProductVAT(lineTokens.nextToken());
                                hasElements[1] = true;
                            }
                            else if(token.trim().toUpperCase().equals("DESCR")){
                                lineTokens.nextToken("\"");
                                p.setDescription(lineTokens.nextToken("\""));
                                hasElements[2] = true;
                            }
                        }
                        
                        if(hasElements[0] && hasElements[1] && hasElements[2])
                            parsedOutput.add(p);
                        else{
                            System.out.println("The following elements are missing from ITEM in line " + lineNum + ":");
                            for(int i = 0; i < 3; ++i)
                                if(!hasElements[i])
                                    System.out.println(elems[i]);
                            System.out.println();
                        }
                        lineNum += tempLineNum;
                    }
                    else{
                        System.out.println("Expected { below ITEM in line " + lineNum++);
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
