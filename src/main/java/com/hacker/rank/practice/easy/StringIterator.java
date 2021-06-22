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
package com.hacker.rank.practice.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.0.0
 */
public class StringIterator {

    /**
     * Function given by hacker rank to update.
     *
     * @param myList List instance to iterate according to problem specifications.
     * @return Iterator after the first instance of string is found.
     */
    private static Iterator func(ArrayList myList) {

        final Iterator it = myList.iterator();

        while (it.hasNext()) {

            final Object element = it.next();

            if (element instanceof String)
                break;
        }

        return it;
    }

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {

        final ArrayList myList = new ArrayList();

        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            myList.add(sc.nextInt());
        }

        if (m > 0)
            myList.add("###");

        for (int i = 0; i < m; i++) {
            myList.add(sc.next());
        }

        final Iterator it = func(myList);

        while (it.hasNext()) {

            final String element = (String) it.next();
            System.out.println(element);
        }

        sc.close();
    }

}
