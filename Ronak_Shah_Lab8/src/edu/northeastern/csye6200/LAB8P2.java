package edu.northeastern.csye6200;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LAB8P2 extends Application {

	private static final String[] COMPONENTS = {"Project", "Exams", "Assignments", "Attendance"};
    private static final double[] PERCENTAGES = {35, 30, 30, 5};
    private static final Color[] COLORS = {Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE};

    @Override
    public void start(Stage primaryStage) throws Exception {
    	HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.BOTTOM_CENTER);

        double max = getMax(PERCENTAGES);
        double height = 200;
        double width = 150;

        StackPane pane = new StackPane();
        pane.setPadding(new javafx.geometry.Insets(20, 15, 5, 15));

        for (int i = 0; i < COMPONENTS.length; i++) {
            Rectangle rectangle = new Rectangle(0, 0, width, height * PERCENTAGES[i] / max);
            rectangle.setFill(COLORS[i]);

            Text text = new Text(0, 0, COMPONENTS[i] + " -- " + PERCENTAGES[i] + "%");

            hBox.getChildren().add(getVBox(text, rectangle));
        }

        pane.getChildren().add(hBox);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Lab8_Problem2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double getMax(double[] values) {
        double max = values[0];
        for (double value : values) {
            if (value > max)
                max = value;
        }
        return max;
    }

    private VBox getVBox(Text text, Rectangle rectangle) {
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.BOTTOM_LEFT);
        vBox.getChildren().addAll(text, rectangle);
        return vBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
