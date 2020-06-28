package utils;

//Converte a cloat passada para uma determinada moeda
public class ConvertFloatToCurrency {

    public static final int CURRENCY_REAL = 0;
    public static final int CURRENCY_DOLAR = 1;

    //Converte o valor
    public static String convert (float currencyValue){
        return "";
    }

    //Converte o valor para uma determinada moeda
    public static String convert (float currencyValue, int currency){
        return getCurrency(currency);
    }

    //retorna um valor de currency
    private static String getCurrency (int currency){
        switch (currency){
            case CURRENCY_REAL: return "R$";
            case CURRENCY_DOLAR: return "U$";
            default: return "$";
        }
    }
}
