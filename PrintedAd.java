class PrintedAd extends Advertisement {
    private int costFront;
    private int costMid;
    private int costBack;
    void setcostFront(int costFront) {
        this.costFront = costFront;
    }
    void setcostMid(int costMid) {
        this.costMid = costMid;
    }
    void setcostBack(int costBack) {
        this.costBack = costBack;
    }
    int getcostFront() {
        return costFront;
    }
    int getcostMid() {
        return costMid;
    }
    int getcostBack() {
        return costBack;
    }
    public String toString() {
        return super.toString() + "\n Cost for the first page for each word: " + costFront + "\n Cost for the middle pages for each word: " + costMid + "\n Cost for the last page for each word: " + costBack;
    }
}