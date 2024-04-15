package com.fileanalyzer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class TextFileAnalyzer {

    public static String findLongestLine(String[] lines)
    {
        String longestline="";
        for(String s:lines)
        {
            if(s.length()>longestline.length())
            {
                longestline=s;
            }
        }

        return longestline;
    }


    public static String findShortestLine(String[] lines)
    {
        String shortline=lines[0];
        for(String line:lines)
        {
            if(line.length()<shortline.length())
            {
                shortline=line;
            }
        }
        return shortline;
    }

    public static int[] countWords(String[] lines)
    {
        int[] wordcounts=new int[lines.length];
        for(int i=0;i<lines.length;i++)
        {
            String[] words=lines[0].split("\\s+");
            wordcounts[i]=words.length;
        }

        return wordcounts;
    }


    public static void sortWordCount(int[] wordcounts)
    {
        Arrays.sort(wordcounts);
        reverseArray(wordcounts);
    }

    private static void reverseArray(int[] arr)
    {
        int start=0;
        int end=arr.length-1;
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            start++;
            end--;
        }
    }


    public static String readFile(String filename) throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(filename));
        String line;
        StringBuilder contentBuilder=new StringBuilder();
        while((line=reader.readLine())!=null)
        {
            contentBuilder.append(line).append("\n");
        }

        reader.close();
        String[] lines=contentBuilder.toString().split("\n");
        return line;
    }

    public static void main(String[] args)
    {
        String filename="example.txt";
        try{
            String[] lines=readFile(filename);
            String longestline=findLongestLine(lines);
            String shortestLine=findShortestLine(lines);
            int[] wordcounts=countWords(lines);
            sortWordCount(wordcounts);

            System.out.println("contents of the file : ");
            for(int i=0;i<lines.length;i++)
            {
                System.out.println("Line "+(i+1)+"  : "+lines[i]);
            }

            System.out.println("Longest Line : ");
            System.out.println(longestline);

            System.out.println("Shortest Line : ");
            System.out.println(shortestLine);

            System.out.println("word count for each lines : ");
            for(int i=0;i<lines.length;i++)
            {
                System.out.println("Line "+(i+1)+ " : "+wordcounts[i]+ " words");


            }

            System.out.println("sorted wordcount : ");
            for(int count:wordcounts)
            {
                System.out.println(count+" words");
            }




        }
        catch(IOException e)
        {
            System.err.println("error reading the file : "+e.getMessage());
    }
    }
}
