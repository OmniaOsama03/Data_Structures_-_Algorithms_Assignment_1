public class MutualFund extends Investment
{
    //The attributes specific to Funds
    private String fundManager;

    //Default & overloaded constructors
    MutualFund(){}
    MutualFund(String name, String symbol, int quantity, double purchasePrice, double marketValue, String fundManager)
    {
        super( name,  symbol,  quantity,  purchasePrice,  marketValue);
        this.fundManager = fundManager;
    }

    //Setter & getter:
    public void setFundManager(String fundManager)
    {
        this.fundManager = fundManager;
    }
    public String getFundManager()
    {
        return this.fundManager;
    }

    @Override
    public void DisplayDetails() //Modifying the method to display the variables specific to Funds
    {
        super.DisplayDetails(); //Invoking DisplayDetails() from the parent class
        System.out.println("6. Fund Manager: " + fundManager);
    }

}
