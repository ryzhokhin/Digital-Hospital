package com.example.demofinalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class VirtualHospitalApplication extends Application {

    Socket socket;
    BufferedReader in;
    PrintWriter out;



//  <<<<<<<< SERVER METHODS >>>>>>>
    private boolean socketConnect() {
        if (socket == null /*|| !socket.isClosed()*/) {
            System.out.println("Socket is not connected, connecting socket");
            try {
                socket = new Socket("localHost", 8080);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);

            }
        }


        return true;
    }

    /*This method close the socket connection*/
    private boolean socketAbort() {
        try {

            socket.close();
            socket = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /*This method passes needed command to a server*/
    private boolean passToServer(String command) {
        try {
            out.println(command);
            String serverResponse = in.readLine();
            if (serverResponse.equalsIgnoreCase("true")) return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

// <<<<<<<<< - - - - - >>>>>>
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("welcome_scene.fxml"));
            stage.setTitle("Virtual Hospital");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}