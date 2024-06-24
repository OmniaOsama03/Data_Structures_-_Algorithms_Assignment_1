
import java.io.File;
import java.io.IOException;
import java.util.*;
public class FinanceCorp_MS
{
    // v Declaring 4 sample portfolios for different customers. Made static to ensure accessibility across methods
    static ArrayList<Investment> OmniaInvestments;
    static ArrayList<Investment> AalaInvestments;
    static ArrayList<Investment> ArwaInvestments;
    static ArrayList<Investment> OsamaInvestments;

    static Boolean[] InvestmentsAdded = {false, false, false, false};
    // ^To ensure that a bulk addition of investments can be done once per customer. 4 elements for 4 sample customers.

    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);

        //Creating sample stocks, bonds, and funds through polymorphism
        Investment stock1 = new Stock("Microsoft Corporation", "MSFT", 50, 7500, 6500, "Technology", 2.5);
        Investment bond1 = new Bond("U.S. Treasury Bond", "US-TBond", 10, 12000, 10000,"U.S. Department of Treasury");
        Investment fund1 = new MutualFund("VTSM Index Fund", "VTSAX", 200, 40000, 38000, "Vanguard Group");
        Investment stock2 = new Stock("Alphabel Inc.", "GOOGL", 60, 75000, 90000, "Technology", 0.85);
        Investment bond2 = new Bond("Corporate Bond- XYZ Corp.", "XYZ- Bond", 15, 18750, 17000, "XYZ Corporation");
        Investment fund2 = new MutualFund("Fidelity Contrafund", "FCNTX", 150, 29500, 30750, "Fidelity Investments");

        //Initializing the 4 portfolios & adding investments to each
        OmniaInvestments = new ArrayList<>();
        OmniaInvestments.add(stock1);
        OmniaInvestments.add(fund2);
        OmniaInvestments.add(stock2);

        AalaInvestments = new ArrayList<>();
        AalaInvestments.add(stock1);
        AalaInvestments.add(fund2);
        AalaInvestments.add(bond1);

        ArwaInvestments = new ArrayList<>();
        ArwaInvestments.add(fund1);
        ArwaInvestments.add(stock2);

        OsamaInvestments = new ArrayList<>();
        OsamaInvestments.add(bond2);
        OsamaInvestments.add(bond1);
        OsamaInvestments.add(fund1);



        int userChoice;
        do {
            DislayMenu();
            userChoice = UserMenuChoice();
            switch (userChoice) {
                case 1: AddInvestmentToPortfolio(); break; 	// 1-	Add a new investment to a portfolio.
                case 2: UpdateInvestmentDetails(); break;	// 2-	Update investment details (quantity, purchase price, ...).
                case 3: AddInvestmentsFromFile(); break;	// 3-	Bulk addition of investments from a file.
                case 4: ListAllInvestments(); break;		// 4-	List all investments in the portfolio of a selected customer.
                case 5: CalculatePortfolioValue(); break;				// 5-	Calculate the total portfolio value for a selected customer.

                default:  System.out.println("Thank you for using CSC301's Investment Portfolio Management System, Have a Good Bye.");
            }
        }while (userChoice != 0);


    }//End of main method


    public static void DislayMenu() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Investment Portfolio Management System (FinanceCorp, Spring2024)");
        System.out.println("---------------------------------------------------------");
        System.out.println("1- Add a new investment to a portfolio.");
        System.out.println("2- Update investment details (quantity, purchase price, ...).");
        System.out.println("3- Bulk addition of investments from a file.");
        System.out.println("4- List all investments in the portfolio of a selected customer.");
        System.out.println("5- Calculate the total portfolio value for a selected customer.");
        System.out.println("0- Quit");
        System.out.println("---------------------------------------------------------");
    }

    public static int UserMenuChoice(){
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Your choice (0, 1, 2, 3, 4, 5):");
            choice = input.nextInt();
        } while(choice > 5);
        return choice;
    }

    public static void AddInvestmentToPortfolio()
    {
        Scanner input = new Scanner(System.in);

        //Listing the customers with portfolios & allowing 1 to be chosen
        System.out.println("\n1. Omnia Osama \n2. Aala Osama \n3. Arwa Osama \n4. Osama Mohamed");
        System.out.println("To which customer would u like to add an investment? ");
        int choice = input.nextInt();

        //The parameter of AddNewInvestment() is set based on the chosen customer.
        switch (choice)
        {
            case 1: AddNewInvestment(OmniaInvestments); break;
            case 2: AddNewInvestment(AalaInvestments); break;
            case 3: AddNewInvestment(ArwaInvestments);break;
            case 4: AddNewInvestment(OsamaInvestments);break;
            default:  System.out.println("Invalid input");
        }

    }

    public static void UpdateInvestmentDetails()
    {
        Scanner input = new Scanner(System.in);

        //Listing the customers with portfolios & allowing 1 to be chosen
        System.out.println("\n1. Omnia Osama \n2. Aala Osama \n3. Arwa Osama \n4. Osama Mohamed");
        System.out.println("To which customer would you like to update an investment detail? ");
        int choice = input.nextInt();

        //The parameter of UpdateDetail() is set based on the chosen customer.
        switch (choice) {
            case 1: UpdateDetail(OmniaInvestments); break;
            case 2: UpdateDetail(AalaInvestments); break;
            case 3: UpdateDetail(ArwaInvestments);break;
            case 4: UpdateDetail(OsamaInvestments);break;
            default:  System.out.println("Invalid input");
        }
    }

    public static void AddInvestmentsFromFile() throws IOException
    {

        Scanner input = new Scanner(System.in);

        //Listing the customers with portfolios & allowing 1 to be chosen
        System.out.println("\n1. Omnia Osama \n2. Aala Osama \n3. Arwa Osama \n4. Osama Mohamed");
        System.out.println("To which customer would you like to bulk investments to? ");
        int choice = input.nextInt();

        try {  //Encased in a 'try' due to a possible IOException occurring
            switch (choice) {
                case 1:
                    if(InvestmentsAdded[0] == false)
                    {
                        AddBulkInvestments(OmniaInvestments);
                        InvestmentsAdded[0] = true;
                    }
                    else
                        System.out.println("The investments were already added:(");
                    break;
                case 2:
                    if(InvestmentsAdded[1] == false)
                    {
                        AddBulkInvestments(AalaInvestments);
                        InvestmentsAdded[1] = true;
                    }
                    else
                         System.out.println("The investments were already added:(");
                    break;
                case 3:
                    if(InvestmentsAdded[2] == false)
                    {
                        AddBulkInvestments(ArwaInvestments);
                        InvestmentsAdded[2] = true;
                    }
                    else
                        System.out.println("The investments were already added:(");
                    break;
                case 4:
                    if(InvestmentsAdded[3] == false)
                    {
                        AddBulkInvestments(OsamaInvestments);
                        InvestmentsAdded[3] = true;
                    }
                    else
                        System.out.println("The investments were already added:(");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void ListAllInvestments()
    {
        Scanner input = new Scanner(System.in);

        //Listing the customers with portfolios & allowing 1 to be chosen
        System.out.println("\n1. Omnia Osama \n2. Aala Osama \n3. Arwa Osama \n4. Osama Mohamed");
        System.out.println("List the investments of customer__ ");
        int choice = input.nextInt();

        //The parameter of DisplayAllInvestments() is set based on the chosen customer.
        switch (choice) {
            case 1: DisplayAllInvestments(OmniaInvestments); break;
            case 2: DisplayAllInvestments(AalaInvestments); break;
            case 3: DisplayAllInvestments(ArwaInvestments);break;
            case 4: DisplayAllInvestments(OsamaInvestments);break;
            default:  System.out.println("Invalid input");
        }
    }

    public static void CalculatePortfolioValue()
    {
        Scanner input = new Scanner(System.in);

        //Listing the customers with portfolios & allowing 1 to be chosen
        System.out.println("\n1. Omnia Osama \n2. Aala Osama \n3. Arwa Osama \n4. Osama Mohamed");
        System.out.println("To which customer would you like to calculate portfolio value? ");
        int choice = input.nextInt();

        //The parameter of ComputeTotalValue() is set based on the chosen customer.
        switch (choice) {
            case 1: ComputeTotalValue(OmniaInvestments); break;
            case 2: ComputeTotalValue(AalaInvestments); break;
            case 3: ComputeTotalValue(ArwaInvestments);break;
            case 4: ComputeTotalValue(OsamaInvestments);break;
            default:  System.out.println("Invalid input");
        }
    }

    public static void AddNewInvestment(ArrayList<Investment> portfolio)
    {
        Scanner input = new Scanner(System.in);

        //Filling in the attributes required for an investment:
        System.out.print("Enter the investment's name: ");
        String name = input.next();

        System.out.print("Enter the investment's symbol: ");
        String symbol = input.next();

        System.out.print("Enter the investment's quantity: ");
        int quantity = input.nextInt();

        System.out.print("Enter the investment's purchase price: ");
        double price = input.nextDouble();

        System.out.print("Enter the investment's market value: ");
        double value = input.nextDouble();

        System.out.println("\nThe new investment is a \n1. Stock \n2.Bond \n3.Mutual Fund");
        System.out.print("Choice: ");
        int choice = input.nextInt();

        //Checking the type of investment chosen & filling in the type-specific attributes
        switch (choice) {
            case 1:
                System.out.print("Enter stock sector: ");
                String sector = input.next();

                System.out.print("Enter the dividend yield: ");
                double divYield = input.nextDouble();

                //Adding a new stock to the portfolio.
                portfolio.add(new Stock(name, symbol, quantity, price, value, sector, divYield));
                System.out.println("\nSuccessfully added the stock! ");
                break;

            case 2:
                System.out.print("Enter the bond issuer: ");
                String issuer = input.next();

                //Adding a new bond to the portfolio.
                portfolio.add(new Bond(name, symbol, quantity, price, value, issuer));
                System.out.println("\nSuccessfully added bond! ");
                break;

            case 3:
                System.out.print("Enter the fund manager: ");
                String manager = input.next();

                //Adding a new fund to the portfolio.
                portfolio.add(new MutualFund(name, symbol, quantity, price, value, manager));
                System.out.println("\nSuccessfully added the fund! ");
                break;

            default:  System.out.println("Invalid input");
        }
    } //End of method AddNewInvestment

    public static void UpdateDetail(ArrayList<Investment> portfolio)
    {
        Scanner input = new Scanner(System.in);

        int counter = 0; //Solely to number the investments as they get listed
        for(Investment investment : portfolio)
        {
            System.out.print(counter + " ");
            System.out.println(investment.getName()); //Printing the names of each investment in the portfolio
            counter++;
        }
        System.out.print("Pick an investment to update: ");
        int index = input.nextInt(); //Index of the chosen investment in the list.

        portfolio.get(index).DisplayDetails(); //Displaying the details of the chosen investment
        System.out.println("Which detail would u like to update? ");
        int choice = input.nextInt();
        // ^ P.S The details are already numbered within DisplayDetails()

        // v Based on the chosen detail, the new value is set
        switch (choice) {
            case 1:
                System.out.print("New investment name: ");
                String name = input.next();

                portfolio.get(index).setName(name); //Using a setter to update the name attribute
                System.out.println("\n Name successfully updated to " + name);
                break;
            case 2:
                System.out.print("New investment symbol: ");
                String symbol = input.next();

                portfolio.get(index).setSymbol(symbol); //Using a setter to update the symbol attribute
                System.out.println("\n Symbol successfully updated to " + symbol);
                break;
            case 3:
                System.out.print("New quantity: ");
                int quantity = input.nextInt();

                portfolio.get(index).setQuantity(quantity); //Using a setter to update the quantity attribute
                System.out.println("\n Quantity successfully updated to " + quantity);
                break;
            case 4:
                System.out.print("New purchase price: ");
                double price = input.nextDouble();

                portfolio.get(index).setPurchasePrice(price); //Using a setter to update the price attribute
                System.out.println("\n Price successfully updated to " + price);
                break;
            case 5:
                System.out.print("New market value: ");
                double value = input.nextDouble();

                portfolio.get(index).setMarketValue(value); //Using a setter to update the value attribute
                System.out.println("\n Market Value successfully updated to " + value);
            case 6:
                /*The 6th attribute listed could belong to a stock, bond, or fund. We'll check for the type of current
                  investment & update the respective variable */
                if(portfolio.get(index) instanceof Stock)
                {
                    System.out.print("New sector: ");
                    String sector = input.next();

                    ((Stock) portfolio.get(index)).setSector(sector); //Explicit casting to Stocks to access .setSector()
                    System.out.println("\n Sector successfully updated to " + sector);
                }
                if(portfolio.get(index) instanceof Bond)
                {
                    System.out.print("New issuer: ");
                    String issuer = input.next();

                    ((Bond) portfolio.get(index)).setIssuer(issuer); //Explicit casting to Bond to access .setIssuer()
                    System.out.println("\n Bond Issuer successfully updated to " + issuer);
                }
                if(portfolio.get(index) instanceof MutualFund)
                {
                    System.out.print("New fund manager: ");
                    String manager = input.next();

                    ((MutualFund) portfolio.get(index)).setFundManager(manager); //Explicit casting to MutualFunds to access.setFundManager()
                    System.out.println("\n Fund manager successfully updated to " + manager);
                }
                break;
            case 7:
                /*If a 7th attribute is listed, then it only belongs to Stock. The required attribute is filled and the
                current investment is cast to Stocks to access setDivYield()
                */

                if(portfolio.get(index) instanceof Stock)
                {
                    System.out.print("New dividend yield: ");
                    double divYield = input.nextDouble();

                    ((Stock) portfolio.get(index)).setDivYield(divYield);
                    System.out.println("\n Dividend yield successfully updated to " + divYield);
                }
                break;
            default:  System.out.println("Invalid input");
        }
    }//End of method UpdateDetail

    public static void AddBulkInvestments(ArrayList<Investment> portfolio) throws IOException
    {
        //v creating a scanner to read from the file.
        try (Scanner scanner = new Scanner(new File("C:\\Users\\maado\\IdeaProjects\\CSC301 Assignment 1\\src\\Investments.txt")))
        {
            while (scanner.hasNextLine()) { //To check if the file has a subsequent line
                String line = scanner.nextLine(); //Storing the current line in a string.
                String[] investment = line.split(" "); //Splitting the line based on the spaces and storing it in an array

                //Storing each element in a respective variable
                String name = investment[1];
                String symbol = investment[2];
                int quantity = Integer.parseInt(investment[3]);
                double price = Double.parseDouble(investment[4]);
                double value = Double.parseDouble(investment[5]);

                /*The first column in the file specifies the type of investment, stored in the array as element 0. The
                following if statements check for the type, store the info accordingly, and add the appropriate type of
                investment to the portfolio */

                if(investment[0].equalsIgnoreCase("Stock"))
                {
                    String sector = investment[6];
                    Double divYield = Double.parseDouble(investment[7]);

                    portfolio.add(new Stock(name, symbol, quantity, price, value, sector, divYield));
                }
                else if(investment[0].equalsIgnoreCase("Bond"))
                {
                    String issuer = investment[6];

                    portfolio.add(new Bond(name, symbol, quantity, price, value, issuer));
                }
                else if(investment[0].equalsIgnoreCase("Fund"))
                {
                    String manager = investment[6];

                    portfolio.add(new MutualFund(name, symbol, quantity, price, value, manager));
                }
            }
            System.out.println("Investments successfully added!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method AddBulkInvestments

    public static void DisplayAllInvestments(ArrayList<Investment> portfolio)
    {
        //Loops through the portfolio ArrayList, and displays each investment's details
        int count = 1; //Solely to number all investments
        for(Investment investment : portfolio)
        {
            System.out.println(" \n\nINVESTMENT " + count);
            investment.DisplayDetails();
            count++;
        }
    }

    public static void ComputeTotalValue(ArrayList<Investment> portfolio)
    {
        //Loops through the portfolio, invokes method ComputeValue() for each, and adds it to variable 'value'
        double value = 0;
        for(Investment investment : portfolio)
        {
            value += investment.ComputeValue();
        }
        System.out.println("The value of this portfolio is " + value);
    }


}
