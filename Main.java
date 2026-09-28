import java.util.Scanner; 

interface Consoles { 

    String getConsoleType(); 
    String getStore(); 
    int getTotalSales(); 
    void printReport(); 

} 

 

abstract class Console implements Consoles { 

 

    private String consoleType; 
    private String store; 
    private int totalSales; 

    public Console(String consoleType, String store, int totalSales) { 

        this.consoleType = consoleType; 

        this.store = store; 

        this.totalSales = totalSales; 

    } 
    public String getConsoleType() { 

        return consoleType; 

    } 
    public String getStore() { 

        return store; 

    } 
    public int getTotalSales() { 

        return totalSales; 

    } 
} 


class ConsoleSales extends Console { 
    public ConsoleSales(String consoleType, String store, int totalSales) { 

        super(consoleType, store, totalSales); 

    } 
    public void printReport() { 

        System.out.println("Console Type: " + getConsoleType()); 

        System.out.println("Store: " + getStore()); 

        System.out.println("Total Sales: " + getTotalSales()); 

    } 

} 
public class Main { 
    public static void main(String[] args) { 

 

        Scanner input = new Scanner(System.in); 
        String[] cities = { 

            "Johannesburg", 

            "Cape Town", 

            "Durban" 

        }; 
        String[] consoles = { 

            "PlayStation", 

            "Xbox", 

            "Nintendo" 

        }; 
        int[][] sales = { 

            {120, 150, 100}, 

            {180, 130, 160}, 

            {90, 110, 140} 

        }; 
        int grandTotal = 0; 

        int highestSales = 0; 

        String highestCity = ""; 
        System.out.println("CONSOLE SALES REPORT"); 

        System.out.println("=============================================="); 
        System.out.printf("%-15s %-15s %-15s %-15s%n", 

                "City", "PlayStation", "Xbox", "Nintendo"); 
        System.out.println("=============================================="); 
        for (int row = 0; row < cities.length; row++) { 
            int cityTotal = 0; 
            System.out.printf("%-15s", cities[row]); 
            for (int column = 0; column < sales[row].length; column++) { 

 

                System.out.printf("%-15d", sales[row][column]); 

 

                cityTotal = cityTotal + sales[row][column]; 

                grandTotal = grandTotal + sales[row][column]; 

            } 

            System.out.println(); 
            if (cityTotal > highestSales) { 

                highestSales = cityTotal; 

                highestCity = cities[row]; 
            } 

        } 
 
        System.out.println("=============================================="); 
        System.out.println("Total Sales: " + grandTotal); 
        System.out.println("City with most sales: " + highestCity); 
        System.out.println("Highest City Sales: " + highestSales); 


        input.close(); 
    } 

} 
