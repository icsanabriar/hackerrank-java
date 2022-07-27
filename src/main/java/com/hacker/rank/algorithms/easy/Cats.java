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
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class Cats {

    /**
     * Return which Cat of the given 2 is going to catch the mouse. In case there is a tie, the mouse is going to scape.
     *
     * @param x Position of the first cat.
     * @param y Position of the second cat.
     * @param z Position of the mouse.
     * @return A String representing the cat that catch the mouse, or the mouse string in case of scape.
     */
    private static String catAndMouse(int x, int y, int z) {

        final int dxz = Math.abs(x - z);
        final int dyz = Math.abs(y - z);

        if (dxz == dyz)
            return "Mouse C";

        return dxz < dyz ? "Cat A" : "Cat B";
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

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            final int q = scanner.nextInt();

            for (int qItr = 0; qItr < q; qItr++) {

                final int x = scanner.nextInt();
                final int y = scanner.nextInt();
                final int z = scanner.nextInt();

                final String result = catAndMouse(x, y, z);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }

        }

        scanner.close();
    }

}
