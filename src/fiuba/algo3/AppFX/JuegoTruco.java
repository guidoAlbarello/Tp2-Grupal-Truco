package fiuba.algo3.AppFX;

import fiuba.algo3.Juego;
import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.NodoJugador;
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
import java.util.List;

/**
 * Created by Fechee on 28/11/2015.
 */
public class JuegoTruco extends Application {


    Juego truco = new Juego();



    public Scene principal;
    public VBox jugadores;
    public VBox configurar;
    public TextArea creditosParaMostrar = new TextArea(" Trabajo Practico Final\n Algoritmos y Programacion III - Facultad de Ingenieria de la Universidad De Buenos Aires (FIUBA) \n\n\n \n Colaboradores: \n Fede \n Guido \n Tony \n \n \n Tutor: Matias");
    public MenuBar barraMenu;





    public VBox botonesyLog = new VBox();
    public GridPane mesa = new GridPane();

    public HBox contenedorBotonesYMesa = new HBox(botonesyLog,mesa);

    public HBox cartas = new HBox();

    public VBox mesaGral = new VBox(contenedorBotonesYMesa,cartas);




    @Override
    public void start(Stage stage) throws Exception {

        creditosParaMostrar.setPrefHeight(550);

        stage.setTitle(" T R U C O");
        principal = new Scene(new VBox(), 800, 600);


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



    public void generarMesaInicialJuego(Integer cantidad){

        List<VBox> contenedoresJugadores = new ArrayList<VBox>();
        NodoJugador actual = this.truco.manejadorDeTurnos.getJugadores().getPrimero();
        for (int i = 0 ; i < cantidad ; i++){
            Label nombre = new Label(actual.getJugador().getNombre());
            Button cartaJugada = new Button("?");
            VBox representacionJugador = new VBox(nombre,cartaJugada);
            contenedoresJugadores.add(representacionJugador);
            actual = actual.getSiguiente();
        }

        if (cantidad == 2){
            this.mesa.add(contenedoresJugadores.get(0),2,4);
            this.mesa.add(contenedoresJugadores.get(1),2,1);
        }else{
            this.mesa.add(contenedoresJugadores.get(0),2,4);
            this.mesa.add(contenedoresJugadores.get(1),1,3);
            this.mesa.add(contenedoresJugadores.get(2),2,1);
            this.mesa.add(contenedoresJugadores.get(3),4,3);
        }


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





    public void generarPanelDeConfiguracion(){

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

        HandlerBotonConfirmarConfiguracion handler = new HandlerBotonConfirmarConfiguracion(this,selector);
        botonConfirmar.setOnAction(handler);

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


    public void mostrarConfigNombresDeJugadores(Button confirmar) {
        ((VBox) principal.getRoot()).getChildren().add(jugadores);
        ((VBox) principal.getRoot()).getChildren().add(confirmar);
    }

    public void mostrarMesa() {
        limpiarContenedorPrincipal();
        ((VBox) principal.getRoot()).getChildren().add(mesaGral);
    }
}
