package se.lexicon;

import java.util.Locale;

public class ConverterApp {
    //Constants
    //TEMP
    static final double CELSIUS_TO_FAHRENHEIT = 9.0 / 5.0;
    static final double FAHRENHEIT_TO_CELSIUS = 5.0 / 9.0;
    static final double FAHRENHEIT_OFFSET = 32;
    //CURRENCY
    static final double SEK_PER_USD = 10.87;
    static final double SEK_PER_EUR = 11.32;
    //BMI
    static final double NORMAL_WEIGHT_FROM = 18.5;
    static final double OVERWEIGHT_FROM = 25.0;
    static final double OBESE_FROM = 30.0;
    //FAKEGUI
    static final String LINE = "==================================";



    //Methods
    static double celsiusToFahrenheit(double celsius) {
        return celsius * CELSIUS_TO_FAHRENHEIT + FAHRENHEIT_OFFSET;
    }
    static double fahrenheitToCelsius(double farenheit) {
        return (farenheit - FAHRENHEIT_OFFSET) * FAHRENHEIT_TO_CELSIUS;
    }
    static double sekToUsd(double sek) {
        return sek / SEK_PER_USD;
    }
    static double sekToEur(double sek) {
        return sek / SEK_PER_EUR;
    }
    static double calculateBmi(double weightKg, double heightM) {
        return weightKg / Math.pow(heightM, 2);
    }
    static String bmiCategory(double bmi) {
        if (bmi < NORMAL_WEIGHT_FROM) {
            return "Underweight";
        }
        else if (bmi < OVERWEIGHT_FROM) {
            return "Normal weight";
        }
        else if (bmi < OBESE_FROM) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }
    static void printMenu() {
        IO.println(LINE);
        IO.println("      LEXICON CONVERTER APP");
        IO.println(LINE);
        IO.println("1. Temperature Converter");
        IO.println("2. Currency Converter");
        IO.println("3. BMI Calculator");
        IO.println("4. Exit");
        IO.println(LINE);
    }
    static void temperatureConverter() {
        IO.println("--- Temperature Converter ---");
        IO.println("Convert:");
        IO.println("  1. Celsius to Fahrenheit");
        IO.println("  2. Fahrenheit to Celsius");
        int direction = Integer.parseInt(IO.readln("Your choice: "));

        if ( direction == 1) {
            double celsius = Double.parseDouble(IO.readln("Enter temperature in Celsius: "));
            double fahrenheit = celsiusToFahrenheit(celsius);
            IO.println(String.format(Locale.US, "Result: %.2f C = %.2f F", celsius, fahrenheit));
        }
        else {
            double fahrenheit = Double.parseDouble(IO.readln("Enter temperature in Fahrenheit: "));
            double celsius = fahrenheitToCelsius(fahrenheit);
            IO.println(String.format(Locale.US, "Result: %.2f F = %.2f C", fahrenheit, celsius));
        }
    }
    static void currencyConverter() {
        IO.println("--- Currency Converter ---");
        IO.println("Convert:");
        IO.println("  1. SEK to USD");
        IO.println("  2. SEK to EUR");
        int direction = Integer.parseInt(IO.readln("Your choice: "));
        double sek = Double.parseDouble(IO.readln("Enter amount in SEK: "));
        if ( direction == 1) {
            double usd = sekToUsd(sek);
            IO.println(String.format(Locale.US, "Result: %.2f SEK = %.2f USD", sek, usd));
        }
        else {
            double eur = sekToEur(sek);
            IO.println(String.format(Locale.US, "Result: %.2f SEK = %.2f EUR", sek, eur));
        }
    }
    static void bmiCalculator() {
        IO.println("--- BMI Calculator ---");
        double weightKg = Double.parseDouble(IO.readln("Enter weight in kg: "));
        double heightM = Double.parseDouble(IO.readln("Enter height in metres: "));
        double bmi = calculateBmi(weightKg, heightM);
        String category = bmiCategory(bmi);
        IO.println(String.format(Locale.US, "BMI: %.2f  ->  %s", bmi, category));
    }

    // constants: rates and fixed values
    // one method per conversion, return result
    // printMenu()
    // One screen per conversion (not bmi) input -> specificConverter()
    // menu choice runConverter()
    // Loop menu, convert. until exit "Continue (yes/no)".

    void main () {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = Integer.parseInt(IO.readln("Choose an option: "));
            if (choice == 4) {
                running = false;
            }
            else {
                if (choice == 1 ) {
                    IO.println();
                    temperatureConverter();
                }
                else if (choice == 2 ) {
                    IO.println();
                    currencyConverter();
                }
                else if (choice == 3 ) {
                    IO.println();
                    bmiCalculator();
                }
                IO.println("");
                running = IO.readln("Continue? (yes/no): ").equalsIgnoreCase("yes");
                if (running) {
                    IO.println();
                }
            }
        }
        IO.println("Goodbye!");


    }
}