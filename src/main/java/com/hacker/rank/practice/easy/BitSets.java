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

import java.util.BitSet;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class BitSets {

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int M = scanner.nextInt();

        final BitSet[] bitSets = new BitSet[2];

        for (int i = 0; i < bitSets.length; i++) {
            bitSets[i] = new BitSet(N);
        }

        for (int i = 0; i < M; i++) {

            final String operation = scanner.next();
            final int set = scanner.nextInt() - 1;
            final int setOrIndex = scanner.nextInt();

            if ("AND".equals(operation)) {
                bitSets[set].and(bitSets[setOrIndex - 1]);

            } else if ("OR".equals(operation)) {
                bitSets[set].or(bitSets[setOrIndex - 1]);

            } else if ("XOR".equals(operation)) {
                bitSets[set].xor(bitSets[setOrIndex - 1]);

            } else if ("FLIP".equals(operation)) {
                bitSets[set].flip(setOrIndex);

            } else if ("SET".equals(operation)) {
                bitSets[set].set(setOrIndex);
            }

            final String result = bitSets[0].cardinality() + " " +
                    bitSets[1].cardinality();

            System.out.println(result);
        }

        scanner.close();
    }

}
