package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyPasswordByRules {

    public static String[] RULE_SPECIAL_CHARACTER = {"!","@","#","$","%","ˆ","&","*", "(", ")", "|", "\\", "/", "{", "}", "[", "]", ";", ":", "'","\"", "<", ">", "?", "_", "-", "+", "=",",", "."};
    public static String[] RULE_ALPHANUMERIC = {"0", "1", "2", "3", "4", "5", "6","7", "8", "9"};
    public static String[] RULE_LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H","I","J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};



    public static boolean verifyPassword (String password, String[] rule1){
        return checkByRule(password, rule1);
    }

    public static boolean verifyPassword (String password, String[] rule1, String[] rule2){
        boolean result = false;
        if(!checkByRule(password, rule1)){
            result = false;
            return result;
        }


        if(!checkByRule(password, rule2)){
            result = false;
            return result;
        }

        return result;
    }

    public static boolean verifyPassword (String password, String[] rule1, String[] rule2, String[] rule3){
        boolean result = false;
        if(!checkByRule(password, rule1)){
            result = false;
            return result;
        }


        if(!checkByRule(password, rule2)){
            result = false;
            return result;
        }

        if(!checkByRule(password, rule3)){
            result = false;
            return result;
        }

        return result;
    }

    public static boolean verifyPassword (String password, List<String[]> rules){
        boolean result = true;

        for(String[] rule: rules){
            boolean _result = checkByRule(password, rule);
            if(!_result){
                result = _result;
                break;
            }
        }
        return result;
    }

    private static boolean checkByRule (String password, String[] rules){
        boolean result = false;
        for (String rule : rules){
            if(password.contains(rule)){
                result = true;
                break;
            }
        }
        return result;
    }
}
