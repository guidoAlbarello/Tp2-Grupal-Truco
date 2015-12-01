package fiuba.algo3.aplicacionAnthony;


import fiuba.algo3.AppFX.HandlerMenuOpciones;
import fiuba.algo3.Eventos.HandlerBotonNoQuiero;
import fiuba.algo3.Eventos.HandlerBotonQuiero;
import fiuba.algo3.Eventos.*;
import fiuba.algo3.Juego;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.manejoDeJugadores.Jugador;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by anthony on 29/11/2015.
 */
public class Aplicacion extends Application {
    private BorderPane panel;
    public ImageView contenedorCartaJugador1, contenedorCartaJugador2,
            contenedorCartaJugador3,contenedorCartaJugador4,iv1,iv2,iv3;
    private Button botonCarta1,botonCarta2,botonCarta3;
    private Juego juego;
    public VBox configurar,nombrar;
    public GridPane verticalMedio;
    private Boolean conflor;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){

        stage.setTitle("Truco- Algoritmos y programacion 3");
        panel = new BorderPane();
        /*
        panel.setRight(this.contenedorDeJugadas());
        panel.setCenter(this.cuadriculaDeJuego());
        panel.setLeft(this.contenedorEstadoDeJuego());
        panel.setTop(this.crearMenuDeVentana(stage));*/
        panel.setCenter(this.generarPanelDeConfiguracion());

        panel.setTop(this.crearMenuDeVentana(stage));

        stage.setWidth(770);
        stage.setHeight(660);
        Scene scene = new Scene(panel);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void setConFlor(Boolean conFlor){this.conflor = conFlor;}
    public VBox generarPanelDeConfiguracion(){

        configurar = new VBox();
        configurar.setSpacing(40);
        Image logo = new Image("imagenes/truco.jpg");
        ImageView contLogo = new ImageView(logo);
        contLogo.setFitHeight(280);
        contLogo.setFitWidth(350);
        configurar.getChildren().add(contLogo);

        Label bienvenida = new Label("Bienvenido al Truco!");
        bienvenida.setFont(Font.font(null, FontWeight.BOLD, 28));
        bienvenida.setStyle("-fx-text-fill: #FFFFFF");

        configurar.getChildren().add(bienvenida);

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");



        ChoiceBox selector = new ChoiceBox(FXCollections.observableArrayList("2 Jugadores", "4 Jugadores"));
        Tooltip textoChek = new Tooltip("Seleccione la cantidad de jugadores.");
        selector.setTooltip((textoChek));
        selector.getTooltip().setStyle("-fx-text-fill: #FFFFFF");

        selector.getSelectionModel().selectFirst();
        CheckBox conFlor = new CheckBox("Con Flor");
        conFlor.setSelected(true);
        conFlor.setStyle("-fx-text-fill: #FFFFFF");

        Label titulo = new Label("      Seleccione la cantidad de jugadores y el modo de juego.");
        titulo.setFont(Font.font(null, FontWeight.BOLD, 15));
        titulo.setStyle("-fx-text-fill: #FFFFFF");
        configurar.getChildren().add(titulo);



        HBox configNueva = new HBox(selector,conFlor);
        configNueva.setAlignment(Pos.CENTER);
        configNueva.setSpacing(30);
        configurar.getChildren().add(configNueva);

        HandlerConfirmarConfiguracion handler = new HandlerConfirmarConfiguracion(this,selector,conFlor);
        botonConfirmar.setOnAction(handler);

        configurar.getChildren().add(botonConfirmar);

        configurar.setAlignment(Pos.CENTER);
        configurar.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg')");
        return configurar;
    }

    public List<HBox> generarContenedoresSegunCantidadDeJugadores(Integer opcionSelector){
        this.nombrar = new VBox();
        Label espacio = new Label();
        nombrar.getChildren().add(espacio);
        Image imagen = new Image("imagenes/i.jpg");
        ImageView cont = new ImageView(imagen);
        cont.setFitWidth(300);
        cont.setFitHeight(300);
        nombrar.getChildren().add(cont);
        int cantidadJugadores=2;
        if (opcionSelector==1){cantidadJugadores=4;}
        ArrayList<HBox> contenedores = new ArrayList<HBox>();
        for (int i = 0 ; i < cantidadJugadores ; i++) {
            Label instruccion = new Label("Introduzca nombre del Jugador "+(i+1)+": ");
            instruccion.setFont(Font.font(null, FontWeight.BOLD, 15));
            instruccion.setStyle("-fx-text-fill: #FFCC33");
            TextField completar = new TextField();
            HBox contenedor = new HBox(instruccion, completar);
            contenedor.setSpacing(10);
            contenedor.setAlignment(Pos.CENTER);
            contenedores.add(contenedor);
            nombrar.getChildren().add(contenedor);
        }
        nombrar.setAlignment(Pos.TOP_CENTER);
        nombrar.setSpacing(20);

        Button confirmarPartida = new Button("Comenzar partida");
        HandlerConfirmarJugadores handler = new HandlerConfirmarJugadores(contenedores,this);
        confirmarPartida.setOnAction( handler);

        nombrar.getChildren().add(confirmarPartida);
        nombrar.setStyle("-fx-background-image: url('imagenes/texturamesa.jpg')");
        return contenedores;
    }


    private MenuBar crearMenuDeVentana(Stage stage) {
        MenuBar barraDeMenu = new MenuBar();
        barraDeMenu.prefWidthProperty().bind(stage.widthProperty());

        Menu menuDeArchivo = new Menu("Archivo");
        MenuItem nuevoJuegoItemMenu = new MenuItem("Nuevo Juego");
        nuevoJuegoItemMenu.setOnAction(new HandlerNuevoJuego(this));
        MenuItem opcionesItemMenu = new MenuItem("Opciones");
        opcionesItemMenu.setOnAction(new HandlerMenuOpciones(this));
        MenuItem salirItemMenu = new MenuItem("Salir");
        //salirItemMenu.setOnAction(actionEvent->Platform.exit());

        menuDeArchivo.getItems().addAll(nuevoJuegoItemMenu, opcionesItemMenu, new SeparatorMenuItem(), salirItemMenu);

        Menu menuDeSoporte = new Menu("Ayuda y Soporte");
        MenuItem valoresDeCartasItemMenu = new MenuItem("Valores de Cartas");
        MenuItem creditosItemMenu = new MenuItem("Creditos..");

        menuDeSoporte.getItems().addAll(valoresDeCartasItemMenu, creditosItemMenu);

        barraDeMenu.getMenus().addAll(menuDeArchivo, menuDeSoporte);
        return barraDeMenu;
    }


    public GridPane cuadriculaDeJuego(){
        verticalMedio = new GridPane();
        verticalMedio.setStyle("-fx-background-color: #009900");
        ColumnConstraints columna0 = new ColumnConstraints(150,150,150);
        ColumnConstraints columna1 = new ColumnConstraints(150,150,150);
        ColumnConstraints columna2 = new ColumnConstraints(150,150,150);
        RowConstraints fila0 = new RowConstraints(150,150,150);
        RowConstraints fila1 = new RowConstraints(150,150,150);
        RowConstraints fila2 = new RowConstraints(150,150,150);
        RowConstraints fila3 = new RowConstraints(150,150,150);
        verticalMedio.getColumnConstraints().add(0,columna0);
        verticalMedio.getColumnConstraints().add(1,columna1);
        verticalMedio.getColumnConstraints().add(2,columna2);
        verticalMedio.getRowConstraints().add(0,fila0);
        verticalMedio.getRowConstraints().add(1,fila1);
        verticalMedio.getRowConstraints().add(2,fila2);
        verticalMedio.getRowConstraints().add(3,fila3) ;
        verticalMedio.setGridLinesVisible(false);
        verticalMedio.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg')");
        Image imagenLogo = new Image("imagenes/logo2.jpg");
        ImageView contImage = new ImageView(imagenLogo);

        contImage.setFitWidth(140);
        contImage.setFitHeight(140);

        verticalMedio.add(contImage,1,1);
        verticalMedio.setPadding(new Insets(10));

        // imagenes de cartas
        List<Carta> cartasMano = juego.manejadorDeTurnos.getJugadorConTurnoActual().getMano().getCartasEnMano();
        Carta carta = cartasMano.get(0);
        String direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image imagenCarta1 = new Image(direccionCarta);
        iv1 = new ImageView(imagenCarta1);
        iv1.setFitHeight(130);
        iv1.setFitWidth(90);
        botonCarta1 = new Button("jugar Carta 1");
        botonCarta1.setFont(Font.font(null, FontWeight.BOLD, 15));
        botonCarta1.setGraphic(iv1);
        botonCarta1.setDefaultButton(true);
        botonCarta1.setContentDisplay(ContentDisplay.TOP);
        botonCarta1.setOnAction(new HandlerBotonJugarCarta1(this));
        botonCarta1.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg');-fx-text-fill: #FFCC00");


        carta = cartasMano.get(1);
        direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image imagenCarta2 = new Image(direccionCarta);
        iv2 = new ImageView(imagenCarta2);
        iv2.setFitWidth(90);
        iv2.setFitHeight(130);
        botonCarta2 = new Button("jugar Carta 2");
        botonCarta2.setFont(Font.font(null, FontWeight.BOLD, 15));
        botonCarta2.setGraphic(iv2);
        botonCarta2.setDefaultButton(true);
        botonCarta2.setContentDisplay(ContentDisplay.TOP);
        botonCarta2.setOnAction(new HandlerBotonJugarCarta2(this));
        botonCarta2.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg');-fx-text-fill: #FFCC00");

        carta = cartasMano.get(2);
        direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image imagenCarta3 = new Image(direccionCarta);
        iv3 = new ImageView(imagenCarta3);
        iv3.setFitHeight(130);
        iv3.setFitWidth(90);
        botonCarta3 = new Button("jugar Carta 3");
        botonCarta3.setFont(Font.font(null, FontWeight.BOLD, 15));
        botonCarta3.setGraphic(iv3);
        botonCarta3.setDefaultButton(true);
        botonCarta3.setContentDisplay(ContentDisplay.TOP);
        botonCarta3.setOnAction(new HandlerBotonJugarCarta3(this));
        botonCarta3.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg');-fx-text-fill: #FFCC00");



        verticalMedio.add(botonCarta1,0,3);
        verticalMedio.setHalignment(botonCarta1,HPos.CENTER);
        verticalMedio.add(botonCarta2,1,3);
        verticalMedio.setHalignment(botonCarta2,HPos.CENTER);
        verticalMedio.add(botonCarta3,2,3);
        verticalMedio.setHalignment(botonCarta3,HPos.CENTER);


        this.inicializarMesa();
        this.actualizarBotonesCartas();
        return verticalMedio;
    }

public void inicializarMesa(){
    Image cartaJugador1 = new Image("imagenes/huskar.jpg");
    Image cartaJugador2 = new Image("imagenes/huskar.jpg");
    Image cartaJugador3 = new Image("imagenes/huskar.jpg");
    Image cartaJugador4 = new Image("imagenes/huskar.jpg");


    contenedorCartaJugador1 = new ImageView(cartaJugador1);
    contenedorCartaJugador1.setFitHeight(90);
    contenedorCartaJugador1.setFitWidth(65);
    verticalMedio.setHalignment(contenedorCartaJugador1, HPos.CENTER);

    contenedorCartaJugador2 = new ImageView(cartaJugador2);
    contenedorCartaJugador2.setFitHeight(90);
    contenedorCartaJugador2.setFitWidth(65);
    verticalMedio.setHalignment(contenedorCartaJugador2, HPos.CENTER);

    contenedorCartaJugador3 = new ImageView(cartaJugador3);
    contenedorCartaJugador3.setFitHeight(90);
    contenedorCartaJugador3.setFitWidth(65);
    verticalMedio.setHalignment(contenedorCartaJugador3, HPos.CENTER);

    contenedorCartaJugador4 = new ImageView(cartaJugador4);
    contenedorCartaJugador4.setFitHeight(90);
    contenedorCartaJugador4.setFitWidth(65);
    verticalMedio.setHalignment(contenedorCartaJugador4, HPos.CENTER);
    verticalMedio.add(contenedorCartaJugador1,1,2);
    verticalMedio.add(contenedorCartaJugador2,2,1);
    verticalMedio.add(contenedorCartaJugador3,1,0);
    verticalMedio.add(contenedorCartaJugador4,0,1);
}

    public VBox contenedorDeJugadasEnvido(){
        Button botonEnvido = new Button("Envido");
        botonEnvido.setPrefSize(100,50);
        botonEnvido.setAlignment(Pos.CENTER);
        botonEnvido.setOnAction(new HandlerBotonEnvido(this));

        Button botonRealEnvido = new Button("Real Envido");
        botonRealEnvido.setPrefSize(100,50);
        botonRealEnvido.setAlignment(Pos.CENTER);
        botonRealEnvido.setOnAction(new HandlerBotonRealEnvido(this));

        Button botonFaltaEnvido = new Button("Falta Envido");
        botonFaltaEnvido.setPrefSize(100,50);
        botonFaltaEnvido.setAlignment(Pos.CENTER);
        botonFaltaEnvido.setOnAction(new HandlerBotonFaltaEnvido(this));

        Button botonVolver = new Button("volver");
        botonVolver.setPrefSize(100,50);
        botonVolver.setAlignment(Pos.CENTER);
        botonVolver.setOnAction(new HandlerBotonVolver(this));

        VBox contenedorEnvido = new VBox(botonEnvido,botonRealEnvido,botonFaltaEnvido,botonVolver);
        contenedorEnvido.setPrefSize(150,150);
        contenedorEnvido.setStyle("-fx-background-color: #0000FF");
        contenedorEnvido.setAlignment(Pos.CENTER);
        contenedorEnvido.setSpacing(20);
        contenedorEnvido.setPadding(new Insets(10));
        return contenedorEnvido;
    }

    public VBox contenedorDeJugadasTruco(){
        Button botonTruco = new Button("Truco");
        botonTruco.setPrefSize(100,50);
        botonTruco.setAlignment(Pos.CENTER);
        botonTruco.setOnAction(new HandlerBotonTruco(this));

        Button botonRetruco = new Button("Retruco");
        botonRetruco.setPrefSize(100,50);
        botonRetruco.setAlignment(Pos.CENTER);
        botonRetruco.setOnAction(new HandlerBotonRetruco(this));

        Button botonValeCuatro = new Button("Vale cuatro");
        botonValeCuatro.setPrefSize(100,50);
        botonValeCuatro.setAlignment(Pos.CENTER);
        botonValeCuatro.setOnAction(new HandlerBotonValeCuatro(this));

        Button botonVolver = new Button("volver");
        botonVolver.setPrefSize(100,50);
        botonVolver.setAlignment(Pos.CENTER);
        botonVolver.setOnAction(new HandlerBotonVolver(this));

        VBox contenedorTruco = new VBox(botonTruco,botonRetruco,botonValeCuatro,botonVolver);
        contenedorTruco.setPrefSize(150, 150);
        contenedorTruco.setStyle("-fx-background-color: #FFFF00");
        contenedorTruco.setAlignment(Pos.CENTER);
        contenedorTruco.setSpacing(20);
        contenedorTruco.setPadding(new Insets(10));
        return contenedorTruco;
    }

    public VBox contenedorDeJugadasFlor(){
        Button botonContraFlor = new Button("Contra flor");
        botonContraFlor.setPrefSize(100, 50);
        botonContraFlor.setAlignment(Pos.CENTER);
        botonContraFlor.setOnAction(new HandlerBotonContraFlor(this));

        Button botonContraFlorAlResto = new Button("Contra flor al resto");
        botonContraFlorAlResto.setPrefSize(100, 50);
        botonContraFlorAlResto.setAlignment(Pos.CENTER);
        botonContraFlorAlResto.setOnAction(new HandlerBotonContraFlorAlResto(this));

        Button botonVolver = new Button("volver");
        botonVolver.setPrefSize(100,50);
        botonVolver.setAlignment(Pos.CENTER);
        botonVolver.setOnAction(new HandlerBotonVolver(this));

        VBox contenedorDeJugadasFlor = new VBox(botonContraFlor,botonContraFlorAlResto,botonVolver);
        contenedorDeJugadasFlor.setPrefSize(150, 150);
        contenedorDeJugadasFlor.setStyle("-fx-background-color: #006699");
        contenedorDeJugadasFlor.setAlignment(Pos.CENTER);
        contenedorDeJugadasFlor.setSpacing(20);
        contenedorDeJugadasFlor.setPadding(new Insets(10));
        return contenedorDeJugadasFlor;
    }

    public VBox contenedorDeJugadas(){


        Label textoJugadas = new Label("Jugadas\nposibles: ");
        textoJugadas.setFont(Font.font(null, FontWeight.BOLD, 15));
        textoJugadas.setStyle("-fx-text-fill: #FFFFFF");

        Label textoEspacio = new Label();

        Button botonQuiero = new Button("Quiero");
        botonQuiero.setPrefSize(100,50);
        botonQuiero.setAlignment(Pos.CENTER);
        botonQuiero.setOnAction(new HandlerBotonQuiero(this));

        Button botonNoQuiero = new Button("No quiero");
        botonNoQuiero.setPrefSize(100, 50);
        botonNoQuiero.setAlignment(Pos.CENTER);
        botonNoQuiero.setOnAction(new HandlerBotonNoQuiero(this));


        Button botonEnvido = new Button("Envido");
        botonEnvido.setPrefSize(100,50);
        botonEnvido.setAlignment(Pos.CENTER);
        botonEnvido.setOnAction(new HandlerBotonJugadasEnvido(this));
        if (this.getJuego().manejadorDeTurnos.getManoActual() > 1 )
            botonEnvido.setDisable(true);


        Button botonAlMazo = new Button("mazo");
        botonAlMazo.setPrefSize(100,50);
        botonAlMazo.setAlignment(Pos.CENTER);
        botonAlMazo.setOnAction(new HandlerBotonMazo(this));

        Button botonTruco = new Button("Truco");
        botonTruco.setPrefSize(100,50);
        botonTruco.setAlignment(Pos.CENTER);
        botonTruco.setOnAction(new HandlerBotonJugadasTruco(this));
        if(juego.manejadorDeTurnos.getPrimeroQueCantoTruco() != null ){
                if ((juego.manejadorDeTurnos.getPrimeroQueCantoTruco().getJugador().getEquipo().getNombre())
                        .equals(juego.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().getNombre()))
                botonTruco.setDisable(true);
        }
        Button botonFlor = new Button("Flor");
        botonFlor.setPrefSize(100,50);
        botonFlor.setAlignment(Pos.CENTER);
        botonFlor.setOnAction(new HandlerBotonJugadasFlor(this));
        if (!this.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().getMano().hayFlorEnMano())
            botonFlor.setDisable(true);

        VBox contenedorDeJugadas = new VBox(textoJugadas,botonEnvido,botonTruco,botonFlor,botonAlMazo,textoEspacio,botonQuiero,botonNoQuiero);
        contenedorDeJugadas.setPrefSize(150,150);
        contenedorDeJugadas.setStyle("-fx-background-image: url('imagenes/texturaMesa.jpg')");
        contenedorDeJugadas.setAlignment(Pos.CENTER);
        contenedorDeJugadas.setSpacing(20);
        contenedorDeJugadas.setPadding(new Insets(10));

        return contenedorDeJugadas;
    }

    public VBox contenedorEstadoDeJuego(){
        // label Jugador en turno
        Label jugadorEnTurno = new Label("Turno actual:\n"+"    "+juego.manejadorDeTurnos.getJugadorConTurnoActual().getNombre());
        jugadorEnTurno.setFont(Font.font("Comic",FontWeight.BOLD, 15));
        jugadorEnTurno.setStyle("-fx-text-fill: #FFFFFF");

        // label puntajede jugador en turno
        Label puntajeDeJugador1 = new Label("Puntaje Equipo1:\n"+"            "+juego.manejadorDeTurnos.getJugadores().getJugadorEnPosicion(0).getEquipo().getPuntaje());
        puntajeDeJugador1.setFont(Font.font("Comic",FontWeight.BOLD, 15));
        puntajeDeJugador1.setStyle("-fx-text-fill: #FFFFFF");
        //label puntaje del juego
        Label puntajeDeJugador2 = new Label("Puntaje Equipo2:\n"+"            "+juego.manejadorDeTurnos.getJugadores().getJugadorEnPosicion(1).getEquipo().getPuntaje());
        puntajeDeJugador2.setFont(Font.font("Comic",FontWeight.BOLD, 15));
        puntajeDeJugador2.setStyle("-fx-text-fill: #FFFFFF");

        // lable manos ganadas por equipo
        Label manoActual = new Label("Mano Actual:\n "+"        "+juego.manejadorDeTurnos.getManoActual());
        manoActual.setFont(Font.font("Comic",FontWeight.BOLD, 15));
        manoActual.setStyle("-fx-text-fill: #FFFFFF");

        Label numeroDeRonda = new Label("Ronda Actual:\n"+"         "+juego.manejadorDeTurnos.getRondaActual());
        numeroDeRonda.setFont(Font.font("Comic",FontWeight.BOLD, 15));
        numeroDeRonda.setStyle("-fx-text-fill: #FFFFFF");


        // contenedor vertical donde se muestra el estado del juego
        VBox contenedorDeEstadoDeJuego = new VBox(jugadorEnTurno,puntajeDeJugador1,puntajeDeJugador2,manoActual,numeroDeRonda);
        contenedorDeEstadoDeJuego.setPrefSize(150, 150);
        contenedorDeEstadoDeJuego.setStyle("-fx-background-image: url('imagenes/texturaMesa.jpg')");
        contenedorDeEstadoDeJuego.setAlignment(Pos.CENTER);
        contenedorDeEstadoDeJuego.setPadding(new Insets(10));
        contenedorDeEstadoDeJuego.setSpacing(20);

        return contenedorDeEstadoDeJuego;
    }

    public Juego inicializarJuego(List<Jugador> jugadores) {
        juego = new Juego(conflor);

        for (Jugador jugador : jugadores){
            jugador.setJuego(juego);
            juego.agregarJugador(jugador);
        }
        juego.configurarManejadorDeTurnos();
        juego.repartirCartasAJugadores();
        return juego;
    }

    public BorderPane getBorderPane() {
        return this.panel;
    }

    public Juego getJuego(){
        return this.juego;
    }

    public ImageView getContenedorCartaJugador1() {
        return contenedorCartaJugador1;
    }

    public void actualizarBotonesCartas(){
        List<Integer> cartasJugadas = juego.manejadorDeTurnos.getJugadorConTurnoActual().getMano().getIndicesDeCartasJugadas();
        if (cartasJugadas.contains(0))
            botonCarta1.setVisible(false);
        else
            botonCarta1.setVisible(true);
        if (cartasJugadas.contains(1))
            botonCarta2.setVisible(false);
        else
            botonCarta2.setVisible(true);
        if (cartasJugadas.contains(2))
            botonCarta3.setVisible(false);
        else
            botonCarta3.setVisible(true);
    }
}