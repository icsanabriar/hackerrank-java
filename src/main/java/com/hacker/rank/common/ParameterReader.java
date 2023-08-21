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
package com.hacker.rank.common;

import java.util.Scanner;

/**
 * Class that is responsible of abstracting duplicate code to read inputs of given problems on hacker rank.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class ParameterReader {

    /**
     * Scanner instance used to read input from console.
     */
    private final Scanner scanner;

    /**
     * Parameter given as problem input.
     */
    private int k;

    /**
     * Array of integers given as problem input.
     */
    private int[] a;

    /**
     * Constructor of reader to read set of integers.
     *
     * @param scanner Scanner instance created a main functions.
     */
    public ParameterReader(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Reads an set of integers based on 3 parts.
     * <p>
     * - N - Size of array.
     * - K - Parameter to process.
     * - A - Array of integers with size N.
     */
    public void readIntParams() {

        final int n = scanner.nextInt();

        this.k = scanner.nextInt();
        this.a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
    }

    /**
     * Retrieves the second parameter capture after reading N.
     *
     * @return Integer capture after N.
     */
    public int getK() {
        return k;
    }

    /**
     * Retrieves array of integers read with the given scanner.
     *
     * @return Array of integers.
     */
    public int[] getA() {
        return a;
    }

}
