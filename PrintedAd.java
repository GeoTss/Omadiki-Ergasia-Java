class PrintedAd extends Advertisement{
    private int wordCount;
    private float costInPos;
    String position;

    PrintedAd(PrintedAdType _info, int _productCode, String _reason, int _durationDays, int _wordCount, String _position){
        typeCode = _info.getCode();
        productCode = _productCode;
        reason = _reason;
        durationDays = _durationDays;

        wordCount = _wordCount;
        position = _position;

        switch(position){
            case "front":
                costInPos = _info.getCostFront();
                break;
            case "middle":
                costInPos = _info.getCostMid();
                break;
            case "back":
                costInPos = _info.getCostBack();
                break;
        }
    }

    float calculateCost(){
        return wordCount * costInPos * durationDays;
    }

    public String toString(){
        return super.toString() + "\nWord amount: " + wordCount + "\nPosition: " + position;
    }
}