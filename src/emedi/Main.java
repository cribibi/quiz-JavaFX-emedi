package emedi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main extends Application implements EventHandler<ActionEvent> {

    final static String url = "https://www.emedi.ro/";

    static String fileNameEseuRomana1 = "eseuRomana1.txt";
    static String fileNameEseuRomana2 = "eseuRomana2.txt";
    static String fileNameEseuRomana3 = "eseuRomana3.txt";
    static String fileNameEseuIstorie = "eseuIstorie.txt";
    static String testBacovia = "testBacovia.txt";
    static String testIstorie = "testIstorie.txt";

    String caleImagineRectangle = "simplebanner.jpg";

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
    int height = 700;
    StringBuilder guess;
    StringBuilder helperFeedbackFinal = new StringBuilder("");
    String feedbackFinal;

    Text textEseu = new Text();
    StringBuilder stringBuilderTextEseu = new StringBuilder();
    String[] titluriEseu = {"Tema si viziunea despre lume", "Titlu eseu 2", "Titlu eseu 3"};

    VBox vBoxInceput;
    Rectangle rectangle1 = new Rectangle();
    VBox vBoxIntrebari;
    VBox vBoxIntrebareSiVariante;
    HBox hBoxButonVerificare;
    HBox hBoxInceput1;
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

        feedbackText.setWrapText(true);
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
        intrebariGresiteText.setWrapText(true);
        intrebariGresiteText.setMaxWidth(width - 100);

        //scena initiala
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

        Scene sceneSelectie = new Scene(vBoxInceput1, width, height);

        //scena start
        vBoxInceput = new VBox(50);
        vBoxInceput.setPadding(new Insets(15, 12, 15, 12));
        vBoxInceput.getChildren().addAll(materie, buttonIncepeTestul);
        vBoxInceput.setAlignment(Pos.CENTER);

        Scene sceneInitial = new Scene(vBoxInceput, width, height);

        //Scena intrebarilor
        vBoxIntrebari = new VBox();
        vBoxIntrebari.setPadding(new Insets(15, 12, 15, 12));
        vBoxIntrebari.getChildren().addAll(questionNrField);
        vBoxIntrebari.setAlignment(Pos.CENTER);
        vBoxIntrebari.getStylesheets().add("emedi/css/vBoxIntrebari.css");

        readImage(rectangle1, caleImagineRectangle);
        //rectangle1.setFill(imagePattern);

        rectangle1.setStroke(Color.BLACK);
        rectangle1.setStrokeWidth(2);
        rectangle1.setWidth(width / 3);
        rectangle1.setHeight(50);
        rectangle1.setArcHeight(50);
        rectangle1.setArcWidth(50);

        StackPane stackPaneIntrebari = new StackPane();
        stackPaneIntrebari.setPadding(new Insets(60, 10, 10, 10));
        stackPaneIntrebari.getChildren().addAll(rectangle1, vBoxIntrebari);

        VBox vBoxVariante = new VBox(10);
        vBoxVariante.getChildren().addAll(checkBoxA, checkBoxB, checkBoxC, checkBoxD);
        checkBoxA.setWrapText(true);
        checkBoxB.setWrapText(true);
        checkBoxC.setWrapText(true);
        checkBoxD.setWrapText(true);
        checkBoxA.wrapTextProperty();
        checkBoxB.wrapTextProperty();
        checkBoxC.wrapTextProperty();
        checkBoxD.wrapTextProperty();
        checkBoxA.setMaxWidth(width / 1.5);
        checkBoxB.setMaxWidth(width / 1.5);
        checkBoxC.setMaxWidth(width / 1.5);
        checkBoxD.setMaxWidth(width / 1.5);


        Group groupVariante = new Group();
        groupVariante.getChildren().add(vBoxVariante);
        vBoxVariante.setAlignment(Pos.CENTER_LEFT);

        vBoxIntrebareSiVariante = new VBox(20);
        vBoxIntrebareSiVariante.setPadding(new Insets(15, 12, 15, 12));
        questionText.setWrappingWidth(width - 100);
        questionText.setTextAlignment(TextAlignment.JUSTIFY);
        vBoxIntrebareSiVariante.getChildren().addAll(questionText, groupVariante);
        vBoxIntrebareSiVariante.setAlignment(Pos.CENTER);

        hBoxButonVerificare = new HBox(10);
        hBoxButonVerificare.setPadding(new Insets(15, 25, 25, 12));
        hBoxButonVerificare.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxButonVerificare.getChildren().add(buttonVerificaRaspuns);

        borderPanePaginaIntrebari.setTop(stackPaneIntrebari);
        borderPanePaginaIntrebari.setCenter(vBoxIntrebareSiVariante);
        borderPanePaginaIntrebari.setBottom(hBoxButonVerificare);
        borderPanePaginaIntrebari.setMaxWidth(width);
        borderPanePaginaIntrebari.setMaxHeight(height);

        Scene sceneIntrebari = new Scene(borderPanePaginaIntrebari, width, height);

        //scena feedback
        VBox vBoxCorectGresit = new VBox();
        vBoxCorectGresit.setPadding(new Insets(15, 12, 15, 12));
        vBoxCorectGresit.getChildren().add(raspunsCorectGresit);
        vBoxCorectGresit.setAlignment(Pos.CENTER);

        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setStroke(Color.MEDIUMPURPLE);
        rectangle2.setStrokeWidth(2);
        rectangle2.setWidth(width / 3);
        rectangle2.setHeight(50);
        rectangle2.setArcHeight(50);
        rectangle2.setArcWidth(50);

        stackPaneFeedback.setPadding(new Insets(100, 10, 10, 10));
        stackPaneFeedback.getChildren().addAll(rectangle2, vBoxCorectGresit);

        feedbackText.setWrapText(true);
        feedbackText.setAlignment(Pos.CENTER);

        vBoxFeedback = new VBox();
        vBoxFeedback.setPadding(new Insets(15, 50, 15, 50));
        vBoxFeedback.getChildren().add(feedbackText);
        vBoxFeedback.setAlignment(Pos.CENTER);

        HBox hBoxButUrmIntreb = new HBox();
        hBoxButUrmIntreb.setPadding(new Insets(15, 100, 100, 12));
        hBoxButUrmIntreb.getChildren().add(buttonUrmatoareaIntrebare);
        hBoxButUrmIntreb.setAlignment(Pos.CENTER_RIGHT);

        VBox vBoxFeedbackTotal = new VBox(30);
        vBoxFeedbackTotal.getChildren().addAll(stackPaneFeedback, vBoxFeedback, hBoxButUrmIntreb);


        Scene sceneFeedback = new Scene(vBoxFeedbackTotal, width, height);

        //scena rezultate
        HBox hBoxButoaneEseuRomana = new HBox(10);
        hBoxButoaneEseuRomana.setPadding(new Insets(15, 12, 15, 12));
        hBoxButoaneEseuRomana.setAlignment(Pos.CENTER);
        hBoxButoaneEseuRomana.getChildren().addAll(buttonEseu1, buttonEseu2, buttonEseu3);

        vBoxButoaneRezultate = new VBox(15);
        vBoxButoaneRezultate.setPadding(new Insets(15, 12, 15, 12));
        vBoxButoaneRezultate.setAlignment(Pos.CENTER);
        vBoxButoaneRezultate.getChildren().addAll(buttonEmedi, buttonIntrebariGresite, buttonRefaTestul, buttonBackToStart, hBoxButoaneEseuRomana, buttonEseuIstorie);

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

        //scena intrebari gresite
        vBoxIntrebariGresite = new VBox(10);
        vBoxIntrebariGresite.setPadding(new Insets(15, 15, 15, 15));
        buttonInapoiDinIntrebariGresite.setAlignment(Pos.BOTTOM_RIGHT);
        vBoxIntrebariGresite.getChildren().addAll(titluIntrebariGresite, intrebariGresiteText, buttonInapoiDinIntrebariGresite);
        vBoxIntrebariGresite.setAlignment(Pos.CENTER);

        ScrollPane scrollPaneIntrebariGresite = new ScrollPane();
        scrollPaneIntrebariGresite.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneIntrebariGresite.setContent(vBoxIntrebariGresite);
        Scene sceneIntrebariGresite = new Scene(scrollPaneIntrebariGresite, width, height);


        //scena eseu
        vBoxEseu = new VBox(15);
        vBoxEseu.setPadding(new Insets(15, 12, 15, 12));
        vBoxEseu.getChildren().addAll(titluEseu, textEseu, buttonInapoiDinEseu);
        vBoxEseu.setAlignment(Pos.CENTER);

        ScrollPane scrollPaneEseu = new ScrollPane();
        scrollPaneEseu.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneEseu.setContent(vBoxEseu);
        Scene sceneEseu = new Scene(scrollPaneEseu, width, height);
        textEseu.setWrappingWidth(sceneEseu.getWidth() - 50);

        // folosim css urile create
        sceneSelectie.getStylesheets().add("emedi/css/firstpage.css");
        sceneSelectie.getStylesheets().add("emedi/css/buttons.css");


        sceneInitial.getStylesheets().add("emedi/css/firstpage.css");
        sceneInitial.getStylesheets().add("emedi/css/buttons.css");

        sceneIntrebari.getStylesheets().add("emedi/css/checkbox.css");
        sceneIntrebari.getStylesheets().add("emedi/css/buttonVerificaIntrebarea.css");
        sceneIntrebari.getStylesheets().add("emedi/css/intrebari.css");
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

            readFiles(testBacovia, listaIntrebari, listaVar1, listaVar2,
                    listaVar3, listaVar4, listaRaspunsuriCorecte, listaFeedback);
            nrIntrebari = listaIntrebari.size();
            buttonEseuIstorie.setVisible(false);

            primaryStage.setScene(sceneInitial);
        });

        buttonIstorie.setOnAction(actionEvent -> {
            materie.setText("Test la istorie");
            readFiles(testIstorie, listaIntrebari, listaVar1, listaVar2, listaVar3, listaVar4, listaRaspunsuriCorecte, listaFeedback);
            nrIntrebari = listaIntrebari.size();
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
            //buttonVerificaRaspuns.setDisable(true);
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

        buttonEmedi.setOnAction(actionEvent -> {
            getHostServices().showDocument(url);
        });
        buttonVerificaRaspuns.setDefaultButton(true);
        buttonUrmatoareaIntrebare.setDefaultButton(true);
        buttonIncepeTestul.setDefaultButton(true);
        buttonInapoiDinIntrebariGresite.setDefaultButton(true);
        buttonInapoiDinEseu.setDefaultButton(true);
        buttonRomana.setFocusTraversable(true);
        buttonIstorie.setFocusTraversable(true);


        buttonEseuIstorie.setOnAction(actionEvent -> {
            try {
                readEssay(fileNameEseuIstorie, stringBuilderTextEseu);
            } catch (IOException e) {
                e.printStackTrace();
            }
            titluEseu.setText("Constitutia din 1866");
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
            stringBuilderTextEseu.delete(0, stringBuilderTextEseu.length());
            textEseu.setText("");
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
            raspunsCorectGresit.setText("Raspuns gresit!");
            feedbackText.setText(listaFeedback.get(index));
            helperFeedbackFinal.append("• " + listaIntrebari.get(index) + "\n" +
                    listaVar1.get(index) + "\n" +
                    listaVar2.get(index) + "\n" +
                    listaVar3.get(index) + "\n" +
                    listaVar4.get(index) + "\n" + "\n");
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


    public static void readImage(Rectangle rectangle, String caleImagineRectangle)  {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL imageResource = classLoader.getResource(caleImagineRectangle);
        if (imageResource == null) {
            throw new RuntimeException("Resource not found : " + caleImagineRectangle);
        }
        rectangle.setFill(new ImagePattern(new Image(imageResource.toExternalForm()), 0, 0, 1, 1, true));
    }

    public static void readFiles(String fileName, ArrayList<String> intrebare,
                                 ArrayList<String>var1, ArrayList<String>var2, ArrayList<String>var3,
                                 ArrayList<String> var4, ArrayList<String> raspuns, ArrayList<String> feedback) {
        ClassLoader classLoader = Main.class.getClassLoader();
        Scanner input = new Scanner(classLoader.getResourceAsStream(fileName));
        while (input.hasNext()) {
            String intr = input.nextLine();
            intrebare.add(intr);
            String v1 = input.nextLine();
            var1.add(v1);
            String v2 = input.nextLine();
            var2.add(v2);
            String v3 = input.nextLine();
            var3.add(v3);
            String v4 = input.nextLine();
            var4.add(v4);
            String rasp = input.nextLine();
            raspuns.add(rasp);
            String feed = input.nextLine();
            feedback.add(feed);
        }
    }

    public static void readEssay(String fileName, StringBuilder stringBuilderTextEseu) throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName)));
        int theCharNum = reader.read();
        while (theCharNum != -1) {
            char theChar = (char) theCharNum;
            stringBuilderTextEseu.append(theChar);
            theCharNum = reader.read();
        }
    }

}