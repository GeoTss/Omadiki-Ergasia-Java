import java.io.BufferedWriter;

class PrintedAd extends Advertisement{
    private int wordCount;
    private float costInPos;
    int position;

    PrintedAd() {}

    PrintedAd(PrintedAdType _info, Product _product, String _reason, int _durationDays, int _wordCount, int _position){
        typeCode = _info.getCode();
        productCode = _product.getCode();
        reason = _reason;
        durationDays = _durationDays;

        wordCount = _wordCount;
        position = _position;

        switch(position){
            case 0:
                costInPos = _info.getCostFront();
                break;
            case 1:
                costInPos = _info.getCostMid();
                break;
            case 2:
                costInPos = _info.getCostBack();
                break;
        }
    }

    PrintedAd(PrintedAdType _info, int _product, String _reason, int _durationDays, int _wordCount, int _position){
        typeCode = _info.getCode();
        productCode = _product;
        reason = _reason;
        durationDays = _durationDays;

        wordCount = _wordCount;
        position = _position;

        switch(position){
            case 0:
                costInPos = _info.getCostFront();
                break;
            case 1:
                costInPos = _info.getCostMid();
                break;
            case 2:
                costInPos = _info.getCostBack();
                break;
        }
    }

    void setProductCode(int _product) {
        productCode = _product;
    }

    void setWordCount(int _wordCount) {
        wordCount = _wordCount;
    }

    void setCostInPos(float _costInPos) {
        costInPos = _costInPos;
    }

    void setposition(int _position) {
        position = _position;
    }

    void setDurationDays(int _durationDays) {
        durationDays = _durationDays;
    }

    void showCostFormula(){
        System.out.println("wordCount * costInPosition * durationInDays = " + wordCount + " * " + costInPos + " * " + durationDays + " = " + (wordCount * costInPos * durationDays));
    }

    float calculateCost(){
        showCostFormula();
        return wordCount * costInPos * durationDays;
    }

    public String toString(){
        return super.toString() + "\nWord amount: " + wordCount + "\nPosition: " + position;
    }
}