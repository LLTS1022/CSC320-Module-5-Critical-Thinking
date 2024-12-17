import java.util.Scanner; // Import the Scanner class 

public class Monthly_Temp {
    public static void main(String[] args) {
        // This array is used to store months and temperatures.
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        double[] temperatures = new double[12];

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Input temperatures for each month
        for (int i = 0; i < months.length; i++) {
            while (true) { // Loop until valid input is entered
                System.out.print("Enter the average temperature for " + months[i] + ": ");
                temperatures[i] = scanner.nextDouble();
                if (temperatures[i] >= -21 && temperatures[i] <= 120) {
                    break; // Valid input; exit loop. I added this to avoid entering invalid temperatures,
                           // say 800 F.
                } else {
                    System.out.println("Invalid temperature. Please enter a valid temperature");
                }
            }
        }

        // Prompt user for month or "year
        System.out.print("Enter a month to view the temperature or 'year' for yearly data: ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("year")) {
            // Display all of the monthly temperatures and calculate yearly averages
            double total = 0;
            double highest = temperatures[0];
            double lowest = temperatures[0];
            String highestMonth = months[0];
            String lowestMonth = months[0];

            System.out.println("\nMonthly Temperatures:");
            for (int i = 0; i < months.length; i++) {
                System.out.println(months[i] + ": " + temperatures[i] + "°F");
                total += temperatures[i];

                // This checks for highest and lowest temperatures
                if (temperatures[i] > highest) {
                    highest = temperatures[i];
                    highestMonth = months[i];
                }
                if (temperatures[i] < lowest) {
                    lowest = temperatures[i];
                    lowestMonth = months[i];
                }
            }

            double average = total / months.length;
            System.out.printf("Yearly Average Temperature: %.2f°F\n", average);
            System.out.printf("Highest Monthly Temperature: %s with %.2f°F\n", highestMonth, highest);
            System.out.printf("Lowest Monthly Temperature: %s with %.2f°F\n", lowestMonth, lowest);
        } else {
            // Displays temperature for the selected month
            boolean found = false;
            for (int i = 0; i < months.length; i++) {
                if (input.equalsIgnoreCase(months[i])) {
                    System.out.println("Average temperature for " + months[i] + ": " + temperatures[i] + "°F");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid month entered.");
            }
        }

        // Closes the scanner
        scanner.close();
    }
}
