package com.dekha.calculatriceFX;

import com.dekha.calculatriceFX.controleur.ControleurAffichage;
import com.dekha.calculatriceFX.layout.ExceptionAfficheur;
import com.dekha.calculatriceFX.layout.Inputs;
import com.dekha.calculatriceFX.layout.Ligne0;
import com.dekha.calculatriceFX.layout.Ligne1;
import com.dekha.calculatriceFX.layout.Ligne2;
import com.dekha.calculatriceFX.layout.Ligne3;
import com.dekha.calculatriceFX.layout.Ligne4;
import com.dekha.calculatriceFX.layout.Ligne5;
import com.dekha.calculatriceFX.layout.ResultatAfficheur;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PopupControl;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * JavaFX App
 */
public class App extends Application {

    private static PopupControl pop;
    private static Stage stage;
    private static ContextMenu cm;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        Menu menu = new Menu("Bonjour");
//        menu.getStyleableNode().getl

        cm = new ContextMenu(menu);

        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        //  var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        //  var scene = new Scene(new StackPane(label), 640, 480);
//      textField = new TextField();
        VBox vbox = new VBox(ResultatAfficheur.getInstance(), ExceptionAfficheur.getInstance(), new Ligne0(), new Ligne1(), new Ligne2(), new Ligne3(), new Ligne4(), new Ligne5());
        vbox.setBackground(Background.EMPTY);
        TextField textField = new TextField();
        textField.setEditable(false);
        textField.setPrefHeight(400);


        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(vbox);
        borderPane.setCenter(textField);
        Scene scene = new Scene(borderPane, 720, 480);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
//scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<InputEvent>() {
//    @Override
//    public void handle(InputEvent inputEvent) {
//        KeyEvent keyEvent = (KeyEvent) inputEvent;
//
//        if(keyEvent.getText().matches("\\d")){
//            System.out.println(keyEvent.getCode());
//            System.out.println(keyEvent.getCharacter());
//            System.out.println(keyEvent.getText());
//            ControleurAffichage.traite(keyEvent.getText());
//            inputEvent.consume();
//        }
//    }
//
//});
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void affiche(String str) {
        ResultatAfficheur.affiche(str);
    }

    public static void showPop(Node node) {
        System.out.println(" " + node.getScene().getX() + node.getParent().getLayoutX() + "    " + node.getScene().getY());
//        cm.show(stage, stage.getX(), stage.getY() + node.getParent().getLayoutY());
        pop.show(stage, 0, 0);
    }

}
