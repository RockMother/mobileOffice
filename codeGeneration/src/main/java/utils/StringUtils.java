package utils;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class StringUtils {
    public static String toPascalCase(String input){
        return toCaseConvert(input, false);
    }
    public static String toCamelCase(String input){
        return toCaseConvert(input, true);
    }
    private static String toCaseConvert(String input, boolean firstToLower){
        String[] parts = input.split("_");
        String result = parts[0].toLowerCase();
        if (!firstToLower){
            result = result.substring(0, 1).toUpperCase() + result.substring(1);
        }
        for (Integer i = 1; i < parts.length; i++) {
            String part = parts[i];
            result += part.substring(0, 1).toUpperCase() + part.substring(1);
        }
        return result;
    }

}
