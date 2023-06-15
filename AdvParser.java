import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AdvParser extends Parser<AdvertisementType> {
    static PrintedAdType printedAdTypeParser(BufferedReader _buff) {
        PrintedAdType ret = new PrintedAdType();
        try {
            _buff.reset();
            StringTokenizer lineTokens;
            String token;
            String line;
            line = _buff.readLine();

            while ( !(line.trim().equals("}")) ) {
                line = _buff.readLine();
                
                lineTokens = new StringTokenizer(line);
                token = lineTokens.nextToken();
                
                if(token.trim().toUpperCase().equals("CODE"))
                    ret.setCode(Integer.parseInt(lineTokens.nextToken()));
                else if(token.trim().toUpperCase().equals("DESCR")){
                    lineTokens.nextToken("\"");
                    ret.setDescription(lineTokens.nextToken("\""));
                }
                else if(token.trim().toUpperCase().equals("AFM"))
                    ret.setCarrierVAT(lineTokens.nextToken());

                else if(token.trim().toUpperCase().equals("COST_FRONT"))
                    ret.setCostFront(Float.parseFloat(lineTokens.nextToken()));

                else if(token.trim().toUpperCase().equals("COST_MID"))
                    ret.setCostMid(Float.parseFloat(lineTokens.nextToken()));

                else if(token.trim().toUpperCase().equals("COST_BACK"))
                    ret.setCostBack(Float.parseFloat(lineTokens.nextToken()));

            }
        } catch (IOException sex) {}

        return ret;
    }

    void parse(String filepath) {
        try {
            FileReader file = new FileReader(filepath);
            BufferedReader _buff = new BufferedReader(file);

            StringTokenizer lineTokens;
            String token, line = "";

            AdvertisementType advtype = null;

            while (true) {
                line = _buff.readLine();
                if (line == null)
                    break;

                if (line.trim().toUpperCase().equals("ADVTYPE")) {
                    line = _buff.readLine();
                    while (!(line.trim().equals("}"))) {
                        lineTokens = new StringTokenizer(line);
                        token = lineTokens.nextToken();

                        if (token.trim().toUpperCase().equals("TYPE")) {
                            token = lineTokens.nextToken();

                            if (token.trim().toUpperCase().equals("Print"))
                                advtype = printedAdTypeParser(_buff);
                            else if (token.trim().toUpperCase().equals("Radio"))
                                advtype = new RadioTVAdType();
                            else
                                advtype = new WebAdType();
                        }
                    }
                    parsedOutput.add(advtype);
                }
            }

        } catch (IOException sex) {

        }
    }
}

