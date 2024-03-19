package marasample;
import java.text.ParseException; // is used to indicate problems encountered while parsing strings in date and time formatting
import java.text.SimpleDateFormat; //  is used to format and parse dates in a specific pattern
import java.util.Date; // is used to represent date and time objects
import java.util.InputMismatchException; // is an exception that is thrown when a scanner's input does not match the pattern.
import java.util.Scanner; // is used to get user input

public class UpdatedMS2 {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        // Arrays for employee details
        String[] lastNames = {
        	    "Garcia", "Lim", "Aquino", "Reyes", "Hernandez", 
        	    "Villanueva", "San Jose", "Romualdez", "Atienza", "Alvaro", 
        	    "Salcedo", "Lopez", "Farala", "Martinez", "Romualdez", 
        	    "Mata", "De Leon", "San Jose", "Rosario", "Bautista", 
        	    "Lazaro", "Delos Santos", "Santos", "Del Rosario", "Tolentino", 
        	    "Gutierrez", "Manalaysay", "Villegas", "Ramos", "Maceda", 
        	    "Aguilar", "Castro", "Martinez", "Santos"
        	};

        	String[] firstNames = {
        	    "Manuel III", "Antonio", "Bianca Sofia", "Isabella", "Eduard", 
        	    "Andrea Mae", "Brad", "Alice", "Rosie", "Roderick", 
        	    "Anthony", "Josie", "Martha", "Leila", "Fredrick", 
        	    "Christian", "Selena", "Allison", "Cydney", "Mark", 
        	    "Darlene", "Kolby", "Vella", "Tomas", "Jacklyn", 
        	    "Percival", "Garfield", "Lizeth", "Carol", "Emelia", 
        	    "Delia", "John Rafael", "Carlos Ian", "Beatriz"
        	};

        	String[] birthdays = {
        	    "10/11/1983", "06/19/1988", "08/04/1989", "06/16/1994", "09/23/1989", 
        	    "02/14/1988", "03/15/1996", "05/14/1992", "09/24/1948", "03/30/1988", 
        	    "09/14/1993", "01/14/1987", "01/11/1942", "07/11/1970", "03/10/1985", 
        	    "10/21/1987", "02/20/1975", "06/24/1986", "10/06/1996", "02/12/1991", 
        	    "11/25/1985", "02/26/1980", "12/31/1983", "12/18/1978", "05/19/1984", 
        	    "12/18/1970", "08/28/1986", "12/12/1981", "08/20/1978", "04/14/1973", 
        	    "01/27/1989", "02/09/1992", "11/16/1990", "08/07/1990"
        	};

        	String[] addresses = {
        	    "Valero Carpark Building Valero Street 1227, Makati City",
        	    "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite",
        	    "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City",
        	    "460 Solanda Street Intramuros 1000, Manila",
        	    "National Highway, Gingoog, Misamis Occidental",
        	    "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands",
        	    "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi",
        	    "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte",
        	    "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte",
        	    "#284 T. Morato corner, Scout Rallos Street, Quezon City",
        	    "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate",
        	    "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro",
        	    "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte",
        	    "37/46 Kulas Roads, Maragondon 0962 Quirino",
        	    "22A/52 Lubowitz Meadows, Pililla 4895 Zambales",
        	    "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu",
        	    "89A Armstrong Trace, Compostela 7874 Maguindanao",
        	    "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union",
        	    "93A/21 Berge Points, Tapaz 2180 Quezon",
        	    "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino",
        	    "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino",
        	    "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur",
        	    "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur",
        	    "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque",
        	    "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao",
        	    "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur",
        	    "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur",
        	    "66/77 Mann Views, Luisiana 1263 Dinagat Islands",
        	    "72/70 Stamm Spurs, Bustos 4550 Iloilo",
        	    "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija",
        	    "95 Cremin Junction, Surallah 2809 Cotabato",
        	    "Hi-way, Yati, Liloan Cebu",
        	    "Bulala, Camalaniugan",
        	    "Agapita Building, Metro Manila"
        	};

