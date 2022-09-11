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
package com.hacker.rank.structures.easy;

import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Insert {

    /**
     * Add the given value using the current node.
     *
     * @param current Current node to validate in which path to add the value.
     * @param value   Value to add in the binary tree.
     * @return Node with the given value.
     */
    private static Node insert(Node current, int value) {

        if (current == null)
            return new Node(value);

        if (value <= current.value)
            current.left = insert(current.left, value);
        else
            current.right = insert(current.right, value);

        return current;
    }

    /**
     * Prints the given binary tree.
     *
     * @param node Node of the tree.
     */
    private static void printTree(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();

        Node root = null;

        for (int i = 0; i < n; i++) {

            final int data = sc.nextInt();
            root = insert(root, data);
        }

        printTree(root);

        sc.close();
    }

}
