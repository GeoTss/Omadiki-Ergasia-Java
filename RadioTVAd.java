class RadioTVAd extends Advertisement{
    private String timeZone;
    private int durationSeconds;
    private float timeZoneCPS;

    RadioTVAd(RadioTVAdType _info, int _productCode, String _reason, int _durationDays, String _timeZone, int _durationSeconds){
        typeCode = _info.getCode();
        productCode = _productCode;
        reason = _reason;
        durationDays = _durationDays;
        
        timeZone = _timeZone;
        durationSeconds = _durationSeconds;

        switch(timeZone){
            case "morning":
                timeZoneCPS = _info.getcpsMorning();
                break;
            case "midday":
                timeZoneCPS = _info.getcpsMidday();
                break;
            case "evening":
                timeZoneCPS = _info.getcpsEvening();
                break;
            case "night":
                timeZoneCPS = _info.getcpsNight();
                break;
        }
    }

    float calculateCost(){
        return durationSeconds * timeZoneCPS * durationDays;
    }

    public String toStirng(){
        return super.toString() + "\nAdvertisement duration in seconds: " + durationSeconds + "\nTime zone: " + timeZone;
    }
}