        	String[] phoneNumbers = {
        	    "966-860-270", "171-867-411", "966-889-370", "786-868-477", "088-861-012",
        	    "918-621-603", "797-009-261", "983-606-799", "266-036-427", "053-381-386",
        	    "070-766-300", "478-355-427", "329-034-366", "877-110-749", "023-079-009",
        	    "783-776-744", "975-432-139", "179-075-129", "868-819-912", "683-725-348",
        	    "740-721-558", "739-443-033", "955-879-269", "882-550-989", "675-757-366",
        	    "512-899-876", "948-628-136", "332-372-215", "250-700-389", "973-358-041",
        	    "529-705-439", "332-424-955", "078-854-208", "526-639-511"
        	};

        	String[] positions = {
        	    "Chief Executive Officer", "Chief Operating Officer", "Chief Finance Officer", "Chief Marketing Officer", "IT Operations and Systems",
        	    "HR Manager", "HR Team Leader", "HR Rank and File", "HR Rank and File", "Accounting Head",
        	    "Payroll Manager", "Payroll Team Leader", "Payroll Rank and File", "Payroll Rank and File", "Account Manager",
        	    "Account Team Leader", "Account Team Leader", "Account Rank and File", "Account Rank and File", "Account Rank and File",
        	    "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File",
        	    "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File",
        	    "Account Rank and File", "Sales & Marketing", "Supply Chain and Logistics", "Customer Service and Relations"
        	};

        	double[] hourlyRates = {
        	    535.71, 357.14, 357.14, 357.14, 313.51, 
        	    313.51, 255.80, 133.93, 133.93, 313.51, 
        	    302.53, 229.02, 142.86, 142.86, 318.45, 
        	    255.80, 249.11, 133.93, 133.93, 138.39, 
        	    138.39, 142.86, 133.93, 133.93, 142.86, 
        	    147.32, 147.32, 142.86, 133.93, 133.93, 
        	    133.93, 313.51, 313.51, 313.51
        	};

