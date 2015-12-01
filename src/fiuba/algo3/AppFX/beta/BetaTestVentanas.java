package fiuba.algo3.AppFX.beta;


import fiuba.algo3.AppFX.HandlerBotonConfirmarConfiguracion;
import fiuba.algo3.AppFX.HandlerBotonConfirmarJugadores;
import fiuba.algo3.AppFX.HandlerNuevaPartida;
import fiuba.algo3.AppFX.eventosBeta.*;
import fiuba.algo3.Juego;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.manejoDeJugadores.Jugador;
import javafx.application.Application;
import javafx.application.Platform;
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
 * Created by Fechee on 29/11/2015.
 */
public class BetaTestVentanas extends Application {
    public BorderPane panel;
    private ImageView contenedorCartaJugador1, contenedorCartaJugador2,
            contenedorCartaJugador3,contenedorCartaJugador4;

    private boolean inicializado=false;
    private Button botonJugarCarta1,botonJugarCarta2,botonJugarCarta3;
    private Juego juego;
    public Integer manoActual=0;
    public Integer rondaActual=1;
    public GridPane verticalMedio;
    public VBox configurar,nombrar;


    public BetaTestVentanas(){
        //this.juego = this.inicializarJuego();
    }



    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){

        stage.setTitle("Truco - Algoritmos y programacion 3");
        panel = new BorderPane();

        //panel.setRight(this.contenedorDeJugadas());
        //panel.setCenter(this.inicializarMesaParaNuevaPartida());

        panel.setCenter(this.generarPanelDeConfiguracion());

        //panel.setLeft(this.contenedorEstadoDeJuego());
        panel.setTop(this.crearMenuDeVentana(stage));

        stage.setWidth(770);
        stage.setHeight(700);
        Scene scene = new Scene(panel);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public VBox generarPanelDeConfiguracion(){

        configurar = new VBox();
        configurar.setSpacing(40);

        Label bienvenida = new Label("Bienvenido al Truco!");
        bienvenida.setFont(Font.font ("Verdana", 28));
        configurar.getChildren().add(bienvenida);

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");


        ChoiceBox selector = new ChoiceBox(FXCollections.observableArrayList("2 Jugadores", "4 Jugadores"));
        selector.setTooltip((new Tooltip("Seleccione la cantidad de jugadores.")));
        selector.getSelectionModel().selectFirst();
        CheckBox conFlor = new CheckBox("Con Flor");
        conFlor.setSelected(true);

        configurar.getChildren().add(new Label("      Seleccione la cantidad de jugadores y el modo de juego."));


        HBox configNueva = new HBox(selector,conFlor);
        configNueva.setAlignment(Pos.CENTER);
        configNueva.setSpacing(30);
        configurar.getChildren().add(configNueva);

        HandlerBotonConfirmarConfiguracion handler = new HandlerBotonConfirmarConfiguracion(this,selector);
        botonConfirmar.setOnAction(handler);

        configurar.getChildren().add(botonConfirmar);

        configurar.setAlignment(Pos.CENTER);
        return configurar;
    }



    private MenuBar crearMenuDeVentana(Stage stage) {
        MenuBar barraDeMenu = new MenuBar();
        barraDeMenu.prefWidthProperty().bind(stage.widthProperty());

        Menu menuDeArchivo = new Menu("Archivo");
        MenuItem nuevoJuegoItemMenu = new MenuItem("Nuevo Juego");
        nuevoJuegoItemMenu.setOnAction(new HandlerNuevaPartida(this));
        MenuItem opcionesItemMenu = new MenuItem("Opciones");
        MenuItem salirItemMenu = new MenuItem("Salir");
        salirItemMenu.setOnAction(actionEvent-> Platform.exit());

        menuDeArchivo.getItems().addAll(nuevoJuegoItemMenu, opcionesItemMenu, new SeparatorMenuItem(), salirItemMenu);

        Menu menuDeSoporte = new Menu("Ayuda y Soporte");
        MenuItem valoresDeCartasItemMenu = new MenuItem("Valores de Cartas");
        MenuItem creditosItemMenu = new MenuItem("Creditos..");

        menuDeSoporte.getItems().addAll(valoresDeCartasItemMenu, creditosItemMenu);

        barraDeMenu.getMenus().addAll(menuDeArchivo, menuDeSoporte);
        return barraDeMenu;
    }


    public GridPane inicializarMesaParaNuevaPartida(){
        //this.juego = inicializarJuego();
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
        verticalMedio.setHalignment(contImage, HPos.CENTER);
        verticalMedio.setPadding(new Insets(10));


        // imagenes de cartas en mano
        inicializarCartasEnMano(verticalMedio);

        //imagenes de cartas en mesa

        inicializarImagenesDeCartasEnMesa(5,null);


        //contenedorCartaJugador1.setImage(new Image("imagenes/naipeDota.jpg"));

        this.verticalMedio = verticalMedio;
        return verticalMedio;
    }


    public void actualizarCartasEnManoParaJugadorActual(){
        List<Carta> cartasMano = juego.manejadorDeTurnos.getJugadorConTurnoActual().getMano().getCartasEnMano();
        Carta carta = cartasMano.get(0);
        String direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image imagenCarta1 = new Image(direccionCarta);
        ImageView iv1 = new ImageView(imagenCarta1);
        iv1.setFitHeight(130);
        iv1.setFitWidth(90);
        if (!inicializado){botonJugarCarta1 = new Button("Jugar carta 1");}
        botonJugarCarta1.setFont(Font.font(null, FontWeight.BOLD, 15));
        botonJugarCarta1.setGraphic(iv1);
        botonJugarCarta1.setDefaultButton(true);
        botonJugarCarta1.setContentDisplay(ContentDisplay.TOP);
        botonJugarCarta1.setOnAction(new HandlerBotonJugarCartaEnPosicion(0,this,imagenCarta1));
        botonJugarCarta1.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg');-fx-text-fill: #FFCC00");


        carta = cartasMano.get(1);
        direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image imagenCarta2 = new Image(direccionCarta);
        ImageView iv2 = new ImageView(imagenCarta2);
        iv2.setFitWidth(90);
        iv2.setFitHeight(130);
        if (!inicializado){botonJugarCarta2 = new Button("Jugar carta 2");}
        botonJugarCarta2.setFont(Font.font(null, FontWeight.BOLD, 15));
        botonJugarCarta2.setGraphic(iv2);
        botonJugarCarta2.setDefaultButton(true);
        botonJugarCarta2.setContentDisplay(ContentDisplay.TOP);
        botonJugarCarta2.setOnAction(new HandlerBotonJugarCartaEnPosicion(1,this,imagenCarta2));
        botonJugarCarta2.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg');-fx-text-fill: #FFCC00");

        carta = cartasMano.get(2);
        direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image imagenCarta3 = new Image(direccionCarta);
        ImageView iv3 = new ImageView(imagenCarta3);
        iv3.setFitHeight(130);
        iv3.setFitWidth(90);
        if (!inicializado){botonJugarCarta3 = new Button("Jugar carta 3"); inicializado=true;}
        botonJugarCarta3.setFont(Font.font(null, FontWeight.BOLD, 15));
        botonJugarCarta3.setGraphic(iv3);
        botonJugarCarta3.setDefaultButton(true);
        botonJugarCarta3.setContentDisplay(ContentDisplay.TOP);
        botonJugarCarta3.setOnAction(new HandlerBotonJugarCartaEnPosicion(2,this,imagenCarta3));
        botonJugarCarta3.setStyle("-fx-background-image: url('imagenes/texturaMadera2.jpg');-fx-text-fill: #FFCC00");


    }




    public List<HBox> generarContenedoresSegunCantidadDeJugadores(Integer opcionSelector){
        this.nombrar = new VBox();
        int cantidadJugadores=2;
        if (opcionSelector==1){cantidadJugadores=4;}
        ArrayList<HBox> contenedores = new ArrayList<HBox>();
        for (int i = 0 ; i < cantidadJugadores ; i++) {
            Label instruccion = new Label("Introduzca nombre del Jugador "+(i+1)+": ");
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
        HandlerBotonConfirmarJugadores handler = new HandlerBotonConfirmarJugadores(contenedores,this);
        confirmarPartida.setOnAction(handler);

        nombrar.getChildren().add(confirmarPartida);
        return contenedores;
    }



    public void inicializarCartasEnMano(GridPane verticalMedio) {
        actualizarCartasEnManoParaJugadorActual();

        verticalMedio.add(botonJugarCarta1,0,3);
        verticalMedio.add(botonJugarCarta2,1,3);
        verticalMedio.add(botonJugarCarta3,2,3);
    }

    public void inicializarImagenesDeCartasEnMesa(Integer posicion,Image imagen) {

        Image cartaJugador1 = new Image("imagenes/huskar.jpg");
        Image cartaJugador2 = new Image("imagenes/huskar.jpg");
        Image cartaJugador3 = new Image("imagenes/huskar.jpg");
        Image cartaJugador4 = new Image("imagenes/huskar.jpg");

        contenedorCartaJugador1 = new ImageView(cartaJugador1);
        contenedorCartaJugador1.setFitHeight(90);
        contenedorCartaJugador1.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador1, HPos.CENTER);
        if (posicion==1) {contenedorCartaJugador1.setImage(imagen);}

        contenedorCartaJugador2 = new ImageView(cartaJugador2);
        contenedorCartaJugador2.setFitHeight(90);
        contenedorCartaJugador2.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador2, HPos.CENTER);
        if (posicion==2) {contenedorCartaJugador2.setImage(imagen);}

        contenedorCartaJugador3 = new ImageView(cartaJugador3);
        contenedorCartaJugador3.setFitHeight(90);
        contenedorCartaJugador3.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador3, HPos.CENTER);
        if (posicion==3) {contenedorCartaJugador3.setImage(imagen);}

        contenedorCartaJugador4 = new ImageView(cartaJugador4);
        contenedorCartaJugador4.setFitHeight(90);
        contenedorCartaJugador4.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador4, HPos.CENTER);
        if (posicion==4) {contenedorCartaJugador4.setImage(imagen);}

        verticalMedio.add(contenedorCartaJugador1,1,2);
        verticalMedio.add(contenedorCartaJugador2,2,1);
        verticalMedio.add(contenedorCartaJugador3,1,0);
        verticalMedio.add(contenedorCartaJugador4,0,1);
    }

    public void actualizarMesa(){
    }


    public VBox contenedorDeJugadasEnvido(){
        Button botonEnvido = new Button("Envido");
        botonEnvido.setPrefSize(100,50);
        botonEnvido.setAlignment(Pos.CENTER);
        botonEnvido.setOnAction(new HandlerBotonEnvidoBeta(this));

        Button botonRealEnvido = new Button("Real Envido");
        botonRealEnvido.setPrefSize(100,50);
        botonRealEnvido.setAlignment(Pos.CENTER);
        botonRealEnvido.setOnAction(new HandlerBotonContraFlorBeta(this));

        Button botonFaltaEnvido = new Button("Falta Envido");
        botonFaltaEnvido.setPrefSize(100,50);
        botonFaltaEnvido.setAlignment(Pos.CENTER);
        botonFaltaEnvido.setOnAction(new HandlerBotonFaltaEnvidoBeta(this));

        Button botonVolver = new Button("volver");
        botonVolver.setPrefSize(100,50);
        botonVolver.setAlignment(Pos.CENTER);
        botonVolver.setOnAction(new HandlerBotonVolverBeta(this));

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
        botonTruco.setOnAction(new HandlerBotonTrucoBeta(this));

        Button botonRetruco = new Button("Retruco");
        botonRetruco.setPrefSize(100,50);
        botonRetruco.setAlignment(Pos.CENTER);
        botonRetruco.setOnAction(new HandlerBotonRetrucoBeta(this));

        Button botonValeCuatro = new Button("Vale cuatro");
        botonValeCuatro.setPrefSize(100,50);
        botonValeCuatro.setAlignment(Pos.CENTER);
        botonValeCuatro.setOnAction(new HandlerBotonContraFlorBeta(this));

        Button botonVolver = new Button("volver");
        botonVolver.setPrefSize(100,50);
        botonVolver.setAlignment(Pos.CENTER);
        botonVolver.setOnAction(new HandlerBotonVolverBeta(this));

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
        botonContraFlor.setOnAction(new HandlerBotonContraFlorBeta(this));

        Button botonContraFlorAlResto = new Button("Contra flor al resto");
        botonContraFlorAlResto.setPrefSize(100, 50);
        botonContraFlorAlResto.setAlignment(Pos.CENTER);
        botonContraFlorAlResto.setOnAction(new HandlerBotonContraFlorAlRestoBeta(this));

        Button botonVolver = new Button("volver");
        botonVolver.setPrefSize(100,50);
        botonVolver.setAlignment(Pos.CENTER);
        botonVolver.setOnAction(new HandlerBotonVolverBeta(this));

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
    botonQuiero.setOnAction(new HandlerBotonQuieroBeta(this));

    Button botonNoQuiero = new Button("No quiero");
    botonNoQuiero.setPrefSize(100, 50);
    botonNoQuiero.setAlignment(Pos.CENTER);
    botonNoQuiero.setOnAction(new HandlerBotonNoQuieroBeta(this));


    Button botonEnvido = new Button("Envido");
    botonEnvido.setPrefSize(100,50);
    botonEnvido.setAlignment(Pos.CENTER);
    botonEnvido.setOnAction(new HandlerBotonJugadasEnvidoBeta(this));
    if (this.getJuego().manejadorDeTurnos.getManoActual() > 1 || juego.getPuntosDeEnvidoQuerido() > 0)
        botonEnvido.setDisable(true);


    Button botonAlMazo = new Button("mazo");
    botonAlMazo.setPrefSize(100,50);
    botonAlMazo.setAlignment(Pos.CENTER);
    botonAlMazo.setOnAction(new HandlerBotonMazoBeta(this));

    Button botonTruco = new Button("Truco");
    botonTruco.setPrefSize(100,50);
    botonTruco.setAlignment(Pos.CENTER);
    botonTruco.setOnAction(new HandlerBotonJugadasTrucoBeta(this));
    if(juego.manejadorDeTurnos.getPrimeroQueCantoTruco() != null ){
        if ((juego.manejadorDeTurnos.getPrimeroQueCantoTruco().getJugador().getEquipo().getNombre())
                .equals(juego.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().getNombre()))
            botonTruco.setDisable(true);
    }
    Button botonFlor = new Button("Flor");
    botonFlor.setPrefSize(100,50);
    botonFlor.setAlignment(Pos.CENTER);
    botonFlor.setOnAction(new HandlerBotonJugadasFlorBeta(this));
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
        juego = new Juego();

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

    public ImageView getContenedorCartaJugador(int pos) {
        if (pos==0)    return contenedorCartaJugador1;
        if (pos==1)    return contenedorCartaJugador2;
        if (pos==2)    return contenedorCartaJugador3;
        else return contenedorCartaJugador4;
    }

    public void actualizarBotonesCartas(){
        List<Integer> cartasJugadas = juego.manejadorDeTurnos.getJugadorConTurnoActual().getMano().getIndicesDeCartasJugadas();
        if (cartasJugadas.contains(0))
            botonJugarCarta1.setVisible(false);
        else
            botonJugarCarta1.setVisible(true);
        if (cartasJugadas.contains(1))
            botonJugarCarta2.setVisible(false);
        else
            botonJugarCarta2.setVisible(true);
        if (cartasJugadas.contains(2))
            botonJugarCarta3.setVisible(false);
        else
            botonJugarCarta3.setVisible(true);
    }
}
