class WebAd {
    private int cpdLoad;
    private int CostPerPage;
    void setcpdLoad(int cpdLoad) {
        this.cpdLoad = cpdLoad;
    }
    void setCostPerPage(int CostPerPage) {
        this.CostPerPage = CostPerPage;
    }
    int getcpdLoad() {
        return cpdLoad;
    }
    int getCostPerPage() {
        return CostPerPage;
    }
    public String toString() {
        return super.toString() + "\nCost per day when the website is loaded: " + cpdLoad + "\nCost for each additional page for display on more than one page: " + CostPerPage;
    }
}