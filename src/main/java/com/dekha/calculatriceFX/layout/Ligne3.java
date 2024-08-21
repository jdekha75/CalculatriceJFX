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
public class Ligne3 extends HBox {

    Button quatre;
    Button cinq;
    Button six;
    Button multupliction;
    Button i;
    Button funX;
    Button inverse;
    Button factoriel;
    Button absolue;
    Button arg;

    public Ligne3() {

        this.setPadding(new Insets(0, 12, 4, 12));
        this.setSpacing(4);

        quatre = ajouter("4");
        cinq = ajouter("5");
        six = ajouter("6");
        multupliction = ajouter("×");
        i = ajouter("i");
        funX = ajouter("\u0058   \u2304");
        inverse = ajouter("\u0058\u207B\u00B9");
        factoriel = ajouter("\u0058!");
        absolue = ajouter("|\u0058|");
        arg = ajouter("Arg");

        this.getChildren().addAll(quatre, cinq, six, multupliction, i, funX, inverse, factoriel, absolue, arg);
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
