/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.layout;

import com.dekha.calculatriceFX.controleur.ControleurAffichage;

import java.util.function.UnaryOperator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

/**
 * @author linux
 */
public class ResultatAfficheur extends TextField {

    static private int oldCaretPosition = 0;

    private ResultatAfficheur() {
        setPrefHeight(40);
        setPadding(new Insets(0, 0, 5, 10));
        setFont(Font.font("Ubuntu", 21));
        setId("resultatInput");

        setTextFormatter(new TextFormatter(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change t) {

                oldCaretPosition = t.getControlAnchor();

                switch (t.getText()) {
                    case "*":
                        t.setText("×");
//                        t.setText("\u00D7");
                        break;
                    case "-":
                        t.setText("−");
//                        t.setText("\u2212");
                        break;
                    case "/":
                        t.setText("÷");
//                        t.setText("\u00f7");
                        break;
                    case "=":
                        ControleurAffichage.traite("=");
                        t.setText("");
                        break;
                }
                return t;
            }
        }));

//        focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                if (newPropertyValue) {
//                    System.out.println("Textfield on focus");
//                } else {
//                    System.out.println("Textfield out focus");
//                }
//            }
//
//        });
    }

    public static ResultatAfficheur getInstance() {
        return ResultatAfficheurHolder.INSTANCE;
    }

    public static void affiche(String str) {
        if (!ResultatAfficheurHolder.INSTANCE.isFocused()) {

//            newCaretPosition = oldCaretPosition;
//
//            ResultatAfficheurHolder.INSTANCE.requestFocus();
            ResultatAfficheurHolder.INSTANCE.insertText(oldCaretPosition, str);
            int old = ResultatAfficheurHolder.INSTANCE.getAnchor();
            ResultatAfficheurHolder.INSTANCE.requestFocus();
            ResultatAfficheurHolder.INSTANCE.positionCaret(old);
        }
        oldCaretPosition = ResultatAfficheurHolder.INSTANCE.getAnchor();
//        caretPosition = ResultatAfficheurHolder.INSTANCE.getCaretPosition();
    }

    public static String getTexte() {
        return ResultatAfficheurHolder.INSTANCE.getText();
    }

    public static void efface() {
        ResultatAfficheurHolder.INSTANCE.clear();
    }

    public static void _undo() {
        ResultatAfficheurHolder.INSTANCE.undo();
    }

    public static void _redo() {
        ResultatAfficheurHolder.INSTANCE.redo();
    }

    private static class ResultatAfficheurHolder {

        private static final ResultatAfficheur INSTANCE = new ResultatAfficheur();

        public ResultatAfficheurHolder() {
//            INSTANCE.setId("inp");
        }
    }
}
