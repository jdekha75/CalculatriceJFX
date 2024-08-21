/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.layout;

import javafx.scene.layout.VBox;

/**
 *
 * @author linux
 */
public class Inputs extends VBox {

    public Inputs() {

        ResultatAfficheur resultatAfficheur = ResultatAfficheur.getInstance();
        ExceptionAfficheur exceptionAfficheur = ExceptionAfficheur.getInstance();

        this.setSpacing(0);

        this.getChildren().addAll(resultatAfficheur, exceptionAfficheur);
    }
}
