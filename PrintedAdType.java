public class PrintedAdType extends AdvertisementType{
    protected int costFront;
    protected int costMid;
    protected int costBack;

    void setCostFront(int costFront) {
        this.costFront = costFront;
    }
    void setCostMid(int costMid) {
        this.costMid = costMid;
    }
    void setCostBack(int costBack) {
        this.costBack = costBack;
    }
    int getCostFront() {
        return costFront;
    }
    int getCostMid() {
        return costMid;
    }
    int getCostBack() {
        return costBack;
    }

    public String toString(){
        return super.toString() + "\nPrice per word in first page: " + costFront + "\nPrice per word in middle pages: " + costMid + "\nPrice per word in last page: " + costBack;
    }
}
