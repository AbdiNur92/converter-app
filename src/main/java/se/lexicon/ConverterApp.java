package se.lexicon;

import java.util.Locale;

public class ConverterApp {
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

    // constants: rates and fixed values
    // one method per conversion, return result
    // printMenu()
    // One screen per conversion (not bmi) input -> specificConverter()
    // menu choice runConverter()
    // Loop menu, convert. until exit "Continue (yes/no)".

    void main () {
        IO.println("LEXICON CONVERTER APP");
        IO.println(celsiusToFahrenheit(100)); // 212.0
        IO.println(fahrenheitToCelsius(212)); // 100.0
        IO.println(sekToUsd(1000));           // 91.99…
        IO.println(sekToEur(1000));           // 88.33…
        IO.println(calculateBmi(75, 1.80));   // 23.14…
        IO.println(bmiCategory(18.4));        // Underweight
        IO.println(bmiCategory(18.5));        // Normal weight
        IO.println(bmiCategory(25.0));        // Overweight
        IO.println(bmiCategory(30.0));
    }
}