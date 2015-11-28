package fiuba.algo3.AppFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fechee on 28/11/2015.
 */
public class JuegoTruco extends Application {

    public Scene principal;
    //public VBox principal;
    public VBox jugadores;
    public VBox configurar;
    public TextArea creditosParaMostrar = new TextArea(" Trabajo Practico Final\n Algoritmos y Programacion III - Facultad de Ingenieria de la Universidad De Buenos Aires (FIUBA) \n\n\n \n Colaboradores: \n Fede \n Guido \n Tony \n \n \n Tutor: Matias");
    public MenuBar barraMenu;



    @Override
    public void start(Stage stage) throws Exception {

        creditosParaMostrar.setPrefHeight(550);

        stage.setTitle("T R U C O");
        principal = new Scene(new VBox(), 800, 600);


        //resetearConfiguracion();
        //resetearJugadores();


        creditosParaMostrar.setEditable(false);

        configurarMenu();

        ((VBox) principal.getRoot()).getChildren().add(barraMenu);

        stage.setScene(principal);
        stage.show();

    }

    public void resetearJugadores() {
        jugadores = new VBox();
        jugadores.setSpacing(10);
    }

    public void resetearConfiguracion() {
        configurar = new VBox();
        configurar.setSpacing(10);
    }


    public List<HBox> generarContenedoresSegunCantidadDeJugadores(Integer opcionSelector){
        int cantidadJugadores=2;
        if (opcionSelector==1){cantidadJugadores=4;}
        ArrayList<HBox> contenedores = new ArrayList<HBox>();
        for (int i = 0 ; i < cantidadJugadores ; i++) {
            Label instruccion = new Label("Introduzca nombre del Jugador "+(i+1)+": ");
            TextField completar = new TextField();
            HBox contenedor = new HBox(instruccion, completar);
            contenedor.setSpacing(10);
            contenedores.add(contenedor);
        }
        return contenedores;
    }





    public void generarPanelInicialDeJugadores(){

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");


        ChoiceBox selector = new ChoiceBox(FXCollections.observableArrayList("2 Jugadores", "4 Jugadores"));
        selector.setTooltip((new Tooltip("Seleccione la cantidad de jugadores.")));
        selector.getSelectionModel().selectFirst();
        CheckBox conFlor = new CheckBox("Con Flor");
        conFlor.setSelected(true);

        configurar.getChildren().add(new Label("      Seleccione la cantidad de jugadores y el modo de juego.!"));


        HBox configNueva = new HBox(selector,conFlor);
        configNueva.setSpacing(30);
        configurar.getChildren().add(configNueva);
        JuegoTruco juego = this;

        botonConfirmar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resetearJugadores();
                List<HBox> contenedores = generarContenedoresSegunCantidadDeJugadores(selector.getSelectionModel().getSelectedIndex());
                jugadores.getChildren().addAll(contenedores);
                limpiarContenedorPrincipal();
                Button confirmarJugadores = new Button();
                confirmarJugadores.setOnAction(new HandlerBotonConfirmarJugadores(contenedores,juego));
                mostrarConfigNombresDeJugadores();
            }
        });

        configurar.getChildren().add(botonConfirmar);



    }





    private void configurarMenu() {
        barraMenu = new MenuBar();

        Menu menuFile = new Menu("Menu");
        MenuItem nuevaPartida = new MenuItem("Nueva partida...");
        MenuItem creditos = new MenuItem("Creditos");
        MenuItem salir = new MenuItem("Salir");

        EventHandler manejadorNuevaPartida = new HandlerNuevaPartida(this);

        nuevaPartida.setOnAction(manejadorNuevaPartida);
        creditos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mostrarCreditos();
            }
        });
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        menuFile.getItems().addAll(nuevaPartida,creditos,salir);
        barraMenu.getMenus().add(menuFile);
    }



    public void mostrarCreditos(){
        limpiarContenedorPrincipal();
        ((VBox) principal.getRoot()).getChildren().add(creditosParaMostrar);//boton salir de creditos
    }

    public void limpiarContenedorPrincipal() {
        if (((VBox) principal.getRoot()).getChildren().size() > 1){
            ((VBox) principal.getRoot()).getChildren().remove(1, ((VBox) principal.getRoot()).getChildren().size());
        }
    }

    public void mostrarPanelInicialDeJugaodres() {
        ((VBox) principal.getRoot()).getChildren().add(configurar);
    }


    public void mostrarConfigNombresDeJugadores() {
        ((VBox) principal.getRoot()).getChildren().add(jugadores);
    }

}
