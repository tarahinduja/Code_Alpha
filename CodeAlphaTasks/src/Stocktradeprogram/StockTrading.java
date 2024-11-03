package Stocktradeprogram;
import java.util.HashMap;
import java.util.Map;

public class StockTrading{
    private Map<String,Stock> marketData;
    private Portfolio portfolio;
    public StockTrading(){
        marketData=new HashMap<>();
        portfolio=new Portfolio();
    }
    public void addStock(String symbol,double price){
        marketData.put(symbol,new Stock(symbol,price));
    }
    public void buyStock(String symbol, int quantity) {
        if (marketData.containsKey(symbol)) {
            portfolio.buyStock(symbol, quantity);
            System.out.println("You have bought " + quantity + " shares of " + symbol + " at $" + marketData.get(symbol).getPrice() + " each.");
        } else {
            System.out.println("This stock is not available in the market.");
        }
    }
    public void sellStock(String symbol, int quantity) {
        if (marketData.containsKey(symbol)) {
            portfolio.sellStock(symbol, quantity);
            System.out.println("You have sold " + quantity + " shares of " + symbol + " at $" + marketData.get(symbol).getPrice() + " each.");
        } else {
            System.out.println("This stock is not available in the market.");
        }
    }

    public void printMarketData() {
        for (Map.Entry<String, Stock> entry : marketData.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue().getPrice());
        }
    }
    public void printPortfolio() {
        portfolio.printHoldings();
    }

}
