package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Controller controller;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        controller = Controller.getController();
        controller.createSomeObjects();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Medicinordination");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(800);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabOpret = new Tab("Opret ordinationer");
        Tab tabVis = new Tab("Vis ordinationer");
        Tab tabStatistik = new Tab("Vis statistik");

        tabOpret.setContent(new OpretOrdinationPane());
        VisOrdinationPane visOrdinationPane = new VisOrdinationPane();
        tabVis.setContent(visOrdinationPane);
        tabStatistik.setContent(new StatistikPane());

        tabPane.getTabs().add(tabOpret);
        tabPane.getTabs().add(tabVis);
        tabPane.getTabs().add(tabStatistik);

        tabVis.setOnSelectionChanged(event -> visOrdinationPane.updateControls());
    }

}
