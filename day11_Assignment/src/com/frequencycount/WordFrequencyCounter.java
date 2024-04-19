package com.frequencycount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
public class WordFrequencyCounter {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the value of N : ");
        int n=sc.nextInt();
        sc.nextLine();

        Map<String,Integer> wordfrequencymap=new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt")))
        {
            String line;
            while((line=reader.readLine())!=null)
            {
                String[] words=line.split("\\s+");
                for(String word:words)
                {
                    String normalizedWord=word.toLowerCase();
                    wordfrequencymap.put(normalizedWord,wordfrequencymap.getOrDefault(normalizedWord,0)+1);

                }
            }
        }

        catch(IOException e)
        {
            System.err.println("error reading the file : "+e.getMessage());
            return;
        }
       }

    }
}
