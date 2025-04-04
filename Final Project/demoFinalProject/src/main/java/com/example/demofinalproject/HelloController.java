package com.example.demofinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.LinkPermission;
import java.util.Objects;

public class HelloController {



    public Socket socket;
    public Button doctorButton;
    public Button patientButton;
    public Button registerButton;
    private BufferedReader in;
    private PrintWriter out;


    @FXML
    private Label welcomeText;

// These methods are handle the changes of scenes from welcome scene
    public void handleDoctorButtonAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "doctor_login_scene.fxml");
    }

    public void handlePatientButtonAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "patient_login_scene.fxml");
    }

    public void handleRegisterButtonAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "patient_register_scene.fxml");
    }

    @FXML
    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
////        Boolean rsp = connectToServer("heyy we got to the client part");
//        socketConnect();
//        passToServer("Welcome to JavaFX Application!");
////        socketAbort();
//        System.out.println("Out of the click");
    }

    @FXML
    protected void onCloseBtnClick(){
//        socketAbort();
//        System.out.println("Socket is closed");
    }






//    /*This method establishes connection to the server via socket*/
//    public boolean socketConnect() {
//        if (socket == null /*|| !socket.isClosed()*/) {
//            System.out.println("Socket is not connected, connecting socket");
//            try {
//                socket = new Socket("localHost", 8080);
//                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                out = new PrintWriter(socket.getOutputStream(), true);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//
//            }
//        }
//        return true;
//    }
//
//    /*This method close the socket connection*/
//    public boolean socketAbort() {
//        try {
//
//            socket.close();
//            socket = null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    /*This method passes needed command to a server*/
//    public boolean passToServer(String command) {
//        if(socketConnect()){
//            try {
//                out.println(command);
//                String serverResponse = in.readLine();
//                if (serverResponse.equalsIgnoreCase("true")) return true;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }






    public void switchScene(ActionEvent event, String fxmlFile) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile))); // Exception can be thrown here
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
}