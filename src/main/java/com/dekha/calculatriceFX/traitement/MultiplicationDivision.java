/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dekha.calculatriceFX.traitement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author linux
 */
public class MultiplicationDivision {

    private static int p1 = 0;
    private static int p2 = 0;

    public static String multuplieDivise(String str) {
        double res = 0d;
        int p1;
        int p2;

        String regExp = "(([+\\-])?\\d+(\\.\\d+)?([Ee]\\+?\\d+)?) *([/*]) *(([+\\-])?\\d+(\\.\\d+)?(E\\d+)?)";
        String regExp2 = "(-?\\d+(\\.\\d+)?(E\\d+)?)";

        //String regExp = "(-?\\d+(\\.\\d+)?)(/|\\*)(-?\\d+(\\.\\d+)?)";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);

        if (!matcher.find()) {
            return str;
        }
        else {
            matcher.reset();
        }

        while (!str.isBlank() && matcher.find()) {
            String op1 = matcher.group(1);

            String op = matcher.group(5);
            String op2 = matcher.group(6);

            p1 = matcher.start();
            p2 = matcher.end();

            double d1 = Double.valueOf(op1);
            double d2 = Double.valueOf(op2);

            if (op.equals("*")) {
                res = d1 * d2;
            }
            else {
                res = d1 / d2;
            }

//            resultat += res;
            String s = String.format("%+9f", res);
            str = str.substring(0, p1) + s + str.substring(p2);
            matcher = pattern.matcher(str);

        }
        System.out.println(str);
        return str;
    }

    public static String traiter(String str) {

        while (!str.isBlank() && (str.contains("/") || str.contains("*"))) {
            str = str.replace("--", "+");
            str = str.replace("-+", "-");
            str = str.replace("+-", "-");
            String s;
            int i1 = str.indexOf('/');
            int i2 = str.indexOf('*');

            if (i1 < 0) {
                i1 = Integer.MAX_VALUE;
            }
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }

            int positionMin = Math.min(i1, i2);
            s = String.format("%f", traiter(str, positionMin));

            str = str.substring(0, p1) + s + str.substring(p2, str.length());

        }
        return str;
    }

    private static double traiter(String str, int position) {

        char c = str.charAt(position);

        //int pos = Integer.min((int) (Math.abs(pos1)), (int) (Math.abs(pos2)));
        double op1 = operande1(str, position);
        double op2 = operande2(str, position);

        double result = 0;

        switch (c) {
            case '*':
                result = multiplier(op1, op2);
                break;

            case '/':
                result = diviser(op1, op2);
                break;

        }
        return result;
    }

    private static double operande1(String str, int position) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String s = "";
        char c = 0;

        do {
            position--;

            if (position >= 0 && !str.isEmpty()) {
                c = str.charAt(position);

                if (Character.isDigit(c) || c == '.' || c == ',') {
                    s = c + s;
                }
            }

        } while (position >= 0 && (Character.isDigit(c) || c == '.' || c == ','));

        p1 = position + 1;

        System.out.println("op1 : " + s);
        if (!s.isEmpty()) {
            return Double.parseDouble(s);
        }
        else {
            return 0.0;
        }
    }

    private static double operande2(String str, int position) {

        String s = "";
        char c = 0;
        int signeMoins = 0;
        do {
            position++;

            if (position < str.length() && !str.isEmpty()) {

                c = str.charAt(position);

                if (Character.isDigit(c) || c == '-' || c == '.' || c == ',') {

                    if (c == '-' && s.isEmpty()) {
                        s += c;
                        signeMoins++;
                    }
                    else if ((c == '-') && !s.isEmpty()) {

                        signeMoins++;
                        signeMoins++;
                    }
                    else {
                        s += c;
                    }

                }
            }
        } while (signeMoins < 2 && position < str.length() && (Character.isDigit(c) || c == '-' || c == '-' || c == '.' || c == ','));

        //p2 = Integer.min(str.length() - 1, position);
        p2 = position;
        System.out.println("op2 : " + s);
        if (!s.equals("")) {
            return Double.parseDouble(s);
        }
        else {
            return 0.0;
        }

    }

    private static double multiplier(double op1, double op2) {
        return op1 * op2;
    }

    private static double diviser(double op1, double op2) {
        return op1 / op2;
    }
}
