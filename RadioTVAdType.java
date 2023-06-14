import java.util.Scanner;

class RadioTVAdType extends AdvertisementType {
    // private static int currCode = 100;
    protected float cpsMorning, cpsMidday, cpsEvening, cpsNight;

    RadioTVAdType() {}

    RadioTVAdType(String _description, Carrier _carrier, float _cpsMorning, float _cpsMidday, float _cpsEvening,
            float _cpsNight) {
        code = currCode++;
        description = _description;
        carrier_VAT = _carrier.getVAT();

        cpsMorning = _cpsMorning;
        cpsMidday = _cpsMidday;
        cpsEvening = _cpsEvening;
        cpsNight = _cpsNight;
    }

    RadioTVAdType(String _description, String _carrier, float _cpsMorning, float _cpsMidday, float _cpsEvening,
            float _cpsNight) {
        code = currCode++;
        description = _description;
        carrier_VAT = _carrier;

        cpsMorning = _cpsMorning;
        cpsMidday = _cpsMidday;
        cpsEvening = _cpsEvening;
        cpsNight = _cpsNight;
    }

    RadioTVAdType(String _description, String _carrier, Scanner scan) {
        code = currCode++;
        description = _description;
        carrier_VAT = _carrier;

        System.out.println("Insert cost per second in the morning.");
        cpsMorning = scan.nextFloat();
        System.out.println("Insert cost per second in the midday.");
        cpsMidday = scan.nextFloat();
        System.out.println("Insert cost per second in the evening.");
        cpsEvening = scan.nextFloat();
        System.out.println("Insert cost per second in the night.");
        cpsNight = scan.nextFloat();
    }

    void setcpsMorning(float cpsMorning) {
        this.cpsMorning = cpsMorning;
    }

    void setcpsMidday(float cpsMidday) {
        this.cpsMidday = cpsMidday;
    }

    void setcpsEvening(float cpsEvening) {
        this.cpsEvening = cpsEvening;
    }

    void setcpsNight(float cpsNight) {
        this.cpsNight = cpsNight;
    }

    float getcpsMorning() {
        return cpsMorning;
    }

    float getcpsMidday() {
        return cpsMidday;
    }

    float getcpsEvening() {
        return cpsEvening;
    }

    float getcpsNight() {
        return cpsNight;
    }

    public String toString() {
        return super.toString() + "\nPrice per second - Morning zone: " + cpsMorning
                + "\nPrice per second - Midday zone: " + cpsMidday + "\nPrice per second - Evening zone: " + cpsEvening
                + "\nPrice per second - Night zone: " + cpsNight;
    }
}
