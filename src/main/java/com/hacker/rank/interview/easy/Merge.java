/*
 * Copyright (C) 2023 Iván Camilo Sanabria.
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
package com.hacker.rank.interview.easy;

import com.hacker.rank.structures.easy.Merge.SinglyLinkedList;
import com.hacker.rank.structures.easy.Merge.SinglyLinkedListNode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.4.0
 */
public class Merge {

    /**
     * Merge the given list maintaining the order of the values.
     *
     * @param head1 Head of the first linked list.
     * @param head2 Head of the second linked list.
     * @return Single linked list node with the head of the merge result.
     */
    private static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode result = new SinglyLinkedListNode(0);
        SinglyLinkedListNode temp = result;

        while (head1 != null && head2 != null) {

            if (head1.getData() < head2.getData()) {
                temp.setNext(head1);
                head1 = head1.getNext();
            } else {
                temp.setNext(head2);
                head2 = head2.getNext();
            }

            temp = temp.getNext();
        }

        if (head1 != null)
            temp.setNext(head1);
        else
            temp.setNext(head2);

        return result.getNext();
    }

    /**
     * Print single linked list using the given node, separator and writer instance.
     *
     * @param node   Head node of the list to start printing the list.
     * @param writer Buffer writer instance used to write the linked list data.
     * @throws IOException Thrown when the application is not able to write data in the OUTPUT_PATH.
     */
    private static void printSinglyLinkedList(SinglyLinkedListNode node, BufferedWriter writer) throws IOException {

        while (node != null) {
            writer.write(String.valueOf(node.getData()));

            node = node.getNext();

            if (node != null)
                writer.write(" ");

        }
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

                    final int list1Count = Integer.parseInt(
                            bufferedReader.readLine()
                                    .trim());

                    SinglyLinkedList list1 = com.hacker.rank.structures.easy.Merge.readLinkedList(bufferedReader, list1Count);

                    final int list2Count = Integer.parseInt(
                            bufferedReader.readLine()
                                    .trim());

                    SinglyLinkedList list2 = com.hacker.rank.structures.easy.Merge.readLinkedList(bufferedReader, list2Count);


                    SinglyLinkedListNode list3 = mergeLists(list1.getHead(), list2.getHead());

                    printSinglyLinkedList(list3, bufferedWriter);
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
