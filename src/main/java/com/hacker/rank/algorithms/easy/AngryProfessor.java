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
public class AngryProfessor {

    /**
     * Function that return YES if the class is canceled based on the given k and array a.
     *
     * @param k Number of students should be present on time.
     * @param a Integer numbers representing the arrival's minutes early or late from the student classroom.
     * @return A String YES in case the class is canceled, otherwise NO is returned.
     */
    private static String angryProfessor(int k, int[] a) {

        int counter = 0;

        for (int i1 : a) {

            if (i1 <= 0)
                counter++;
        }

        return k > counter ? "YES" : "NO";
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
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {

            final int n = scanner.nextInt();
            final int k = scanner.nextInt();

            final int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            final String result = angryProfessor(k, a);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }

}
