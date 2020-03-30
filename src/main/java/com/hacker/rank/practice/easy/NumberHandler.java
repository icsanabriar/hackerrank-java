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
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class NumberHandler {

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = ": ";

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        try {

            final int x = scanner.nextInt();
            final int y = scanner.nextInt();

            final int z = x / y;

            System.out.println(z);

        } catch (Throwable t) {

            String message = t.getClass()
                    .getName();

            if (t instanceof ArithmeticException) {
                message = message + SEPARATOR + t.getMessage();
            }

            System.out.println(message);
        }

        scanner.close();
    }

}
