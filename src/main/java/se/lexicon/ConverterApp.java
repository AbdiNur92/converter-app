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
        return celsius * CELSIUS_TO_FAHRENHEIT + 32;
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
        return weightKg / (heightM * heightM);
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
        IO.println("Convert: ");
        IO.println("  1. Celsius to Fahrenheit");
        IO.println("  2. Fahrenheit to Celsius");
        int direction = Integer.parseInt(IO.readln("Your choice: "));

        if ( direction == 1) {
            double celsius = Double.parseDouble(IO.readln("Enter temperature in Celsius: "));
            double fahrenheit = celsiusToFahrenheit(celsius);
            IO.println(String.format(Locale.US, "Result: %.2f C = %.2f F", celsius, fahrenheit));
            IO.println(LINE);
        }
        else {
            double fahrenheit = Double.parseDouble(IO.readln("Enter temperature in Fahrenheit: "));
            double celsius = fahrenheitToCelsius(fahrenheit);
            IO.println(String.format(Locale.US, "Result: %.2f F = %.2f C", fahrenheit, celsius));
            IO.println(LINE);
        }
    }

    // constants: rates and fixed values
    // one method per conversion, return result
    // printMenu()
    // One screen per conversion (not bmi) input -> specificConverter()
    // menu choice runConverter()
    // Loop menu, convert. until exit "Continue (yes/no)".

    void main () {

        printMenu();
        int choice = Integer.parseInt(IO.readln("Choose an option: "));
        if (choice == 4) {
            IO.println("Goodbye!");
        } else if (choice == 1 ) {
            IO.println();
            temperatureConverter();
        }

    }


}