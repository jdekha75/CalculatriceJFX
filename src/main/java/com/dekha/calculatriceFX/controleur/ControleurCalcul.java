/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.controleur;

import com.dekha.calculatriceFX.traitement.AdditionSoustraction;
import com.dekha.calculatriceFX.traitement.Fonction;
import com.dekha.calculatriceFX.traitement.MultiplicationDivision;
import com.dekha.calculatriceFX.traitement.Parenthese;
import com.dekha.calculatriceFX.traitement.Puissance;
import java.time.Duration;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author linux
 */
public class ControleurCalcul {

    private static int p1 = 0;
    private static int p2 = 0;
    private double resultat = 0;

    public ControleurCalcul() {
    }

    public static String calcule(String str) {
        str = insereCaret(str);
        str = Parenthese.retireParenthese(str);
        str = Fonction.traite(str);
        str = traite(str) + "";
        return str;
    }

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
    public static double traite(String str) {
        str = Puissance.traitePuissance(str);
        str = MultiplicationDivision.multuplieDivise(str);
        str = str.replace("--", "+");
        str = str.replace("-+", "-");
        str = str.replace("+-", "-");
        str = str.replace("−", "-");

        str = AdditionSoustraction.additionneSoustraire(str);
//        str = String.format("%f", resultat);

        return Double.valueOf(str);
    }

    /*
    Changer le typescript (puissance) par un ^

     */
    private static String insereCaret(String str) {

        int position = 0;
        int taille;

        StringBuilder strBuild = new StringBuilder();

        if (str != null && !str.isEmpty()) {
            str = str.trim();
            taille = str.length();
        }
        else {
            return null;
        }

        while (position < taille) {

            while (position < taille && !ControleurAffichage.isSupScript(str.charAt(position) + "")) {
                //while (position < taille && !Character.isDigit(str.charAt(position))) {
                strBuild.append(str.charAt(position));
                position++;
            }

            if (position < taille) {
                str = str.substring(0, position) + "^" + str.substring(position);
                strBuild.append("^");
                taille = str.length();
                position++;
            }

            String s = null;

            while (position < taille && ControleurAffichage.isSupScript(str.charAt(position) + "")) {
                //while (position < taille && Character.isDigit(str.charAt(position))) {
                char c = str.charAt(position);
                //str = str.substring(taille, taille)
                s = ControleurAffichage.getSupScript(c + "");
                strBuild.append(s);
                position++;
            }

            str = str.substring(0, position) + "@" + str.substring(position);
            taille = str.length();
            position++;
            if (s != null) {
                strBuild.append("@");
            }
        }
        //return str;
        return strBuild.toString();
    }

    public static String factorise(String str) {

        Pattern pattern = Pattern.compile("(\\d+)(\\.0+)?");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        else {
            throw new IllegalArgumentException("entier");
        }

        LocalTime debut = LocalTime.now();
        //   Instant ins = Instant.now();

        //System.out.println(debut);
        long l = Long.parseLong(str);
        StringBuilder sb = new StringBuilder();
//        String s = l + "";
//        String str = "";
        long i = 2;
        if (l % i != 0) {
            i++;
        }
        long reste = l;

        //long inter = l / 2;
        while (reste > i) {
            reste = l / i;

            if (l % i == 0) {
                l = reste;
//                str = str + i + "x";
                sb.append(i).append("x");
                System.out.println(sb.toString());
            }
            else if (i != 2) {
                i += 2;
            }
            else {
                i++;
            }
        }

//        str = str + l;
        sb.append(l);
        long ll = LocalTime.now().toNanoOfDay() - debut.toNanoOfDay();
        //System.out.println(ll);
        // System.out.println(debut.plusNanos(ll));
        System.out.println(Duration.ofNanos(ll));

        return sb.toString();
    }

}
