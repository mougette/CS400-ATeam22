package application;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
    // store any command-line arguments that were entered.
    // NOTE: this.getParameters().getRaw() will get these also
    private List<String> args;

    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 450;
    private static final String APP_TITLE = "COVID19 Tracker";
    
    @Override
    public void start(Stage primaryStage) throws Exception {
      
      HBox hbox = new HBox();
      hbox.setAlignment(Pos.BASELINE_CENTER);
      
      /**
       * Right Side - Title, Options & BUttons
       */
      VBox rightSide = new VBox(10);
      rightSide.setAlignment(Pos.CENTER_RIGHT);
      rightSide.setPadding(new Insets(10, 20, 20, 10));
      rightSide.setMinHeight(WINDOW_HEIGHT);
      rightSide.setMinWidth(250);
      
      Label label = new Label("COVID19 Tracker");
      label.setPadding(new Insets(0, 0, 0, 10));
      label.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
      label.setTextFill(Color.web("#ffff00"));
      rightSide.getChildren().add(label);
      
      
      //NOTE: ComboBoxOptions are currently hard coded until CountryLists are finished
      String[] countryComboBoxOptions = new String[] {"China", "South Korea", "USA"};
      ComboBox countryComboBox = new ComboBox(FXCollections.observableArrayList(countryComboBoxOptions));
      countryComboBox.setValue("Select Country");
      countryComboBox.setMinWidth(150);
      countryComboBox.setMaxWidth(150);
      rightSide.getChildren().add(countryComboBox);
      
      String[] startDateComboBoxOptions = new String[] {"3/1/2020", "3/2/2020", "3/3/2020"};
      ComboBox startDateComboBox = new ComboBox(FXCollections.observableArrayList(startDateComboBoxOptions));
      startDateComboBox.setValue("Select Satrt Date");
      startDateComboBox.setMinWidth(150);
      startDateComboBox.setMaxWidth(150);
      rightSide.getChildren().add(startDateComboBox);
      
      String[] endDateComboBoxOptions = new String[] {"3/1/2020", "3/2/2020", "3/3/2020"};
      ComboBox endDateComboBox = new ComboBox(FXCollections.observableArrayList(startDateComboBoxOptions));
      endDateComboBox.setValue("Select End Date");
      endDateComboBox.setMinWidth(150);
      endDateComboBox.setMaxWidth(150);
      rightSide.getChildren().add(endDateComboBox);
      
      Button trackButton = new Button("Track");
      rightSide.getChildren().add(trackButton);
      trackButton.setPadding(new Insets(10, 50, 10, 50));
      
      Button outputButton = new Button("Save Output File");
      rightSide.getChildren().add(outputButton);
      
      Button inputButton = new Button("Change Input File");
      rightSide.getChildren().add(inputButton);
      
      
      /*
       * LeftSide - Graph To Display Data
       */
      VBox leftSide = new VBox();
      leftSide.setAlignment(Pos.CENTER_LEFT);
      
      NumberAxis xAxis = new NumberAxis();
      xAxis.setLabel("Days");

      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("No. Cases");

      LineChart lineChart = new LineChart(xAxis, yAxis);

      XYChart.Series dataSeries = new XYChart.Series();
      dataSeries.setName("2020");
      
      for (int i = 1, j = 10; i < 5; i++) {
        // Super Advanced COVID19 Growth AI
        // AKA Sample Data
        dataSeries.getData().add(new XYChart.Data(i , j));
        j = j * i + 1;
      }

      lineChart.getData().add(dataSeries);
      
      leftSide.getChildren().add(lineChart);
      
      Scene mainScene = new Scene(hbox, WINDOW_WIDTH, WINDOW_HEIGHT);
      
      BackgroundFill background_fill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY);
      Background background = new Background(background_fill);
      rightSide.setBackground(background);
      
      BackgroundFill background_fill_left = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
      Background background_left = new Background(background_fill_left);
      leftSide.setBackground(background_left);
      
      hbox.getChildren().addAll(leftSide, rightSide);
      //hbox.getChildren().add(leftSide);
      hbox.setBackground(background_left);
      
      primaryStage.setTitle("COVID19 Tracker");
      primaryStage.setScene(mainScene);
      primaryStage.show();
      
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
           launch(args);
    }
}