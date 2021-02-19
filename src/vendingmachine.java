// Testing
import java.util.Scanner;
import java.util.InputMismatchException;
/*
 * @author Yadel Negash, Bryan Sullivan, Henok Ketsela
 *
 *  @date 02/13/2020
 */
public class vendingmachine {
    public static int CustomerAmtOfDollars = 0;
    public static Scanner input = new Scanner(System.in);
    public static String[][] candies = new String[5][4];
    public static double[][] candyPrices = new double[5][4];
    public static Integer AvailBal = null;

    public void vendingmachine() {
        initializeCandiesInMatrix();
        ShowInstructions();
        ShowVendingMachine();
        InitializeCandyCost();
        ShowCandies();
        transaction();

    }

    public static void initializeCandiesInMatrix() {
        candies[0] = new String[]{"Resses", "Doritos", "Gobstopper", "Hersheys Chochlate bar"};
        candies[1] = new String[]{"Staceys Chips", "Poptart", "Skittels", "Pretzels"};
        candies[2] = new String[]{"cheetos", "lays potato chips", "Lays barbque chips", "Beef jurkey"};
        candies[3] = new String[]{"M&Ms", "peanut M&M's", "Ruffles", "Fritos"};
        candies[4] = new String[]{"Sun Chips", "Smart pop", "Chocholate cookie", "Sun flower seeds"};
    }

    public void ShowInstructions() {
        System.out.println("Welcome to our Vending machine! Please enter how much money that \nyou currently have we only accept dollers please no cents or \nyou will be ask you to reinput.");
        Boolean inputflag = true;
        while (inputflag) {
            System.out.print("-> $");
            String tempCur = input.nextLine();
            try {
                AvailBal = Integer.parseInt(tempCur);
                int TransferCurrency = Integer.parseInt(tempCur);
                CustomerAmtOfDollars = TransferCurrency;
                inputflag = false;

            } catch (Exception e) {
                System.out.println("\033[0;31m" + "you did not enter a proper number of dollars don't insert coins please take your $" + tempCur + " back and try again" + "\033[0m");
            }
        }
        ShowCredits();
    }

    public static void ShowCredits() {
        System.out.format("Your credits in this machine is $%d.00 \n", CustomerAmtOfDollars);
    }
    public void ShowVendingMachine(){
        System.out.println("|--------------------|");
        System.out.println("| A1 | A2 | A3 | A4  |");
        System.out.println("| B1 | B2 | B3 | B4  |");
        System.out.println("| C1 | C2 | C3 | C4  |");
        System.out.println("| D1 | D2 | D3 | D4  |");
        System.out.println("| E1 | E2 | E3 | E4  |");
        System.out.println("|--------------------|");
        System.out.println("Buttons above are respective to the snack options below \n");

    }
    public static void InitializeCandyCost(){
        for(int i = 0; i< candyPrices.length; i++){
            for(int j = 0; j< candyPrices[0].length; j++){
                candyPrices[i][j] = random_Candies_Price();
            }
        }

    }
    public static double random_Candies_Price(){
        double temp = Math.random()*2;
        double sub = temp % 0.25;
        double total = temp - sub;
        if (total == 0){
            total = total + 1.0;
        }
        return total;
    }
    public static void ShowCandies(){
      for(int i = 0; i< candies.length; i++){
        for(int j = 0; j< candies[0].length; j++){
          System.out.print(candies[i][j]+ ", ");
        }
        System.out.println();
      }
    }

    public static void transaction(){
      System.out.println("\nPlease type in from the options above using the button options");
      System.out.print("Button Selected -> ");
      String buttonVal = input.nextLine();
      try {
        String column = buttonVal.substring(0, buttonVal.length()/2).toLowerCase();
        String row = buttonVal.substring(buttonVal.length()/2);
        int rowInt = Integer.parseInt(row);
        rowInt = rowInt - 1;
        int c1 = 99;
        switch(column){
          case ("a"): c1 = 0; break;
          case ("b"): c1 = 1; break;
          case ("c"): c1 = 2; break;
          case ("d"): c1 = 3; break;
          case ("e"): c1 = 4; break;
          default: System.out.print("\033[0;31m" + "Invalid input please try again." + "\033[0m");
          transaction();
          break;
        }
        System.out.println("You have selected " + candies[c1][rowInt] + " the price is $"+ candyPrices[c1][rowInt]);
        System.out.println("Do you confirm?");
        System.out.print("(Yes or No) -> ");
        String yesNo = input.nextLine();
        if (yesNo.equalsIgnoreCase("yes")){
          System.out.println( "Your change will be $" + (AvailBal - candyPrices[c1][rowInt]));
          System.out.println( "Please take your change and have a good rest of your day :)");
          //System.out.println("You have selected " + candies[c1][rowInt] + " the price is $"+ candyPrices[c1][rowInt]);
        } else if (yesNo.equalsIgnoreCase("no")) {
          System.out.println("Do you want to make another choice?");
          System.out.print("(Yes or No) -> ");
          String DDconf = input.nextLine();
          if (DDconf.equalsIgnoreCase("yes")){
            transaction();
          } else if ((DDconf.equalsIgnoreCase("no"))) {
            System.out.println("It's okay keep the money you could use it take your $" + AvailBal + " back.");
          } else {
            System.out.println("\033[0;31m" + "Invalid input please try again." + "\033[0m");
            transaction();
          }
        } else {
          System.out.println("\033[0;31m" + "invalid input please try again" + "\033[0m");
          transaction();
        }
      } catch (Exception e){
        System.out.println("\033[0;31m" + "Invalid input please try again." + "\033[0m");
        transaction();
      }
    }

    public static void main(String[] args) {
        vendingmachine run = new vendingmachine();
        run.vendingmachine();
    }
}
