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
