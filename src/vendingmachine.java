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
    public void vendingmachine(){
      initializeCandiesInMatrix();
      ShowInstructions();
    }
  public static void initializeCandiesInMatrix(){
    candies[0] = new String[]{"Resses", "Doritos", "Gobstopper", "Hersheys Chochlate bar"};
    candies[1] = new String[]{"Staceys Chips", "Poptart","Skittels","Pretzels"};
    candies[2] = new String[]{"cheetos", "lays potato chips","Lays barbque chips", "Beef jurkey"};
    candies[3] = new String[]{"M&Ms", "peanut M&M's","Ruffles","Fritos"};
    candies[4] = new String[]{"Sun Chips", "Smart pop","Chocholate cookie","Sun flower seeds"};
  }
  public void ShowInstructions(){
    System.out.println("Welcome to our Vending machine! Please enter how much money that \nyou currently have we only accept dollers please no cents or \nyou will be ask you to reinput.");
    Boolean inputflag = true;
    while(inputflag) {
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
  public static void ShowCredits(){
    System.out.format("Your credits in this machine is $%d.00 \n", CustomerAmtOfDollars);
  }
    public static void main(String[] args) {
      vendingmachine run = new vendingmachine();
      run.vendingmachine();
      }

}
