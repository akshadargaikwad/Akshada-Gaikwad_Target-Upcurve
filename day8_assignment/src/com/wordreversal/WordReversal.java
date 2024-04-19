package com.wordreversal;

import static org.junit.Assert.*;
import org.junit.Test;
public class WordReversal {

    public static String reverseWords(String input)
    {
        if(input==null || input.isEmpty())
        {
            return "";
        }

        String[] words=input.split("\\s+");
        StringBuilder reversed=new StringBuilder();

        for(int i=words.length-1;i>=0;i--)
        {
           reversed.append(words[i]);
           if(i>0)
           {
               reversed.append(" ");
           }
        }

        return reversed.toString();
    }

    @Test
    public void testsingleWordInput()
    {
        assertEquals("Hello",reverseWords("Hello"));
    }

    @Test
    public void testMultipleWordsInput()
    {
        assertEquals("World Hello",reverseWords("Hello World"));
        assertEquals("test a is this",reverseWords("this is a test"));
    }

    @Test
    public void testExtraSpacesBetweenWords()
    {
        assertEquals("World Hello",reverseWords("Hello     World"));
    }

    @Test
    public void testLeadingAndTrainingSpaces()
    {
        assertEquals("World Hello", reverseWords("   Hello World "));
    }


     @Test
    public void testEmptyStringInput()
     {
         assertEquals("",reverseWords(""));
     }

     @Test
    public void testSpecialCharactersAndPunctuationMarks()
     {
         assertEquals("! @ # $ Hello World",reverseWords("World Hello $ # @ ! "));
     }

}
