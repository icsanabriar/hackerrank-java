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

/**
 * Class to define the node in order to create binary tree.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
class Code {

    /**
     * Frequency of the character.
     */
    int frequency;

    /**
     * Data of the node.
     */
    char data;

    /**
     * Node on the left path.
     */
    Code left;

    /**
     * Node on the right path.
     */
    Code right;

    /**
     * Constructor of the node using the given frequency value.
     *
     * @param frequency Value to store in as frequency in the node.
     */
    Code(int frequency) {
        this.frequency = frequency;
    }

}

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
class Decoder {

    /**
     * Print the decoded string based on the given tree.
     *
     * @param s    String given to decode.
     * @param root Binary tree given with the frequency to decode the string.
     */
    void decode(String s, Code root) {

        Code node = root;

        for (char c : s.toCharArray()) {

            if (c == '0')
                node = node.left;
            else
                node = node.right;

            if (node.data != 0) {
                System.out.print(node.data);
                node = root;
            }
        }
    }

}
