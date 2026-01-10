package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    Scene ekranDodawania, ekranGlowny, ekranInfo;
    TaskService taskService = new TaskService();

    @Override
    public void start(Stage stage) {



        Label etykieta = new Label("Ekran glowny");
        etykieta.getStyleClass().add("duzy-tekst"); // Dodajemy klasę CSS (jak w HTML)

        Button dodaj_zadanie = new Button("Add new task");
        dodaj_zadanie.getStyleClass().add("button-add");

        Button usun_zadanie = new Button("Remove task");

        Button info_zadanie = new Button("Get more info");



        ListView<Task> listaZakupow = new ListView<>(taskService.getTasks());

        Label etykietaInfo = new Label("");

        listaZakupow.getSelectionModel().selectedItemProperty().addListener(
                (observable, staraWartosc, nowaWartosc) -> {
                    if (nowaWartosc != null) {
                        etykietaInfo.setText("Chosen task: " + nowaWartosc);
                    }
                }
        );

        usun_zadanie.setOnAction(e -> {
            taskService.removeTask(listaZakupow.getSelectionModel().getSelectedItem());
            etykietaInfo.setText("");
        });

        info_zadanie.setOnAction(e -> {
            stage.setScene(ekranInfo);
        });

        // PRZYCISK
        dodaj_zadanie.setOnAction(e -> stage.setScene(ekranDodawania));

        VBox layout1 = new VBox(20);
        HBox layoutbutton = new HBox(20);
        layoutbutton.setAlignment(Pos.CENTER);
        layoutbutton.getChildren().addAll(usun_zadanie,info_zadanie, dodaj_zadanie);
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(etykietaInfo,listaZakupow,layoutbutton);


        ekranGlowny = new Scene(layout1, 600, 450);


        // EKRAN INFO
//        String name = listaZakupow.getSelectionModel().getSelectedItem().getName();
//        String description = listaZakupow.getSelectionModel().getSelectedItem().getDescription();

        String name = "";
        String description = "";

        Label label_info_name = new Label("");
        Label label_info_description = new Label("");
        if (name == null) {
            label_info_name.setText(name);
        }
        if (description == null) {
            label_info_description.setText(description);
        }

        Button buttonBack = new Button("<< Back");
        buttonBack.getStyleClass().add("button-success");


        buttonBack.setOnAction(e -> stage.setScene(ekranGlowny));

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(label_info_name,label_info_description, buttonBack);
        StackPane.setAlignment(label_info_name, Pos.TOP_CENTER);
        StackPane.setAlignment(buttonBack, Pos.BOTTOM_LEFT);



        ekranInfo = new Scene(layout2, 600, 450);







        // EKRAN DODAWANIAA
        Label label2 = new Label("Jesteś na ekranie dodawania");
        buttonBack.getStyleClass().add("button-success");

        Button buttonAdd = new Button("Add task");
        buttonAdd.getStyleClass().add("button-add");

        Button buttonGetInfo= new Button("Add task");
        buttonGetInfo.getStyleClass().add("button-success");


        TextField poleImie = new TextField();
        poleImie.setPromptText("Enter the task name");


        buttonBack.setOnAction(e -> stage.setScene(ekranGlowny));
        buttonAdd.setOnAction(e -> {
                    taskService.addTask(new Task(poleImie.getText(), "", Priority.HIGH));
                    poleImie.clear();
                    stage.setScene(ekranGlowny);

        });

        StackPane layout_info = new StackPane();
        layout_info.getChildren().addAll(label2,poleImie, buttonBack, buttonAdd);
        StackPane.setAlignment(label2, Pos.TOP_CENTER);
        StackPane.setAlignment(buttonBack, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(buttonAdd, Pos.BOTTOM_RIGHT);

        // Tworzymy obiekt Sceny 2
        ekranDodawania = new Scene(layout_info, 600, 450);




        ekranDodawania.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        ekranGlowny.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Task Manager");
        stage.setScene(ekranGlowny);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}