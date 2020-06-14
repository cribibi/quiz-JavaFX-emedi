package emedi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main extends Application implements EventHandler<ActionEvent> {

    final static String url = "https://www.emedi.ro/";

    static String fileNameEseuRomana1 = "/Users/biancacricler/Documents/cosmin/src/emedi/eseuRomana1.txt";
    static String fileNameEseuRomana2 = "/Users/biancacricler/Documents/cosmin/src/emedi/eseuRomana2.txt";
    static String fileNameEseuRomana3 = "/Users/biancacricler/Documents/cosmin/src/emedi/eseuRomana3.txt";
    static String fileNameEseuIstorie = "/Users/biancacricler/Documents/cosmin/src/emedi/eseuIstorie.txt";

    static String fileNameIntrebariRomana = "/Users/biancacricler/Documents/cosmin/src/emedi/intrebariRomana.txt";
    static String fileNameVar1Romana = "/Users/biancacricler/Documents/cosmin/src/emedi/var1Romana.txt";
    static String fileNameVar2Romana = "/Users/biancacricler/Documents/cosmin/src/emedi/var2Romana.txt";
    static String fileNameVar3Romana = "/Users/biancacricler/Documents/cosmin/src/emedi/var3Romana.txt";
    static String fileNameVar4Romana = "/Users/biancacricler/Documents/cosmin/src/emedi/var4Romana.txt";
    static String fileNameRaspunsCorectRomana = "/Users/biancacricler/Documents/cosmin/src/emedi/raspunsRomana.txt";
    static String fileNameFeedbackRomana = "/Users/biancacricler/Documents/cosmin/src/emedi/feedbackRomana.txt";

    static String fileNameIntrebariIstorie = "/Users/biancacricler/Documents/cosmin/src/emedi/intrebariIstorie.txt";
    static String fileNameVar1Istorie = "/Users/biancacricler/Documents/cosmin/src/emedi/var1Istorie.txt";
    static String fileNameVar2Istorie = "/Users/biancacricler/Documents/cosmin/src/emedi/var2Istorie.txt";
    static String fileNameVar3Istorie = "/Users/biancacricler/Documents/cosmin/src/emedi/var3Istorie.txt";
    static String fileNameVar4IStorie = "/Users/biancacricler/Documents/cosmin/src/emedi/var4Istorie.txt";
    static String fileNameRaspunsCorectIstorie = "/Users/biancacricler/Documents/cosmin/src/emedi/raspunsIstorie.txt";
    static String fileNameFeedbackIstorie = "/Users/biancacricler/Documents/cosmin/src/emedi/feedbackIstorie.txt";

    static ArrayList<String> listaIntrebari = new ArrayList<>();
    static ArrayList<String> listaVar1 = new ArrayList<>();
    static ArrayList<String> listaVar2 = new ArrayList<>();
    static ArrayList<String> listaVar3 = new ArrayList<>();
    static ArrayList<String> listaVar4 = new ArrayList<>();
    static ArrayList<String> listaRaspunsuriCorecte = new ArrayList<>();
    static ArrayList<String> listaFeedback = new ArrayList<>();
    List<String> intrebariGresiteArrayList = new ArrayList<>();

    CheckBox checkBoxA, checkBoxB, checkBoxC, checkBoxD;
    Button buttonIncepeTestul = new Button("Start test");
    Button buttonVerificaRaspuns = new Button("Trimite raspunsul");
    Button buttonUrmatoareaIntrebare = new Button("Urmatoarea intrebare");
    Button buttonEseu1 = new Button("Eseu 1");
    Button buttonEseu2 = new Button("Eseu 2");
    Button buttonEseu3 = new Button("Eseu 3");
    Button buttonEseuIstorie = new Button("Eseu");
    Button buttonIntrebariGresite = new Button("Verifica intrebari gresite");
    Button buttonInapoiDinIntrebariGresite = new Button("Inapoi");
    Button buttonInapoiDinEseu = new Button("Inapoi");
    Button buttonRefaTestul = new Button("Reia testul");
    Button buttonEmedi = new Button("Cumpara varianta oficiala Emedi");
    Button buttonRomana = new Button("Limba romana");
    Button buttonIstorie = new Button("Istoria Romaniei");
    Button buttonBackToStart = new Button("Pagina initiala");

    int index;
    int nrRaspunsuriCorecte;
    static int nrIntrebari;
    int result;
    int width = 1000;
    int margine = 100;
    int height = 700;
    StringBuilder guess;
    StringBuilder helperFeedbackFinal = new StringBuilder("");
    String feedbackFinal;

    Text textEseu = new Text("text initial pentru eseu");
    StringBuilder stringBuilderTextEseu = new StringBuilder();
    String[] titluriEseu = {"Tema si viziunea despre lume", "Titlu eseu 2", "Titlu eseu 3"};

    VBox vBoxInceput;

    Rectangle rectangle1 = new Rectangle();
    VBox vBoxIntrebari;

    VBox vBoxIntrebareSiVariante;
    HBox hBoxButonVerificare;
    HBox hBoxInceput1;
    VBox vBoxIntrebareVarianteButoaneRaspuns;

    VBox vBoxRezultate;
    VBox vBoxButoaneRezultate;

    VBox vBoxFeedback;
    Rectangle rectangle2 = new Rectangle();

    VBox vBoxIntrebariGresite;
    VBox vBoxEseu;

    Label questionNrField = new Label();
    Text rezultat = new Text("Punctaj: ");
    Text questionText = new Text();
    Label bunVenit = new Label("Bine ai venit pe platforma Emedi!");
    Label materie = new Label("Teste limba romana");
    Text rezultatTest = new Text();
    Label rezultatText = new Label();
    Text titluEseu = new Text("Titlu eseu");
    Label titluIntrebariGresite = new Label("Intrebarile la care ati gresit");
    Label intrebariGresiteText = new Label();
    Label feedbackText = new Label();
    Label raspunsCorectGresit = new Label();

    BorderPane borderPanePaginaIntrebari = new BorderPane();
    StackPane stackPaneFeedback = new StackPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Platforma de testare Emedi");
        checkBoxA = new CheckBox();
        checkBoxA.setIndeterminate(false);
        checkBoxA.setWrapText(true);
        checkBoxB = new CheckBox();
        checkBoxB.setIndeterminate(false);
        checkBoxB.setWrapText(true);
        checkBoxC = new CheckBox();
        checkBoxC.setIndeterminate(false);
        checkBoxC.setWrapText(true);
        checkBoxD = new CheckBox();
        checkBoxD.setIndeterminate(false);
        checkBoxD.setWrapText(true);

        Hyperlink hyperlink = new Hyperlink("Go to emedi home page");
        buttonEmedi.setOnAction(actionEvent -> {
            getHostServices().showDocument(url);
        });

        intrebariGresiteText.setText(intrebariGresiteArrayList.toString());
        rezultatText.setTextAlignment(TextAlignment.CENTER);
        rezultat.setTextAlignment(TextAlignment.CENTER);
        titluEseu.setTextAlignment(TextAlignment.CENTER);
        materie.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        rezultatText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        titluEseu.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        titluIntrebariGresite.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        questionNrField.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
        questionText.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        feedbackText.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        raspunsCorectGresit.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 15));

        buttonIntrebariGresite.setDisable(true);
        buttonVerificaRaspuns.setDisable(true);

        checkBoxA.setOnAction(actionEvent -> {
            buttonVerificaRaspuns.setDisable(false);
        });

        checkBoxB.setOnAction(actionEvent -> {
            buttonVerificaRaspuns.setDisable(false);
        });

        checkBoxC.setOnAction(actionEvent -> {
            buttonVerificaRaspuns.setDisable(false);
        });

        checkBoxD.setOnAction(actionEvent -> {
            buttonVerificaRaspuns.setDisable(false);
        });
        //
        hBoxInceput1 = new HBox(50);
        hBoxInceput1.setPadding(new Insets(10, 12, 10, 12));
        buttonRomana.setAlignment(Pos.CENTER);
        buttonIstorie.setAlignment(Pos.CENTER);
        hBoxInceput1.getChildren().addAll(buttonRomana, buttonIstorie);
        hBoxInceput1.setAlignment(Pos.CENTER);

        VBox vBoxInceput1 = new VBox(50);
        vBoxInceput1.setPadding(new Insets(12, 10, 12, 10));
        bunVenit.setAlignment(Pos.CENTER);
        vBoxInceput1.getChildren().addAll(bunVenit, hBoxInceput1);
        vBoxInceput1.setAlignment(Pos.CENTER);
        vBoxInceput1.setPrefWidth(width);
        vBoxInceput1.setPrefWidth(height);
        bunVenit.setWrapText(false);
        bunVenit.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        vBoxInceput1.setLayoutX(width / 6);
        vBoxInceput1.setLayoutY(height / 3);

        Pane panePrimaPaginaSelectie = new Pane();
        panePrimaPaginaSelectie.setPadding(new Insets(12, 10, 12, 10));
        panePrimaPaginaSelectie.getChildren().addAll(vBoxInceput1);

        Scene sceneSelectie = new Scene(panePrimaPaginaSelectie, width, height);

        //
        vBoxInceput = new VBox(50);
        vBoxInceput.setPadding(new Insets(15, 12, 15, 12));
        vBoxInceput.getChildren().addAll(materie, buttonIncepeTestul);
        vBoxInceput.setAlignment(Pos.CENTER);

        StackPane stackPanePrimaPagina = new StackPane();
        stackPanePrimaPagina.setPadding(new Insets(175, 175, 175, 175));
        stackPanePrimaPagina.getChildren().addAll(vBoxInceput);
        Scene sceneInitial = new Scene(stackPanePrimaPagina, width, height);

        //ok
        vBoxIntrebari = new VBox();
        vBoxIntrebari.setPadding(new Insets(15, 12, 15, 12));
        vBoxIntrebari.getChildren().addAll(questionNrField);
        vBoxIntrebari.setAlignment(Pos.CENTER);

        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setStrokeWidth(2);
        rectangle1.setWidth(width - 100);
        rectangle1.setHeight(50);


        StackPane stackPaneIntrebari = new StackPane();
        stackPaneIntrebari.setPadding(new Insets(10, 10, 10, 10));
        stackPaneIntrebari.getChildren().addAll(rectangle1, vBoxIntrebari);

        vBoxIntrebareSiVariante = new VBox(10);
        vBoxIntrebareSiVariante.setPadding(new Insets(15, 12, 15, 52));
        questionText.setWrappingWidth(rectangle1.getWidth() - 10);
        vBoxIntrebareSiVariante.getChildren().addAll(questionText, checkBoxA, checkBoxB, checkBoxC, checkBoxD);
        vBoxIntrebareSiVariante.setAlignment(Pos.CENTER_LEFT);

        hBoxButonVerificare = new HBox(10);
        hBoxButonVerificare.setPadding(new Insets(15, 12, 50, 12));
        hBoxButonVerificare.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxButonVerificare.getChildren().add(buttonVerificaRaspuns);

        borderPanePaginaIntrebari.setTop(stackPaneIntrebari);
        borderPanePaginaIntrebari.setCenter(vBoxIntrebareSiVariante);
        borderPanePaginaIntrebari.setBottom(hBoxButonVerificare);
        borderPanePaginaIntrebari.setMaxWidth(width);
        borderPanePaginaIntrebari.setMaxHeight(height);

        Scene sceneIntrebari = new Scene(borderPanePaginaIntrebari, width, height);


        //
        VBox vBoxCorectGresit = new VBox();
        vBoxCorectGresit.setPadding(new Insets(15, 12, 15, 12));
        vBoxCorectGresit.setAlignment(Pos.CENTER);
        vBoxCorectGresit.getChildren().add(raspunsCorectGresit);

        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setStroke(Color.MEDIUMPURPLE);
        rectangle2.setStrokeWidth(2);
        rectangle2.setWidth(width - 100);
        rectangle2.setLayoutX(width / 2 - (width - 100) / 2);

        vBoxFeedback = new VBox(10);
        vBoxFeedback.setPadding(new Insets(15, 12, 15, 12));
        feedbackText.prefWidthProperty().bind(rectangle2.widthProperty().subtract(10));
        feedbackText.setWrapText(true);
        feedbackText.setAlignment(Pos.CENTER);
        vBoxFeedback.getChildren().add(feedbackText);
        vBoxFeedback.setAlignment(Pos.CENTER_LEFT);
        rectangle2.heightProperty().bind(feedbackText.heightProperty().add(30));
        rectangle2.setArcHeight(40);
        rectangle2.setArcWidth(40);

        stackPaneFeedback.setPadding(new Insets(10, 10, 10, 10));
        stackPaneFeedback.getChildren().addAll(rectangle2, vBoxFeedback);
        stackPaneFeedback.setAlignment(Pos.CENTER);

        HBox hBoxButUrmIntreb = new HBox();
        hBoxButUrmIntreb.setPadding(new Insets(15, 12, 40, 12));
        hBoxButUrmIntreb.getChildren().add(buttonUrmatoareaIntrebare);
        hBoxButUrmIntreb.setAlignment(Pos.CENTER_RIGHT);

        VBox vBoxFeedbackTotal = new VBox(30);
        vBoxFeedbackTotal.getChildren().addAll(vBoxCorectGresit, stackPaneFeedback, hBoxButUrmIntreb);

        Pane paneFeedback = new Pane();
        paneFeedback.getChildren().add(vBoxFeedbackTotal);

        Scene sceneFeedback = new Scene(paneFeedback, width, height);

        //
        vBoxButoaneRezultate = new VBox(15);
        vBoxButoaneRezultate.setPadding(new Insets(15, 12, 50, 12));
        vBoxButoaneRezultate.setAlignment(Pos.CENTER);
        vBoxButoaneRezultate.getChildren().addAll(buttonEmedi, buttonIntrebariGresite, buttonRefaTestul, buttonBackToStart, buttonEseu1, buttonEseu2, buttonEseu3, buttonEseuIstorie);

        vBoxRezultate = new VBox(50);
        vBoxRezultate.setPadding(new Insets(50, 25, 25, 22));
        vBoxRezultate.getChildren().addAll(rezultatText, vBoxButoaneRezultate);
        vBoxRezultate.setAlignment(Pos.CENTER);

        VBox vBoxRezultat = new VBox(30);
        vBoxRezultat.setAlignment(Pos.CENTER);
        vBoxRezultat.setPrefSize(width, height);
        vBoxRezultat.getChildren().addAll(vBoxRezultate, vBoxButoaneRezultate);

        Pane paneRezultate = new Pane();
        paneRezultate.getChildren().add(vBoxRezultat);

        Scene sceneRezultate = new Scene(paneRezultate, width, height);

        //
        vBoxIntrebariGresite = new VBox(10);
        vBoxIntrebariGresite.setPadding(new Insets(15, 15, 15, 15));
        buttonInapoiDinIntrebariGresite.setAlignment(Pos.BOTTOM_RIGHT);
        vBoxIntrebariGresite.getChildren().addAll(titluIntrebariGresite, intrebariGresiteText, buttonInapoiDinIntrebariGresite);
        vBoxIntrebariGresite.setAlignment(Pos.CENTER);

        ScrollPane scrollPaneIntrebariGresite = new ScrollPane();
        scrollPaneIntrebariGresite.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneIntrebariGresite.setContent(vBoxIntrebariGresite);
        Scene sceneIntrebariGresite = new Scene(scrollPaneIntrebariGresite, width, height);


        //
        vBoxEseu = new VBox(15);
        vBoxEseu.setPadding(new Insets(15, 12, 15, 12));
        vBoxEseu.getChildren().addAll(titluEseu, textEseu, buttonInapoiDinEseu);
        vBoxEseu.setAlignment(Pos.CENTER);

        ScrollPane scrollPaneEseu = new ScrollPane();
        scrollPaneEseu.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneEseu.setContent(vBoxEseu);
        Scene sceneEseu = new Scene(scrollPaneEseu, width, height);
        textEseu.setWrappingWidth(sceneEseu.getWidth() - 50);

        //
        sceneSelectie.getStylesheets().add("emedi/css/firstpage.css");
        sceneInitial.getStylesheets().add("emedi/css/firstpage.css");
        sceneInitial.getStylesheets().add("emedi/css/buttons.css");

        sceneIntrebari.getStylesheets().add("emedi/css/checkbox.css");
        sceneIntrebari.getStylesheets().add("emedi/css/buttons.css");
        sceneIntrebari.getStylesheets().add("emedi/css/whiteBackground.css");

        sceneFeedback.getStylesheets().add("emedi/css/buttons.css");
        sceneFeedback.getStylesheets().add("emedi/css/checkbox.css");
        sceneFeedback.getStylesheets().add("emedi/css/feedback.css");

        sceneRezultate.getStylesheets().add("emedi/css/firstpage.css");
        sceneRezultate.getStylesheets().add("emedi/css/buttons.css");

        sceneIntrebariGresite.getStylesheets().add("emedi/css/buttons.css");
        sceneIntrebariGresite.getStylesheets().add("emedi/css/intrebarigresite.css");


        sceneEseu.getStylesheets().add("emedi/css/buttons.css");
        sceneEseu.getStylesheets().add("emedi/css/eseu.css");

        primaryStage.setScene(sceneSelectie);

        buttonRomana.setOnAction(actionEvent -> {
            materie.setText("Test la limba romana");

            try {
                readFiles(fileNameIntrebariRomana, listaIntrebari);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            nrIntrebari = listaIntrebari.size();

            try {
                readFiles(fileNameVar1Romana, listaVar1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameVar2Romana, listaVar2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameVar3Romana, listaVar3);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameVar4Romana, listaVar4);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameRaspunsCorectRomana, listaRaspunsuriCorecte);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameFeedbackRomana, listaFeedback);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //buttonEseuIstorie.setVisible(false);

            primaryStage.setScene(sceneInitial);
        });

        buttonIstorie.setOnAction(actionEvent -> {
            materie.setText("Test la istorie");

            try {
                readFiles(fileNameIntrebariIstorie, listaIntrebari);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            nrIntrebari = listaIntrebari.size();

            try {
                readFiles(fileNameVar1Istorie, listaVar1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameVar2Istorie, listaVar2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameVar3Istorie, listaVar3);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameVar4IStorie, listaVar4);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameRaspunsCorectIstorie, listaRaspunsuriCorecte);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                readFiles(fileNameFeedbackIstorie, listaFeedback);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            buttonEseu3.setVisible(false);
            buttonEseu2.setVisible(false);
            buttonEseu1.setVisible(false);
            primaryStage.setScene(sceneInitial);

        });



        buttonIncepeTestul.setOnAction(actionEvent -> {
            nextQuestion();
            primaryStage.setScene(sceneIntrebari);
        });

        buttonVerificaRaspuns.setOnAction(actionEvent -> {
            guess = new StringBuilder();
            if (checkBoxA.isSelected()) {
                guess.append("A");
            }
            if (checkBoxB.isSelected()) {
                guess.append("B");
            }
            if (checkBoxC.isSelected()) {
                guess.append("C");
            }
            if (checkBoxD.isSelected()) {
                guess.append("D");
            }
            if (guess.toString().equals(listaRaspunsuriCorecte.get(index))) {
                nrRaspunsuriCorecte++;
            }

            checkBoxA.setDisable(true);
            checkBoxB.setDisable(true);
            checkBoxC.setDisable(true);
            checkBoxD.setDisable(true);
            buttonVerificaRaspuns.setDisable(true);
            buttonUrmatoareaIntrebare.setDisable(false);
            primaryStage.setScene(sceneFeedback);
            displayAnswer();
        });

        buttonUrmatoareaIntrebare.setOnAction(actionEvent -> {
            index++;
            raspunsCorectGresit.setText("");
            checkBoxA.setDisable(false);
            checkBoxB.setDisable(false);
            checkBoxC.setDisable(false);
            checkBoxD.setDisable(false);
            if (index == listaIntrebari.size() - 1) {
                buttonUrmatoareaIntrebare.setText("Vezi rezultate");
            }

            if (index >= listaIntrebari.size()) {
                results();
                primaryStage.setScene(sceneRezultate);
            } else {
                primaryStage.setScene(sceneIntrebari);
                nextQuestion();
            }
        });

        buttonEseuIstorie.setOnAction(actionEvent -> {
            try {
                readEssay(fileNameEseuIstorie, stringBuilderTextEseu);
            } catch (IOException e) {
                e.printStackTrace();
            }
            titluEseu.setText("eseu istorie");
            textEseu.setText(stringBuilderTextEseu.toString());
            primaryStage.setScene(sceneEseu);

        });

        buttonEseu1.setOnAction(actionEvent -> {
            try {
                readEssay(fileNameEseuRomana1, stringBuilderTextEseu);
            } catch (IOException e) {
                e.printStackTrace();
            }
            titluEseu.setText(titluriEseu[0]);
            textEseu.setText(stringBuilderTextEseu.toString());
            primaryStage.setScene(sceneEseu);
        });

        buttonEseu2.setOnAction(actionEvent -> {
            try {
                readEssay(fileNameEseuRomana2, stringBuilderTextEseu);
            } catch (IOException e) {
                e.printStackTrace();
            }
            titluEseu.setText(titluriEseu[1]);
            primaryStage.setScene(sceneEseu);
        });

        buttonEseu3.setOnAction(actionEvent -> {
            try {
                readEssay(fileNameEseuRomana3, stringBuilderTextEseu);
            } catch (IOException e) {
                e.printStackTrace();
            }
            titluEseu.setText(titluriEseu[2]);
            primaryStage.setScene(sceneEseu);
        });

        buttonIntrebariGresite.setOnAction(actionEvent ->
                primaryStage.setScene(sceneIntrebariGresite));

        buttonInapoiDinEseu.setOnAction(actionEvent -> {
            primaryStage.setScene(sceneRezultate);
        });

        buttonInapoiDinIntrebariGresite.setOnAction(actionEvent -> {
            primaryStage.setScene(sceneRezultate);
        });

        buttonRefaTestul.setOnAction(actionEvent -> {
            helperFeedbackFinal.delete(0, helperFeedbackFinal.length());
            index = 0;
            nrRaspunsuriCorecte = 0;
            buttonUrmatoareaIntrebare.setText("Urmatoarea intrebare");
            primaryStage.setScene(sceneInitial);
        });

        buttonBackToStart.setOnAction(actionEvent -> {
            helperFeedbackFinal.delete(0, helperFeedbackFinal.length());
            index = 0;
            nrRaspunsuriCorecte = 0;
            buttonUrmatoareaIntrebare.setText("Urmatoarea intrebare");
            buttonEseuIstorie.setVisible(true);
            buttonEseu1.setVisible(true);
            buttonEseu2.setVisible(true);
            buttonEseu3.setVisible(true);
            listaIntrebari.clear();
            listaVar1.clear();
            listaVar2.clear();
            listaVar3.clear();
            listaVar4.clear();
            listaRaspunsuriCorecte.clear();
            listaFeedback.clear();
            primaryStage.setScene(sceneSelectie);
        });

        primaryStage.setResizable(true);
        primaryStage.show();

    }


    public void nextQuestion() {
        if (index >= nrIntrebari) {
            results();
        } else {
            questionNrField.setText("Intrebarea numarul " + (index + 1) + " din " + nrIntrebari + ":");
            questionText.setText(listaIntrebari.get(index));
            checkBoxA.setText(listaVar1.get(index));

            checkBoxA.setSelected(false);
            checkBoxB.setText(listaVar2.get(index));
            checkBoxB.setSelected(false);
            checkBoxC.setText(listaVar3.get(index));
            checkBoxC.setSelected(false);
            checkBoxD.setText(listaVar4.get(index));
            checkBoxD.setSelected(false);
        }
    }

    public void displayAnswer() {
        if (guess.toString().equals(listaRaspunsuriCorecte.get(index))) {
            raspunsCorectGresit.setText("Răspuns corect!");
            feedbackText.setText("Felicitari!");
        } else {
            raspunsCorectGresit.setText("Raspuns gresit :( :( :(");
            feedbackText.setText(listaFeedback.get(index));
            helperFeedbackFinal.append("• " + listaIntrebari.get(index) + "\n" +
                    "A. " + listaVar1.get(index) + "\n" +
                    "B. " + listaVar2.get(index) + "\n" +
                    "C. " + listaVar3.get(index) + "\n" +
                    "D. " + listaVar4.get(index) + "\n" + "\n");
        }
    }

    public void results() {
        result = (int) ((nrRaspunsuriCorecte / (double) nrIntrebari) * 100);
        rezultatTest.setText(String.valueOf(result) + "%");
        if (result >= 70) {
            rezultatText.setText("Rezultat: " + result + "%" +
                    "\nAi raspuns corect la " + nrRaspunsuriCorecte + " intrebari din " + nrIntrebari + ".\n" +
                    "\n\nFelicitari! Ati trecut testul.");

        } else {
            rezultatText.setText("Rezultat: " + result + "%" +
                    "\nAi raspuns corect la " + nrRaspunsuriCorecte + " intrebari din " + nrIntrebari + ".\n" +
                    "\n\nDin pacate nu ai reusit sa treci testul. Nu te panica, poti face urmatoarele:");
        }

        feedbackFinal = helperFeedbackFinal.toString();
        if (!"".equals(feedbackFinal)) {
            intrebariGresiteText.setText(feedbackFinal);
            titluIntrebariGresite.setText("Intrebarile la care ati gresit");
            buttonIntrebariGresite.setDisable(false);
        } else {
            intrebariGresiteText.setText("Nu ati gresit nicio intrebare.");
            titluIntrebariGresite.setText("Felicitari! ");
            buttonIntrebariGresite.setDisable(true);
        }
    }


    @Override
    public void handle(ActionEvent actionEvent) {

    }

    public static void readQuestions(String fileName, ArrayList<String> intrebare, ArrayList<String> var1,
                                     ArrayList<String> var2, ArrayList<String> var3, ArrayList<String> var4,
                                     ArrayList<String> raspuns, ArrayList<String> indicatii)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] fields = line.split(";");
            String i = fields[0];
            String v1 = fields[1];
            String v2 = fields[2];
            String v3 = fields[3];
            String v4 = fields[4];
            String r = fields[5];
            String c = fields[6];
            intrebare.add(i);
            var1.add(v1);
            var2.add(v2);
            var3.add(v3);
            var4.add(v4);
            raspuns.add(r);
            indicatii.add(c);
        }
        nrIntrebari = intrebare.size();
    }

    public static void readFiles(String fileName, ArrayList<String> list)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String line = input.nextLine();
            list.add(line);
        }
    }

    public static void readEssay(String fileName, StringBuilder stringBuilderTextEseu) throws IOException {
        //BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), Charset.forName("UTF-8"));
        BufferedReader reader
                = new BufferedReader(new FileReader(fileName));
        int theCharNum = reader.read();
        while(theCharNum != -1) {
            char theChar = (char) theCharNum;
            stringBuilderTextEseu.append(theChar);
            theCharNum = reader.read();
        }
    }
}