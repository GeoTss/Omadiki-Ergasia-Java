class RadioTVAd extends Advertisement{
    private String timeZone;
    private int durationSeconds;
    private float timeZoneCPS;

    RadioTVAd(RadioTVAdType _info, Product _product, String _reason, int _durationDays, String _timeZone, int _durationSeconds){
        typeCode = _info.getCode();
        productCode = _product.getCode();
        reason = _reason;
        durationDays = _durationDays;
        VAT = _info.getCarrierVAT();

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

    RadioTVAd(RadioTVAdType _info, String _product, String _reason, int _durationDays, String _timeZone, int _durationSeconds){
        typeCode = _info.getCode();
        productCode = _product;
        reason = _reason;
        durationDays = _durationDays;
        VAT = _info.getCarrierVAT();

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