import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main extends Application {

    Stage thestage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // et ma saaksin stage-i teistes meetodites ka kasutada.
        thestage = primaryStage;

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);


        Scene info = new Scene(vbox, 600, 600);
        primaryStage.setScene(info);
        primaryStage.show();

        Stage tulemus = new Stage();

        Label vilaeg = new Label("Viljastumise aeg:");
        TextField vilField = new TextField();

        DatePicker datePicker = new DatePicker();
        datePicker.setShowWeekNumbers(false);

        datePicker.setOnAction(event -> {
            double siis = datePicker.getValue().toEpochDay();
            double praegu = LocalDate.now().toEpochDay();

            int  days  = (int) Math.abs(praegu - siis);

            // System.out.println("Oled olnud beebiootel " + days + " päeva.");

            LocalDate date = datePicker.getValue();

            String pattern = "dd.MM.yyyy";

            datePicker.setPromptText(pattern.toLowerCase());

            datePicker.setConverter(new StringConverter<LocalDate>() {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

                @Override
                public String toString(LocalDate date) {
                    if (date != null) {
                        return dateFormatter.format(date);
                    } else {
                        return "";
                    }
                }

                @Override
                public LocalDate fromString(String string) {
                    if (string != null && !string.isEmpty()) {
                        return LocalDate.parse(string, dateFormatter);
                    } else {
                        return null;
                    }
                }
            });

        });

        Label kaal = new Label("Sinu algkaal (kg):");
        ChoiceBox kaalChoice = new ChoiceBox(FXCollections.observableArrayList("50","51","52","53","54","55","56","57","58","59","60","61","62","63","64")
        );


        Label pikkus = new Label("Sinu pikkus (cm):");
        ChoiceBox pikkusChoice = new ChoiceBox(FXCollections.observableArrayList(
                "165", "166", "167", "168", "169", "170")
        );

        Button submitButton = new Button("Kalkuleeri");

        vbox.getChildren().addAll(vilaeg, datePicker, kaal, kaalChoice, pikkus, pikkusChoice, submitButton);

        submitButton.setOnAction(event -> {

            double siis = datePicker.getValue().toEpochDay();
            double praegu = LocalDate.now().toEpochDay();

            int  days  = (int) Math.abs(praegu - siis);

            if (days > 1 && days <= 84) {

                Label esimenetri = new Label("Käimas on I trimester.");
                System.out.println("I trimester");

            } else if (days > 84 && days < 189) {

                Label teinetri = new Label("Käimas on II trimester.");
                System.out.println("II trimester");

            } else if (days >= 189 && days < 280) {

                Label kolmastri = new Label("Käimas on III trimester.");
                System.out.println("III trimester");
            }


            System.out.println("Teine aken töötab, jess!");

            VBox lopp = new VBox();
            lopp.setSpacing(10);
            lopp.setAlignment(Pos.CENTER);

            Scene jee = new Scene(lopp, 600, 600);
            thestage.setScene(jee);

            Label awesome = new Label("Awesome, ootadki beebit!");

            Label beebiootel = new Label("Oled olnud beebiootel " + days + " päeva.");

            lopp.getChildren().addAll(awesome, beebiootel);
        });

    }

}
