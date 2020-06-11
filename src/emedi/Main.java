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

import java.util.ArrayList;
import java.util.List;


public class Main extends Application implements EventHandler<ActionEvent> {

    final static String url = "https://www.emedi.ro/";

    String[] intrebariArray = {" Care sunt cele doua teme ale poemului?",
            " Ce forma Imbraca adverbul iar, din din incipit?",
            " Discursul fetei din prima secvența este o interogație retorica, dar si o enumeratie marcata de repetarea lui…"};

    String[] intrebariArrayIstorie = {" Care ",
            " Ce ?",
            " De marcata de repetarea lui…"};

    String[][] varianteDeRaspuns = {{"Ion Popescu", "Mihail Eminovici", "Gheorghe Alecu", "Pavel Ciprian"},
            {"1820", "1919", "1850", "1929"},
            {"De-as avea", "La mormântul lui Aron Pumnul", "Craiasa din povesti", "Somnoroase pasarele"}};
    String[] raspunsuriCorecte = {"AB", "A", "A"};
    String[] feedback = {" In majoritatea operelor cu tema asemanatoare, chemarea la iubire este realizata de catre eul liric, care aspira ca ființa iubita sa vina In lumea lui.",
            " A doua intervenție a vocii eului poetic continua meditația din cea de-a doua secvența poetica asupra iubirii trecute, rememorate, pe care indragostitul o proiecteaza ca fiind ideala.",
            " Contrastul dintre vis si realitate, ca incompatibilitate a celor doua lumi, este sugerat de versul final Totusi este trist In lume!"};

    String[] texteEseu = {"text eseu 1", "text eseu2", "text eseu 3"};
    String[] titluriEseu = {"Titlu eseu 1", "Titlu eseu 2", "Titlu eseu 3"};

    Text textEseu = new Text();
    List<String> intrebariGresiteArrayList = new ArrayList<>();

    CheckBox checkBoxA, checkBoxB, checkBoxC, checkBoxD;

    Button buttonIncepeTestul = new Button("Start test");
    Button buttonVerificaRaspuns = new Button("Trimite raspunsul");
    Button buttonUrmatoareaIntrebare = new Button("Urmatoarea intrebare");
    Button buttonEseu1 = new Button("Eseu 1");
    Button buttonEseu2 = new Button("Eseu 2");
    Button buttonEseu3 = new Button("Eseu 3");
    Button buttonIntrebariGresite = new Button("Verifica intrebari gresite");
    Button buttonInapoiDinIntrebariGresite = new Button("Inapoi");
    Button buttonInapoiDinEseu = new Button("Inapoi");
    Button buttonRefaTestul = new Button("Reia testul");
    Button buttonEmedi = new Button("Cumpara varianta oficiala Emedi");
    Button buttonRomana =new Button("Limba romana");
    Button buttonIstorie = new Button("Istoria Romaniei");

    int index;
    int nrRaspunsuriCorecte;
    int nrIntrebari = intrebariArray.length;
    int result;
    int width = 800;
    int margine = 40;
    int height = 600;
    StringBuilder guess;
    StringBuilder helperFeedbackFinal = new StringBuilder("");
    String feedbackFinal;

    VBox vBoxInceput;

    Rectangle rectangle1 = new Rectangle();
    VBox vBoxIntrebari;

    VBox vBoxIntrebareSiVariante;
    HBox hBoxButonVerificare;
    HBox hBoxInceput1;
    VBox vBoxIntrebareVarianteButoaneRaspuns;

    VBox vBoxRezultate;
    HBox hBoxButoaneRezultate;

    VBox vBoxFeedback;
    Rectangle rectangle2 = new Rectangle();

    VBox vBoxIntrebariGresite;
    VBox vBoxEseu;

    Label questionNrField = new Label();
    Text rezultat = new Text("Punctaj: ");
    Text questionText = new Text();
    Label bunVenit=new Label("Bine ai venit pe platforma Emedi");
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
        checkBoxB = new CheckBox();
        checkBoxB.setIndeterminate(false);
        checkBoxC = new CheckBox();
        checkBoxC.setIndeterminate(false);
        checkBoxD = new CheckBox();
        checkBoxD.setIndeterminate(false);

        Hyperlink hyperlink = new Hyperlink("Go to Eclipse home page");
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
        hBoxInceput1 = new HBox(30);
        hBoxInceput1.setPadding(new Insets(50, 50, 50, 50));
        buttonRomana.setAlignment(Pos.CENTER);
        buttonIstorie.setAlignment(Pos.CENTER);
        hBoxInceput1.getChildren().addAll(buttonRomana, buttonIstorie);
        hBoxInceput1.setAlignment(Pos.CENTER);

        VBox vBoxInceput1 = new VBox(50);
        vBoxInceput1.setPadding(new Insets(width/3, 10, width/3, 10));
        bunVenit.setAlignment(Pos.CENTER);
        vBoxInceput1.getChildren().addAll(bunVenit, hBoxInceput1);
        vBoxInceput1.setAlignment(Pos.CENTER);

