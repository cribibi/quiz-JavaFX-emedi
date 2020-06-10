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

    String[] intrebariArray = {" Care sunt cele doua teme ale poemului?",
            " Ce forma Imbraca adverbul iar, din din incipit?",
            " Discursul fetei din prima secvența este o interogație retorica, dar si o enumeratie marcata de repetarea lui…"};

    String[][] varianteDeRaspuns = {{"Ion Popescu", "Mihail Eminovici", "Gheorghe Alecu", "Pavel Ciprian"},
            {"1820", "1919", "1850", "1929"},
            {"De-as avea", "La mormântul lui Aron Pumnul", "Craiasa din povesti", "Somnoroase pasarele"}};
    String[] raspunsuriCorecte = {"A", "A", "A"};
    String[] feedback = {" In majoritatea operelor cu tema asemanatoare, chemarea la iubire este realizata de catre eul liric, care aspira ca ființa iubita sa vina In lumea lui.",
            " A doua intervenție a vocii eului poetic continua meditația din cea de-a doua secvența poetica asupra iubirii trecute, rememorate, pe care indragostitul o proiecteaza ca fiind ideala.",
            " Contrastul dintre vis si realitate, ca incompatibilitate a celor doua lumi, este sugerat de versul final Totusi este trist In lume!"};
    Text textEseu = new Text(
            "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                    "\n" +
                    "Why do we use it?\n" +
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                    "\n" +
                    "\n" +
                    "Where does it come from?\n" +
                    "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                    "\n" +
                    "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");

    List<String> intrebariGresiteArrayList = new ArrayList<>();

    CheckBox checkBoxA, checkBoxB, checkBoxC, checkBoxD;

    Button buttonIncepeTestul = new Button("Start test");
    Button buttonTrimiteRaspunsul = new Button("Trimite raspunsul");
    Button buttonUrmatoareaIntrebare = new Button("Urmatoarea intrebare");
    Button buttonArataEseu = new Button("Citeste eseu");
    Button buttonIntrebariGresite = new Button("Intrebari gresite");
    Button buttonInapoiDinIntrebariGresite = new Button("Inapoi");
    Button buttonInapoiDinEseu = new Button("Inapoi");
    Button buttonRefaTestul = new Button("Reia testul");

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
    HBox hBoxButoane;
    VBox vBoxIntrebareVarianteButoaneRaspuns;

    VBox vBoxRezultate;
    HBox hBoxButoane2;

    VBox vBoxFeedback;
    Rectangle rectangle2 = new Rectangle();

    VBox vBoxIntrebariGresite;
    VBox vBoxEseu;

    HBox hBoxVarButRaspCorect;

    Text questionNrField = new Text();
    Text rezultat = new Text("Punctaj: ");
    Text questionText = new Text();
    Text bunVenit = new Text("TEST EMINESCU");
    Text rezultatTest = new Text();
    Text rezultatText = new Text();
    Text titluEseu = new Text("Titlu eseu");
    Text titluIntrebariGresite = new Text("Intrebarile la care ati gresit");
    Text intrebariGresiteText = new Text();
    Text feedbackText = new Text();
    Text raspunsCorectGresit = new Text();

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

        intrebariGresiteText.setText(intrebariGresiteArrayList.toString());
        rezultatText.setTextAlignment(TextAlignment.CENTER);
        rezultat.setTextAlignment(TextAlignment.CENTER);
        titluEseu.setTextAlignment(TextAlignment.CENTER);
        buttonArataEseu.setAlignment(Pos.BOTTOM_CENTER);
        bunVenit.setFill(Color.LIGHTBLUE);


        bunVenit.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        rezultatText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        titluEseu.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        titluIntrebariGresite.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        questionNrField.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
        questionText.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        questionText.setWrappingWidth(width-margine);
        feedbackText.setWrappingWidth(width-margine);


        buttonIntrebariGresite.setDisable(true);
        buttonTrimiteRaspunsul.setDisable(true);
        buttonUrmatoareaIntrebare.setDisable(true);

        checkBoxA.setOnAction(actionEvent -> {
            buttonTrimiteRaspunsul.setDisable(false);
        });

        checkBoxB.setOnAction(actionEvent -> {
            buttonTrimiteRaspunsul.setDisable(false);
        });

        checkBoxC.setOnAction(actionEvent -> {
            buttonTrimiteRaspunsul.setDisable(false);
        });

        checkBoxD.setOnAction(actionEvent -> {
            buttonTrimiteRaspunsul.setDisable(false);
        });

        vBoxInceput = new VBox(50);
        vBoxInceput.setPadding(new Insets(15, 12, 15, 12));
        vBoxInceput.getChildren().addAll(bunVenit, buttonIncepeTestul);
        vBoxInceput.setAlignment(Pos.CENTER);

        hBoxButoane2 = new HBox(10);
        hBoxButoane2.setPadding(new Insets(15, 12, 15, 12));
        hBoxButoane2.setAlignment(Pos.BOTTOM_CENTER);
        hBoxButoane2.getChildren().addAll(buttonIntrebariGresite, buttonArataEseu, buttonRefaTestul);

        //vbox pentru intrebare si variante
        vBoxIntrebareSiVariante = new VBox(10);
        vBoxIntrebareSiVariante.setPadding(new Insets(15, 12, 15, 12));
        vBoxIntrebareSiVariante.getChildren().addAll(questionText, checkBoxA, checkBoxB, checkBoxC, checkBoxD);
        vBoxIntrebareSiVariante.setVisible(true);
        vBoxIntrebareSiVariante.setAlignment(Pos.CENTER_LEFT);

        //hbox cu intrebare, variante si raspuns
        hBoxVarButRaspCorect = new HBox(10);
        raspunsCorectGresit.setTextAlignment(TextAlignment.LEFT);
        hBoxVarButRaspCorect.getChildren().addAll(vBoxIntrebareSiVariante, raspunsCorectGresit);

        //hbox pentru cele 2 butoane
        hBoxButoane = new HBox(20);
        hBoxButoane.setPadding(new Insets(15, 12, 15, 12));
        hBoxButoane.setAlignment(Pos.BOTTOM_LEFT);
        hBoxButoane.getChildren().addAll(buttonTrimiteRaspunsul, buttonUrmatoareaIntrebare);

        vBoxIntrebareVarianteButoaneRaspuns = new VBox(10);
        vBoxIntrebareVarianteButoaneRaspuns.setPadding(new Insets(15, 12, 15, margine));
        vBoxIntrebareVarianteButoaneRaspuns.setFillWidth(true);
        vBoxIntrebareVarianteButoaneRaspuns.getChildren().addAll(hBoxVarButRaspCorect, hBoxButoane);
        vBoxIntrebareVarianteButoaneRaspuns.setAlignment(Pos.TOP_RIGHT);


        vBoxIntrebari = new VBox(10);
        vBoxIntrebari.setPadding(new Insets(15, 12, 15, 12));
        vBoxIntrebari.setFillWidth(true);
        vBoxIntrebari.getChildren().addAll(questionNrField);
        vBoxIntrebari.setAlignment(Pos.CENTER);

        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setStrokeWidth(2);
        rectangle1.setWidth(width - margine);
        rectangle1.setHeight(50);



        vBoxFeedback = new VBox(10);
        vBoxFeedback.setPadding(new Insets(15, 12, 15, 12));
        vBoxFeedback.setFillWidth(true);
        vBoxFeedback.getChildren().add(feedbackText);
        vBoxFeedback.setAlignment(Pos.BOTTOM_CENTER);

        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setWidth(width - margine);
        rectangle2.setHeight(80);
        rectangle2.setStrokeWidth(2);

        vBoxIntrebariGresite = new VBox(10);
        vBoxIntrebariGresite.setPadding(new Insets(15, 15, 15, 15));
        vBoxIntrebariGresite.setFillWidth(true);
        vBoxIntrebariGresite.getChildren().addAll(titluIntrebariGresite, intrebariGresiteText, buttonInapoiDinIntrebariGresite);
        vBoxIntrebariGresite.setAlignment(Pos.CENTER);


        vBoxRezultate = new VBox(10);
        vBoxRezultate.setPadding(new Insets(15, 12, 15, 12));
        vBoxRezultate.getChildren().addAll(rezultatText, hBoxButoane2);
        vBoxRezultate.setAlignment(Pos.CENTER);

        vBoxEseu = new VBox(15);
        vBoxEseu.setPadding(new Insets(15, 12, 15, 12));
        vBoxEseu.getChildren().addAll(titluEseu, textEseu, buttonInapoiDinEseu);
        vBoxEseu.setAlignment(Pos.CENTER);

        StackPane stackPanePrimaPagina = new StackPane();
        stackPanePrimaPagina.setPadding(new Insets(10, 10, 10, 10));
        stackPanePrimaPagina.getChildren().add(vBoxInceput);

        StackPane stackPaneIntrebari = new StackPane();
        stackPaneIntrebari.setPadding(new Insets(10, 10, 10, 10));
        stackPaneIntrebari.getChildren().addAll(rectangle1, vBoxIntrebari);

        stackPaneFeedback.setPadding(new Insets(10, 10, 10, 10));
        stackPaneFeedback.getChildren().addAll(rectangle2, vBoxFeedback);

        borderPanePaginaIntrebari.setTop(stackPaneIntrebari);
        borderPanePaginaIntrebari.setCenter(vBoxIntrebareVarianteButoaneRaspuns);

        borderPanePaginaIntrebari.setMaxWidth(width);
        borderPanePaginaIntrebari.setMaxHeight(height);

        BorderPane borderPaneRezultate = new BorderPane();
        borderPaneRezultate.setCenter(vBoxRezultate);
        borderPaneRezultate.setBottom(hBoxButoane2);

        ScrollPane scrollPaneEseu = new ScrollPane();
        scrollPaneEseu.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneEseu.setContent(vBoxEseu);

        ScrollPane scrollPaneIntrebariGresite = new ScrollPane();
        scrollPaneIntrebariGresite.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneIntrebariGresite.setContent(vBoxIntrebariGresite);

        Scene sceneIntrebari = new Scene(borderPanePaginaIntrebari, width, height);
        Scene sceneRezultate = new Scene(borderPaneRezultate, width, height);
        Scene sceneEseu = new Scene(scrollPaneEseu, width, height);
        Scene sceneIntrebariGresite = new Scene(scrollPaneIntrebariGresite, width, height);


        intrebariGresiteText.setWrappingWidth(sceneRezultate.getWidth() - 50);
        textEseu.setWrappingWidth(sceneEseu.getWidth() - 50);
        feedbackText.setWrappingWidth(sceneRezultate.getWidth() - margine);
        feedbackText.setTextAlignment(TextAlignment.CENTER);
        Scene sceneInitial = new Scene(stackPanePrimaPagina, width, height);

        sceneInitial.getStylesheets().add("emedi/firstpage.css");
        sceneInitial.getStylesheets().add("emedi/button.css");
        sceneIntrebari.getStylesheets().add("emedi/checkbox.css");
        sceneIntrebari.getStylesheets().add("emedi/whiteBackground.css");
        sceneIntrebari.getStylesheets().add("emedi/button.css");
        sceneIntrebari.getStylesheets().add("emedi/whiteBackground.css");
        sceneRezultate.getStylesheets().add("emedi/button.css");
        sceneIntrebariGresite.getStylesheets().add("emedi/button.css");
        sceneEseu.getStylesheets().add("emedi/button.css");
        sceneEseu.getStylesheets().add("emedi/whiteBackground.css");
        sceneIntrebariGresite.getStylesheets().add("emedi/whiteBackground.css");

        primaryStage.setScene(sceneInitial);

        buttonIncepeTestul.setOnAction(actionEvent -> {
            nextQuestion();
            primaryStage.setScene(sceneIntrebari);

        });

        buttonTrimiteRaspunsul.setOnAction(actionEvent -> {
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
            buttonTrimiteRaspunsul.setDisable(true);
            buttonUrmatoareaIntrebare.setDisable(false);
            displayAnswer();
        });

        buttonUrmatoareaIntrebare.setOnAction(actionEvent -> {
            index++;
            raspunsCorectGresit.setText("");
            checkBoxA.setDisable(false);
            checkBoxB.setDisable(false);
            checkBoxC.setDisable(false);
            checkBoxD.setDisable(false);
            buttonUrmatoareaIntrebare.setDisable(true);
            if (index == intrebariArray.length - 1) {
                buttonUrmatoareaIntrebare.setText("Vezi rezultate");
            }

            if (index >= intrebariArray.length) {
                results();
                primaryStage.setScene(sceneRezultate);
            } else {
                nextQuestion();
            }
        });

        buttonArataEseu.setOnAction(actionEvent -> {
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
        borderPanePaginaIntrebari.setBottom(null);

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
            raspunsCorectGresit.setText(" Răspuns corect!");
        } else {
            raspunsCorectGresit.setText("Raspuns gresit!");
            feedbackText.setText(feedback[index]);
            helperFeedbackFinal.append(intrebariArray[index] + "\n" +
                    "A. " + varianteDeRaspuns[index][0] + "\n" +
                    "B. " + varianteDeRaspuns[index][1] + "\n" +
                    "C. " + varianteDeRaspuns[index][2] + "\n" +
                    "D. " + varianteDeRaspuns[index][3] + "\n"+"\n");
            borderPanePaginaIntrebari.setBottom(stackPaneFeedback);
        }
    }

    public void results() {
        result = (int) ((nrRaspunsuriCorecte / (double) nrIntrebari) * 100);
        rezultatTest.setText(String.valueOf(result) + "%");
        if (result > 50) {
            rezultatText.setText("Rezultat: " + result + "%" +
                    "\nAti raspuns corect la " + nrRaspunsuriCorecte + " intrebari din " + nrIntrebari + "." +
                    "\nFelicitari! Ati trecut testul.");

        } else {
            rezultatText.setText("Rezultat: " + result + "%" +
                    "\nAti raspuns corect la " + nrRaspunsuriCorecte + " intrebari din " + nrIntrebari + "." +
                    "\nVa recomandam sa cititi eseul si sa refaceti testul.");
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


