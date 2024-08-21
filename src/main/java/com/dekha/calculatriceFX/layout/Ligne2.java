/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.layout;

/**
 *
 * @author linux
 */

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

public class Ligne2 extends HBox {

    Button sept;
    Button huit;
    Button neuf;
    Button division;
    Button parentheseOuv;
    Button parentheseFer;
    Button sinh;
    Button cosh;
    Button tanh;

    public Ligne2() {

        this.setPadding(new Insets(0, 12, 4, 12));
        this.setSpacing(4);

        sept = ajouter("7");
        huit = ajouter("8");
        neuf = ajouter("9");
        division = ajouter("\u00f7");
        parentheseOuv = ajouter("(");
        parentheseFer = ajouter(")");

        //   HBox hb1 = new HBox(sept, huit, neuf, division, parentheseOuv, parentheseFer);
        sinh = ajouter("sinh");
        sinh.setPrefSize(93.13, 35);

        cosh = ajouter("cosh");
        cosh.setPrefSize(93.13, 35);
        cosh.setMaxWidth(Double.MAX_VALUE);

        tanh = ajouter("tanh");
        tanh.setPrefSize(93.13, 35);
        tanh.setMaxWidth(Double.MAX_VALUE);

//        HBox hb2 = new HBox(sinh, cosh, tanh);
//
//        HBox.setHgrow(hb1, Priority.ALWAYS);
//        hb1.setMaxWidth(Double.MIN_VALUE);
//        hb1.setPrefWidth(600);
//        HBox.setHgrow(hb2, Priority.ALWAYS);
//        hb2.setMaxWidth(Double.MIN_VALUE);
//        hb2.setPrefWidth(500);
        this.getChildren().addAll(sept, huit, neuf, division, parentheseOuv, parentheseFer, sinh, cosh, tanh);
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
