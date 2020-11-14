package Utils;

public class StringUtils {
    public static String capitalize(String nome) {
        return nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
    }
}