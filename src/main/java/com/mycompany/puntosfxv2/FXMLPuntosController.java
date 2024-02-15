/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.puntosfxv2;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.Punto2D;
import com.fasterxml.jackson.databing.ObjectMapper;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class FXMLPuntosController implements Initializable {

    @FXML
    public Label idLabel1;
    @FXML
    public Canvas idCanvas;
    @FXML
    public TextArea idTXTArea;
    @FXML
    public MenuBar idMenuB;

    GraphicsContext g;

    LinkedList<Punto2D> listaP;
    public static Stage s;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaP = new LinkedList<>();
        g = idCanvas.getGraphicsContext2D();
        double h = idCanvas.getHeight();
        double w = idCanvas.getWidth();

        g.setStroke(Color.BLUE);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);

    }

    @FXML
    public void getCoordenadas(MouseEvent m) {

        double x = m.getX();
        double y = m.getY();

        System.out.println("X " + x + ", y " + y);
        listaP.add(new Punto2D(x, y));
    }

    @FXML
    public void mostrarPuntos(ActionEvent a) {
        String mostrar = "";
        for (int i = 0; i < listaP.size(); i++) {
            Punto2D get = listaP.get(i);
            mostrar += get.toString() + "\n";
        }
        idTXTArea.setText(mostrar);
    }

    @FXML
    public void saveFile(ActionEvent a) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Archivo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));

        // Se asume que se obtiene el Stage desde el evento; de otra forma, necesitarías una referencia al Stage.
        //s = (Stage) ((MenuItem) a.getSource()).get getScene().getWindow();

        File file = fileChooser.showSaveDialog(s);
        if (file != null) {
            System.out.println("Archivo guardado en: " + file.getPath());
            crearArchivo(file);
        }
    }
    
    public void crearArchivo(File file){
        String content = "";
        for (int i = 0; i < listaP.size(); i++){
            content += listaP.get(i).toString();
          }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String , Object> = new HashMap<>();
        data.put(content);
        try{
        objectMapper.WriteValue(file, data);
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
