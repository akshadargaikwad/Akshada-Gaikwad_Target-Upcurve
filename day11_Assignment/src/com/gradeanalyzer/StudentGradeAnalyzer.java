package com.gradeanalyzer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGradeAnalyzer {

    public static void main(String[] args) {
        // Read the contents of the CSV file
        List<String> lines = readFile("grades.csv");

        // Parse the CSV lines and calculate statistics
        if (lines != null && !lines.isEmpty()) {
            int totalStudents = lines.size();
            double totalGrades = 0;
            int highestGrade = Integer.MIN_VALUE;
            int lowestGrade = Integer.MAX_VALUE;
            int passedStudents = 0;

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String studentName = parts[0].trim();
                    int grade = Integer.parseInt(parts[1].trim());

                    // Calculate statistics
                    totalGrades += grade;
                    if (grade > highestGrade) {
                        highestGrade = grade;
                    }
                    if (grade < lowestGrade) {
                        lowestGrade = grade;
                    }
                    if (grade >= 60) {
                        passedStudents++;
                    }
                }
            }

            int failedStudents = totalStudents - passedStudents;

            // Calculate average grade
            double averageGrade = totalGrades / totalStudents;

            // Display the statistics
            System.out.println("Statistics:");
            System.out.println("- Average grade: " + averageGrade);
            System.out.println("- Highest grade: " + highestGrade);
            System.out.println("- Lowest grade: " + lowestGrade);
            System.out.println("- Number of students passed: " + passedStudents);
            System.out.println("- Number of students failed: " + failedStudents);
        } else {
            System.out.println("No data found in the file.");
        }
    }

    private static List<String> readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }
}
