public class Bond extends Investment_G2_1084505
{
    //Attribute specific to Bonds:
    private String issuer;

    //Default & overloaded constructors:
    Bond(){}
    Bond(String name, String symbol, int quantity, double purchasePrice, double marketValue, String issuer)
    {
        super( name,  symbol,  quantity,  purchasePrice,  marketValue);
        this.issuer = issuer;
    }

    //Setter & Getter:
    public void setIssuer(String issuer)
    {
        this.issuer = issuer;
    }

    public String getIssuer()
    {
        return this.issuer;
    }

    @Override
    public void DisplayDetails() //Modifying the method to display the variables specific to Bonds
    {
        super.DisplayDetails(); //Invoking DisplayDetails() from the parent class
        System.out.println("6. Issuer: " + issuer);
    }
}
