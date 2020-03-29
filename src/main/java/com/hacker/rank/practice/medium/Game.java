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
package com.hacker.rank.practice.medium;

import com.hacker.rank.common.ParameterReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class Game {

    /**
     * Function given by hacker rank to complete. The function returns a boolean that defines if the game could
     * be won or not.
     *
     * @param leap Number of steps a user could take from the current index.
     * @param game Array with 0 and 1 defined if a user could land in specific index.
     * @return A boolean representing if the user could win the game or not.
     */
    private static boolean canWin(int leap, int[] game) {

        final boolean[] cache = new boolean[game.length];

        final Queue<Integer> nextJumps = new LinkedList<>();
        nextJumps.add(0);

        while (!nextJumps.isEmpty()) {

            final int currentIndex = nextJumps.poll();

            if (currentIndex >= game.length)
                return true;

            if (currentIndex >= 0 && game[currentIndex] == 0 && !cache[currentIndex]) {

                nextJumps.add(currentIndex + leap);
                nextJumps.add(currentIndex + 1);
                nextJumps.add(currentIndex - 1);

                cache[currentIndex] = true;
            }
        }

        return false;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        final Scanner scan = new Scanner(System.in);
        final ParameterReader parameterReader = new ParameterReader(scan);

        int q = scan.nextInt();

        while (q-- > 0) {

            parameterReader.readIntParams();

            System.out.println(
                    (canWin(
                            parameterReader.getK(),
                            parameterReader.getA()
                    )) ? "YES" : "NO"
            );
        }

        scan.close();
    }

}
