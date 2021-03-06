package com.archanajl.romanNumeralsKata;
import java.util.*;
import java.util.stream.Collectors;

public class romanNumerals {

    private static int[] baseValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static HashMap< Integer, String> numberMap = new HashMap<>();
    private static HashMap<Character, Integer> numeralMap = new HashMap<>();

    public void initialiseNumberMap(){
        numberMap.put(1, "I");
        numberMap.put(4,"IV");
        numberMap.put(5,"V");
        numberMap.put(9,"IX");
        numberMap.put(10, "X");
        numberMap.put(40,"XL");
        numberMap.put(50, "L");
        numberMap.put(90, "XC");
        numberMap.put(100, "C");
        numberMap.put(400, "CD");
        numberMap.put(500,"D");
        numberMap.put(900,"CM");
        numberMap.put(1000,"M");
    }

    public void initialiseRomanMap(){
        numeralMap.put('I', 1);
        numeralMap.put('V', 5);
        numeralMap.put('X', 10);
        numeralMap.put('L', 50);
        numeralMap.put('C', 100);
        numeralMap.put('D', 500);
        numeralMap.put('M', 1000);
    }

    public boolean checkIfRoman(String input_roman_numeral) {
        // Check whether all characters exist in the numeral map
        List<Character> roman_numeral_list = input_roman_numeral.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList());
        return (numeralMap.keySet().containsAll(roman_numeral_list));
    }

    public String toRoman(int n) {
        String input_number = Integer.toString(n);
        initialiseNumberMap();
        StringBuilder roman_numeral = new StringBuilder();
        // Iterate through the baseValues and find out how many are present and substitute with the respective letter repeated.
        // Subtract the value and move on to the next base value
        for (int i=0;i <= baseValues.length-1;i++){
            if (n >= baseValues[i]){
                int no_of_times = n / baseValues[i] ;
                roman_numeral.append(numberMap.get(baseValues[i]).repeat(no_of_times));
                n = n - (baseValues[i] * no_of_times);
            }
        }
        return "The equivalent roman number for " + input_number + " is " + roman_numeral + ".";
    }

    public String fromRoman(String romanNumeral) {

        initialiseRomanMap();
        int result_number = 0;
        int present_value ;
        int roman_numeral_size = romanNumeral.length();

        if (checkIfRoman(romanNumeral)) {
            // loop through the numeral
            for (int position = 0; position < roman_numeral_size; position++) {
                present_value = numeralMap.get(romanNumeral.charAt(position));
                if (position + 1 < roman_numeral_size) {
                    int next_value = numeralMap.get(romanNumeral.charAt(position + 1));
                    // Compare adjacent numerals
                    // For values where the smaller values comes before the larger values,
                    // make sure it is subtracted instead of adding
                    // and move the position extra as we have included the number value
                    if (present_value >= next_value) {
                        result_number += present_value;
                    } else {
                        result_number = result_number + next_value - present_value;
                        position++;
                    }
                } else {
                    // Add the value to the result
                    result_number += present_value;
                }
            }

            return "The equivalent number for " + romanNumeral + " is " + result_number + ".";
        }else{
            return "The Roman numeral entered is invalid!";
        }


    }



}
