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
public class LCA {

    /**
     * Search the common ancestor of v1 and v2 on the given binary tree.
     *
     * @param root Root node of the tree.
     * @param v1   First value to find common ancestor.
     * @param v2   Second value to find common ancestor.
     * @return Node instance representing the common ancestor.
     */
    private static Node lca(Node root, int v1, int v2) {

        if (root.value < v1 && root.value < v2)
            return lca(root.right, v1, v2);

        if (root.value > v1 && root.value > v2)
            return lca(root.left, v1, v2);

        return root;
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

        final int v1 = sc.nextInt();
        final int v2 = sc.nextInt();

        final Node result = lca(tree.root, v1, v2);
        System.out.println(result.value);
    }

}
