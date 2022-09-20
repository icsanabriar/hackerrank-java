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
class Node {

    /**
     * Data of the node.
     */
    int data;

    /**
     * Node on the left path.
     */
    Node left;

    /**
     * Node on the right path.
     */
    Node right;

    /**
     * Constructor of the node using the given value.
     *
     * @param data Value to store in the node.
     */
    Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }

}

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
class Binary {

    /**
     * Validates that the given tree is a binary search tree.
     *
     * @param root Root node of the tree.
     * @return A boolean representing if the given tree is a binary search.
     */
    boolean checkBST(Node root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Validate the given tree is a binary search tree using limits.
     *
     * @param node Root node of the tree.
     * @param min  Minimum value accepted in the tree.
     * @param max  Maximum value accepted in the tree.
     * @return A boolean representing if the given tree is a binary search.
     */
    private boolean validate(Node node, int min, int max) {

        if (node == null)
            return true;

        if (node.data < min || node.data > max)
            return false;

        return validate(node.left, min, node.data - 1) && validate(node.right, node.data + 1, max);
    }

}
