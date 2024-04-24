import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        
        CurrencyConverter fazerConversao = new CurrencyConverter();
        Scanner sc = new Scanner(System.in);

        // Repeat * for menu
        String str = "*";
        String repeated = str.repeat(100);

        boolean running = true;

        do{
            HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();
            DecimalFormat f = new DecimalFormat("0.00");
        
            // Currency codes
            currencyCodes.put(1, "USD");
            currencyCodes.put(2, "BRL");
            currencyCodes.put(3, "EUR");
            currencyCodes.put(4, "CNY");
            currencyCodes.put(5, "JPY");
            currencyCodes.put(6, "RUB");

            Integer from, to;
            String fromCode, toCode;
            double amount;

            System.out.println();
            System.out.println(repeated);
            System.out.println();
            System.out.println("Welcome to the Currency Converter!");
            System.out.println();
        
            // FROM Currency
            System.out.println("Choose the Currency converting FROM");
            System.out.println("1: USD (US dollar)\t 2: BRL (Brazilian real)\t 3: EUR (Euro)\t 4: CNY (Renminbi)\t 5: JPY (Japanese yen)\t 6: RUB (Russian ruble)");
            from =  sc.nextInt();
            System.out.println();
            while (from < 1 || from > 6) {
                System.out.println("Please select a valid currency option (1-6)");
                System.out.println("1: USD (US dollar)\t 2: BRL (Brazilian real)\t 3: EUR (Euro)\t 4: CNY (Renminbi)\t 5: JPY (Japanese yen)\t 6: RUB (Russian ruble)");
                from =  sc.nextInt();
                System.out.println();
            }
            fromCode = currencyCodes.get(from);

            // TO Currency
            System.out.println("Choose the Currency converting TO");
            System.out.println("1: USD (US dollar)\t 2: BRL (Brazilian real)\t 3: EUR (Euro)\t 4: CNY (Renminbi)\t 5: JPY (Japanese yen)\t 6: RUB (Russian ruble)");
            to =  sc.nextInt();
            System.out.println();
            while (to < 1 || to > 6) {
                System.out.println("Please select a valid currency option (1-6)");
                System.out.println("1: USD (US dollar)\t 2: BRL (Brazilian real)\t 3: EUR (Euro)\t 4: CNY (Renminbi)\t 5: JPY (Japanese yen)\t 6: RUB (Russian ruble)");
                to =  sc.nextInt();
                System.out.println();
            }
            toCode = currencyCodes.get(to);

            // Amount to convert
            System.out.println("Amount you wish to convert?");
            amount = sc.nextFloat();
            System.out.println();
    
            try {
                double valorConvertido = fazerConversao.converterMoeda(fromCode, toCode, amount);
                System.out.println("Conversion result: " + f.format(amount) + fromCode + " is " + f.format(valorConvertido) + toCode + ".");
                System.out.println();
                System.out.println("Would you like to make another conversion?");
                System.out.println("1 - Yes \t Any other integer key: No");
                if (sc.nextInt() != 1){
                    running = false;
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Closing the aplication.");
            }
        } while(running);
        
        System.out.println("Thank you for using the Currency Converter!");
        System.out.println();
        System.out.println(repeated);
        sc.close();
    }

}
