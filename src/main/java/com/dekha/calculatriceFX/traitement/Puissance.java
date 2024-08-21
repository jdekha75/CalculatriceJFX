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
public class Puissance {

    private static int p1 = 0;
    private static int p2 = 0;

    public static String traiterPuissance(String str) {

        while (!str.isBlank() && !str.isEmpty() && (str.contains("^"))) {
            int position = str.indexOf("^");

            String s = String.format("%f", pow(str, position));

            str = str.substring(0, p1) + pow(str, position) + str.substring(p2, str.length());

        }

        return str;

    }

    public static String traitePuissance(String str) {

        Pattern pattern = Pattern.compile("(\\-?\\d+(\\.\\d+)?)\\^(\\d+)@");
        Matcher matcher = pattern.matcher(str);

        while (!str.isBlank() && !str.isEmpty() && matcher.find()) {
            
            p1 = matcher.start();
            p2 = matcher.end();
            String s1 = matcher.group(1);
            String s2 = matcher.group(3);
            double mantisse = Double.valueOf(s1);
            int exposant = Integer.valueOf(s2);
            double result = Math.pow(mantisse, exposant);
            String s = String.format("%f", result);
            System.out.println(s);
            str = str.substring(0, p1) + s + str.substring(p2, str.length());
            matcher = pattern.matcher(str);
        }

        return str;
    }

    private static double pow(String str, int position) {

        String mantisse = mantisse(str, position);
        String exposant = exposant(str, position);
        double mant = 0;
        double exp = 0;

        if (mantisse != null) {
            if (mantisse.contains("(")) {
                mantisse = Parenthese.retireParenthese(mantisse);
            }
            mant = Double.valueOf(mantisse);
        }
        if (exposant != null) {
            exp = Double.valueOf(exposant);
        }

        return Math.pow(mant, exp);
    }

    private static String mantisse(String str, int position) {
        String mantisse = "";
        int parentheseOuvrante;

        if (position > 0 && str.charAt(position - 1) == ')') {
            parentheseOuvrante = Parenthese.positionOuvrante(str, position - 1);
            while (--position >= parentheseOuvrante) {
                mantisse = str.charAt(position) + mantisse;
            }
            p1 = position + 1;
        } else {
            while (--position >= 0 && (Character.isDigit(str.charAt(position)) || str.charAt(position) == '.')) {
                mantisse = str.charAt(position) + mantisse;
            }
            p1 = position + 1;
        }

        return mantisse;
    }

    private static String exposant(String str, int position) {

        String exposant = "";
        int taille;

        if (str != null && !str.isEmpty()) {

            taille = str.length();
            //while (i < taille && c != '@');
            while (++position < taille && Character.isDigit(str.charAt(position))) {
                exposant += str.charAt(position);
            }
            p2 = position + 1;
            System.out.println("p2 : " + p2 + "taille : " + taille);
        }
        return exposant;
    }
}
