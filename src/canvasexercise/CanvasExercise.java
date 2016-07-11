package canvasexercise;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CanvasExercise extends Application {

    public static final int CANVASDIMENSION = 500;

    @Override
    public void start(Stage primaryStage) {
        Canvas canv = new Canvas(CANVASDIMENSION, CANVASDIMENSION);
        GraphicsContext gc = canv.getGraphicsContext2D();
        Group root = new Group();
        root.getChildren().add(canv);
        GridPane grid = new GridPane();
        MySlider slTriangle = new MySlider();
        grid.add(slTriangle, 0, 1);
        MySlider slRect = new MySlider();
        grid.add(slRect, 1, 1);
        MySlider slCircle = new MySlider();
        grid.add(slCircle, 2, 1);
        Text dimTriangle = new Text("Lato del \ntriangolo");
        grid.add(dimTriangle, 0, 2);
        Text dimRect = new Text("Lato del \nquadrato");
        grid.add(dimRect, 1, 2);
        Text dimCircle = new Text("Raggio del \ncerchio");
        grid.add(dimCircle, 2, 2);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33.3);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33.3);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(33.3);
        Button circle = new Button("Circle");
        circle.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                drawCircle(gc, slCircle.getValue());
            }
        });
        Button rectangle = new Button("Quadrato");
        rectangle.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                drawRect(gc, slRect.getValue());
            }
        });

        Button triangle = new Button("Triangle");
        triangle.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                drawTriangle(gc, slTriangle.getValue());
            }
        });
        grid.add(triangle, 0, 0);
        grid.add(rectangle, 1, 0);
        grid.add(circle, 2, 0);
        VBox vbox = new VBox();
        vbox.getChildren().add(grid);
        Scene scene = new Scene(root, CANVASDIMENSION, CANVASDIMENSION);
        primaryStage.setTitle("Picture Pane");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        Scene scene2 = new Scene(vbox, 300, 300);
        Stage Stage2 = new Stage();
        Stage2.setTitle("Comandi");
        Stage2.setScene(scene2);
        Stage2.setX(300);
        Stage2.setY(300);

        Stage2.show();
        primaryStage.setOnCloseRequest(new EventHandler() {
            @Override
            public void handle(Event event) {
                Platform.exit();
            }
        });
        Stage2.setOnCloseRequest(new EventHandler() {
            @Override
            public void handle(Event event) {
                Platform.exit();
            }
        });
    }

    private void drawRect(GraphicsContext gc, double dim) {
        gc.setFill(Color.YELLOW);
        gc.fillRect((int) (Math.random() * CANVASDIMENSION), (int) (Math.random() * CANVASDIMENSION), dim, dim);
    }

    private void drawCircle(GraphicsContext gc, double dim) {
        gc.setFill(Color.RED);
        gc.fillOval((int) (Math.random() * CANVASDIMENSION), (int) (Math.random() * CANVASDIMENSION), dim, dim);
    }

    private void drawTriangle(GraphicsContext gc, double dim) {
        gc.setFill(Color.BLUE);
        int x = (int) (Math.random() * CANVASDIMENSION);
        int y = (int) (Math.random() * CANVASDIMENSION);
        gc.fillPolygon(new double[]{x + (dim / 2), x, x + dim}, new double[]{y + (0.134 * dim), y + dim, y + dim}, 3);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
