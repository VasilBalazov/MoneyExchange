import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        double value = Double.parseDouble(input[0]);
        String entryCurrency = input[1];
        String convertedCurrency = input[2];
        BigDecimal accurateValue = BigDecimal.valueOf(value); //getting the exact number

        // for accurate exchange rate they can be created in another class and updated before conversion
        double fromGBPExchangeRate = 1.20758;
        BigDecimal accurateFromGBPExchangeRate = BigDecimal.valueOf(fromGBPExchangeRate); //getting the exact exchange rate
        double fromUSDExchangeRate = 0.905236;
        BigDecimal accurateFromUSDExchangeRate = BigDecimal.valueOf(fromUSDExchangeRate); //getting the exact exchange rate
        double fromBGNExchangeRate = 0.511292;
        BigDecimal accurateFromBGNExchangeRate = BigDecimal.valueOf(fromBGNExchangeRate); //getting the exact exchange rate
        double inEUR = 0;
        BigDecimal accurateInEUR = new BigDecimal("0"); //getting the exact value in EUR

        // set entry currency to be equal to EUR
        switch (entryCurrency){
            case "GBP":
            case "gbp":
            case "Gbp":
                inEUR = value * fromGBPExchangeRate;
                accurateInEUR = accurateValue.multiply(accurateFromGBPExchangeRate);
                break;
            case "EUR":
            case "eur":
            case "Eur":
                inEUR = value;
                accurateInEUR = accurateValue;
                break;
            case "USD":
            case "usd":
            case "Usd":
                inEUR = value * fromUSDExchangeRate;
                accurateInEUR = accurateValue.multiply(accurateFromUSDExchangeRate);
                break;
            case "BGN":
            case "Bgn":
            case "bgn":
                inEUR = value * fromBGNExchangeRate;
                accurateInEUR = accurateValue.multiply(accurateFromBGNExchangeRate);
                break;
            case default:
                System.out.println("Currently we DO NOT this entry currency");
        }

        double convertedValue = 0;
        BigDecimal accurateConvertedValue = new BigDecimal("0"); //getting the exact value in EUR
        double toGBPExchangeRate = 0.828103;
        BigDecimal accurateToGBPExchangeRate = BigDecimal.valueOf(toGBPExchangeRate); //getting the exact exchange rate
        double toUSDExchangeRate = 1.10468;
        BigDecimal accurateToUSDExchangeRate = BigDecimal.valueOf(toUSDExchangeRate); //getting the exact exchange rate
        double toBGNExchangeRate = 1.95583;
        BigDecimal accurateToBGNExchangeRate = BigDecimal.valueOf(toBGNExchangeRate); //getting the exact exchange rate
        switch (convertedCurrency){
            case "GBP":
            case "gbp":
            case "Gbp":
                convertedValue = inEUR * toGBPExchangeRate;
                accurateConvertedValue = accurateInEUR.multiply(accurateToGBPExchangeRate);
                break;
            case "EUR":
            case "eur":
            case "Eur":
                convertedValue = inEUR;
                accurateConvertedValue = accurateInEUR;
                break;
            case "USD":
            case "usd":
            case "Usd":
                convertedValue = inEUR * toUSDExchangeRate;
                accurateConvertedValue = accurateInEUR.multiply(accurateToUSDExchangeRate);
                break;
            case "BGN":
            case "Bgn":
            case "bgn":
                convertedValue = inEUR * toBGNExchangeRate;
                accurateConvertedValue = accurateInEUR.multiply(accurateToBGNExchangeRate);
                break;
            case default:
                System.out.println("Currently we DO NOT this exit currency");
        }

        System.out.printf("%f %s\n", convertedValue, convertedCurrency);

        System.out.println("BigDecimal: " + accurateConvertedValue);

    }
}
