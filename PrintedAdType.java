import java.util.Scanner;

public class PrintedAdType extends AdvertisementType {
    // private static int currCode = 100;
    protected float costFront;
    protected float costMid;
    protected float costBack;

    PrintedAdType() {};

    PrintedAdType(String _description, Carrier _carrier, float _costFront, float _costMid, float _costBack) {
        code = currCode++;
        carrier_VAT = _carrier.getVAT();
        description = _description;

        costFront = _costFront;
        costMid = _costMid;
        costBack = _costBack;
    }

    PrintedAdType(String _description, String _carrier, float _costFront, float _costMid, float _costBack) {
        code = currCode++;
        carrier_VAT = _carrier;
        description = _description;

        costFront = _costFront;
        costMid = _costMid;
        costBack = _costBack;
    }

    PrintedAdType(String _description, String _carrier, Scanner scan) {
        code = currCode++;
        description = _description;
        carrier_VAT = _carrier;

        System.out.println("Insert cost of front page.");
        costFront = scan.nextFloat();
        System.out.println("Insert cost of the middle page.");
        costMid = scan.nextFloat();
        System.out.println("Insert cost of the back page");
        costBack = scan.nextFloat();
    }

    void setCostFront(float costFront) {
        this.costFront = costFront;
    }

    void setCostMid(float costMid) {
        this.costMid = costMid;
    }

    void setCostBack(float costBack) {
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

    public String toString() {
        return super.toString() + "\nPrice per word in first page: " + costFront + "\nPrice per word in middle pages: "
                + costMid + "\nPrice per word in last page: " + costBack;
    }

}
