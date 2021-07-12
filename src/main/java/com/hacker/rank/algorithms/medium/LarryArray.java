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
package com.hacker.rank.algorithms.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class LarryArray {

    /**
     * Return YES in case the given array A is sorted by the premises specify on the problem, otherwise the function
     * returns NO.
     *
     * @param A Sequence of numbers to sort.
     * @return String representing if the array could be sorted or not.
     */
    private static String larrysArray(final List<Integer> A) {

        for (int i = 0; i < A.size(); i++) {

            int index = A.indexOf(i + 1);

            while (index >= i + 2) {

                A.set(index, A.get(index - 1));
                A.set(index - 1, A.get(index - 2));
                A.set(index - 2, i + 1);

                index = index - 2;
            }

            if (index == i + 1) {

                if (index == A.size() - 1)
                    return "NO";

                A.set(index, A.get(index + 1));
                A.set(index + 1, A.get(index - 1));
                A.set(index - 1, i + 1);
            }
        }

        return "YES";
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        final BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH")));

        final int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {

            final int n = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            final String[] ATemp = bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" ");

            final List<Integer> A = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                final int AItem = Integer.parseInt(ATemp[i]);
                A.add(AItem);
            }

            final String result = larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

}
