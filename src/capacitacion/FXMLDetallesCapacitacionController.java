package capacitacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.dao.CapacitacionDAO;
import model.pojo.Capacitacion;

/**
 * FXML Controller class
 *
 * @author jenice
 */
public class FXMLDetallesCapacitacionController implements Initializable {

    private final CapacitacionDAO cdao = new CapacitacionDAO();
    private Capacitacion c = new Capacitacion();
    
    @FXML
    private JFXTextField txt_accion;
        @FXML
    private JFXTextField txt_f_inicio;
    @FXML
    private JFXTextField txt_f_fin;
    @FXML
    private JFXTextField txt_t_accion;
    @FXML
    private JFXTextField txt_trimestre;
    @FXML
    private JFXTextField txt_lugar;
    @FXML
    private JFXTextField txt_modo_formacion;
    @FXML
    private JFXTextField txt_responsable;
    @FXML
    private JFXCheckBox cbx_cumplido;
    @FXML
    private JFXButton btn_closewindow;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            // TODO
            detalles();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDetallesCapacitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void detalles() throws IOException {
        File f = new File("temp");
        Scanner scanner = new Scanner(f);
        String result = scanner.next();
        System.out.println("Detalles " +result);
        c = cdao.getCapacitacion(Long.parseLong(result)).get(0);
        
        txt_accion.setText(c.getAcciones());
        txt_f_inicio.setText(c.getMes_inicio() + "/" + c.getAnyo_inicio());
        txt_f_fin.setText(c.getMes_fin() + "/" + c.getAnyo_fin());
        txt_t_accion.setText(c.getTipo_Accion());
        txt_trimestre.setText(c.getTrimestre());
        txt_lugar.setText(c.getLugar().getNombrelugar());
        txt_modo_formacion.setText(c.getModo_formacion().getM_form());
        txt_responsable.setText(c.getResponsable().getNomb_responsable());
        cbx_cumplido.setSelected(c.isCumplimiento());
    }
    
    @FXML
    public void closewindow(ActionEvent event) throws IOException {

        Stage stage = (Stage) this.btn_closewindow.getScene().getWindow();
        stage.close();

    }
}
