class PrintedAd extends Advertisement{
    private int wordCount;
    private float costInPos;
    String position;

    PrintedAd(PrintedAdType _info, Product _product, String _reason, int _durationDays, int _wordCount, String _position){
        typeCode = _info.getCode();
        productCode = _product.getCode();
        reason = _reason;
        durationDays = _durationDays;
        VAT = _info.carrier_VAT;

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

    PrintedAd(PrintedAdType _info, String _product, String _reason, int _durationDays, int _wordCount, String _position){
        typeCode = _info.getCode();
        productCode = _product;
        reason = _reason;
        durationDays = _durationDays;
        VAT = _info.carrier_VAT;

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