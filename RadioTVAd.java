class RadioTVAd extends Advertisement{
    private String timeZone;
    private int durationSeconds;
    private float timeZoneCPS;

    RadioTVAd(RadioTVAdType info, String _timeZone, int _durationSeconds){
        timeZone = _timeZone;
        durationSeconds = _durationSeconds;

        switch(timeZone){
            case "morning":
                timeZoneCPS = info.getcpsMorning();
                break;
            case "midday":
                timeZoneCPS = info.getcpsMidday();
                break;
            case "evening":
                timeZoneCPS = info.getcpsEvening();
                break;
            case "night":
                timeZoneCPS = info.getcpsNight();
                break;
        }
    }

    float calculateCost(){
        return durationSeconds * timeZoneCPS * durationDays;
    }
}