        while (true) { // Loop to calculate salary for multiple employees
            // Prompt for employee ID
            int employeeID = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                	System.out.println("Welcome to the Salary Calculator!");
                    System.out.print("Enter employee ID (1-34): ");
                    employeeID = scanner.nextInt();
                    if (employeeID < 1 || employeeID > 34) {
                        System.out.println("Invalid employee ID. Please enter a number between 1 and 34.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            
            int index = employeeID - 1;

            // Display the employee details
            System.out.println("Employee Name: " + firstNames[index] + " " + lastNames[index]);
            System.out.println("ID: " + employeeID);
            System.out.println("Birthday: " + birthdays[index]);
            System.out.println("Address: " + addresses[index]);
            System.out.println("Phone Number: " + phoneNumbers[index]);
            System.out.println("Position: " + positions[index]);
            System.out.println("Hourly Rate: " + hourlyRates[index]);
            // Ask for the number of days worked in the month
            int daysWorked = 0;
            validInput = false;
            while (!validInput) {
                try {
                	System.out.println();
                    System.out.print("Enter the number of days worked in the month: ");
                    daysWorked = scanner.nextInt();
                    if (daysWorked < 0) {
                        System.out.println("Invalid input. Please enter a positive number.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            double totalhrswork = 0.0;
            double totallatedeductions = 0.0;
            for (int day = 1; day <= daysWorked; day++) { // Loop through the days worked
                System.out.println("\nDay " + day);
                // Get login time
                Date loginTime = null;
                Date logoutTime = null;
                while (loginTime == null) {
                    System.out.print("Enter login time (e.g., 08:00): ");
                    String loginTimeStr = scanner.next();
                    try {
                        loginTime = dateFormat.parse(loginTimeStr);
                    } catch (ParseException e) {
                        System.out.println("Error parsing time. Please enter time in the correct format (e.g., 08:00)");
                    }
                }

                // Get logout time
                while (logoutTime == null) {
                    System.out.print("Enter logout time (e.g., 17:00): ");
                    String logoutTimeStr = scanner.next();
                    try {
                        logoutTime = dateFormat.parse(logoutTimeStr);
                    } catch (ParseException e) {
                        System.out.println("Error parsing time. Please enter time in the correct format (e.g., 17:00)");
                    }
                }

                // Calculate hours worked
                long diffInMill = logoutTime.getTime() - loginTime.getTime();
                double hoursWorked = (double) diffInMill / (60 * 60 * 1000);
                // Subtract 1 hour for unpaid lunch break
                hoursWorked -= 1.0;

             // Calculate late deductions
                int graceperiod = 10;
                double lateDeductionPerHour = hourlyRates[index]; // Each hour late incurs the hourly rate as a deduction
                double lateDeductions = 0.0;

                // Calculate the number of minutes late
                long minLate = (loginTime.getTime() - dateFormat.parse("08:00").getTime()) / (60 * 1000);

                if (minLate > graceperiod) { // Beyond the grace period is considered late
                    // Calculate the number of hours late (rounded up)
                    double hoursLate = Math.ceil((minLate - graceperiod) / 60.0);
                    lateDeductions = hoursLate * lateDeductionPerHour;
                }

                totalhrswork += hoursWorked;
                totallatedeductions += lateDeductions;

                System.out.printf("Hours Worked: %.2f\n", hoursWorked);
                System.out.printf("Late Deduction/s: ₱%.2f\n", lateDeductions);
            }

            // Calculate gross salary
            double grossSalary = hourlyRates[index] * totalhrswork;

            // Deduct late deductions from gross salary
            grossSalary -= totallatedeductions;

            // Pag-IBIG contribution calculation
            double pagibigContribution = Math.min(grossSalary * 0.02, 100);

            // PhilHealth contribution calculation
            double philhealthContribution = 0.0;
            if (grossSalary <= 10000) {
                philhealthContribution = 300.0 / 2; // 150.0
            } else if (grossSalary > 10000 && grossSalary <= 59999.99) {
                philhealthContribution = (grossSalary * 0.03) / 2; // 3% of grossSalary, then divided by 2 for employee's share
            } else if (grossSalary >= 60000) {
                philhealthContribution = 1800.0 / 2; // 900.0
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
            double OverallDeductions = pagibigContribution + philhealthContribution + sssContribution;

            // Withholding tax calculation (simplified example, please adjust according to the actual tax brackets)
            double taxableIncome = grossSalary - OverallDeductions;
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
            System.out.printf("Total Hours Worked: %.2f\n", totalhrswork);
            System.out.printf("Gross Salary: ₱%.2f\n", grossSalary);
            System.out.printf("Pag-IBIG Contribution: ₱%.2f\n", pagibigContribution);
            System.out.printf("PhilHealth Contribution: ₱%.2f\n", philhealthContribution);
            System.out.printf("SSS Contribution: ₱%.2f\n", sssContribution);
            System.out.printf("Total Deductions: ₱%.2f\n", OverallDeductions);
            System.out.printf("Taxable Income: ₱%.2f\n", taxableIncome);
            System.out.printf("Withholding Tax: ₱%.2f\n", withholdingTax);
            System.out.printf("Net Salary: ₱%.2f\n", netSalary);

            // Ask the user if they want to calculate another employee's salary
            System.out.print("\nDo you want to calculate another employee's salary? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")&& !response.equals("y")) {
                System.out.println("Thank you for using the salary calculator.");
                break; // Exit the loop if the user does not want to continue
            }
        }

        scanner.close();
    }
}
/* MO-IT101 Computer Programming 1 - H1102

Mara Cervantes

 */
