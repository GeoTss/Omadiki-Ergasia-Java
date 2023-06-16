class RadioTVAd extends Advertisement{
    private int timeZone;
    private int durationSeconds;
    private float timeZoneCPS;

    RadioTVAd() {}

    RadioTVAd(RadioTVAdType _info, Product _product, String _reason, int _durationDays, int _timeZone, int _durationSeconds){
        typeCode = _info.getCode();
        productCode = _product.getCode();
        reason = _reason;
        durationDays = _durationDays;
        // VAT = _info.getCarrierVAT();

        timeZone = _timeZone;
        durationSeconds = _durationSeconds;

        switch(timeZone){
            case 0:
                timeZoneCPS = _info.getcpsMorning();
                break;
            case 1:
                timeZoneCPS = _info.getcpsMidday();
                break;
            case 2:
                timeZoneCPS = _info.getcpsEvening();
                break;
            case 3:
                timeZoneCPS = _info.getcpsNight();
                break;
        }
    }

    RadioTVAd(RadioTVAdType _info, int _product, String _reason, int _durationDays, int _timeZone, int _durationSeconds){
        typeCode = _info.getCode();
        productCode = _product;
        reason = _reason;
        durationDays = _durationDays;
        // VAT = _info.getCarrierVAT();

        timeZone = _timeZone;
        durationSeconds = _durationSeconds;

        switch(timeZone){
            case 0:
                timeZoneCPS = _info.getcpsMorning();
                break;
            case 1:
                timeZoneCPS = _info.getcpsMidday();
                break;
            case 2:
                timeZoneCPS = _info.getcpsEvening();
                break;
            case 3:
                timeZoneCPS = _info.getcpsNight();
                break;
        }
    }

    void construct(AdvertisementType _info){
        switch(timeZone){
            case 0:
                timeZoneCPS = ((RadioTVAdType)_info).getcpsMorning();
                break;
            case 1:
                timeZoneCPS = ((RadioTVAdType)_info).getcpsMidday();
                break;
            case 2:
                timeZoneCPS = ((RadioTVAdType)_info).getcpsEvening();
                break;
            case 3:
                timeZoneCPS = ((RadioTVAdType)_info).getcpsNight();
                break;
        }
    }

    void setProductCode(int _product) {
            productCode = _product;
        }
    
    void setDurationDays(int _durationDays) {
        durationDays = _durationDays;
    }

    void setTimeZone(int _timeZone) {
        timeZone = _timeZone;
    }

    void setDurationSeconds(int _durationSeconds) {
        durationSeconds = _durationSeconds;
    }

    void showCostFormula(){
        System.out.println("durationInSecondsForAD * timeZoneCostPerSecond * durationInDays = " + durationSeconds + " * " + timeZoneCPS + " * " + durationDays + " = " + (durationSeconds * timeZoneCPS * durationDays));
    }
    float calculateCost(){
        showCostFormula();
        return durationSeconds * timeZoneCPS * durationDays;
    }

    String genFileFormat(){
        return ("TYPE RADIO\n" + super.genFileFormat() + "\nDURATION_SECONDS " + durationSeconds + "\nTIMEZONE " + timeZone).replaceAll("(?m)^", "\t\t");
    }

    public String toStirng(){
        return super.toString() + "\nAdvertisement duration in seconds: " + durationSeconds + "\nTime zone: " + timeZone;
    }
}