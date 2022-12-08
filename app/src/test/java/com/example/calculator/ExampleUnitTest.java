package com.example.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_removeExcessiveSpacesFromStringIsCalled_Then_NullPointerExceptionIsThrown(){
        com.example.calculator.Utils.removeExcessiveSpacesFromString(null);
    }

    //empty string
    @Test
    public void Given_EmptyString_When_removeExcessiveSpacesFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "";
        final String expectedResult = "";
        final String actualResult = com.example.calculator.Utils.removeExcessiveSpacesFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with multiple spaces
    @Test
    public void Given_StringOfMultipleEmptySpaces_When_removeExcessiveSpacesFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "   ";
        final String expectedResult = "";
        final String actualResult = com.example.calculator.Utils.removeExcessiveSpacesFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //text with multiple spaces
    @Test
    public void Given_TextString_When_removeExcessiveSpacesFromStringIsCalled_Then_StringWithoutExcessiveSpacesIsReturned(){
        final String givenString = "Poetry   of  logical ideas  ";
        final String expectedResult = "Poetry of logical ideas";
        final String actualResult = com.example.calculator.Utils.removeExcessiveSpacesFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //---removeNumbersFromString---
    //null
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_removeNumbersFromStringIsCalled_Then_NullPointerExceptionIsThrown(){
        com.example.calculator.Utils.removeNumbersFromString(null);
    }

    //empty string
    @Test
    public void Given_EmptyString_When_removeNumbersFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "";
        final String expectedResult = "";
        final String actualResult = com.example.calculator.Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with letters only
    @Test
    public void Given_String_When_removeNumbersFromStringIsCalledWithLettersOnly_Then_ReturnedInitialString(){
        final String givenString = "abc";
        final String expectedResult = "abc";
        final String actualResult = com.example.calculator.Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with letters and numbers
    @Test
    public void Given_String_When_removeNumbersFromStringIsCalledWithLettersAndNumbers_Then_ReturnedStringWithLettersOnly(){
        final String givenString = "a1b2c";
        final String expectedResult = "abc";
        final String actualResult = com.example.calculator.Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with numbers only
    @Test
    public void Given_String_When_removeNumbersFromStringIsCalledWithNumbersOnly_Then_ReturnedEmptyString(){
        final String givenString = "123";
        final String expectedResult = "";
        final String actualResult = com.example.calculator.Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }


    //---removeLettersFromString---
    //null
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_removeLettersFromStringIsCalled_Then_NullPointerExceptionIsThrown(){
        com.example.calculator.Utils.removeLettersFromString(null);
    }

    //empty string
    @Test
    public void Given_EmptyString_When_removeLettersFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "";
        final String expectedResult = "";
        final String actualResult = com.example.calculator.Utils.removeLettersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with letters only
    @Test
    public void Given_String_When_removeLettersFromStringIsCalledWithLettersOnly_Then_ReturnedEmptyString(){
        final String givenString = "abc";
        final String expectedResult = "";
        final String actualResult = com.example.calculator.Utils.removeLettersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with numbers only
    @Test
    public void Given_String_When_removeLettersFromStringIsCalledWithNumbersOnly_Then_ReturnedInitialString(){
        final String givenString = "123";
        final String expectedResult = "123";
        final String actualResult = com.example.calculator.Utils.removeLettersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with letters and numbers
    @Test
    public void Given_String_When_removeLettersFromStringIsCalledWithLettersAndNumbers_Then_ReturnedStringWithNumbersOnly(){
        final String givenString = "a1b2c3";
        final String expectedResult = "123";
        final String actualResult = com.example.calculator.Utils.removeLettersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }
}