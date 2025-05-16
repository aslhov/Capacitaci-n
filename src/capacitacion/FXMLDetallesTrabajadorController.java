/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.dao.TrabajadorDAO;
import model.pojo.Trabajador;

/**
 * FXML Controller class
 *
 * @author wason
 */
public class FXMLDetallesTrabajadorController implements Initializable {

    private Trabajador t;
    private final TrabajadorDAO tdao = new TrabajadorDAO();

    @FXML
    private JFXTextField txt_idtrabajador;
    @FXML
    private JFXTextField txt_nombre;
    @FXML
    private JFXTextField txt_ci;
    @FXML
    private JFXTextArea txt_direccion;
    @FXML
    private JFXTextField txt_grupo;
    @FXML
    private JFXTextField txt_cargo;
    @FXML
    private JFXTextField txt_especialidad;
    @FXML
    private JFXTextField txt_municipio;
    
    @FXML
    private JFXButton btn_closewindow;
  
    @FXML
    private MaterialDesignIconView btn_closeup;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            detalles();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDetallesTrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    private void detalles() throws IOException {
        File f = new File("temp");
        Scanner scanner = new Scanner(f);
        String result = scanner.next();
        System.out.println("Detalles: " + result);
        t = tdao.getTrabajadorPorID(result).get(0);
        txt_idtrabajador.setText(t.getId());
        txt_cargo.setText(t.getcargo().getCargo());
        txt_ci.setText(t.getNroIdentidad());
        txt_direccion.setText(t.getdireccion());
        txt_especialidad.setText(t.getEspecialidad().getNomb_especialidad());
        txt_grupo.setText(t.getGrupo().getNombregrupo());
        txt_municipio.setText(t.getmunicipio());
        txt_nombre.setText(t.getNombre());
    }

    public Trabajador getT() {
        return t;
    }

    public void setT(Trabajador t) {
        this.t = t;
    }

    
    @FXML
    public void closewindow(ActionEvent event) throws IOException{
    txt_idtrabajador.setText("");
        txt_cargo.setText("");
        txt_ci.setText("");
        txt_direccion.setText("");
        txt_especialidad.setText("");
        txt_grupo.setText("");
        txt_municipio.setText("");
        txt_nombre.setText("");
        
        Stage stage= (Stage) this.btn_closewindow.getScene().getWindow();
        stage.close();
    
//        Stage stage1= (Stage) this.btn_closeup.getScene().getWindow();
//        stage1.close();
    }
    
    
     @FXML
    private void close() throws IOException {
       closewindow2();
    }
    
    
    
    @FXML
    public void closewindow2() throws IOException{
    txt_idtrabajador.setText("");
        txt_cargo.setText("");
        txt_ci.setText("");
        txt_direccion.setText("");
        txt_especialidad.setText("");
        txt_grupo.setText("");
        txt_municipio.setText("");
        txt_nombre.setText("");
        
            
        Stage stage= (Stage) this.btn_closeup.getScene().getWindow();
        stage.close();
    }
    
    
    
}
