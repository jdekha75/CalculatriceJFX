/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dekha.calculatriceFX.traitement;

import com.dekha.calculatriceFX.controleur.ControleurCalcul;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author linux
 */
public class Parenthese {

    private static int p1 = 0;
    private static int p2 = 0;

    public static String retireParenthese(String str) {

        if (!str.isEmpty()) {

            str = str.trim();
//            str = str.replace(" ", "");
//            str = str.replace("\t", "");
            str = str.replace('x', '*');
            str = str.replace('×', '*');
            str = str.replace('÷', '/');
            str = str.replace('−', '-');
//            str = str.replace("−−", "+");
//            str = str.replace("+−", "-");
//            str = str.replace("−+", "-");
            str = str.replace(",", ".");

            //str = str.replace(' ', '-');
            str = str.replace(',', '.');

            Pattern pattern = Pattern.compile("\\(([^(]+?)\\)");
            Matcher matcher = pattern.matcher(str);

            while (!str.isBlank() && !str.isEmpty() && matcher.find()) {

                p1 = matcher.start();
                p2 = matcher.end();
                String s = matcher.group(1);
                s = ControleurCalcul.traite(s) + "";
                str = str.substring(0, p1) + s + str.substring(p2, str.length());
                matcher = pattern.matcher(str);
            }

        }
        return str;
    }

    public static String retirerParenthese(String str) {

        if (!str.isEmpty()) {

            str = str.trim();
            str = str.replace(" ", "");
            str = str.replace("\t", "");
            str = str.replace('x', '*');
            str = str.replace('×', '*');
            str = str.replace('÷', '/');
            str = str.replace('−', '-');
            str = str.replace("−−", "+");
            str = str.replace("+−", "-");
            str = str.replace("−+", "-");
            str = str.replace(",", ".");

            //str = str.replace(' ', '-');
            str = str.replace(',', '.');

        }

        while (str.contains("(") && str.contains(")")) {

            int lastOuvr = str.lastIndexOf('(');
            int firstFerm = str.indexOf(')', lastOuvr);

            String s = str.substring(lastOuvr + 1, firstFerm);
            str = str.substring(0, lastOuvr) + ControleurCalcul.traite(s) + str.substring(firstFerm + 1);
        }

        if (str.contains("(") || str.contains(")")) {

            int position = Integer.max(str.indexOf('('), str.indexOf(')'));
            throw new IllegalArgumentException("manque " + position);
        }

        // double result = traiter(str);
        //str = String.format("%,.4g", result);
        return str;
    }

    public static int positionFermante(String str, int i) {

        int position = i;
        int flag = 1;
        while (++i < str.length() && flag != 0) {
            if (str.charAt(i) == ')') {
                position = i;
                flag--;
            }
            else if (str.charAt(i) == '(') {
                flag++;
                positionFermante(str, i);
            }

        }
        if (flag == 0) {
            return position;
        }
        else {
            return -1;
        }
    }

    public static int positionOuvrante(String str, int i) {

        int position = i;
        int flag = 1;
        while (--i >= 0 && flag != 0) {
            if (str.charAt(i) == '(') {
                position = i;
                flag--;
            }
            else if (str.charAt(i) == ')') {
                flag++;
                positionFermante(str, i);
            }

        }
        if (flag == 0) {
            return position;
        }
        else {
            return -1;
        }
    }
}
