import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class GUI extends Application{
    @Override
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();

        root.setTop(topHBox(root));
        root.setLeft(null);
        root.setRight(null);
        root.setCenter(new WeightConversion().getPane());

        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("Vert It!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public HBox topHBox(BorderPane roots)  {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: #336699;");

        //----------------------------------------Buttons Menu----------------------------------------------

        Button buttonWeight = new Button("Weight");
        buttonWeight.setPrefSize(100, 20);
        buttonWeight.setOnAction(e ->
                roots.setCenter(new WeightConversion().getPane()));



        Button buttonVolume = new Button("Volume");
        buttonVolume.setPrefSize(100, 20);
        buttonVolume.setOnAction(e ->
                roots.setCenter(new VolumeConversion().getPane()));


        Button buttonCurrency = new Button("Currency");
        buttonCurrency.setPrefSize(100, 20);
        buttonCurrency.setOnAction(e ->
                roots.setCenter(new CurrencyConversion().getPane()));

        Button buttonDistance = new Button("Distance");
        buttonDistance.setPrefSize(100, 20);
        buttonDistance.setOnAction(e ->
                roots.setCenter(new DistanceConversion().getPane()));


        //--------------------------------------------------------------------------------------


        hbox.getChildren().addAll(buttonWeight, buttonVolume, buttonDistance, buttonCurrency);
        return hbox;
    }
}
