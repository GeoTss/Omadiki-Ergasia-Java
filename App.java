import java.util.Scanner;

public class App {
  public static void greetUser() {
    System.out.println("Type 1 to add a new carrier.\nType 2 to add a new Advertisement type.\nType 3 to add a new Advertisement.\nType 4 to display Advertisements.\nType 5 to display Advertisements of a certain Carrier.\nType 6 to evaluate the cost of all the Advertisements of a certain carrier.\nType 7 to display the count of Advertisements per Product.\nType 8 to evaluate the cost of the Advertisement of a single Product.\nType 9 to display the cost of the Advertisements per Product.\nType 0 to exit the application.");
  }
  public static int getResponse() {
    greetUser();
    Scanner scan = new Scanner(System.in);
    int answer = scan.nextInt();
    scan.close();
    return answer;
  }
  public static void main(String[] args) {
    carrierList _carrierList = new carrierList();
    _carrierList.insertCarrier(new Carrier("1234", "Giwrgos"));
    _carrierList.insertCarrier(new Carrier("5678", "Vasilis"));
    _carrierList.insertCarrier(new Carrier("1312", "Filippos"));
    _carrierList.insertCarrier(new Carrier("6969", "Antonis"));
    productList _productList = new productList();
    _productList.insertProduct(new Product("CoDe", "DeScRiPtIoN", "1234"));
    _productList.insertProduct(new Product("Hello", "IDK", "1212"));
    _productList.insertProduct(new Product("World", "null", "2069"));
    _productList.insertProduct(new Product("ARDVARG", "Pays off", "1821"));
    typeList _typeList = new typeList();
    _typeList.insertType(new PrintedAdType("get rekt", 3.14f, 6.28f, 9.42f));
    _typeList.insertType(new PrintedAdType("I am not a god, i am not a king, i am... worse", 3.03f, 8.18f, 10.02f));
    _typeList.insertType(new PrintedAdType("frontises smr", 15f, 60f, 28f));
    _typeList.insertType(new RadioTVAdType("o pappas o paxus", 1f, 2f, 3f, 4f));
    _typeList.insertType(new RadioTVAdType("paei o palios o xronos", 2f, 4f, 6f, 8f));
    _typeList.insertType(new RadioTVAdType("ela re ti leei", 5f, 10f, 15f, 20f));
    _typeList.insertType(new WebAdType("Giannhs", 2f, 6f, 10f));
    _typeList.insertType(new WebAdType("Giannakhs", 29f, 43f, 10f));
    _typeList.insertType(new WebAdType("Giannaras", 8f, 11.880f, 9.11f));
    adList _AdList = new adList();
    _AdList.insertAd(new PrintedAd());
    _AdList.insertAd(new PrintedAd());
    _AdList.insertAd(new PrintedAd());
    _AdList.insertAd(new PrintedAd());
    _AdList.insertAd(new RadioTVAd());
    _AdList.insertAd(new RadioTVAd());
    _AdList.insertAd(new RadioTVAd());
    _AdList.insertAd(new RadioTVAd());
    _AdList.insertAd(new WebAd());
    _AdList.insertAd(new WebAd());
    _AdList.insertAd(new WebAd());
    _AdList.insertAd(new WebAd());
    int answer = getResponse();
    while ((answer > 0) && (answer <= 9)) {
      Scanner scan = new Scanner(System.in);
      switch (answer) {
        case 1:
          System.out.println("Insert VAT and Name of the new Carrier");
          _carrierList.insertCarrier(new Carrier(scan.next(),scan.next()));
        case 2:
          System.out.println();
        case 3:

        case 4:
        
        case 5:
        
        case 6:

        case 7:
        
        case 8:

        case 9:
      }
      scan.close();
      getResponse();
    }

  
  
  
  
  
  }
}
