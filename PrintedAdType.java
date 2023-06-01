public class PrintedAdType extends AdvertisementType{
    private static int currCode = 100;
    protected float costFront;
    protected float costMid;
    protected float costBack;

    PrintedAdType(String _description, String _carrier_VAT, float _costFront, float _costMid, float _costBack){
        code = currCode++;
        carrier_VAT = _carrier_VAT;
        description = _description;

        costFront = _costFront;
        costMid = _costMid;
        costBack = _costBack;
    }

    void setCostFront(int costFront) {
        this.costFront = costFront;
    }
    void setCostMid(int costMid) {
        this.costMid = costMid;
    }
    void setCostBack(int costBack) {
        this.costBack = costBack;
    }
    float getCostFront() {
        return costFront;
    }
    float getCostMid() {
        return costMid;
    }
    float getCostBack() {
        return costBack;
    }

    public String toString(){
        return super.toString() + "\nPrice per word in first page: " + costFront + "\nPrice per word in middle pages: " + costMid + "\nPrice per word in last page: " + costBack;
    }
}
