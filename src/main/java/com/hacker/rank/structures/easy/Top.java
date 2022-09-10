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

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Class to define the node in order to generate top view.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
class Node {

    /**
     * Value of the node.
     */
    int value;

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
     * @param value Value to store in the node.
     */
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

}

/**
 * Distance from the current node to the root.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
class Distance {

    /**
     * Node instance.
     */
    Node node;

    /**
     * Distance between the node and root.
     */
    Integer value;

    /**
     * Constructor of the distance using node information and distance to the root.
     *
     * @param node  Node instance distant to the node.
     * @param value Distance from the node to the root.
     */
    Distance(Node node, Integer value) {
        this.node = node;
        this.value = value;
    }

}

/**
 * Class to define binary tree.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
class BinaryTree {

    /**
     * Define root of the binary tree.
     */
    Node root;

    /**
     * Add the given value to the binary tree.
     *
     * @param value Value to add to the binary tree.
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * Add the given value using the current node.
     *
     * @param current Current node to validate in which path to add the value.
     * @param value   Value to add in the binary tree.
     * @return Node with the given value.
     */
    private Node addRecursive(Node current, int value) {

        if (current == null)
            return new Node(value);

        if (value <= current.value)
            current.left = addRecursive(current.left, value);
        else
            current.right = addRecursive(current.right, value);

        return current;
    }

}

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Top {

    /**
     * Prints the top view of the given tree.
     *
     * @param root Root node of the tree.
     */
    private static void topView(Node root) {

        if (root == null)
            return;

        final Map<Integer, Integer> cache = new TreeMap<>();

        final Queue<Distance> distances = new LinkedList<>();
        distances.add(new Distance(root, 0));

        while (!distances.isEmpty()) {

            final Distance distance = distances.poll();
            final Node node = distance.node;

            if (!cache.containsKey(distance.value))
                cache.put(distance.value, node.value);

            if (node.left != null)
                distances.add(new Distance(node.left, distance.value - 1));

            if (node.right != null)
                distances.add(new Distance(node.right, distance.value + 1));
        }

        final StringBuilder builder = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            builder.append(entry.getValue())
                    .append(" ");
        }

        final String output = builder.substring(0, builder.length() - 1);
        System.out.println(output);
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

        topView(tree.root);

        sc.close();
    }

}
