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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * FamilyBudget annotation given hacker rank.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
    String userRole() default "GUEST";
    int budgetLimit();
}

/**
 * FamilyMember class given by hacker rank.
 */
@SuppressWarnings("unused")
class FamilyMember {

    /**
     * Senior member function prints the information of senior roles, taking into account the budget.
     *
     * @param budget     Budget of the senior member.
     * @param moneySpend Money specific member spent.
     */
    @FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
    public void seniorMember(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }

    /**
     * Junior user function prints the information of junior roles, taking into account the budget.
     *
     * @param budget     Budget of the senior member.
     * @param moneySpend Money specific member spent.
     */
    @FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
    public void juniorUser(int budget, int moneySpend) {
        System.out.println("Junior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }
}

/**
 * Class given by hacker rank to complete, in order to use properly FamilyBudget annotation.
 */
public class Annotation {

    /**
     * Main function provided by hacker rank website.
     *
     * @param args Arguments of the program.
     * @throws Exception Thrown when the annotation specification is not properly specified.
     */
    public static void main(String[] args) throws Exception {

        final Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(in.nextLine());

        while (testCases > 0) {

            final String role = in.next();
            final int spend = in.nextInt();

            final Class annotatedClass = FamilyMember.class;
            final Method[] methods = annotatedClass.getMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(FamilyBudget.class)) {

                    final FamilyBudget family = method.getAnnotation(FamilyBudget.class);
                    final String userRole = family.userRole();
                    final int budgetLimit = family.budgetLimit();

                    if (userRole.equals(role)) {

                        if (budgetLimit >= spend) {

                            method.invoke(
                                    FamilyMember.class
                                            .getDeclaredConstructor()
                                            .newInstance(),
                                    budgetLimit,
                                    spend);

                        } else {

                            System.out.println("Budget Limit Over");
                        }
                    }
                }
            }

            testCases--;
        }
    }

}
