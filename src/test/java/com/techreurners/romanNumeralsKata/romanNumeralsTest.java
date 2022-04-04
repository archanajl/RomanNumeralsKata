package com.techreurners.romanNumeralsKata;

import com.techreturners.romanNumeralsKata.romanNumerals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class romanNumeralsTest {

    private romanNumerals romanNumeral;

    @BeforeEach
    public void setUp() {
        romanNumeral = new romanNumerals();
    }

    @Test
    public void checkifRomanWithCorrectValue() {
        romanNumeral.initialiseRomanMap();
        boolean expected = romanNumeral.checkIfRoman("XXV");
        Assertions.assertTrue(expected);

    }

    @Test
    public void checkifRomanWithWrongValue() {
        romanNumeral.initialiseRomanMap();
        boolean expected = romanNumeral.checkIfRoman("ST");
        Assertions.assertFalse(expected);

    }

    @Test
    public void checkToRomanWithinItoX() {
    String expected = romanNumeral.toRoman(1);
    Assertions.assertEquals(expected,"The equivalent roman number for 1 is I.");

}

    @Test
    public void checkToRomanIV()  {
        String expected = romanNumeral.toRoman(4);
        Assertions.assertEquals(expected,"The equivalent roman number for 4 is IV.");

    }

    @Test
    public void checkToRomanVI()  {
        String expected = romanNumeral.toRoman(6);
        Assertions.assertEquals(expected,"The equivalent roman number for 6 is VI.");

    }

    @Test
    public void checkToRomanAbove100()  {
        String expected = romanNumeral.toRoman(409);
        Assertions.assertEquals(expected,"The equivalent roman number for 409 is CDIX.");

    }

    @Test
    public void checkToRomanAbove1000()  {
        String expected = romanNumeral.toRoman(1405);
        Assertions.assertEquals(expected,"The equivalent roman number for 1405 is MCDV.");

    }

    @Test
    public void checkToRomanAbove10()  {
        String expected = romanNumeral.toRoman(20);
        Assertions.assertEquals(expected,"The equivalent roman number for 20 is XX.");

    }

    @Test
    public void checkToRomanHugeValueMMMDCCXXIV()  {
        String expected = romanNumeral.toRoman(3724);
        Assertions.assertEquals(expected,"The equivalent roman number for 3724 is MMMDCCXXIV.");

    }

    @Test
    public void checkFromRomanWithWrongValue(){
        int expected = romanNumeral.fromRoman("ST");
        Assertions.assertEquals(expected,0);

    }

    @Test
    public void checkFromRomanWithin1to10(){
        int expected = romanNumeral.fromRoman("I");
        Assertions.assertEquals(expected,1);

    }

    @Test
    public void checkFromRomanFour()  {
        int expected = romanNumeral.fromRoman("IV");
        Assertions.assertEquals(expected,4);

    }

    @Test
    public void checkFromRomanSix()  {
        int expected = romanNumeral.fromRoman("VI");
        Assertions.assertEquals(expected,6);

    }

    @Test
    public void checkFromRomanAbove10() {
        int expected = romanNumeral.fromRoman("XX");
        Assertions.assertEquals(expected,20);

    }

    @Test
    public void checkFromRomanAbove100()  {
        int expected = romanNumeral.fromRoman("CDIX");
        Assertions.assertEquals(expected,409);

    }

    @Test
    public void checkFromRomanAbove1000(){
        int expected = romanNumeral.fromRoman("MCDV");
        Assertions.assertEquals(expected,1405);

    }

    @Test
    public void checkFromRomanWithHugeValue()  {
        int expected = romanNumeral.fromRoman("MMMDCCXXIV");
        Assertions.assertEquals(expected,3724);
    }

}
