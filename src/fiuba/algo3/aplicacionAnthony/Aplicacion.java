package fiuba.algo3.aplicacionAnthony;


import fiuba.algo3.Eventos.HandlerBotonEnvido;
import fiuba.algo3.Eventos.HandlerBotonFlor;
import fiuba.algo3.Eventos.HandlerBotonTruco;
import fiuba.algo3.Eventos.HandlerBotonVolver;
import fiuba.algo3.Juego;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.manejoDeJugadores.Jugador;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.util.List;


/**
 * Created by anthony on 29/11/2015.
 */
public class Aplicacion extends Application {
    private BorderPane panel;
    private Juego juego;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        juego = this.inicializarJuego();
        stage.setTitle("Truco- Algoritmos y programacion 3");
        panel = new BorderPane();
        panel.setRight(this.contenedorDeJugadas());
        panel.setCenter(this.cuadriculaDeJuego());
        panel.setLeft(this.contenedorEstadoDeJuego());

        stage.setWidth(785);
        stage.setHeight(700);
        Scene scene = new Scene(panel);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public GridPane cuadriculaDeJuego(){
        Jugador jugadorConTurno = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        GridPane verticalMedio = new GridPane();
        verticalMedio.setStyle("-fx-background-color: #009900");
        ColumnConstraints columna0 = new ColumnConstraints(150,150,150);
        ColumnConstraints columna1 = new ColumnConstraints(150,150,150);
        ColumnConstraints columna2 = new ColumnConstraints(150,150,150);
        RowConstraints fila0 = new RowConstraints(150,150,150);
        RowConstraints fila1 = new RowConstraints(150,150,150);
        RowConstraints fila2 = new RowConstraints(150,150,150);
        RowConstraints fila3 = new RowConstraints(150,150,150);
        RowConstraints filaMano = new RowConstraints(50,50,50);
        verticalMedio.getColumnConstraints().add(0,columna0);
        verticalMedio.getColumnConstraints().add(1,columna1);
        verticalMedio.getColumnConstraints().add(2,columna2);
        verticalMedio.getRowConstraints().add(0,fila0);
        verticalMedio.getRowConstraints().add(1,fila1);
        verticalMedio.getRowConstraints().add(2,fila2);
        verticalMedio.getRowConstraints().add(3,fila3) ;
        verticalMedio.getRowConstraints().add(4,filaMano);
        verticalMedio.setGridLinesVisible(false);
        Image imagenLogo = new Image("imagenes/truco.jpg");
        ImageView contImage = new ImageView(imagenLogo);
        contImage.setFitWidth(140);
        contImage.setFitHeight(140);

        verticalMedio.add(contImage,1,1);
        verticalMedio.setPadding(new Insets(10));

        // imagenes de cartas
        List<Carta> cartasMano = juego.manejadorDeTurnos.getJugadorConTurnoActual().getMano().getCartasEnMano();
        Carta carta = cartasMano.get(0);
        String direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image cartaMano1 = new Image(direccionCarta);
        carta = cartasMano.get(1);
        direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image cartaMano2 = new Image(direccionCarta);
        carta = cartasMano.get(2);
        direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
        Image cartaMano3 = new Image(direccionCarta);

        Image cartaJugador1 = new Image("imagenes/huskar.jpg");
        Image cartaJugador2 = new Image("imagenes/huskar.jpg");
        Image cartaJugador3 = new Image("imagenes/huskar.jpg");
        Image cartaJugador4 = new Image("imagenes/huskar.jpg");

        ImageView contenedorCartaMano1 = new ImageView(cartaMano1);
        contenedorCartaMano1.setFitHeight(90);
        contenedorCartaMano1.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaMano1, HPos.CENTER);

