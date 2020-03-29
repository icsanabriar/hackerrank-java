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
package com.hacker.rank.practice.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Interface given by hacker rank website.
 */
interface PerformOperation {
    boolean check(int a);
}

/**
 * Class that is provided by hacker rank website.
 */
class MyMath {

    /**
     * Function provided by hacker rank.
     *
     * @param p   Perform operation to define lambda to execute on the given number.
     * @param num Number is going to be checked.
     * @return A boolean representing the result of the performed operation.
     */
    boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    /**
     * Validate that a given number is odd.
     *
     * @return A boolean representing if a given number is odd.
     */
    PerformOperation isOdd() {
        return num -> num % 2 != 0;
    }

    /**
     * Validate that a given number is prime.
     *
     * @return A boolean representing if a given number is prime.
     */
    PerformOperation isPrime() {
        return num -> {

            for (int i = 2; i * i <= num; i++) {

                if (num % i == 0)
                    return false;
            }

            return true;
        };
    }

    /**
     * Validate that a given number is palidrome.
     *
     * @return A boolean representing if a given number is palidrome.
     */
    PerformOperation isPalindrome() {
        return num -> {

            final String value = String.valueOf(num);

            final String reverse = new StringBuilder(value)
                    .reverse()
                    .toString();

            return num == Integer.parseInt(reverse);
        };
    }
}

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author  Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since   1.0.0
 */
public class Lambda {

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws IOException Thrown when the application is not able to read or write data in console.
     */
    public static void main(String[] args) throws IOException {

        final MyMath ob = new MyMath();

        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(
                br.readLine()
        );

        PerformOperation op;
        boolean ret;
        String ans;

        while (T-- > 0) {

            final String s = br.readLine()
                    .trim();

            final StringTokenizer st = new StringTokenizer(s);

            final int ch = Integer.parseInt(
                    st.nextToken()
            );

            final int num = Integer.parseInt(
                    st.nextToken()
            );

            ans = "UNKNOWN";

            if (ch == 1) {

                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";

            } else if (ch == 2) {

                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";

            } else if (ch == 3) {

                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }

            System.out.println(ans);
        }
    }

}
