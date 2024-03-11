package marasample;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MS2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays for employee details
        String[] lastNames = {"Garcia", "Lim", "Aquino", "Reyes", "Hernandez","Villanueva","San Jose","Romualdez","Atienza","Alvaro"};
        String[] firstNames = {"Manuel III", "Antonio", "Bianca Sofia", "Isabella", "Eduard","Andrea Mae", "Brad", "Alice", "Rosie", "Roderick"
};
        String[] birthdays = {"10/11/1983", "06/19/1988", "08/04/1989", "06/16/1994", "09/23/1989", "02/14/1988","03/15/1996","05/14/1992","09/24/1948","03/30/1988",};
        String[] addresses = {
                "Valero Carpark Building Valero Street",
                "San Antonio De Padua 2, Block 1 Lot 1",
                "Rm. 402 4/F Jiao Building Timog Ave",
                "450 Solanda Street Intramuros 1006",
                "National Highway, Gingog, Misamis",
                "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands",
                "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi",
                "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte",
                "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte",
                "#284 T. Morato corner, Scout Rallos Street, Quezon City",
        };
        String[] phoneNumbers = {"966-860-270", "817-166-411", "866-898-370", "786-868-477", "088-861-012","918-621-603","797-009-261","983-606-799","266-036-427","053-381-386",
};		
        String[] positions = {"Chief Executive Officer","Chief Operating Officer","Chief Finance Officer","Chief Marketing Officer","IT Operations and Systems","HR Manager","HR Team Leader","HR Rank and File","HR Rank and File","Accounting Head"
        };		
        double[] hourlyRates = {535.71, 357.14, 357.14, 357.14, 313.51, 313.51, 255.80, 133.93,133.93, 313.51 };  // Hourly rates for each employee

        // Prompt for employee ID
        System.out.print("Enter employee ID (1-10): ");
        int employeeID = scanner.nextInt();

        // Validating the employee ID
        if (employeeID < 1 || employeeID > 10) {
            System.out.println("Invalid employee ID. Please enter a number between 1 and 10.");
            scanner.close(); // Close scanner if the input is invalid
            return;
        }

        // Adjust for 0-based index arrays
        int index = employeeID - 1;

        // Display the employee details
        System.out.println("Employee Name: " + firstNames[index] + " " + lastNames[index]);
        System.out.println("ID: " + employeeID);
        System.out.println("Birthday: " + birthdays[index]);
        System.out.println("Address: " + addresses[index]);
        System.out.println("Phone Number: " + phoneNumbers[index]);
        System.out.println("Position: " + positions[index]);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        double totalHoursWorked = 0.0;
        double totalLateDeductions = 0.0;
        for (int day = 1; day <= 5; day++) { // Loop through Monday to Friday
            System.out.println("\nDay " + day);
            // Get login time
            System.out.print("Enter login time (e.g., 08:00): ");
            String loginTimeStr = scanner.next();

            // Get logout time
            System.out.print("Enter logout time (e.g., 17:00): ");
            String logoutTimeStr = scanner.next();

            try {
                Date loginTime = dateFormat.parse(loginTimeStr);
                Date logoutTime = dateFormat.parse(logoutTimeStr);

                // Calculate hours worked
                long diffInMillies = logoutTime.getTime() - loginTime.getTime();
                double hoursWorked = (double) diffInMillies / (60 * 60 * 1000);
                // Subtract 1 hour for unpaid lunch break
                hoursWorked -= 1.0;

                // Calculate late deductions
                int gracePeriodMins = 10;
                double lateDeductionPerHour = hourlyRates[index]; // Each hour late incurs the hourly rate as deduction
                double lateDeductions = 0.0;
                if (loginTime.getTime() > dateFormat.parse("08:10").getTime()) { // Beyond 8:10 is considered late
                    lateDeductions = lateDeductionPerHour;
                }

                totalHoursWorked += hoursWorked;
                totalLateDeductions += lateDeductions;

                System.out.printf("Hours Worked: %.2f\n", hoursWorked);
                System.out.printf("Late Deduction/s: ₱%.2f\n", lateDeductions);

            } catch (Exception e) {
                System.out.println("Error parsing time. Please enter time in the correct format (e.g., 08:00)");
                scanner.close();
                return;
            }
        }

        // Calculate gross salary
        double weeklySalary = totalHoursWorked * hourlyRates[index];
        double grossSalary = weeklySalary * 4; // Assuming 4 weeks in a month

        // Deduct late deductions from gross salary
        grossSalary -= totalLateDeductions;

        // Pag-IBIG contribution calculation
        double pagibigContribution = Math.min(grossSalary * 0.02, 100);

        // PhilHealth contribution calculation
        double philhealthContribution = 0.0;
        if (grossSalary <= 10000) {
            philhealthContribution = 150.0;
        } else if (grossSalary > 10000 && grossSalary <= 59999.99) {
            philhealthContribution = 150.0 + (grossSalary - 10000) * 0.03;
        } else {
            philhealthContribution = 900;
        }

        double sssContribution = 135.0;
        double[][] sssTable = {
        	    {3250, 135.0}, {3250, 3750, 157.5}, {3750, 4250, 180.0}, {4250, 4750, 202.5},
        	    {4750, 5250, 225.0}, {5250, 5750, 247.5}, {5750, 6250, 270.0}, {6250, 6750, 292.5},
        	    {6750, 7250, 315.0}, {7250, 7750, 337.5}, {7750, 8250, 360.0}, {8250, 8750, 382.5},
        	    {8750, 9250, 405.0}, {9250, 9750, 427.5}, {9750, 10250, 450.0}, {10250, 10750, 472.5},
        	    {10750, 11250, 495.0}, {11250, 11750, 517.5}, {11750, 12250, 540.0}, {12250, 12750, 562.5},
        	    {12750, 13250, 585.0}, {13250, 13750, 607.5}, {13750, 14250, 630.0}, {14250, 14750, 652.5},
        	    {14750, 15250, 675.0}, {15250, 15750, 697.5}, {15750, 16250, 720.0}, {16250, 16750, 742.5},
        	    {16750, 17250, 765.0}, {17250, 17750, 787.5}, {17750, 18250, 810.0}, {18250, 18750, 832.5},
        	    {18750, 19250, 855.0}, {19250, 19750, 877.5}, {19750, 20250, 900.0}, {20250, 20750, 922.5},
        	    {20750, 21250, 945.0}, {21250, 21750, 967.5}, {21750, 22250, 990.0}, {22250, 22750, 1012.5},
        	    {22750, 23250, 1035.0}, {23250, 23750, 1057.5}, {23750, 24250, 1080.0}, {24250, 24750, 1102.5},
        	    {24750, 100000000, 1125.0}
        	};
        	for (double[] range : sssTable) {
        	    if (grossSalary >= range[0] && grossSalary <= range[1]) {
        	    	sssContribution = range[2];
        	        break; // Exit the loop once the correct range is found
        	    }
        	}
        	// Now the variable 'contribution' holds the correct SSS contribution amount for the given 'salary'
        // Total deductions
        double totalDeductions = pagibigContribution + philhealthContribution + sssContribution;

        // Withholding tax calculation (simplified example, please adjust according to the actual tax brackets)
        double taxableIncome = grossSalary - totalDeductions;
        double withholdingTax;

        // Determine the tax bracket and calculate accordingly
        if (taxableIncome <= 20832) {
            withholdingTax = 0;
        } else if (taxableIncome <= 33332) {
            withholdingTax = (taxableIncome - 20832) * 0.20;
        } else if (taxableIncome <= 66666) {
            withholdingTax = 2500 + (taxableIncome - 33332) * 0.25;
        } else if (taxableIncome <= 166666) {
            withholdingTax = 10833 + (taxableIncome - 66666) * 0.30;
        } else if (taxableIncome <= 666666) {
            withholdingTax = 40833 + (taxableIncome - 166666) * 0.32;
        } else {
            withholdingTax = 200833 + (taxableIncome - 666666) * 0.35;
        }

        // Net salary calculation
        double netSalary = taxableIncome - withholdingTax;

        // Display results
        System.out.println("\nMonthly Summary:");
        System.out.printf("Total Hours Worked: %.2f\n", totalHoursWorked);
        System.out.printf("Gross Salary: ₱%.2f\n", grossSalary);
        System.out.printf("Pag-IBIG Contribution: ₱%.2f\n", pagibigContribution);
        System.out.printf("PhilHealth Contribution: ₱%.2f\n", philhealthContribution);
        System.out.printf("SSS Contribution: ₱%.2f\n", sssContribution);
        System.out.printf("Total Deductions: ₱%.2f\n", totalDeductions);
        System.out.printf("Taxable Income: ₱%.2f\n", taxableIncome);
        System.out.printf("Withholding Tax: ₱%.2f\n", withholdingTax);
        System.out.printf("Net Salary: ₱%.2f\n", netSalary);

        scanner.close();
    }
}
