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
public class Preorder {

    /**
     * Prints preorder the given tree.
     *
     * @param root Root node of the tree.
     */
    private static void preOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");

        preOrder(root.left);
        preOrder(root.right);
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

        final BinaryTree tree = new BinaryTree();

        for (int i = 0; i < n; i++) {

            final int data = sc.nextInt();
            tree.add(data);
        }

        preOrder(tree.root);

        sc.close();
    }

}
