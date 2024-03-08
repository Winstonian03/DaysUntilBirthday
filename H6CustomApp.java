///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           6z Days Until Birthday
// Course:          CS 200, Spring 2024
//
// Author:          Winston Chan
// Email:           wchan35@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Used ChatGPT 3.5 to provide some examples with while and do-while loops to safely take in
// each input. Also used it to help navigate the java.time.YearMonth file to more effectively
// check the number of days in each month for any year.
//
///////////////////////////////// REFLECTION ///////////////////////////////////
//
// 1. Describe the problem you wrote the program to solve: The program calculates the number of
//    days until your next birthday, when given the birthdate and the current date.
// 2. What are the biggest challenges you encountered: Creating the proper equations and finding
//    the different conditions to calculate the number of days. The code also tries to factor in
//    leap years when doing the calculations. Another challenge was to only take in safe inputs
//    to prevent the program from crashing.
// 3. What did you learn from this assignment: How to take in safe inputs and how to restrict the
//    inputs that are entered into the program.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;
import java.time.YearMonth;

/**
 * This class calculates the number of days until your next birthday.
 *
 * @author Winston Chan
 */
public class H6CustomApp {
    /**
     * Static variables for days within each month
     */
    private static final int JANUARY_DAYS = 31;
    private static final int FEBRUARY_DAYS = 28;
    private static final int MARCH_DAYS = 31;
    private static final int APRIL_DAYS = 30;
    private static final int MAY_DAYS = 31;
    private static final int JUNE_DAYS = 30;
    private static final int JULY_DAYS = 31;
    private static final int AUGUST_DAYS = 31;
    private static final int SEPTEMBER_DAYS = 30;
    private static final int OCTOBER_DAYS = 31;
    private static final int NOVEMBER_DAYS = 30;
    private static final int DECEMBER_DAYS = 31;

    /**
     * This method returns the number of days for each month and for leap years
     *
     * @param currYear
     * @param currMonth
     * @return
     */

    public static int getDaysInMonth(int currYear, int currMonth) {
        YearMonth yearMonthObject = YearMonth.of(currYear, currMonth);
        return yearMonthObject.lengthOfMonth();
    }

    /**
     * This method returns the boolean value if the integer is a positive integer or negative
     *
     * @param birthMonthNum
     * @return
     */
    public static boolean isPositiveInteger(int birthMonthNum) {
        return birthMonthNum >= 0;
    }

    /**
     * This method calculates whether if the year is a leap year (happens once every 4 years)
     *
     * @param currYear
     * @param birthNum
     * @param currNum
     * @return
     */
    public static int calculateLeapYear(int currYear, int birthNum, int currNum) {
        int extraDay;
        if (((currYear % 4) == 0) && (currNum <= 59) && (birthNum > 59)) {
            extraDay = 1;
        } else {
            extraDay = 0;
        }
        return extraDay;
    }

    /**
     * This method returns the number of days until birthday
     *
     * @param birthNum
     * @param currNum
     * @return
     */
    public static int calculateDaysUntilBirthDay(int birthNum, int currNum) {
        int daysToBirth;
        if (birthNum >= currNum) {
            daysToBirth = birthNum - currNum;
        } else {
            daysToBirth = (365 - Math.abs(birthNum - currNum));
        }
        return daysToBirth;
    }

    /**
     * This method assigns each month with its respective number
     *
     * @param birthMonth
     * @return
     */
    public static int convertMonthToNum(String birthMonth) {
        int birthMonthNum = 0;
        String uppercaseBirthMonth = birthMonth.toUpperCase();

        switch (uppercaseBirthMonth) {
            case "JANUARY":
            case "JAN":
                birthMonthNum = 1;
                break;
            case "FEBRUARY":
            case "FEB":
                birthMonthNum = 2;
                break;
            case "MARCH":
            case "MAR":
                birthMonthNum = 3;
                break;
            case "APRIL":
            case "APR":
                birthMonthNum = 4;
                break;
            case "MAY":
                birthMonthNum = 5;
                break;
            case "JUNE":
            case "JUN":
                birthMonthNum = 6;
                break;
            case "JULY":
            case "JUL":
                birthMonthNum = 7;
                break;
            case "AUGUST":
            case "AUG":
                birthMonthNum = 8;
                break;
            case "SEPTEMBER":
            case "SEPT":
            case "SEP":
                birthMonthNum = 9;
                break;
            case "OCTOBER":
            case "OCT":
                birthMonthNum = 10;
                break;
            case "NOVEMBER":
            case "NOV":
                birthMonthNum = 11;
                break;
            case "DECEMBER":
            case "DEC":
                birthMonthNum = 12;
                break;
            default:
                birthMonthNum = -1;
                break;
        }
        return birthMonthNum;
    }

