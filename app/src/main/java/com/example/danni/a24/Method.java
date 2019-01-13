package com.example.danni.a24;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Method {

    public static String subMake(int target , int[] nums) {
        String res = "";

        int a, b, c, d;
        String[] ops = {"+", "-", "*", "/"};
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                b = nums[j];
                // Two Numbers
                if (nums.length == 2) {
                    res = findTwo(a, b, target, ops);
                    if (res != "") {
                        return res;
                    }
                    continue;
                }
                // Three Numbers
                for (int k = 0; k < nums.length; k++) {
                    if (k == i || k == j) continue;
                    c = nums[k];
                    if (nums.length == 3) {
                        res = findThree(a, b, c, target, ops);
//						System.out.println(a + " " + b + " " + c);
                        if (res != "") {
                            return res;
                        }
                        continue;
                    }
                    // Four Numbers
                    for (int l = 0; l < nums.length; l++) {
                        if (l == i || l == j || l == k) continue;
                        d = nums[l];
                        res = findFour(a, b, c, d, ops);
                        if (res != "") {
                            return res;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<String> makeAll(int target , int[] nums) {
        String res = "";
        ArrayList<String> results = new ArrayList<String>();

        int a, b, c, d;
        String[] ops = {"+", "-", "*", "/"};
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                b = nums[j];
                // Two Numbers
                if (nums.length == 2) {
                    res = findTwo(a, b, target, ops);
                    if (res != "") {
                        if(!results.contains(res))
                            results.add(res);
//						return res;
                    }
                    continue;
                }
                // Three Numbers
                for (int k = 0; k < nums.length; k++) {
                    if (k == i || k == j) continue;
                    c = nums[k];
                    if (nums.length == 3) {
                        res = findThree(a, b, c, target, ops);
                        if (res != "") {
                            if(!results.contains(res))
                                results.add(res);
//							return res;
                        }
                        continue;
                    }
                    // Four Numbers
                    for (int l = 0; l < nums.length; l++) {
                        if (l == i || l == j || l == k) continue;
                        d = nums[l];
//						System.out.println(a + " " + b + " " + c + " " + d);
                        res = findFour(a, b, c, d, ops);
                        if (res != "") {
                            if(!results.contains(res))
                                results.add(res);
//							return res;
                        }
                    }
                }
            }
        }
//		return null;
        return results;
    }

    public static String findTwo (int a, int b, int target, String[] ops) {
        String res = "";
        for (String op1: ops) {
            String calc = a + op1 + b;
            if (calculate(calc) == target) {
                res = calc;
                break;
            }
        }
        if (res == "") return null;
        return res;
    }

    public static String findThree (int a, int b, int c, int target, String[] ops) {
        String res = "";
        for (String op1: ops) {
            for (String op2: ops) {
                String calc = a + op1 + b + op2 + c;
//				System.out.println(calc);
                if (calculate(calc) == target) {
                    switch (op2) {
                        case "*": case "/":
                            res = "(" + a + op1 + b + ")" + op2 + c;
                            break;
                        default: // op2 == "+" || op2 == "-"
                            res = calc;
                            break;
                    }
                    break;
                }
            }
        }
        if (res != "") return res;

        // Checking (a op b) op (c op d)
        String[] multdiv = {"*","/"};
        String[] addminus = {"+","-"};
        for (String op1: multdiv) {
            for (String op2: addminus) {
                String right;
                right = b + op2 + c;
//					System.out.println("\t" + calc);
                int r = calculate(right);
                if (r == -9999) continue;

                right = (r < 0)? "n" + -r : r + "";
                int result = calculate(a + op1 + right);

                if (result == target) {
                    res = a + op1 +"("+ b + op2 + c +")";
                }
            }
        }
        return res;
    }

    public static String findFour (int a, int b, int c, int d, String[] ops) {
        String res = "";
        for (String op1: ops) {
            for (String op2: ops) {
                for (String op3: ops) {
                    String calc = a + op1 + b + op2 + c + op3 + d;
//					System.out.println("\t" + calc);
                    if (calculate(calc) == 24) {
                        switch (op2) {
                            case "*": case "/":
                                res = "(" + a + op1 + b + ")" + op2 + c;
                                break;
                            default: // op2 == "+" || op2 == "-"
                                res = a + op1 + b + op2 + c;
                                break;
                        }
                        switch (op3) {
                            case "*": case "/":
                                res = "(" + res + ")" + op3 + d;
                                break;
                            default: // op2 == "+" || op2 == "-"
                                res += op3 + d;
                                break;
                        }
                        break;
                    }
                }
            }
        }
        if (res != "") return res;

        // Checking (a op b) op (c op d)

        for (String op1: ops) {
            for (String op2: ops) {
                for (String op3: ops) {
                    String left, right;
                    left = a + op2 + b;
                    right = c + op3 + d;
//					System.out.println("\t" + calc);
                    int l = calculate(left);
                    int r = calculate(right);
                    if (l == -9999 || r == -9999) continue;

                    left = (l < 0)? "n" + -l : l + "";
                    right = (r < 0)? "n" + -r : r + "";
                    int result = calculate(left + op1 + right);

//					System.out.println("("+ a + op2 + b +")"+ op1 +"("+ c + op3 + d +")");
//					System.out.println("\tResult = " + l + op1 + r + " = " + result);

                    if (result == 24) {
                        res = "("+ a + op2 + b +")"+ op1 +"("+ c + op3 + d +")";
                    }
                }
            }
        }

        return res;
    }

    public static int calculate(String input) {
        int a, b, c, d, res;
        String ops = "+-*/";
        String op1, op2, op3, first, second;
        StringTokenizer st = new StringTokenizer(input, ops, true);

        first = st.nextToken();
        op1 = st.nextToken();
        second = st.nextToken();

        a = (first.charAt(0) == 'n')? Integer.parseInt(first.substring(1)) * -1 : Integer.parseInt(first.substring(0));
        b = (second.charAt(0) == 'n')? Integer.parseInt(second.substring(1)) * -1 : Integer.parseInt(second.substring(0));

        switch (op1) {
            case "+":
                res = a + b; break;
            case "-":
                res = a - b; break;
            case "*":
                res = a * b; break;
            case "/":
                if (b == 0)
                    res = -9999;
                else if (a % b == 0)
                    res = a / b;
                else res = -9999;
                break;
            default:
                return -9999;
        }

        if (!st.hasMoreTokens()) return res;
        op2 = st.nextToken();
        c = Integer.parseInt(st.nextToken());

        switch (op2) {
            case "+":
                res += c;
                break;
            case "-":
                res -= c;
                break;
            case "*":
                res *= c;
                break;
            case "/":
                if (c == 0)
                    res = -9999;
                else if (res % c == 0)
                    res /= c;
                else res = -9999;
                break;
            default:
                return -9999;
        }

        if (!st.hasMoreTokens()) return res;
        op3 = st.nextToken();
        d = Integer.parseInt(st.nextToken());

        switch (op3) {
            case "+":
                res += d;
                break;
            case "-":
                res -= d;
                break;
            case "*":
                res *= d;
                break;
            case "/":
                if (d == 0)
                    res = -9999;
                else if (res % d == 0)
                    res /= d;
                else res = -9999;
                break;
            default:
                return -9999;
        }

        return res;
    }

    public static void main(String[] args) {
//		int target = 3;
//		int[] nums= {1,4,9};
        String[] ops = {"+","-","*","/"};


//		System.out.println(subMake(target, nums));
        System.out.println(findThree(9,4,1,27, ops));
//		System.out.println(findFour(3, 4, 5, 6));
//		System.out.println(calculate("12+n1000"));
    }
}
