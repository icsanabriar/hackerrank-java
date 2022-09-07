/*
 * Copyright (C) 2022 Iván Camilo Sanabria.
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
package com.hacker.rank.math.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.4.0
 */
public class Easy {

    /**
     * Solve return the final value 2 * a + b.
     *
     * @param x Number to transform based on 4 and 0.
     * @return Number representing the value of 2 * a + b.
     */
    private static int solve(int x) {

        int exp2 = 0;

        while (x % 2 == 0) {
            exp2++;
            x = x / 2;
        }

        int exp5 = 0;

        while (x % 5 == 0) {
            exp5++;
            x = x / 5;
        }

        int b = Math.max(exp2 - 2, exp5);
        int a = 1;
        int remainder = 1 % x;

        while (remainder != 0) {
            remainder = (remainder * 10 + 1) % x;
            a++;
        }

        return 2 * a + b;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                final int t = Integer.parseInt(bufferedReader.readLine().trim());

                for (int i = 0; i < t; i++) {

                    final int x = Integer.parseInt(bufferedReader.readLine().trim());

                    final String result = String.valueOf(solve(x));

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
