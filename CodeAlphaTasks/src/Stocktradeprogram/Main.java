package Stocktradeprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    private String Symbol;
    private double Price;
    public Stock(String symbol,double price){
        this.Symbol=symbol;
        this.Price=price;
    }
    public String getSymbol(){
        return Symbol;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }
}
class Portfolio{
    private Map<String,Integer> holdings;
    public Portfolio(){
        holdings=new HashMap<>();
    }
    public void buyStock(String symbol,int quantity){
        if (holdings.containsKey(symbol)) {
            holdings.put(symbol, holdings.get(symbol) + quantity);
        } else {
            holdings.put(symbol, quantity);
        }
    }
    public void sellStock(String symbol,int quantity){
        if(holdings.containsKey(symbol)){
            int CurrentQuantity = holdings.get(symbol);
            if(CurrentQuantity>= quantity){
                holdings.put(symbol,CurrentQuantity-quantity);
            }
            else{
                System.out.println("You dont have enough shares to sell.");
            }
        }
        else {
            System.out.println("You dont own any shares of this stock.");
        }
    }
    public void printHoldings() {
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
public class Main{
    public static void main(String[] args) {
        StockTrading platform= new StockTrading();
        platform.addStock("Market",1500);
        platform.addStock("Data",1200);
        platform.addStock("Place",1990);
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("1:Buy Stock");
            System.out.println("2: Sell Stock");
            System.out.println("3: Print Market Data");
            System.out.println("4: Print Portfolio");
            System.out.println("Choose Stock Symbol Betweeen:\n Market,Data,Place");
            System.out.println("5:Exit");
            System.out.println("Choose an option");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    System.out.println("Enter Stock Symbol");
                    String symbol= scanner.nextLine();
                    System.out.println("Enter Quantity");
                    int quantity= scanner.nextInt();
                    scanner.nextLine();
                    platform.buyStock(symbol,quantity);
                    break;
                case 2:
                    System.out.println("Enter Stock Symbol");
                    symbol= scanner.nextLine();
                    System.out.println("Enter Quantity");
                    quantity= scanner.nextInt();
                    scanner.nextLine();
                    platform.sellStock(symbol,quantity);
                    break;
                case 3:
                    platform.printMarketData();
                    break;
                case 4:
                    platform.printPortfolio();
                    break;
                case 5:
                    System.out.println("Exit");
                default:
                    System.out.println("Invalid Choice....");
            }
        }
    }
}