class RadioTVAd {
    private int cpsMorning;
    private int cpsMidday;
    private int cpsEvening;
    private int cpsNight;
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
    public String toString() {
        return super.toString() + "\nCost per second during morning hours: " + cpsMorning + "\nCost per second during midday hours: " + cpsMidday + "\nCost per second during evening hours: " + cpsEvening + "\nCost per second during night hours: " + cpsNight;
    }
}
