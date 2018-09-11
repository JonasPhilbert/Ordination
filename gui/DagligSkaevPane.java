package gui;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DagligSkaevPane extends GridPane {
    private TextField txtTimeMinut = new TextField();
    private TextField txtMaengde = new TextField();
    private Button btnOpret = new Button("Opret dosis");
    private ListView<String> listDosis = new ListView<>();

    public DagligSkaevPane() {
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);

        txtTimeMinut.setPromptText("TT:MM");
        txtMaengde.setPromptText("Mængde");

        HBox hbox = new HBox(8);
        hbox.getChildren().add(txtTimeMinut);
        hbox.getChildren().add(txtMaengde);
        hbox.getChildren().add(btnOpret);
        add(hbox, 0, 0);

        listDosis.setMaxHeight(100);
        add(listDosis, 0, 1);

        btnOpret.setOnAction(event -> opretDosis());
    }

    private void opretDosis() {
        String dosis = txtTimeMinut.getText() + " " + txtMaengde.getText();
        listDosis.getItems().add(dosis);
    }

    public String[] getDosisArray() {
        ObservableList<String> items = listDosis.getItems();
        return items.toArray(new String[items.size()]);
    }
}
