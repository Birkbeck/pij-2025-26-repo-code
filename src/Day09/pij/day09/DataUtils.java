package pij.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DataUtils {

    public static List<String> getCities(){
        return new ArrayList<>(Arrays.asList("London", "Cardiff", "Rome", "Birmingham", "Glasgow",
                "Belfast", "Dublin", "Madrid", "Oslo", "Warsaw", "Moscow", "Stockholm", "Bonn", "Berlin", "Paris",
                "Vienna", "Athens"));
    }

    public static String[] getNames(){
        return new String[]{"Amy", "Bob", "Eddy", "Dave", "Fred", "Mary", "Jane", "Mo", "Julie", "abby", "Bo", "Roger",
        "peter", "Greg", "Steve", "Stu", "Richard", "Jules", "Dee", "Imran", "Ingrid", "Santos", "Raj", "patty", "Eve",
        "Tan", "Stan", "George", "Jerry", "Gustav", "Wendy", "Zoe", "Dan", "Doc", "Po", "Daz", "Cat", "ezzy", "Pru"};
    }



    public static boolean isFirstLetterE(java.lang.String s){
        return switch (s.charAt(0)){
            case 'e', 'E' -> true;
            default -> false;
        };

    }

    public static <String> int eSort(String s1, String s2) {
        if ((isFirstLetterE((java.lang.String) s1) && isFirstLetterE((java.lang.String) s2)) || (!isFirstLetterE((java.lang.String) s1) && !isFirstLetterE((java.lang.String) s2) ) ){
            return 0;
        } else if ((isFirstLetterE((java.lang.String) s1) && !isFirstLetterE((java.lang.String) s2))){
            return -1;
        }else{
            return 1;
        }
    }
}
