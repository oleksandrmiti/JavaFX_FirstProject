package com.example.lect_30_01_2024;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CoffeeOrder extends Application {
    private Label drinkLabel, extrasLabel;
    private int clickCount;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Coffee shop");

        drinkLabel = new Label("Choose your drink: ");

        final ToggleGroup group = new ToggleGroup();

        RadioButton coffee = new RadioButton("Coffee");
        coffee.setUserData("Coffee");
        coffee.setToggleGroup(group);
        coffee.setSelected(true);

        RadioButton deCoffee = new RadioButton("Decaf Coffee");
        deCoffee.setUserData("Decaf Coffee");
        deCoffee.setToggleGroup(group);

        RadioButton tea = new RadioButton("Tea");
        tea.setUserData("Tea");
        tea.setToggleGroup(group);

        HBox drinkBox = new HBox(20);
        drinkBox.getChildren().addAll(drinkLabel, coffee, deCoffee, tea);
        drinkBox.setAlignment(Pos.CENTER_LEFT);

        extrasLabel = new Label("Choose your extras: ");

        CheckBox sugar = new CheckBox("Sugar");
        sugar.setUserData("+Sugar");

        CheckBox milk = new CheckBox("Milk");
        milk.setUserData("+Milk");

        CheckBox syrup = new CheckBox("Caramel syrup");
        syrup.setUserData("+Syrup");

        HBox extrasBox = new HBox(20);
        extrasBox.getChildren().addAll(extrasLabel, sugar, milk, syrup);
        extrasBox.setAlignment(Pos.CENTER_LEFT);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefWidth(150);
        textArea.setPrefHeight(200);

        Button orderButton = new Button("Place order");
        orderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String drinkOption = group.getSelectedToggle().getUserData().toString();
                textArea.insertText(0,"===============\n\tOrder Created\n===============\n\n");
                textArea.insertText(0, sugar.isSelected() ? sugar.getUserData().toString()+"\n" : "");
                textArea.insertText(0, milk.isSelected() ? milk.getUserData().toString()+"\n" : "");
                textArea.insertText(0, syrup.isSelected() ? syrup.getUserData().toString()+"\n" : "");
                textArea.insertText(0,drinkOption+"\n");
                textArea.insertText(0,"\n===============\n\tOrder Started\n===============\n");
            }
        });

        Button resetButton = new Button("Reset order");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                coffee.setSelected(true);
                sugar.setSelected(false);
                milk.setSelected(false);
                syrup.setSelected(false);
                textArea.clear();
            }
        });

        Button quitButton = new Button("Quit program");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(orderButton, resetButton, quitButton);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        // Arrange components in a VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.getChildren().addAll(drinkBox, extrasBox, buttonBox, textArea);
        vbox.setPadding(new Insets(10));

        // Create the scene
        Scene scene = new Scene(vbox, 700, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}