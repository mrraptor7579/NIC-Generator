/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicgenerator;

import javafx.application.Application;

import javafx.geometry.*;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;

import javafx.stage.Stage;

//webcam
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;




import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.util.ImageUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.PrinterJob;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;

/**
 *
 * @author akash
 */
public class NICGenerator extends Application {
    TextField tcmpname;
     DatePicker dpisudate;
     TextField tname;
     RadioButton rmale;
     RadioButton rfemale;
     RadioButton rother;
     TextField tpurpose;
     TextArea taaddress;
     
    @Override
    public void start(Stage primaryStage) {
        
        
      
        
    
        //For Scene 1
        
        Label lcmpname = new Label("Company Name");
        Label lisudate = new Label("Issue date");
        Label lname = new Label("Name");
        Label lgender = new Label("Gender");
        Label lpurpose = new Label("Purpose");
        Label laddress = new Label("Address");
        
         tcmpname = new TextField ();
        tcmpname.setPrefColumnCount(20);
        dpisudate = new DatePicker();
        dpisudate.setShowWeekNumbers(true);
        tname = new TextField();
        tname.setPrefColumnCount(20);
         rmale = new RadioButton("Male");
         rfemale = new RadioButton("Female");
        rother = new RadioButton("Other");
        ToggleGroup tg = new ToggleGroup();
        rmale.setToggleGroup(tg);
        rfemale.setToggleGroup(tg);
        rother.setToggleGroup(tg);
        tpurpose = new TextField();
        tpurpose.setPrefColumnCount(20);
        taaddress = new TextArea();
        taaddress.setPrefColumnCount(30);
        taaddress.setPrefRowCount(5);
        Button create=new Button("Create");
        Button btn1 = new Button ("Set Image");
        Button btn2 = new Button ("Generate");
        

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(lcmpname,tcmpname);
        hb1.setSpacing(15);
        hb1.setPadding(new Insets(10,10,10,10));
        
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(lisudate,dpisudate);
        hb2.setSpacing(47);
         hb2.setPadding(new Insets(10,10,10,10));
         
        HBox hb3 = new HBox();
        hb3.getChildren().addAll(lname,tname);
        hb3.setSpacing(69);
         hb3.setPadding(new Insets(10,10,10,10));
        
        HBox hb4 = new HBox();
        HBox hb41 = new HBox();
        
        hb41.getChildren().addAll(rmale,rfemale,rother);
        hb41.setSpacing(25);
        hb4.setSpacing(60);
         hb4.setPadding(new Insets(10,10,10,10));
         hb4.getChildren().addAll(lgender,hb41);
        
        HBox hb5 = new HBox();
        hb5.getChildren().addAll(lpurpose,tpurpose);
        hb5.setSpacing(58);
         hb5.setPadding(new Insets(10,10,10,10));
        
        HBox hb6 = new HBox();
        hb6.getChildren().addAll(laddress,taaddress);
        hb6.setSpacing(58);
         hb6.setPadding(new Insets(10,10,10,10));
         
          HBox hb7 = new HBox();
        hb7.getChildren().addAll(create,btn1,btn2);
        hb7.setSpacing(58);
         hb7.setPadding(new Insets(10,10,10,10));
         hb7.setAlignment(Pos.TOP_CENTER);
        
         
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,hb6,hb7);
         vb1.setPadding(new Insets(10,10,10,10));
        
        Text title = new Text("NIC Generator");
        title.setX(250);
        title.setY(400);
        title.getStyleClass().add("my-text");
        
        
        title.setStyle("-fx-font-size:50");
        
        
    
