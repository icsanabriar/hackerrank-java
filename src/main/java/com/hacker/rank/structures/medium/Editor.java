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
package com.hacker.rank.structures.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Editor {

    /**
     * Regex used to process input of the program.
     */
    private static final String REGEX = "\\s+$";

    /**
     * Separator of values in same line.
     */
    private static final String SEPARATOR = " ";

    /**
     * Replacement of value inline.
     */
    private static final String REPLACEMENT = "";

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int q = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            final Stack<String> operations = new Stack<>();

            String s = "";

            for (int i = 0; i < q; i++) {

                final String[] arrTemp = bufferedReader.readLine()
                        .replaceAll(REGEX, REPLACEMENT)
                        .split(SEPARATOR);

                final int type = Integer.parseInt(arrTemp[0]);

                switch (type) {
                    case 1:
                        operations.push(s);
                        s = s + arrTemp[1];
                        break;
                    case 2:
                        operations.push(s);
                        int k = Integer.parseInt(arrTemp[1]);
                        s = s.substring(0, s.length() - k);
                        break;
                    case 3:
                        int index = Integer.parseInt(arrTemp[1]);
                        System.out.println(s.charAt(index - 1));
                        break;
                    case 4:
                        s = operations.pop();
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
