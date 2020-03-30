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
package com.hacker.rank.algorithms.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class Append {

    /**
     * Function that return YES if the given string s could be converted to string t on the given k-steps.
     *
     * @param s String that is going to be converted.
     * @param t String that is the target of the transformation.
     * @param k Number of allow steps to append or last characters.
     * @return A String with value YES or NO given the result of the transformation.
     */
    private static String appendAndDelete(String s, String t, int k) {

        if ( k >= s.length() + t.length())
            return "Yes";

        int index = s.length();

        while (index > 0) {

            final String prefix = s.substring(0, index);

            if (t.startsWith(prefix)) {

                final int operations = (s.length() - index) + (t.length() - index);

                return operations <= k && (k - operations) % 2 == 0 ? "Yes": "No";
            }
            index--;
        }

        return "No";
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        final Scanner scanner = new Scanner(System.in);
        final FileWriter fileWriter = new FileWriter(System.getenv("OUTPUT_PATH"));
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        final String s = scanner.nextLine();
        final String t = scanner.nextLine();
        final int k = scanner.nextInt();

        final String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

}
