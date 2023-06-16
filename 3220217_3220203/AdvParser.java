import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class ParsedAdvertisement {
    protected Advertisement adv;
    protected ArrayList<Boolean> mandatoryElems;
    protected ArrayList<String> elem;
    protected int mandatoryElemsCount, lineNum, linesAdvanced;
    
    int getMandatoryElemsCount() {
        return mandatoryElemsCount;
    }

    int getLinesAdvanced(){
        return linesAdvanced;
    }

    int getLineNum(){
        return lineNum;
    }

    Advertisement getAdv() {
        return adv;
    }

    int errorLog() {
        String log = "";
        int errors = 0;
        for (int i = 0; i < mandatoryElems.size(); ++i){
            if (!mandatoryElems.get(i)){
                log += elem.get(i) + "\n";
                ++errors;
            }
        }

        if (!log.isEmpty())
            System.out.println("ADV in line " + lineNum + " has the following elements missing:\n" + log + "\n");
        return errors;
    }

    abstract int parse(BufferedReader _buff);

}

class ParsedPrintedAd extends ParsedAdvertisement {

    ParsedPrintedAd(int _line) {
        lineNum = _line;
        linesAdvanced = 0;
        mandatoryElemsCount = 5;
        mandatoryElems = new ArrayList<>(mandatoryElemsCount);
        elem = new ArrayList<>(mandatoryElemsCount);

        for (int i = 0; i < mandatoryElemsCount; ++i)
            mandatoryElems.add(false);

        elem.add("ADVTYPE_CODE");
        elem.add("ITEM_CODE");
        elem.add("DURATION");
        elem.add("WORDCOUNT");
        elem.add("POSITION");
    }