        Pane panePrimaPaginaSelectie = new Pane();
        panePrimaPaginaSelectie.setPadding(new Insets(75, 75, 75, 75));
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
        rectangle1.setWidth(width);
        rectangle1.setHeight(50);


        StackPane stackPaneIntrebari = new StackPane();
        stackPaneIntrebari.setPadding(new Insets(10, 10, 10, 10));
        stackPaneIntrebari.getChildren().addAll(rectangle1, vBoxIntrebari);

        vBoxIntrebareSiVariante = new VBox(10);
        vBoxIntrebareSiVariante.setPadding(new Insets(15, 12, 15, 52));
        questionText.setWrappingWidth(rectangle1.getWidth()-10);
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
        rectangle2.setWidth(width);
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
        hBoxButoaneRezultate = new HBox(15);
        hBoxButoaneRezultate.setPadding(new Insets(15, 12, 50, 12));
        hBoxButoaneRezultate.setAlignment(Pos.BOTTOM_CENTER);
        hBoxButoaneRezultate.getChildren().addAll(buttonIntrebariGresite, buttonEseu1, buttonEseu2, buttonEseu3, buttonRefaTestul, buttonEmedi);

        vBoxRezultate = new VBox(50);
        vBoxRezultate.setPadding(new Insets(50, 25, 25, 22));
        vBoxRezultate.getChildren().addAll(rezultatText, hBoxButoaneRezultate);
        vBoxRezultate.setAlignment(Pos.CENTER);

        VBox vBoxRezultat = new VBox(30);
        vBoxRezultate.setAlignment(Pos.CENTER);
        vBoxRezultat.getChildren().addAll(vBoxRezultate, hBoxButoaneRezultate);

        Pane paneRezultate = new Pane();
        paneRezultate.getChildren().add(vBoxRezultat);

        Scene sceneRezultate = new Scene(paneRezultate, width, height);
        //intrebariGresiteText.setWrappingWidth(sceneRezultate.getWidth() - 50);

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
            primaryStage.setScene(sceneInitial);
        });

        buttonIstorie.setOnAction(actionEvent -> {
            materie.setText("Test la istorie");
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
            if (guess.toString().equals(raspunsuriCorecte[index])) {
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
            if (index == intrebariArray.length - 1) {
                buttonUrmatoareaIntrebare.setText("Vezi rezultate");
            }

            if (index >= intrebariArray.length) {
                results();
                primaryStage.setScene(sceneRezultate);
            } else {
                primaryStage.setScene(sceneIntrebari);
                nextQuestion();
            }
        });

        buttonEseu1.setOnAction(actionEvent -> {
            titluEseu.setText(titluriEseu[0]);
            textEseu.setText(texteEseu[0]);
            primaryStage.setScene(sceneEseu);
        });
        buttonEseu2.setOnAction(actionEvent -> {
            titluEseu.setText(titluriEseu[1]);
            textEseu.setText(texteEseu[1]);
            primaryStage.setScene(sceneEseu);
        });
        buttonEseu3.setOnAction(actionEvent -> {
            titluEseu.setText(titluriEseu[2]);
            textEseu.setText(texteEseu[2]);
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
            index = 0;
            nrRaspunsuriCorecte = 0;
            buttonUrmatoareaIntrebare.setText("Urmatoarea intrebare");
            primaryStage.setScene(sceneInitial);
        });

        primaryStage.setResizable(true);
        primaryStage.show();

    }


    public void nextQuestion() {

        if (index >= nrIntrebari) {
            results();
        } else {
            questionNrField.setText("Intrebarea numarul " + (index + 1) + " din " + nrIntrebari + ":");
            questionText.setText(intrebariArray[index]);
            checkBoxA.setText(varianteDeRaspuns[index][0]);
            checkBoxA.setSelected(false);
            checkBoxB.setText(varianteDeRaspuns[index][1]);
            checkBoxB.setSelected(false);
            checkBoxC.setText(varianteDeRaspuns[index][2]);
            checkBoxC.setSelected(false);
            checkBoxD.setText(varianteDeRaspuns[index][3]);
            checkBoxD.setSelected(false);
        }
    }

    public void displayAnswer() {
        if (guess.toString().equals(raspunsuriCorecte[index])) {
            raspunsCorectGresit.setText("Răspuns corect!");
            feedbackText.setText("Felicitari!");
        } else {
            raspunsCorectGresit.setText("Raspuns gresit :( :( :(");
            feedbackText.setText(feedback[index]);
            helperFeedbackFinal.append("• "+intrebariArray[index] + "\n" +
                    "A. " + varianteDeRaspuns[index][0] + "\n" +
                    "B. " + varianteDeRaspuns[index][1] + "\n" +
                    "C. " + varianteDeRaspuns[index][2] + "\n" +
                    "D. " + varianteDeRaspuns[index][3] + "\n" + "\n");
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

}