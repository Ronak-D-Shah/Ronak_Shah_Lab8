package edu.northeastern.csye6200;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LAB8P3 extends Application {
	
	@Override 
	public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5);
        pane.setVgap(5);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField text = new TextField();
                text.setMaxWidth(Double.MAX_VALUE); 
                text.setText(String.valueOf((int) (Math.random() * 2)));
                pane.add(text, i, j);
                GridPane.setHalignment(text, HPos.CENTER);
                GridPane.setValignment(text, VPos.CENTER);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Lab8_Problem3"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}