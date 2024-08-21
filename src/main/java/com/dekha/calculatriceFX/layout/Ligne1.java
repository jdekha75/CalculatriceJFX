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
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

/**
 *
 * @author linux
 */
public class Ligne1 extends HBox {

    static ToggleButton sub;
    static ToggleButton sup;

    Button puissance;
    Button mod;
    Button retour;
    Button effacer;
    Button cos;
    Button sin;
    Button tan;

    public Ligne1() {

        this.setPadding(new Insets(0, 12, 4, 12));
        this.setSpacing(4);
//        this.setBackground();

        sub = new ToggleButton("\u2193n");
        sub.setId("sub");
        sub.setPrefSize(70, 35);
        sub.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(sub, Priority.ALWAYS);

        sub.setOnAction((t) -> {
            ControleurAffichage.traite("sub");
        });

        sup = new ToggleButton("\u2191n");
        sup.setId("sup");
        sup.setPrefSize(70, 35);
        sup.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(sup, Priority.ALWAYS);

        sup.setOnAction((t) -> {
            ControleurAffichage.traite("sup");
        });

        ToggleGroup group = new ToggleGroup();
        sub.setToggleGroup(group);
        sup.setToggleGroup(group);

        puissance = ajouter("×10ʸ");
        mod = ajouter("mod");
        retour = ajouter("\u21B6");
        effacer = ajouter("C");

        cos = ajouter("cos");
        cos.setPrefSize(93.13, 35);
        cos.setMaxWidth(Double.MAX_VALUE);

        sin = ajouter("sin");
        sin.setPrefSize(93.13, 35);
        sin.setMaxWidth(Double.MAX_VALUE);

        tan = ajouter("tan");
        tan.setPrefSize(93.13, 35);
        tan.setMaxWidth(Double.MAX_VALUE);

        this.getChildren().addAll(sub, sup, puissance, mod, retour, effacer, cos, sin, tan);
    }

    private Button ajouter(String str) {

        Button button = new Button(str);

        //button.setFont(Font.font("Liberation Sans", 16));
        button.setPrefSize(70, 35);
        button.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(button, Priority.ALWAYS);

        button.setOnAction((ActionEvent t) -> {

            ControleurAffichage.traite(str);
        });

        return button;
    }

    public static void armSub() {
        sub.setSelected(true);

    }

    public static void armSup() {
        sup.setSelected(true);;
    }

    public static void disarmSub() {
        sub.setSelected(false);;

    }

    public static void disarmSup() {
        sup.setSelected(false);;
    }

}
