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
package com.hacker.rank.regex.easy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that is executed in hacker rank website as solution.
 *
 * @author Iván Camilo Sanabria (icsanabriar@googlemail.com)
 * @since  1.3.0
 */
public class Repetition {

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {
        Validator tester = new Validator();
        tester.checker("^\\d{2,}[a-z]*[A-Z]*$");
    }

}

/**
 * Given test class on hacker rank website.
 */
class Validator {

    /**
     * Checker of the given regex pattern.
     *
     * @param pattern Pattern to validate.
     */
    void checker(String pattern){

        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        System.out.println(m.find());
    }

}
