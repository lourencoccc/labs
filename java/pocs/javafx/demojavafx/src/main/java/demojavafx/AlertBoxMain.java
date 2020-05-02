package demojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by joaolourenco on 25/04/15.
 */
public class AlertBoxMain extends Application {

    Stage window;
    Button button;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        //simple control
        button = new Button();
        button.setText("Click me");

        //button.setOnAction(event -> AlertBox.display("Alert", "Alert button"));

        button.setOnAction(event -> {
            boolean confirmation =  AlertBoxConfirm.display("Confirm", "Are you sure want?");
            System.out.println(confirmation);
        });

        //Sismple layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300,250);
        window.setTitle("Title of Window");
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        boolean confirm =  AlertBoxConfirm.display("Confirm", "Are you sure want?");
        System.out.println(confirm);
        if(confirm){
            window.close();
        }
    }
}
