import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarrierParser extends Parser<Carrier> {

    void printCarriers(){
        for(Carrier c: parsedOutput)
            System.out.println(c);
    }

    CarrierParser(){
        parsedOutput = new ArrayList<>();
    }

    void parse(String filepath) {
        try {
            FileReader file = new FileReader(filepath);
            BufferedReader _buff = new BufferedReader(file);

            StringTokenizer lineTokens;
            String token;
            String line = "";
            
            int lineNum = 0;

            // String name = " ", afm = " ";
            boolean[] hasElements = new boolean[2];
            String[] elems = new String[2];

            elems[0] = "NAME";
            elems[1] = "AFM";

            while(!line.trim().toUpperCase().equals("COMPANY_LIST"))
                line = _buff.readLine();

            while(line != null && !line.trim().equals("}")){
                ++lineNum;
                line = _buff.readLine();
                
                if(line == null)
                    break;
                
                if(line.trim().toUpperCase().equals("COMPANY")){
                    line = _buff.readLine();
                    Carrier c = new Carrier();
                    
                    if(line.trim().equals("{")){
                        _buff.mark(2077);

                        boolean angleClosed = false;
                        hasElements[0] = hasElements[1] = false;
                        int tempLineCount = 1;

                        while(!line.trim().toUpperCase().equals("COMPANY") && !angleClosed){
                            line = _buff.readLine();
                            angleClosed = line.trim().equals("}");
                            
                            ++tempLineCount;

                            if(line.isBlank() || line.isEmpty())
                                continue;

                            lineTokens = new StringTokenizer(line);

                            if(lineTokens.countTokens() < 2)
                                continue;

                            token = lineTokens.nextToken();
                            if(token.equals("NAME")){
                                lineTokens.nextToken("\"");
                                c.setName(lineTokens.nextToken("\""));
                                hasElements[0] = true;
                            }
                            else if(token.equals("AFM")){
                                // afm = lineTokens.nextToken();
                                c.setVAT(lineTokens.nextToken());
                                hasElements[1] = true;
                            }
                        }

                        if(hasElements[0] && hasElements[1] && angleClosed)
                            parsedOutput.add(c);
                        else if(!angleClosed){
                            System.out.println("COMPANY in line " + lineNum + " expected closing bracket '}'");
                            _buff.reset();
                        }
                        else{
                            System.out.println("The following elements are missing from COMPANY in line " + lineNum + ":");
                            for(int i = 0; i < 2; ++i)
                                if(!hasElements[i])
                                    System.out.println(elems[i]);
                            System.out.println();
                        }
                        lineNum += tempLineCount;
                        // parsedOutput.add(new Carrier(afm, name));
                    }
                    else
                        System.out.println("Expected { below COMPANY in line " + lineNum++);
                }
            }
            _buff.close();

        } catch (IOException sex) {
            Logger.getLogger(CarrierParser.class.getName()).log(Level.SEVERE, null, sex);
        }
    }
}
