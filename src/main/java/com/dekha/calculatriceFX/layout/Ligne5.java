/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.layout;

/*
 * To change this license header, choose License Headers in Project Properties .
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dekha.calculatriceFX.App;
import com.dekha.calculatriceFX.controleur.ControleurAffichage;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

/**
 *
 * @author linux
 */
public class Ligne5 extends HBox {

    Button zero;
    Button virgule;
    Button pourcentage;
    Button addition;
    Button egale;
    Button factorisarion;
    Button re;
    Button lm;
    Button conj;
    Button fx;

    public Ligne5() {

        this.setPadding(new Insets(0, 12, 12, 12));
        this.setSpacing(4);

        zero = ajouter("0");
        virgule = ajouter(",");
        pourcentage = ajouter("%");
        addition = ajouter("+");
        egale = ajouter("=");
        egale.setId("egale");
        factorisarion = ajouter("a×b");
        re = ajouter("Re");
        lm = ajouter("lm");
        conj = ajouter("conj");
        fx = ajouter("f(x) \u2304");

        this.getChildren().addAll(zero, virgule, pourcentage, addition, egale, factorisarion, re, lm, conj, fx);
    }

    private Button ajouter(String str) {

        Button button = new Button(str);
        button.setFont(Font.font("Ubuntu Bold", 16));
        button.setPrefSize(70, 35);
        button.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(button, Priority.ALWAYS);
        button.setOnAction((ActionEvent t) -> {

            ControleurAffichage.traite(str);

        });
        return button;
    }
}