    /**
     * This method returns the weighted value (in days) for each month
     *
     * @param birthMonth
     * @return
     */
    public static int convertMonthToDays(String birthMonth) {
        int birthMonthNum = 0;
        String uppercaseBirthMonth = birthMonth.toUpperCase();

        switch (uppercaseBirthMonth) {
            case "JANUARY":
            case "JAN":
                birthMonthNum = 0;
                break;
            case "FEBRUARY":
            case "FEB":
                birthMonthNum = JANUARY_DAYS;
                break;
            case "MARCH":
            case "MAR":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS;
                break;
            case "APRIL":
            case "APR":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS;
                break;
            case "MAY":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS;
                break;
            case "JUNE":
            case "JUN":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS + MAY_DAYS;
                break;
            case "JULY":
            case "JUL":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS + MAY_DAYS
                        + JUNE_DAYS;
                break;
            case "AUGUST":
            case "AUG":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS + MAY_DAYS
                        + JUNE_DAYS + JULY_DAYS;
                break;
            case "SEPTEMBER":
            case "SEPT":
            case "SEP":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS + MAY_DAYS
                        + JUNE_DAYS + JULY_DAYS + AUGUST_DAYS;
                break;
            case "OCTOBER":
            case "OCT":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS + MAY_DAYS
                        + JUNE_DAYS + JULY_DAYS + AUGUST_DAYS + SEPTEMBER_DAYS;
                break;
            case "NOVEMBER":
            case "NOV":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS + MAY_DAYS
                        + JUNE_DAYS + JULY_DAYS + AUGUST_DAYS + SEPTEMBER_DAYS + OCTOBER_DAYS;
                break;
            case "DECEMBER":
            case "DEC":
                birthMonthNum = JANUARY_DAYS + FEBRUARY_DAYS + MARCH_DAYS + APRIL_DAYS + MAY_DAYS
                        + JUNE_DAYS + JULY_DAYS + AUGUST_DAYS + SEPTEMBER_DAYS + OCTOBER_DAYS
                        + NOVEMBER_DAYS;
                break;
            default:
                birthMonthNum = -1;
                break;
        }
        return birthMonthNum;
    }

    /**
     * This is the main method and  prompts the user for the proper input without crashes,
     * and uses the methods above to calculate days until next birthday.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String promptUserBirth = "Enter your birthday (Year Month Day)";
        String promptUserCurr = "Enter today's date (Year Month Day)";

        System.out.println(promptUserBirth);

        /**
         * Prompts the user to enter birth year to calculate whether if it is a leap year.
         * This is bounded between 1900 and 2024 (inclusive).
         */
        int birthYear;

        do {
            System.out.print("Please enter your birth year: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter your birth year (a number between 1900 and 2024): ");
                input.next();
            }
            birthYear = input.nextInt();

            if (birthYear < 1900 || birthYear > 2024) {
                System.out.println("Please enter your birth year between 1900 and 2024.");
            }
        } while (birthYear < 1900 || birthYear > 2024);

        /**
         * Prompts user to enter birth month, can take non-case sensitive inputs.
         * Restricted to abbreviation and full months.
         */
        String birthMonth = input.nextLine();
        while (!isPositiveInteger(convertMonthToDays(birthMonth))) {
            System.out.print("Please enter your birth month (i.e. jan/january): ");
            birthMonth = input.nextLine();
            birthMonth = birthMonth.trim();
        }

        /**
         * Prompts user to enter a proper day in the month.
         * i.e. if the year is not a leap year, Feb 29 will not be a valid day.
         * i.e. if user inputs day 31 in the month Feb, it will not be a valid input
         */
        int birthDay;
        do {
            System.out.print("Please enter a day in the proper month: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter a day in the proper month: ");
                input.next();
            }
            birthDay = input.nextInt();

            if (birthDay < 1 || birthDay > getDaysInMonth(birthYear,
                    convertMonthToNum(birthMonth))) {
                System.out.println("Please enter a day in the proper month: ");
            }
        } while (birthDay < 1 || birthDay > getDaysInMonth(birthYear,
                convertMonthToNum(birthMonth)));

        System.out.println(promptUserCurr);

        System.out.print("Please enter today's year: ");
        int currYear = input.nextInt();
        while (currYear < 1900 || currYear > 2024) {
            System.out.print("Please enter today's year: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter today's year: ");
                input.next();
            }
            currYear = input.nextInt();

            if (currYear < 1900 || currYear > 2024) {
                System.out.println("Please enter today's year: ");
            }
        }

        String currMonth = input.nextLine();
        currMonth = currMonth.trim();
        while (!isPositiveInteger(convertMonthToDays(currMonth))) {
            System.out.print("Please enter today's month (i.e. jan/january): ");
            currMonth = input.nextLine();
            currMonth = currMonth.trim();
        }

        int currDay;
        do {
            System.out.print("Please enter a day in the proper month: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter a day in the proper month: ");
                input.next();
            }
            currDay = input.nextInt();

            if (currDay < 1 || currDay > getDaysInMonth(currYear,
                    convertMonthToNum(currMonth))) {
                System.out.println("Please enter a day in the proper month: ");
            }
        } while (currDay < 1 || currDay > getDaysInMonth(currYear,
                convertMonthToNum(currMonth)));

        int birthNum = convertMonthToDays(birthMonth) + birthDay;
        int currNum = convertMonthToDays(currMonth) + currDay;

        /**
         * This checks if the birthday is on a leap year (Feb 29th).
         */
        if ((convertMonthToDays(birthMonth) == 31) && (birthDay == 29)) {
            System.out.println("Your birthday is on a leap year!");

            /**
             * This else statement checks when the birthday is already passed, and it is a leap
             * year.This adds +1 to the day count because there are 366 days in a leap year before
             * feb 29th.
             */
        } else if ((convertMonthToDays(currMonth) < (31 + 28)) && (currNum > birthNum)
                && (currYear % 4 == 0)) {
            System.out.println("There are " + (calculateDaysUntilBirthDay(birthNum, currNum)
                    + 1) + " days until your birthday.");

            /**
             * This checks if the birthday is equal to the current day. If it is equal,
             * Happy Birthday!
             */
        } else if (birthNum == currNum) {
            System.out.println("Happy Birthday! There are "
                    + 0 + " days until your birthday.");
            /**
             * This checks the number of days until next birthday without leap years.
             */
        } else {
            System.out.println("There are " + (calculateDaysUntilBirthDay(birthNum, currNum)
                    + calculateLeapYear(currYear, birthNum, currNum))
                    + " days until your birthday.");
        }
        input.close();
    }
}