import java.util.Scanner; 

 
public class Main { 
    public static void main(String[] args) { 

        Scanner input = new Scanner(System.in); 

        // ==================== QUESTION 1 ==================== 

        // Store the city names 

        String[] cities = {"Cape Town", "Port Elizabeth", "Pretoria"}; 

        // Store the console types 
        String[] consoles = {"PS5", "XBOX", "NINTENDO SWITCH"}; 
 

        // Store sales for each city and console 
        int[][] sales = { 

            {1000, 2000, 3000}, 

            {2000, 3000, 4000}, 

            {1500, 1100, 1200} 

        };

        System.out.println("QUESTION 1"); 
        System.out.println("NUMBER 1 ELECTRONICS"); 
        System.out.println("YEARLY SALES REPORT"); 
        System.out.println("==========================================================");
        // Display the table headings 
        System.out.printf("%-20s %-10s %-10s %-18s %-10s%n", 
                "CITY", "PS5", "XBOX", "NINTENDO SWITCH", "TOTAL");
        System.out.println("=========================================================="); 

        int grandTotal = 0; 
        int highestSales = 0; 
        String highestCity = ""; 

        // Loop through each city 
        for (int row = 0; row < sales.length; row++) { 
            int cityTotal = 0; 

            System.out.printf("%-20s", cities[row]); 

            // Loop through each console
            for (int column = 0; column < sales[row].length; column++) { 
                System.out.printf("%-10d", sales[row][column]); 
                // Calculate the city total 
               cityTotal += sales[row][column]; 
            } 

            System.out.printf("%-10d%n", cityTotal); 
            // Calculate the overall sales 

            grandTotal += cityTotal; 

 

            // Find the city with the highest sales 

            if (cityTotal > highestSales) { 

                highestSales = cityTotal; 

                highestCity = cities[row]; 

            } 

        } 

        System.out.println("=========================================================="); 

        System.out.println("TOTAL SALES: " + grandTotal); 

        System.out.println("CITY WITH MOST SALES: " + highestCity); 

        System.out.println("HIGHEST CITY SALES: " + highestSales); 


        // ==================== QUESTION 2 ==================== 

        System.out.println(); 
        System.out.println("QUESTION 2"); 
        System.out.println("CONSOLE SALES APPLICATION"); 

        // Allow the user to select a console 
        System.out.println("Select the console type"); 
        System.out.println("1) PS5"); 
        System.out.println("2) XBOX"); 
        System.out.println("3) NINTENDO SWITCH"); 
        System.out.print("Enter choice: "); 

        int choice = input.nextInt(); 
        input.nextLine(); 
        String consoleType; 

        // Determine the selected console 
        if (choice == 1) { 
            consoleType = consoles[0]; 
        } else if (choice == 2) { 
            consoleType = consoles[1]; 
        } else { 
            consoleType = consoles[2]; 
        } 

        // Get the store name from the user 
        System.out.print("Enter the store: "); 
        String store = input.nextLine(); 

        // Get the total sales from the user 
        System.out.print("Enter the total sales of " + consoleType + ": "); 
        int totalSales = input.nextInt(); 

        // Create a ConsoleSales object 
        ConsoleSales consoleSales = 
                new ConsoleSales(consoleType, store, totalSales); 

        // Display the console sales report 
        consoleSales.printReport(); 
      input.close(); 
    } 
} 

// ==================== QUESTION 2 ==================== 

// Interface containing the required methods 
interface Consoles { 
    String getConsoleType(); 
    String getStore(); 
    int getTotalSales(); 
} 

// Abstract class containing the console information 
abstract class Console implements Consoles { 
    private String consoleType; 
    private String store; 
    private int totalSales; 

    // Constructor 
    public Console(String consoleType, String store, int totalSales) { 
        this.consoleType = consoleType; 
        this.store = store; 
        this.totalSales = totalSales; 
    } 
    // Getter methods 
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

// Subclass that extends the Console class 
class ConsoleSales extends Console { 
    // Constructor 
    public ConsoleSales(String consoleType, String store, int totalSales) { 
        super(consoleType, store, totalSales); 
    } 

    // Print the console sales report 
    public void printReport() { 
        System.out.println(); 
        System.out.println("CONSOLE SALES REPORT"); 
        System.out.println("=============================="); 
        System.out.println("CONSOLE TYPE: " + getConsoleType()); 
        System.out.println("STORE: " + getStore());
        System.out.println("TOTAL SALES: " + getTotalSales()); 

    } 

} 
