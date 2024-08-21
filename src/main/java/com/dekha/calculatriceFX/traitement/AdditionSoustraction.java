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
public class AdditionSoustraction {

    public static String additionneSoustraire(String str) {

        double resultat = 0d;
        double res = 0d;
        int p1;
        int p2;

        String regExp = "((\\+|-)?\\d+(\\.\\d+)?([E]\\d+)?) *(-|\\+) *((\\+|-)?\\d+(\\.\\d+)?(E\\d+)?)";

//        String regExp = "(-?\\d+(\\.\\d+)?(E\\d+)?) *(-|\\+) *(-?\\d+(\\.\\d+)?(E\\d+)?)";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        System.out.println(str);
        if (!matcher.find()) {
            return str;
        }
        else {
            matcher.reset();
        }

        while (!str.isBlank() && !str.isEmpty() && matcher.find()) {
            String op1 = matcher.group(1);
            System.out.println(op1);
            String op = matcher.group(5);
            System.out.println(op);
            String op2 = matcher.group(6);
            System.out.println(op2);

            p1 = matcher.start();
            p2 = matcher.end();

            double d1 = Double.valueOf(op1);
            double d2 = Double.valueOf(op2);

            if (op.equals("+")) {
                res = d1 + d2;
            }
            else {
                res = d1 - d2;
            }

//            resultat += res;
            String s = String.format("%+9f", res);
            str = str.substring(0, p1) + s + str.substring(p2, str.length());
            System.out.println(str);
            matcher = pattern.matcher(str);

        }

        return str;
    }

//    public static double additionnerSoustraire(String str) {
//        str = str.replace("--", "+");
//        double resultat = 0;
//        char operateur = '+';
//
//        int position = 0;
//        int taille = 0;
//        if (str != null && !str.isBlank()) {
//            str = str.trim();
//            taille = str.length();
//
//        }
//
//        while (position < taille) {
//
//            String sch = "";
//
//            char c = str.charAt(position);
//            if (c == '+') {
//                position++;
//
//            } else if (c == '-') {
//                operateur = '-';
//                position++;
//
//            }
//            if (position >= taille) {
//                break;
//            }
//            c = str.charAt(position);
//            while ((c != '+') && (c != '-') && (position < taille)) {
//
//                sch += c;
//                position++;
//                if (position < taille) {
//                    c = str.charAt(position);
//                }
//
//            }
//
//            //if (position < taille)
//            System.out.println(sch);
//
//            double chiffre = Double.parseDouble(sch);
//            System.out.println(chiffre);
//
//            if (operateur == '+') {
//                resultat += chiffre;
//            } else {
//                resultat -= chiffre;
//            }
//
//            operateur = c;
//            position++;
//
//        }
//        return resultat;
//    }
}
