/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.dao.LugarDAO;
import model.dao.Modo_formacionDAO;
import model.dao.ResponsableDAO;
import model.pojo.Lugar;
import model.pojo.Modo_formacion;
import model.pojo.Responsable;
import model.view.Menssager;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class FXMLAddLRMController implements Initializable {

    @FXML
    private JFXTextField txt_lugar;
    @FXML
    private JFXTextField txt_responsable;
    @FXML
    private JFXTextField txt_modo_formacion;

    private final LugarDAO ldao = new LugarDAO();
    private final ResponsableDAO rdao = new ResponsableDAO();
    private final Modo_formacionDAO mfdao = new Modo_formacionDAO();

    Menssager menssager = new Menssager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void insertarLugar() {
        if (ldao.getNombreLugar(txt_lugar.getText()).isEmpty()) {
            Lugar l = new Lugar(txt_lugar.getText());
            if (ldao.addLugar(l)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
            }
        } else {
            menssager.showMessajeINFORMATION(null, "", "Ya existe el lugar", Alert.AlertType.ERROR);
        }

    }

    @FXML
    public void insertarResponsable() {
        if (rdao.getNombreResponsable(txt_responsable.getText()).isEmpty()) {
            Responsable r = new Responsable(txt_responsable.getText());
            if (rdao.addResponsable(r)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
            }
        } else {
            menssager.showMessajeINFORMATION(null, "", "Ya existe el responsable", Alert.AlertType.ERROR);
        }

    }
    
    @FXML
    public void insertarModo_formacion() {
        if (mfdao.getNombreModo_formacion(txt_modo_formacion.getText()).isEmpty()) {
            Modo_formacion mf = new Modo_formacion(txt_modo_formacion.getText());
            if (mfdao.addModo_formacion(mf)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
            }
        } else {
            menssager.showMessajeINFORMATION(null, "", "Ya existe el modo de formación", Alert.AlertType.ERROR);
        }

    }
}
