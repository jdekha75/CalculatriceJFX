/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.layout;

/*
 * To change this license header, choose License Headers in Project Properties.
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
public class Ligne4 extends HBox {

    Button un;
    Button deux;
    Button trois;
    Button soustraction;
    Button pi;
    Button euler;
    Button puissance;
    Button racineCarree;
    Button log;
    Button ln;

    public Ligne4() {

        this.setPadding(new Insets(0, 12, 4, 12));
        this.setSpacing(4);

        un = ajouter("1");
        deux = ajouter("2");
        trois = ajouter("3");
        soustraction = ajouter("−");
        pi = ajouter("\u03C0");
        euler = ajouter("\u2107");
        puissance = ajouter("\u0058ʸ");
        racineCarree = ajouter("\u221a");
        log = ajouter("log");
        ln = ajouter("ln");

        this.getChildren().addAll(un, deux, trois, soustraction, pi, euler, puissance, racineCarree, log, ln);
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
