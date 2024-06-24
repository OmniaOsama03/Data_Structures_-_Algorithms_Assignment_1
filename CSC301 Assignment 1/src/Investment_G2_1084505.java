public abstract class Investment_G2_1084505 implements Investable
{
    //The common attributes of all investments:
    private String name;
    private String symbol;
    private int quantity;
    private double purchasePrice;
    private double marketValue;

    //Default & Overloaded constructors:
    Investment_G2_1084505(){}
    Investment_G2_1084505(String name, String symbol, int quantity, double purchasePrice, double marketValue)
    {
        this.name = name;
        this.symbol = symbol;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.marketValue = marketValue;
    }

    //Setters:
    public void setName( String name)
    {
        this.name = name;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setPurchasePrice(double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public void setMarketValue(double marketValue)
    {
        this.marketValue = marketValue;
    }

    public String getName()
    {
        return this.name;
    }

    //Getters:
    public String getSymbol() { return this.symbol;}

    public int getQuantity()
    {
        return this.quantity;
    }

    public double getPurchasePrice()
    {
        return this.purchasePrice;
    }

    public double getMarketValue()
    {
        return this.marketValue;
    }


    //Implementing the methods in the Investable interface

    public double ComputeValue()
    {
        return quantity * marketValue;
    }

    public void DisplayDetails()
    {
        System.out.println("\n1. Name: " + name + "\n2. Symbol: " + symbol + "\n3. Quantity: " + quantity + "\n4. Purchase Price: " + purchasePrice + "\n5. Market Value: " + marketValue);
    }
}
