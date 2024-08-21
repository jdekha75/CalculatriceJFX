/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.controleur;

import com.dekha.calculatriceFX.layout.Ligne1;
import com.dekha.calculatriceFX.layout.ResultatAfficheur;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author linux
 */
public class ControleurAffichage {

    private static boolean sub = false;
    private static boolean sup = false;

    private static final Map<String, String> subScriptMap = new HashMap<>();
    public static final Map<String, String> supScriptMap = new HashMap<>();
    private static final Map<String, String> superScr = new HashMap<>();

    static {
        supScriptMap.put("0", "\u2070");
        supScriptMap.put("1", "\u00B9");
        supScriptMap.put("2", "\u00B2");
        supScriptMap.put("3", "\u00B3");
        supScriptMap.put("4", "\u2074");
        supScriptMap.put("5", "\u2075");
        supScriptMap.put("6", "\u2076");
        supScriptMap.put("7", "\u2077");
        supScriptMap.put("8", "\u2078");
        supScriptMap.put("9", "\u2079");
        //superScriptMap.put("(", "\u207D");
        //superScriptMap.put(")", "\u207E");
        //superScriptMap.put("+", "\u207A");
        //superScriptMap.put("−", "\u207B");
        //superScriptMap.put("×", "*");
        //superScriptMap.put("x", "*");
        //superScriptMap.put("*", "*");

        subScriptMap.put("0", "\u2080");
        subScriptMap.put("1", "\u2081");
        subScriptMap.put("2", "\u2082");
        subScriptMap.put("3", "\u2083");
        subScriptMap.put("4", "\u2084");
        subScriptMap.put("5", "\u2085");
        subScriptMap.put("6", "\u2086");
        subScriptMap.put("7", "\u2087");
        subScriptMap.put("8", "\u2088");
        subScriptMap.put("9", "\u2089");

        supScriptMap.forEach((key, value) -> {
            superScr.put(value, key);
        });
    }

    public static void traite(String str) {

        if (str.equalsIgnoreCase("sub")) {
            clickSub();
            ResultatAfficheur.affiche("");
            return;
        }

        if (str.equalsIgnoreCase("sup")) {
            clickSup();
            ResultatAfficheur.affiche("");
            return;
        }

        if (str.equalsIgnoreCase("×10ʸ")) {
            ResultatAfficheur.affiche("×10");
            sup = true;
            Ligne1.armSup();
            return;
        }

        if (sub && Character.isDigit(str.charAt(0))) {
            ResultatAfficheur.affiche(subScriptMap.get(str));
            return;
        }

        if (sup && Character.isDigit(str.charAt(0))) {
            ResultatAfficheur.affiche(supScriptMap.get(str));
            return;
        }

        if (str.equalsIgnoreCase("\u21B6")) {
            ResultatAfficheur._undo();
            return;
        }

        if (str.equalsIgnoreCase("c")) {
            ResultatAfficheur.efface();
            Ligne1.disarmSub();
            Ligne1.disarmSup();
            reset();
            return;
        }

        if (str.equalsIgnoreCase("=")) {
            String result = ControleurCalcul.calcule(ResultatAfficheur.getTexte());
            result = formate(result);
            ResultatAfficheur.efface();
            ResultatAfficheur.affiche(result);
            Ligne1.disarmSub();
            Ligne1.disarmSup();
            reset();
            return;
        }

        if (str.equalsIgnoreCase("a×b")) {
            String result = ControleurCalcul.factorise(ResultatAfficheur.getTexte());
            ResultatAfficheur.efface();
            ResultatAfficheur.affiche(result);
            return;
        }

        ResultatAfficheur.affiche(str);
    }

    private static void reset() {
        sub = false;
        sup = false;
    }

    private static void clickSub() {
        sub = !sub;
        sup = false;
    }

    private static void clickSup() {
        sup = !sup;
        sub = false;
    }

    private static void egale() {
    }

    private static boolean isFct(String str) {
        return str.trim().equals("log");

    }

    public static boolean isSupScript(String str) {
        return supScriptMap.containsValue(str);
    }

    public static String getSupScript(String str) {
        return superScr.get(str);
    }

    public static boolean isSub(){
        return sub;
    }

    public static boolean isSup(){
        return sup;
    }

    private static String formate(String str) {

        Pattern pattern = Pattern.compile("(-?\\d+)\\.0+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return str;

    }
}
