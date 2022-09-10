/*
 * Copyright (C) 2020 Iván Camilo Sanabria.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hacker.rank.practice.easy;

import java.util.Scanner;

/**
 * Class that is provided by hacker rank website.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
class MyCalculator {

    /**
     * Function that is calculates the power p of the given number n.
     *
     * @param n Number to estimate the power.
     * @param p Power value to calculate over the given n.
     * @return Number representing the power of the given n.
     * @throws Exception Thrown when n or p are equal or less than 0.
     */
    long power(int n, int p) throws Exception {

        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }

        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }

        long result = 1;

        for (int i = 0; i < p; i++) {
            result = result * n;
        }

        return result;
    }

}

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class Handler {

    /**
     * Define calculator instance to invoke power function.
     */
    private static final MyCalculator calculator = new MyCalculator();

    /**
     * Define scanner to read information from console.
     */
    private static final Scanner in = new Scanner(System.in);

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    @SuppressWarnings("ThrowablePrintedToSystemOut")
    public static void main(String[] args) {

        while (in.hasNextInt()) {

            final int n = in.nextInt();
            final int p = in.nextInt();

            try {

                final long power = calculator.power(n, p);
                System.out.println(power);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        in.close();
    }

}
