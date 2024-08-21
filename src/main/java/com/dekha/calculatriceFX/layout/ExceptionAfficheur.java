/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.dekha.calculatriceFX.layout;

import javafx.scene.control.TextField;

/**
 *
 * @author linux
 */
public class ExceptionAfficheur extends TextField {

    private ExceptionAfficheur() {
        this.setText("Exception");
        this.setEditable(false);
        this.setId("exceptionInput");
    }

    public static ExceptionAfficheur getInstance() {
        return ExceptionAfficheurHolder.INSTANCE;
    }

    private static class ExceptionAfficheurHolder {

        private static final ExceptionAfficheur INSTANCE = new ExceptionAfficheur();
    }
}
