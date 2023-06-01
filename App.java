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
    _typeList.insertType(new PrintedAdType("get rekt","1234", 3.14f, 6.28f, 9.42f));
    _typeList.insertType(new PrintedAdType("I am not a god, i am not a king, i am... worse", "1234", 3.03f, 8.18f, 10.02f));
    _typeList.insertType(new PrintedAdType("frontises smr", "1234", 15f, 60f, 28f));
    _typeList.insertType(new RadioTVAdType("o pappas o paxus", "5678", 1f, 2f, 3f, 4f));
    _typeList.insertType(new RadioTVAdType("paei o palios o xronos", "5678",2f, 4f, 6f, 8f));
    _typeList.insertType(new RadioTVAdType("ela re ti leei", "5678", 5f, 10f, 15f, 20f));
    _typeList.insertType(new WebAdType("Giannhs", "6969", 2f, 6f, 10f));
    _typeList.insertType(new WebAdType("Giannakhs", "8272", 29f, 43f, 10f));
    _typeList.insertType(new WebAdType("Giannaras", "2817", 8f, 11.880f, 9.11f));
    adList _adList = new adList();
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(0), 7548, "kys", 10, 100, "middle"));
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(1), 0420, "syk", 8, 105, "front"));
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(2), 8483, "i have commited several warcrimes", 5, 50, "back"));
    _adList.insertAd(new PrintedAd((PrintedAdType) _typeList.get(2), 7543, "no reason", 100, 2, "middle"));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(4), 2134, "i just had to do it", 10, "morning", 60));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(5), 1234, "i am tired of typing", 30, "midday", 10));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(5), 9898, "the mentor approves", 101, "evening", 610));
    _adList.insertAd(new RadioTVAd((RadioTVAdType) _typeList.get(4), 20921, "madclip leipeis", 1, "night", 17));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(8), 0210, "javac App.java", 10, true, 2));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(6), 8473, "java App", 11, false, 10));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(7), 1312, "App.java:44: error: constructor WebAd in class WebAd cannot be applied to given types;", 101, true, 22));
    _adList.insertAd(new WebAd((WebAdType) _typeList.get(8), 9584, "insert lenny face here", 165, false, 80));
    int answer = getResponse();
    while ((answer > 0) && (answer <= 9)) {
      Scanner scan = new Scanner(System.in);
      switch (answer) {
        case 1:
          System.out.println("Insert VAT and Name of the new Carrier");
          _carrierList.insertCarrier(new Carrier(scan.next(),scan.next()));
          break;
        case 2:
          System.out.println("Insert 1 for PrintedAd, 2 for RadioTVAd , 3 for WebAd");
          switch (scan.nextInt()) {
            case 1:
              System.out.println("Insert description, VAT of carrier, cost for the front page, cost for the middle page and cost for the back page.");
              _typeList.insertType(new PrintedAdType(scan.next(), scan.next(), scan.nextFloat(), scan.nextFloat(), scan.nextFloat()));
              break;
            case 2:
              System.out.println("Insert description, VAT of carrier, cost per second in the morning, cost per second in the midday, cost per second in the evening and cost per second in the night.");
              _typeList.insertType(new RadioTVAdType(scan.next(), scan.next(), scan.nextFloat(), scan.nextFloat(), scan.nextFloat(), scan.nextFloat()));
              break;
            case 3:
              System.out.println("Insert description, VAT of carrier, cost per day, cost per additional page and cost of auto show.");
              _typeList.insertType(new WebAdType(scan.next(), scan.next(), scan.nextFloat(), scan.nextFloat(), scan.nextFloat()));
              break;
          }
          break;
        case 3:
          System.out.println("Insert 1 for PrintedAd, 2 for RadioTVAd , 3 for WebAd");
          switch (scan.nextInt()) {
            case 1:

              break;
            case 2:
          
              break;
            case 3:

              break;
          }
          break;
        case 4:
          _adList.displayAdList();
          break;
        case 5:
        
          break;
        case 6:

          break;
        case 7:
          
          break;
        case 8:
          
          break;
        case 9:
          
          break;
      }
      scan.close();
      getResponse();
    }
  }
}
