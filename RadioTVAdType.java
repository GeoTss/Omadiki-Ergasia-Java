class RadioTVAdType extends AdvertisementType{
    protected int cpsMorning;
    protected int cpsMidday;
    protected int cpsEvening;
    protected int cpsNight;

    void setcpsMorning(int cpsMorning) {
        this.cpsMorning = cpsMorning;
    }
    void setcpsMidday(int cpsMidday) {
        this.cpsMidday = cpsMidday;
    }
    void setcpsEvening(int cpsEvening) {
        this.cpsEvening = cpsEvening;
    }
    void setcpsNight(int cpsNight) {
        this.cpsNight = cpsNight;
    }
    int getcpsMorning() {
        return cpsMorning;
    }
    int getcpsMidday() {
        return cpsMidday;
    }
    int getcpsEvening() {
        return cpsEvening;
    }
    int getcpsNight() {
        return cpsNight;
    }

    public String toString(){
        return super.toString() + "\nPrice per second - Morning zone: " + cpsMorning + "\nPrice per second - Midday zone: " + cpsMidday + "\nPrice per second - Evening zone: " + cpsEvening + "\nPrice per second - Night zone: " + cpsNight;
    }
}
