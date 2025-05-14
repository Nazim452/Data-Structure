package TCS.ActualPYQ;

import java.util.Scanner;

public class WorkOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMinutes = 0;
        int dayCount = 0;

        // Read 7 days of data
        for (int i = 0; i < 7; i++) {
            String input = scanner.nextLine();
            // Extract the minutes part after the colon
            // String[] parts = input.split(":");
            // int minutes = Integer.parseInt(parts[1].trim());
            String[] parts = input.split(":");
            int minutes =Integer.parseInt(parts[1].trim()); 
            totalMinutes += minutes;
            dayCount++;
        }

        // Calculate average and round to 2 decimal places
        double average = (double) totalMinutes / dayCount;
        // average = Math.round(average * 100) / 100.0;

        // Print results
        System.out.println("Sum of workout time: " + totalMinutes + " minutes");
        System.out.printf("Average workout time: %.2f minutes%n", average);
    }
}