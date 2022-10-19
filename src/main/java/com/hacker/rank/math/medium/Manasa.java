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
import java.util.HashMap;
import java.util.Map;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since 1.3.0
 */
public class Manasa {

    private static Map<Integer, Integer> countDigits(String number) {

        final Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < number.length(); i++) {
            final int digit = number.charAt(i) - '0';
            counter.put(digit, counter.getOrDefault(digit, 0) + 1);
        }

        return counter;
    }

    private static boolean allContains(Map<Integer, Integer> counter, Map<Integer, Integer> future) {

        return counter.keySet()
                .stream()
                .allMatch(d -> future.getOrDefault(d, 0) >= counter.get(d));
    }

    private static String solve(String n) {

        final Map<Integer, Integer> counts = countDigits(n);

        for (int prefix = 0; prefix < 1000; prefix += 8) {

            final String exp = "%0" + Math.min(3, n.length()) + "d";
            final String current = String.format(exp, prefix);

            if (allContains(countDigits(current), counts))
                return "YES";
        }

        return "NO";
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                final int t = Integer.parseInt(
                        bufferedReader.readLine()
                                .trim());

                for (int i = 0; i < t; i++) {

                    final String n = bufferedReader.readLine();
                    final String result = solve(n);

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