    int parse(BufferedReader _buff) {
        PrintedAd ret = new PrintedAd();
        boolean angleClosed = false;

        try {
            _buff.reset();

            StringTokenizer lineTokens;
            String token;
            String line;
            line = _buff.readLine();

            while (!line.trim().equals("ADV") && !angleClosed) {
                ++linesAdvanced;

                if (line.isBlank()) {
                    line = _buff.readLine();
                    continue;
                }

                lineTokens = new StringTokenizer(line);
                if (lineTokens.countTokens() < 2) {
                    line = _buff.readLine();
                    continue;
                }

                token = lineTokens.nextToken();

                if (token.trim().toUpperCase().equals("ADVTYPE_CODE")) {
                    ret.setTypeCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(0, true);
                } 

                else if (token.trim().toUpperCase().equals("ITEM_CODE")) {
                    ret.setProductCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(1, true);
                }
                
                else if (token.trim().toUpperCase().equals("JUSTIFICATION")) {
                    lineTokens.nextToken("\"");
                    token = lineTokens.nextToken("\"");
                    if(token != null && !token.isBlank() && !token.isEmpty()){
                        ret.setDescritpion(token);
                    }
                }

                else if (token.trim().toUpperCase().equals("DURATION")) {
                    ret.setDurationDays(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(2, true);
                }

                else if (token.trim().toUpperCase().equals("WORDCOUNT")) {
                    ret.setWordCount(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(3, true);
                }

                else if (token.trim().toUpperCase().equals("POSITION")) {
                    ret.setposition(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(4, true);
                }

                line = _buff.readLine();
                angleClosed = line.trim().equals("}");
                // ++linesAdvanced;
            }
        } catch (IOException sex) {
            Logger.getLogger(ParsedPrintedAd.class.getName()).log(Level.SEVERE, null, sex);
        }
        ++linesAdvanced;

        int ok = errorLog();
        if (ok == 0 && angleClosed)
            adv = ret;
        else if(!angleClosed){
            ok = Integer.MAX_VALUE;
            linesAdvanced = 0;
        }
        
        return ok;
    }
}

class ParsedRadioTVAd extends ParsedAdvertisement {
    ParsedRadioTVAd(int _line) {
        lineNum = _line;
        linesAdvanced = 0;
        mandatoryElemsCount = 5;
        mandatoryElems = new ArrayList<>(mandatoryElemsCount);
        elem = new ArrayList<>(mandatoryElemsCount);

        for (int i = 0; i < mandatoryElemsCount; ++i)
            mandatoryElems.add(false);

        elem.add("ADVTYPE_CODE");
        elem.add("ITEM_CODE");
        elem.add("DURATION");
        elem.add("TIMEZONE");
        elem.add("DURATION_SECONDS");
    }

    int parse(BufferedReader _buff) {
        RadioTVAd ret = new RadioTVAd();
        boolean angleClosed = false;

        try {
            _buff.reset();

            StringTokenizer lineTokens;
            String token;
            String line;
            line = _buff.readLine();
            
            while (!line.trim().equals("ADV") && !angleClosed) {
                
                ++linesAdvanced;
                if (line.isBlank()) {
                    line = _buff.readLine();
                    continue;
                }

                lineTokens = new StringTokenizer(line);
                if (lineTokens.countTokens() < 2) {
                    line = _buff.readLine();
                    continue;
                }

                token = lineTokens.nextToken();

                if (token.trim().toUpperCase().equals("ADVTYPE_CODE")) {
                    ret.setTypeCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(0, true);
                }
                
                else if (token.trim().toUpperCase().equals("ITEM_CODE")) {
                    ret.setProductCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(1, true);
                }

                else if (token.trim().toUpperCase().equals("JUSTIFICATION")) {
                    lineTokens.nextToken("\"");
                    token = lineTokens.nextToken("\"");
                    if(token != null && !token.isBlank() && !token.isEmpty()){
                        ret.setDescritpion(token);
                    }
                }

                else if (token.trim().toUpperCase().equals("DURATION")) {
                    ret.setDurationDays(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(2, true);
                }

                else if (token.trim().toUpperCase().equals("TIMEZONE")) {
                    ret.setTimeZone(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(3, true);
                }

                else if (token.trim().toUpperCase().equals("DURATION_SECONDS")) {
                    ret.setDurationSeconds(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(4, true);
                } 
                

                line = _buff.readLine();
                angleClosed = line.trim().equals("}");
                // ++linesAdvanced;
            }
        } catch (IOException sex) {
            Logger.getLogger(ParsedRadioTVAd.class.getName()).log(Level.SEVERE, null, sex);
        }
        ++linesAdvanced;

        int ok = errorLog();
        if (ok == 0 && angleClosed)
            adv = ret;
        else if(!angleClosed){
            ok = Integer.MAX_VALUE;
            linesAdvanced = 0;
        }

        return ok;
    }
}

class ParsedWebAd extends ParsedAdvertisement {
    ParsedWebAd(int _line) {
        lineNum = _line;
        linesAdvanced = 0;
        mandatoryElemsCount = 5;
        mandatoryElems = new ArrayList<>(mandatoryElemsCount);
        elem = new ArrayList<>(mandatoryElemsCount);

        for (int i = 0; i < mandatoryElemsCount; ++i)
            mandatoryElems.add(false);

        elem.add("ADVTYPE_CODE");
        elem.add("ITEM_CODE");
        elem.add("DURATION");
        elem.add("AUTOSHOW");
        elem.add("ADDITIONAL_PAGES");
    }

    int parse(BufferedReader _buff) {
        WebAd ret = new WebAd();
        boolean angleClosed = false;

        try {
            _buff.reset();

            StringTokenizer lineTokens;
            String token;
            String line;
            line = _buff.readLine();
            
            while (!line.trim().equals("ADV") && !angleClosed) {
                ++linesAdvanced;

                if (line.isBlank()) {
                    line = _buff.readLine();
                    continue;
                }

                lineTokens = new StringTokenizer(line);
                if (lineTokens.countTokens() < 2) {
                    line = _buff.readLine();
                    continue;
                }

                token = lineTokens.nextToken();

                if (token.trim().toUpperCase().equals("ADVTYPE_CODE")) {
                    ret.setTypeCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(0, true);
                }

                else if (token.trim().toUpperCase().equals("ITEM_CODE")) {
                    ret.setProductCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(1, true);
                }
                
                else if (token.trim().toUpperCase().equals("JUSTIFICATION")) {
                    lineTokens.nextToken("\"");
                    ret.setDescritpion(lineTokens.nextToken("\""));
                    if(token != null && !token.isBlank() && !token.isEmpty()){
                        ret.setDescritpion(token);
                    }
                }

                else if (token.trim().toUpperCase().equals("DURATION")) {
                    ret.setDurationDays(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(2, true);
                }

                else if (token.trim().toUpperCase().equals("AUTOSHOW")) {
                    ret.setAutoShow(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(3, true);
                }

                else if (token.trim().toUpperCase().equals("ADDITIONAL_PAGES")) {
                    ret.setAdditionalPages(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(4, true);
                }

                line = _buff.readLine();
                angleClosed = line.trim().equals("}");
                // ++linesAdvanced;
            }
        } catch (IOException sex) {
            Logger.getLogger(ParsedWebAd.class.getName()).log(Level.SEVERE, null, sex);
        }
        ++linesAdvanced;

        int ok = errorLog();
        if (ok == 0 && angleClosed)
            adv = ret;
        else if(!angleClosed){
            ok = Integer.MAX_VALUE;
            linesAdvanced = 0;
        }

        return ok;
    }
}

public class AdvParser extends Parser<Advertisement> {

    AdvParser() {
        parsedOutput = new ArrayList<>();
        bracketStack = new Stack<>();
    }

    void parse(String filepath) {
        try {
            FileReader file = new FileReader(filepath);
            BufferedReader _buff = new BufferedReader(file);

            StringTokenizer lineTokens;
            String token, line = " ";
            int lineNum = 0;

            ParsedAdvertisement parsedAdv = null;

            while(!line.trim().toUpperCase().equals("ADV_LIST")){
                ++lineNum;
                line = _buff.readLine();
            }
            ++lineNum;

            if(!_buff.readLine().trim().equals("{")){
                _buff.close();
                return;
            }

            bracketStack.push(true);

            while (line != null && !bracketStack.isEmpty()) {
                ++lineNum;
                line = _buff.readLine();
                
                if (line == null)
                    break;

                if(line.trim().equals("}"))
                    bracketStack.pop();
                
                if (line.trim().toUpperCase().equals("ADV")) {
                    line = _buff.readLine();
                    if (line.trim().equals("{")) {

                        _buff.mark(2048);
                        boolean foundType = false;
                        int tempLineCount = lineNum+1;

                        bracketStack.push(true);

                        while (!(line.trim().toUpperCase().equals("ADV"))) {
                            line = _buff.readLine();
                            ++tempLineCount;

                            if (line.isBlank())
                                continue;
                            lineTokens = new StringTokenizer(line);

                            if (lineTokens.countTokens() < 2)
                                continue;
                            token = lineTokens.nextToken();

                            if (token.trim().toUpperCase().equals("TYPE")) {
                                token = lineTokens.nextToken();
                                
                                if (token.trim().toUpperCase().equals("PRINT"))
                                    parsedAdv = new ParsedPrintedAd(lineNum);

                                else if (token.trim().toUpperCase().equals("RADIO"))
                                    parsedAdv = new ParsedRadioTVAd(lineNum);

                                else if (token.trim().toUpperCase().equals("MEDIA"))
                                    parsedAdv = new ParsedWebAd(lineNum);
                                else{
                                    System.out.println("Missing typename after TYPE in ADV, line " + lineNum);
                                    break;
                                }
                                foundType = true;
                                
                                int parseErrors = parsedAdv.parse(_buff);
                                if (parseErrors == 0)
                                    parsedOutput.add(parsedAdv.getAdv());
                                else if(parseErrors == Integer.MAX_VALUE){
                                    System.out.println("ADV in line " + lineNum + " expected closing bracket '}'");
                                    _buff.reset();
                                }
                                lineNum += parsedAdv.getLinesAdvanced()+1;

                                if(parseErrors != Integer.MAX_VALUE)
                                    bracketStack.pop();

                                break;
                            }
                        }
                        if(!foundType){
                            System.out.println("Didn't find TYPE for ADV in line " + lineNum);
                            lineNum = tempLineCount;
                        }
                    }
                    else{
                        System.out.println("Missing { in line " + lineNum++);
                    }
                }
            }
        } catch (java.util.NoSuchElementException sex) {
            Logger.getLogger(AdvTypeParser.class.getName()).log(Level.SEVERE,
                    "ERROR WHILE PROCESSING ADVTYPE FOR TYPE");
        } catch (IOException ex) {
            Logger.getLogger(AdvTypeParser.class.getName()).log(Level.SEVERE, "IOException", ex);
        }
    }
}