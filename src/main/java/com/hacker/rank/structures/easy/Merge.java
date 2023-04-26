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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Merge {

    /**
     * Given node class.
     */
    public static class SinglyLinkedListNode {

        /**
         * Data of the node.
         */
        private int data;

        /**
         * Next node of the list.
         */
        private SinglyLinkedListNode next;

        /**
         * Constructor of the linked list.
         *
         * @param nodeData Data of the node.
         */
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        /**
         * Retrieves the data of the node.
         *
         * @return Data of the node.
         */
        public int getData() {
            return data;
        }

        /**
         * Retrieve the next node of the linked list.
         *
         * @return Next node of the linked list.
         */
        public SinglyLinkedListNode getNext() {
            return next;
        }

        /**
         * Set the next node of the linked list.
         *
         * @param next Next node of the linked list.
         */
        public void setNext(SinglyLinkedListNode next) {
            this.next = next;
        }
    }

    /**
     * Given linked list class.
     */
    public static class SinglyLinkedList {

        /**
         * Head of the linked list.
         */
        private SinglyLinkedListNode head;

        /**
         * Tail of the linked list.
         */
        private SinglyLinkedListNode tail;

        /**
         * Constructor of the linked list.
         */
        SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        /**
         * Inset the given node data into the list.
         *
         * @param nodeData Data to insert in the list.
         */
        void insertNode(int nodeData) {

            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }

        /**
         * Retrieves the head of the linked list.
         *
         * @return Head of the linked list.
         */
        public SinglyLinkedListNode getHead() {
            return head;
        }
    }

    /**
     * Build a stack using the given linked list head.
     *
     * @param head Head of linked list.
     * @return Stack of nodes present in the linked list.
     */
    private static Stack<SinglyLinkedListNode> buildStack(SinglyLinkedListNode head) {

        final Stack<SinglyLinkedListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        return stack;
    }

    /**
     * Find the merge node of the given linked lists.
     *
     * @param head1 Head of the first list.
     * @param head2 Head of the second list.
     * @return Data of the merge node of the given lists.
     */
    private static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        final Stack<SinglyLinkedListNode> stack1 = buildStack(head1);
        final Stack<SinglyLinkedListNode> stack2 = buildStack(head2);

        SinglyLinkedListNode merge = null;

        while (!stack1.isEmpty() && stack1.peek() == stack2.peek()) {
            merge = stack1.pop();
            stack2.pop();
        }

        return merge.data;
    }

    /**
     * Read the linked list using the given buffer and number of elements.
     *
     * @param bufferedReader Reader used to read data of the list.
     * @param size           Size of the list.
     * @return Linked list instance with the read data.
     * @throws IOException Thrown when there is a problem reading the data of the list.
     */
    public static SinglyLinkedList readLinkedList(BufferedReader bufferedReader, int size) throws IOException {

        SinglyLinkedList list = new SinglyLinkedList();

        for (int j = 0; j < size; j++) {

            final int item = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            list.insertNode(item);
        }

        return list;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in the OUTPUT_PATH.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            final int t = Integer.parseInt(
                    bufferedReader.readLine()
                            .trim());

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                for (int i = 0; i < t; i++) {

                    final int index = Integer.parseInt(
                            bufferedReader.readLine()
                                    .trim());

                    final int llist1Count = Integer.parseInt(
                            bufferedReader.readLine()
                                    .trim());

                    SinglyLinkedList llist1 = readLinkedList(bufferedReader, llist1Count);

                    final int llist2Count = Integer.parseInt(
                            bufferedReader.readLine()
                                    .trim());

                    SinglyLinkedList llist2 = readLinkedList(bufferedReader, llist2Count);

                    SinglyLinkedListNode ptr1 = llist1.head;
                    SinglyLinkedListNode ptr2 = llist2.head;

                    for (int j = 0; j < llist1Count; j++) {
                        if (j < index) {
                            ptr1 = ptr1.next;
                        }
                    }

                    for (int j = 0; j < llist2Count; j++) {
                        if (j != llist2Count - 1) {
                            ptr2 = ptr2.next;
                        }
                    }

                    ptr2.next = ptr1;

                    final int result = findMergeNode(llist1.head, llist2.head);

                    bufferedWriter.write(
                            String.valueOf(result));

                    bufferedWriter.newLine();
                }
            }
        }
    }

}
