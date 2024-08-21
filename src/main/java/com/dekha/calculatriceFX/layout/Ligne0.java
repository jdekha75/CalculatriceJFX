/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dekha.calculatriceFX.layout;

import com.dekha.calculatriceFX.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PopupControl;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author linux
 */
public class Ligne0 extends HBox {

    private StackPane stackPane1;
    private StackPane stackPane2;
    private ContextMenu contextMenu1;
    private ContextMenu contextMenu2;

    private double y = 0;

    public Ligne0() {

        MenuItem degres = new MenuItem("degres");
        MenuItem radian = new MenuItem("radian");
        MenuItem gradian = new MenuItem("gradian");
        Menu angle = new Menu("angle");
        angle.getItems().addAll(degres, radian, gradian);

        MenuItem km = new MenuItem("km");
        MenuItem miles = new MenuItem("miles");
        MenuItem metre = new MenuItem("metre");
        Menu vitesse = new Menu("vitesse");
        Menu poid = new Menu("poid");
        vitesse.getItems().addAll(metre, km, miles);
        vitesse.setOnAction(eh -> {
            System.out.println("vitesse " + angle.getStyleableNode().getBoundsInParent());
            System.out.println("vitesse " + vitesse.getStyleableNode().getBoundsInParent());
            System.out.println("angle " + angle.getStyleableNode().getLayoutY());
            System.out.println("vitesse " + vitesse.getStyleableNode().getLayoutY());
            System.out.println("vitesse " + vitesse.getStyleableNode().getTranslateY());
            System.out.println("vitesse " + vitesse.getStyleableNode().getScaleY());
            System.out.println("vitesse " + vitesse.getStyleableNode().getLocalToSceneTransform().getTy());
            System.out.println("vitesse " + vitesse.getStyleableNode().getLocalToParentTransform().getTy());
            System.out.println("poid " + poid.getStyleableNode().getLayoutY());
            y = 2;
//            System.out.println(vitesse.);

        });

        contextMenu1 = new ContextMenu(angle, vitesse, poid);
        //        contextMenu1.setStyle("-fx-min-width: 200;");
        //        contextMenu1.getItems().forEach(e -> {
        //            e.setOnAction(eh -> {
        //                y = e.getStyleableNode().getLayoutY();
        //            });
        //        });
        Button fleche1 = new Button("\u2304");
//        button.setOpacity(10);
        fleche1.setAlignment(Pos.CENTER_RIGHT);
        fleche1.setMinWidth(200);
        Button unite1 = new Button("");
        unite1.setId("unite1");
        unite1.setPrefWidth(200);
        unite1.setOpacity(0.5);
        unite1.setOpaqueInsets(new Insets(0, 0, 0, 20));
        unite1.setAlignment(Pos.CENTER_LEFT);
        unite1.setContextMenu(contextMenu1);

        unite1.setOnAction(eh -> {

//            contextMenu1.show(button1, this.getParent().getLayoutX(), this.getParent().getLayoutY());
//            App.showPop(this);
//            System.out.println(" c " + menu.getGraphic().getStyle());
            System.out.println("ly " + this.getParent().getLayoutX());
            System.out.println("ly " + this.getParent().getLayoutY());
            contextMenu1.setMinWidth(100);
            contextMenu1.show(unite1, Side.BOTTOM, 0, y * -26);

        });
        stackPane1 = new StackPane();
        StackPane.setAlignment(fleche1, Pos.CENTER_RIGHT);
        StackPane.setAlignment(unite1, Pos.CENTER_LEFT);
        stackPane1.getChildren().addAll(fleche1, unite1);

        Button to = new Button("to");
        to.setId("to");
        to.setPrefSize(70, 35);

        Button fleche2 = new Button("\u2304");
//        button.setOpacity(10);
        fleche2.setAlignment(Pos.CENTER_RIGHT);
        fleche2.setMinWidth(140);
        Button unite2 = new Button("unite2");
        unite2.setId("unite2");
        unite2.setPrefWidth(140);
        unite2.setOpacity(0.5);
        unite2.setOpaqueInsets(new Insets(0, 0, 0, 20));
        unite2.setAlignment(Pos.CENTER_LEFT);

        stackPane2 = new StackPane();
        StackPane.setAlignment(fleche2, Pos.CENTER_RIGHT);
        StackPane.setAlignment(unite2, Pos.CENTER_LEFT);
        stackPane2.getChildren().addAll(fleche2, unite2);

        this.setPadding(new Insets(12, 12, 10, 12));
        this.setSpacing(4);
//        this.setPrefWidth(720);
        this.getChildren().addAll(stackPane1, to, stackPane2);

    }

}