        //working
        btn2.setOnAction(e->{generate();});
        btn1.setOnAction(e->{setImage();});
        
        
        FlowPane fp = new FlowPane(vb1,title);
        fp.setStyle("-fx-background-color:LightBlue");
          Scene scene1 = new Scene(fp,500,500);
          scene1.getStylesheets().add("style.css");
        primaryStage.setTitle("NIC Generator");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    Stage generateStage;
    void generate() 
    {
       
        try {
            generateStage = new Stage();
            generateStage.initModality(Modality.APPLICATION_MODAL);
            Font f=new Font("Ariel",20);
            
            Label lcname = new Label(tcmpname.getText());
            lcname.setFont(f);
            lcname.setTextAlignment(TextAlignment.CENTER);
            Label lsrno = new Label("Serial number");
            lsrno.setFont(f);
            Label lpurp = new Label(tpurpose.getText());
            lpurp.setFont(f);
            
            
            ImageView iv1=new ImageView(new Image(new FileInputStream("F:\\\\New Folder\\\\NICGenerator\\\\Clicked\\\\selfie.jpg")));
            iv1.setFitHeight(100);
            iv1.setFitWidth(100);
            iv1.setX(60);
            iv1.setY(50);
            Label lisud = new Label("Issue date :"+"  "+ dpisudate.getValue());
            lisud.setFont(f);
            Label Sign = new Label("Signature :");
            Sign.setFont(f);
            VBox vb = new VBox (25);
            vb.getChildren().addAll(lcname,lsrno,lpurp,iv1,lisud,Sign);
            vb.setPadding(new Insets(10,10,10,60));
            
            vb.setPrefSize(240, 200);
            vb.setStyle("-fx-border-size:5");
            vb.setStyle("-fx-border-color:black");
            vb.setStyle("-fx-background-color:orange");
            
            Label lgname =  new Label("Name"+"   "+tname.getText());
            lgname.setFont(f);
            Label lggende = new Label("Gender :");
            Text txgender = new Text();
            if(rmale.isSelected())
            txgender.setText("Male");
            if(rfemale.isSelected())
             txgender.setText("female");
            if(rother.isSelected())
                txgender.setText("Other");
               HBox hbb = new HBox(lggende,txgender);
               hbb.setSpacing(10);
            lggende.setFont(f);
            txgender.setFont(f);
            Label lgaddress = new Label("Address  :"+"    "+taaddress.getText());
            lgaddress.setFont(f);
            VBox vb1 = new VBox(35);
            vb1.getChildren().addAll(lgname,hbb,lgaddress);
            vb1.setPadding(new Insets(10,10,10,10));
            vb1.setPrefSize(240, 200);
            //vb1.setStyle("-fx-border-size:10");
            vb1.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
            vb1.setStyle("-fx-border-color:black");
            vb1.setStyle("-fx-background-color:orange");
            HBox hb = new HBox();
            hb.getChildren().addAll(vb,vb1);
            hb.setSpacing(20);
            hb.setPadding(new Insets(20,10,10,10));
            
            
            FlowPane fp = new FlowPane(200,200);
          
            
            Button btn5 = new Button("Print");
            btn5.setAlignment(Pos.BOTTOM_CENTER);
            
            btn5.setOnAction(e->{
                PrinterJob job = PrinterJob.createPrinterJob();
            if(job != null){
            job.showPrintDialog(generateStage); 
            job.printPage(hb);
            job.endJob();}});
              fp.setStyle("-fx-background-color:skyblue");
            fp.getChildren().addAll(hb,btn5);
            Scene scene2 = new Scene(fp);
            generateStage.setScene(scene2);
            generateStage.show();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NICGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    void selectImage()
    {
      

   // public static void captureWithPanel() throws IOException, Exception{
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
    /*Dimension[] nonStandardResolutions = new Dimension[] {
        WebcamResolution.HD.getSize() // Add HD resolution
	};
	
webcam.setCustomViewSizes(nonStandardResolutions);
webcam.setViewSize(new Dimension(1280, 720));
        */



        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setImageSizeDisplayed(true);

        JFrame window = new JFrame("Webcam");
		 
		JButton button1=new JButton("Click me");  
		
		button1.setBounds(50,105,95,30);


		  button1.addActionListener( e -> {
                      try{
                          BufferedImage image = webcam.getImage();
                          ImageIO.write(image, ImageUtils.FORMAT_JPG, new File("F:\\New Folder\\NICGenerator\\Clicked\\selfie.jpg"));
                          button1.setText("Captured");
                          
                          
                      }catch(IOException ex){}
                      finally{
                          System.out.println("PICTURE IS CLICKED");
                      }
        });  


		
		panel.add(button1);
        window.add(panel);
        window.setResizable(true);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
		

    }


    Stage selectImage;
    TextField pickUpPathField;
    void setImage()
    {
        selectImage = new Stage();
            selectImage.initModality(Modality.APPLICATION_MODAL);
            Button btn_ClickImage = new Button("Click Image");
            Button btn_setImage = new Button ("Set Image from file");
             pickUpPathField = new TextField();
             HBox hb_selectImage= new HBox();
             hb_selectImage.setSpacing(20);
             hb_selectImage.getChildren().addAll(btn_ClickImage,pickUpPathField, btn_setImage);
            btn_ClickImage.setOnAction(e->{
            selectImage();
            });
            btn_setImage.setOnAction(e->{
                getTheUserFilePath();
            });
            
         Scene sc_selectImage = new Scene(hb_selectImage,400,100);
            selectImage.setScene(sc_selectImage);
            selectImage.show();
    }
    public void getTheUserFilePath() {

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select Image");
    fileChooser.getExtensionFilters().addAll(
            
            new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
    );


    File file = fileChooser.showOpenDialog(selectImage);

    if (file != null) {
        // pickUpPathField it's your TextField fx:id
        pickUpPathField.setText(file.getPath());

    } else  {
        System.out.println("error"); // or something else
    }

}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
