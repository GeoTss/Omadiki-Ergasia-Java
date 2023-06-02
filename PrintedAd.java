class PrintedAd extends Advertisement{
    private int wordCount;
    private float costInPos;
    int position;

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

    float calculateCost(){
        return wordCount * costInPos * durationDays;
    }

    public String toString(){
        return super.toString() + "\nWord amount: " + wordCount + "\nPosition: " + position;
    }
}