        ImageView contenedorCartaMano2 = new ImageView(cartaMano2);
        contenedorCartaMano2.setFitHeight(90);
        contenedorCartaMano2.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaMano2, HPos.CENTER);

        ImageView contenedorCartaMano3 = new ImageView(cartaMano3);
        contenedorCartaMano3.setFitHeight(90);
        contenedorCartaMano3.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaMano3, HPos.CENTER);

        ImageView contenedorCartaJugador1 = new ImageView(cartaJugador1);
        contenedorCartaJugador1.setFitHeight(90);
        contenedorCartaJugador1.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador1, HPos.CENTER);

        ImageView contenedorCartaJugador2 = new ImageView(cartaJugador2);
        contenedorCartaJugador2.setFitHeight(90);
        contenedorCartaJugador2.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador2, HPos.CENTER);

        ImageView contenedorCartaJugador3 = new ImageView(cartaJugador3);
        contenedorCartaJugador3.setFitHeight(90);
        contenedorCartaJugador3.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador3, HPos.CENTER);

        ImageView contenedorCartaJugador4 = new ImageView(cartaJugador4);
        contenedorCartaJugador4.setFitHeight(90);
        contenedorCartaJugador4.setFitWidth(65);
        verticalMedio.setHalignment(contenedorCartaJugador4, HPos.CENTER);
        verticalMedio.add(contenedorCartaMano1,0,3);
        verticalMedio.add(contenedorCartaMano2,1,3);
        verticalMedio.add(contenedorCartaMano3,2,3);
        verticalMedio.add(contenedorCartaJugador1,1,2);
        verticalMedio.add(contenedorCartaJugador2,2,1);
        verticalMedio.add(contenedorCartaJugador3,1,0);
        verticalMedio.add(contenedorCartaJugador4,0,1);

        return verticalMedio;
    }

    public VBox contenedorDeJugadasEnvido(){
        Button botonEnvido = new Button("Envido");
        botonEnvido.setPrefSize(100,50);
        botonEnvido.setAlignment(Pos.CENTER);

        Button botonRealEnvido = new Button("Real Envido");
        botonRealEnvido.setPrefSize(100,50);
        botonRealEnvido.setAlignment(Pos.CENTER);

        Button botonFaltaEnvido = new Button("Falta Envido");
        botonFaltaEnvido.setPrefSize(100,50);
        botonFaltaEnvido.setAlignment(Pos.CENTER);

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

        Button botonRetruco = new Button("Retruco");
        botonRetruco.setPrefSize(100,50);
        botonRetruco.setAlignment(Pos.CENTER);

        Button botonValeCuatro = new Button("Vale cuatro");
        botonValeCuatro.setPrefSize(100,50);
        botonValeCuatro.setAlignment(Pos.CENTER);

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

        Button botonContraFlorAlResto = new Button("Contra flor al resto");
        botonContraFlorAlResto.setPrefSize(100, 50);
        botonContraFlorAlResto.setAlignment(Pos.CENTER);

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
        Button botonEnvido = new Button("Envido");
        botonEnvido.setPrefSize(100,50);
        botonEnvido.setAlignment(Pos.CENTER);
        botonEnvido.setOnAction(new HandlerBotonEnvido(this));

        Button botonAlMazo = new Button("mazo");
        botonAlMazo.setPrefSize(100,50);
        botonAlMazo.setAlignment(Pos.CENTER);

        Button botonTruco = new Button("Truco");
        botonTruco.setPrefSize(100,50);
        botonTruco.setAlignment(Pos.CENTER);
        botonTruco.setOnAction(new HandlerBotonTruco(this));

        Button botonFlor = new Button("Flor");
        botonFlor.setPrefSize(100,50);
        botonFlor.setAlignment(Pos.CENTER);
        botonFlor.setOnAction(new HandlerBotonFlor(this));

        VBox contenedorDeJugadas = new VBox(botonEnvido,botonTruco,botonFlor,botonAlMazo);
        contenedorDeJugadas.setPrefSize(150,150);
        contenedorDeJugadas.setStyle("-fx-background-color: #006699");
        contenedorDeJugadas.setAlignment(Pos.CENTER);
        contenedorDeJugadas.setSpacing(20);
        contenedorDeJugadas.setPadding(new Insets(10));
        return contenedorDeJugadas;
    }

    public VBox contenedorEstadoDeJuego(){
        // label Jugador en turno
        Label jugadorEnTurno = new Label("jugador en turno");
        jugadorEnTurno.setFont(new Font("Comic",10));

        // label puntajede jugador en turno
        Label puntajeDeJugadorEnTurno = new Label("puntaje de jugadoor en turno");
        puntajeDeJugadorEnTurno.setFont(new Font("Comic",10));

        //label puntaje del juego
        Label puntajeDeJuego = new Label("puntaje del juego");
        puntajeDeJuego.setFont(new Font("Comic",10));

        // lable manos ganadas por equipo
        Label manosGanadasPorRonda = new Label(" manos ganadas por ronda");
        manosGanadasPorRonda.setFont(new Font("Comic",10));

        // contenedor vertical de botones Jugadas
        VBox contenedorDeJugadas = this.contenedorDeJugadas();

        // contenedor vertical donde se muestra el estado del juego
        VBox contenedorDeEstadoDeJuego = new VBox(jugadorEnTurno,puntajeDeJugadorEnTurno,puntajeDeJuego,manosGanadasPorRonda);
        contenedorDeEstadoDeJuego.setPrefSize(150, 150);
        contenedorDeEstadoDeJuego.setStyle("-fx-background-color: #FF0000");
        contenedorDeEstadoDeJuego.setAlignment(Pos.CENTER);
        contenedorDeEstadoDeJuego.setPadding(new Insets(10));
        contenedorDeEstadoDeJuego.setSpacing(20);

        return contenedorDeEstadoDeJuego;
    }

    public Juego inicializarJuego() {
        Juego juego = new Juego();

        Jugador jugador1 = new Jugador("jugador1"),
                jugador2 = new Jugador("jugador2"),
                jugador3 = new Jugador("jugador3"),
                jugador4 = new Jugador("jugador4");

        jugador1.setJuego(juego);
        juego.agregarJugador(jugador1);
        jugador2.setJuego(juego);
        juego.agregarJugador(jugador2);
        jugador3.setJuego(juego);
        juego.agregarJugador(jugador3);
        jugador4.setJuego(juego);
        juego.agregarJugador(jugador4);
        juego.configurarManejadorDeTurnos();
        juego.repartirCartasAJugadores();
        return juego;
    }

    public BorderPane getBorderPane() {
        return this.panel;
    }
}
