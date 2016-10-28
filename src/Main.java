import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene info = new Scene(vbox, 500, 300);
        primaryStage.setScene(info);
        primaryStage.show();

        Label vilaeg = new Label("Viljastumise aeg (dd.mm.yyyy):");
        TextField vilField = new TextField();

        Label kaal = new Label("Sinu algkaal (kg):");
        TextField kaalField = new TextField();

        Label pikkus = new Label("Sinu pikkus (cm):");
        TextField pikkusField = new TextField();

        Button submitButton = new Button("OK!");

        vbox.getChildren().addAll(vilaeg, vilField, kaal, kaalField, pikkus, pikkusField, submitButton);

        submitButton.setOnAction(event -> {
            System.out.println("töötab, kuule!");

            VBox lõpp = new VBox();
            Scene jee = new Scene(lõpp, 500, 300);
            primaryStage.setScene(jee);
            primaryStage.show();

            Label awesome = new Label("Awesome, ootadki beebit!");

            lõpp.getChildren().add(awesome);
        });

    }
}
