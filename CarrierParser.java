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
            String line;

            String name = " ", afm = " ";

            while(true){
                line = _buff.readLine();

                if(line == null)
                    break;
                
                if(line.trim().toUpperCase().equals("COMPANY")){
                    line = _buff.readLine();
                    if(line.trim().equals("{")){
                        _buff.mark(2077);
                        while(!line.trim().equals("}")){
                            line = _buff.readLine();

                            lineTokens = new StringTokenizer(line);
                            token = lineTokens.nextToken();
                            if(token.equals("NAME")){
                                lineTokens.nextToken("\"");
                                name = lineTokens.nextToken("\"");
                            }
                            else if(token.equals("AFM"))
                                afm = lineTokens.nextToken();
                        }

                        parsedOutput.add(new Carrier(afm, name));
                    }
                }
            }
            _buff.close();

        } catch (IOException sex) {
            Logger.getLogger(CarrierParser.class.getName()).log(Level.SEVERE, null, sex);
        }
    }
}
