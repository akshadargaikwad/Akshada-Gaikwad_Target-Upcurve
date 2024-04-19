package com.primefactorization;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorizationTest {

    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n < 2) {
            throw new IllegalArgumentException("Input should be greater than or equal to 2.");
        }
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    @Test
    public void testPrimeFactors() {
        // Testing with prime numbers
        assertEquals(Arrays.asList(2), primeFactors(2));
        assertEquals(Arrays.asList(3), primeFactors(3));
        assertEquals(Arrays.asList(5), primeFactors(5));
        assertEquals(Arrays.asList(7), primeFactors(7));
        assertEquals(Arrays.asList(11), primeFactors(11));

        // Testing with composite numbers
        assertEquals(Arrays.asList(2, 2, 3), primeFactors(12));
        assertEquals(Arrays.asList(2, 2, 2, 3), primeFactors(24));
        assertEquals(Arrays.asList(3, 5), primeFactors(15));
        assertEquals(Arrays.asList(2, 2, 7), primeFactors(28));

        // Testing with a number that has only one prime factor
        assertEquals(Arrays.asList(17), primeFactors(17));

        // Testing with negative numbers (since prime factors are positive, the result should be the same as positive)
        assertEquals(Arrays.asList(2, 3, 5), primeFactors(-30));
        assertEquals(Arrays.asList(2, 7), primeFactors(-56));

        // Testing with zero and one
        try {
            primeFactors(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Pass
        }
        try {
            primeFactors(1);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Pass
        }
    }
}

