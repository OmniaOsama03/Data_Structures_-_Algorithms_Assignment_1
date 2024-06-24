public class Stock_G2_1084505 extends Investment_G2_1084505
{
    //The attributes specific to Stocks:
    private String sector;
    private double divYield;

    //Default & overloaded constructors
    Stock_G2_1084505(){}
    Stock_G2_1084505(String name, String symbol, int quantity, double purchasePrice, double marketValue, String sector, double divYield)
    {
        super( name,  symbol,  quantity,  purchasePrice,  marketValue);

        this.sector = sector;
        this.divYield = divYield;
    }

    //Setters:
    public void setSector(String sector)
    {
        this.sector = sector;
    }
    public void setDivYield(double divYield)
    {
        this.divYield = divYield;
    }

    //Getters
    public String getSector()
    {
        return this.sector;
    }
    public double getDivYield()
    {
        return this.divYield;
    }


    @Override
    public double ComputeValue() //Modifying the calculation to factor in the dividend yield
    {
        return ((divYield/100) * super.getMarketValue());
    }

    @Override
    public void DisplayDetails() //Modifying the method to display the variables specific to Stocks
    {
        super.DisplayDetails(); //Invoking DisplayDetails() from the parent class
        System.out.println("6. Sector: " + sector + "\n7. Dividend Yield: " + divYield);

    }
}
