import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class ParsedAdvertisementType {
    protected AdvertisementType adv;
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

    AdvertisementType getAdv() {
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
            System.out.println("In line " + lineNum + ", the following items from ADVTYPE are missing:\n" + log);
        return errors;
    }

    abstract int parse(BufferedReader _buff);

}

class ParsedPrintedAdType extends ParsedAdvertisementType {

    ParsedPrintedAdType(int _line) {
        lineNum = _line;
        linesAdvanced = 0;
        mandatoryElemsCount = 6;
        mandatoryElems = new ArrayList<>(mandatoryElemsCount);
        elem = new ArrayList<>(mandatoryElemsCount);

        for (int i = 0; i < mandatoryElemsCount; ++i)
            mandatoryElems.add(false);

        elem.add("CODE");
        elem.add("AFM");
        elem.add("DESCR");
        elem.add("COST_FRONT");
        elem.add("COST_MID");
        elem.add("COST_BACK");
    }

    int parse(BufferedReader _buff) {
        PrintedAdType ret = new PrintedAdType();
        boolean angleClosed = false;

        try {
            _buff.reset();

            StringTokenizer lineTokens;
            String token;
            String line;
            line = _buff.readLine();
            
            while (!line.trim().equals("ADVTYPE") && !angleClosed) {
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

                if (token.trim().toUpperCase().equals("CODE")) {
                    ret.setCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(0, true);
                } 

                else if (token.trim().toUpperCase().equals("AFM")) {
                    ret.setCarrierVAT(lineTokens.nextToken());
                    mandatoryElems.set(1, true);
                }
                
                else if (token.trim().toUpperCase().equals("DESCR")) {
                    lineTokens.nextToken("\"");
                    token = lineTokens.nextToken("\"");
                    if(token != null && !token.isBlank() && !token.isEmpty()){
                        ret.setDescription(token);
                        mandatoryElems.set(2, true);
                    }
                }


                else if (token.trim().toUpperCase().equals("COST_FRONT")) {
                    ret.setCostFront(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(3, true);
                }

                else if (token.trim().toUpperCase().equals("COST_MID")) {
                    ret.setCostMid(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(4, true);
                }

                else if (token.trim().toUpperCase().equals("COST_BACK")) {
                    ret.setCostBack(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(5, true);
                }

                line = _buff.readLine();
                angleClosed = line.trim().equals("}");
            }
        } catch (IOException sex) {
            Logger.getLogger(ParsedPrintedAdType.class.getName()).log(Level.SEVERE, null, sex);
        }
        ++linesAdvanced;

        int ok = errorLog();
        if (ok == 0 && angleClosed)
            adv = ret;
        else if(!angleClosed)
            ok = Integer.MAX_VALUE;
        
        return ok;
    }
}

class ParsedRadioTVAdType extends ParsedAdvertisementType {
    ParsedRadioTVAdType(int _line) {
        lineNum = _line;
        linesAdvanced = 0;
        mandatoryElemsCount = 7;
        mandatoryElems = new ArrayList<>(mandatoryElemsCount);
        elem = new ArrayList<>(mandatoryElemsCount);

        for (int i = 0; i < mandatoryElemsCount; ++i)
            mandatoryElems.add(false);

        elem.add("CODE");
        elem.add("AFM");
        elem.add("DESCR");
        elem.add("CPS_MORNING");
        elem.add("CPS_MIDDAY");
        elem.add("CPS_EVENING");
        elem.add("CPS_NIGHT");
    }

    int parse(BufferedReader _buff) {
        RadioTVAdType ret = new RadioTVAdType();
        boolean angleClosed = false;

        try {
            _buff.reset();

            StringTokenizer lineTokens;
            String token;
            String line;
            line = _buff.readLine();
            
            while (!line.trim().equals("ADVTYPE") && !angleClosed) {
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

                if (token.trim().toUpperCase().equals("CODE")) {
                    ret.setCode(Integer.parseInt(lineTokens.nextToken()));
                    mandatoryElems.set(0, true);
                }
                
                else if (token.trim().toUpperCase().equals("AFM")) {
                    ret.setCarrierVAT(lineTokens.nextToken());
                    mandatoryElems.set(1, true);
                }

                else if (token.trim().toUpperCase().equals("DESCR")) {
                    lineTokens.nextToken("\"");
                    ret.setDescription(lineTokens.nextToken("\""));
                    mandatoryElems.set(2, true);
                }

                else if (token.trim().toUpperCase().equals("CPS_MORNING")) {
                    ret.setcpsMorning(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(3, true);
                }

                else if (token.trim().toUpperCase().equals("CPS_MIDDAY")) {
                    ret.setcpsMidday(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(4, true);
                }

                else if (token.trim().toUpperCase().equals("CPS_EVENING")) {
                    ret.setcpsEvening(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(5, true);
                } 
                
                else if (token.trim().toUpperCase().equals("CPS_NIGHT")) {
                    ret.setcpsNight(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(6, true);
                }

                line = _buff.readLine();
                angleClosed = line.trim().equals("}");
            }
        } catch (IOException sex) {
            Logger.getLogger(ParsedRadioTVAdType.class.getName()).log(Level.SEVERE, null, sex);
        }
        ++linesAdvanced;

        int ok = errorLog();
        if (ok == 0 && angleClosed)
            adv = ret;
        else if(!angleClosed)
            ok = Integer.MAX_VALUE;

        return ok;
    }
}

class ParsedWebAdType extends ParsedAdvertisementType {
    ParsedWebAdType(int _line) {
        lineNum = _line;
        linesAdvanced = 0;
        mandatoryElemsCount = 6;
        mandatoryElems = new ArrayList<>(mandatoryElemsCount);
        elem = new ArrayList<>(mandatoryElemsCount);

        for (int i = 0; i < mandatoryElemsCount; ++i)
            mandatoryElems.add(false);

        elem.add("CODE");
        elem.add("AFM");
        elem.add("DESCR");
        elem.add("COST_PER_DAY");
        elem.add("COST_PER_ADDITIONAL_PAGE");
        elem.add("COST_AUTOSHOW");
    }

    int parse(BufferedReader _buff) {
        WebAdType ret = new WebAdType();
        boolean angleClosed = false;

        try {
            _buff.reset();

            StringTokenizer lineTokens;
            String token;
            String line;
            line = _buff.readLine();
            
            while (!line.trim().equals("ADVTYPE") && !angleClosed) {
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

                if (token.trim().toUpperCase().equals("CODE")) {
                    ret.setCode(Integer.parseInt(lineTokens.nextToken()));
                    
                    mandatoryElems.set(0, true);
                }

                else if (token.trim().toUpperCase().equals("AFM")) {
                    ret.setCarrierVAT(lineTokens.nextToken());
                    mandatoryElems.set(1, true);
                }
                
                else if (token.trim().toUpperCase().equals("DESCR")) {
                    lineTokens.nextToken("\"");
                    ret.setDescription(lineTokens.nextToken("\""));
                    mandatoryElems.set(2, true);
                }

                else if (token.trim().toUpperCase().equals("COST_PER_DAY")) {
                    ret.setCostPerDay(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(3, true);
                }

                else if (token.trim().toUpperCase().equals("COST_PER_ADDITIONAL_PAGE")) {
                    ret.setCostPerAdditionalPage(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(4, true);
                }

                else if (token.trim().toUpperCase().equals("COST_AUTOSHOW")) {
                    ret.setCostAutoShow(Float.parseFloat(lineTokens.nextToken()));
                    mandatoryElems.set(5, true);
                }

                line = _buff.readLine();
                angleClosed = line.trim().equals("}");
            }
        } catch (IOException sex) {
            Logger.getLogger(ParsedWebAdType.class.getName()).log(Level.SEVERE, null, sex);
        }
        ++linesAdvanced;

        int ok = errorLog();
        if (ok == 0 && angleClosed)
            adv = ret;
        else if(!angleClosed)
            ok = Integer.MAX_VALUE;

        return ok;
    }
}

public class AdvTypeParser extends Parser<AdvertisementType> {

    AdvTypeParser() {
        parsedOutput = new ArrayList<>();
        angleStack = new Stack<>();
    }

    void parse(String filepath) {
        try {
            FileReader file = new FileReader(filepath);
            BufferedReader _buff = new BufferedReader(file);

            StringTokenizer lineTokens;
            String token, line = "";
            int lineNum = 0;

            ParsedAdvertisementType parsedAdvType = null;

            while (true) {
                ++lineNum;
                line = _buff.readLine();
                // System.out.println(lineNum + ": " + line);

                if (line == null)
                    break;

                if (line.trim().toUpperCase().equals("ADVTYPE")) {
                    line = _buff.readLine();
                    if (line.trim().equals("{")) {
                        angleStack.push(true);

                        _buff.mark(2048);
                        boolean foundType = false;
                        int tempLineCount = lineNum+1;

                        while(!line.trim().equals("}") ) {
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
                                    parsedAdvType = new ParsedPrintedAdType(lineNum);

                                else if (token.trim().toUpperCase().equals("RADIO"))
                                    parsedAdvType = new ParsedRadioTVAdType(lineNum);

                                else if (token.trim().toUpperCase().equals("MEDIA"))
                                    parsedAdvType = new ParsedWebAdType(lineNum);
                                else{
                                    System.out.println("Missing typename after TYPE in ADVTYPE, line " + lineNum);
                                    break;
                                }
                                foundType = true;
                                
                                int parseErrors = parsedAdvType.parse(_buff);
                                if (parseErrors == 0)
                                    parsedOutput.add(parsedAdvType.getAdv());
                                else if(parseErrors == Integer.MAX_VALUE){
                                    System.out.println("ADVTYPE in line " + lineNum + " expected closing bracket '}'");
                                    _buff.reset();
                                }

                                lineNum += parsedAdvType.getLinesAdvanced()+1;
                                break;
                            }

                        }
                        // angleStack.pop();
                        if(!foundType){
                            System.out.println("Didn't found TYPE for ADVTYPE in line " + lineNum);
                            lineNum = tempLineCount;
                        }
                    }
                    else{
                        // ++lineNum;
                        System.out.println("Expected { after ADVTYPE in line " + lineNum++);
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