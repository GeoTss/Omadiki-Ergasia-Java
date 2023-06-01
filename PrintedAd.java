class PrintedAd extends Advertisement{
    private int wordCount;
    private float costInPos;
    String position;

    PrintedAd(PrintedAdType info, int _wordCount, String _position){
        wordCount = _wordCount;
        position = _position;

        switch(position){
            case "front":
                costInPos = info.getCostFront();
                break;
            case "middle":
                costInPos = info.getCostMid();
                break;
            case "back":
                costInPos = info.getCostBack();
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