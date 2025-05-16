/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion;

import Util.HibernateUtil;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import model.dao.CargoDAO;
import model.dao.EspecialidadDAO;
import model.dao.GrupoDAO;
import model.pojo.Cargo;
import model.pojo.Especialidad;
import model.pojo.Grupo;
import model.view.Menssager;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Conectando Paisaje
 */
public class FXMLAddCEGController implements Initializable {

    @FXML
    static private Pane espPlus;
    @FXML
    static private Pane cargPlus;
    @FXML
    static private Pane grupPlus;
    @FXML
    private JFXTextField txt_grupo;
    @FXML
    private JFXTextField txt_cargo;
    @FXML
    private JFXTextField txt_especialidad;

    private final GrupoDAO gdao = new GrupoDAO();

    private final EspecialidadDAO edao = new EspecialidadDAO();

    private final CargoDAO cgdao = new CargoDAO();

    Menssager menssager = new Menssager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    void NOvisualizar() throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddESP.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.hide();
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    // codigos bd
    @FXML
    public void insertarGrupo() {
        if (gdao.getNombreGrupo(txt_grupo.getText()).isEmpty()) {
            Grupo g = new Grupo(txt_grupo.getText());
            if (gdao.addGrupo(g)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
            }
        } else {
            menssager.showMessajeINFORMATION(null, "", "Ya existe el grupo", Alert.AlertType.ERROR);
        }

    }

    @FXML
    public void insertarCargo() {
        if (cgdao.getNombreCargo(txt_cargo.getText()).isEmpty()) {
            Cargo c = new Cargo(txt_cargo.getText());
            if (cgdao.addCargo(c)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
            }
        } else {
            menssager.showMessajeINFORMATION(null, "", "Ya existe el grupo", Alert.AlertType.ERROR);
        }

    }

    @FXML
    public void insertarEspecialidad() {
        if (edao.getNombreEspecialidad(txt_especialidad.getText()).isEmpty()) {
            Especialidad e = new Especialidad(txt_especialidad.getText());
            if (edao.addEspecialidad(e)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
            }
        } else {
            menssager.showMessajeINFORMATION(null, "", "Ya existe el grupo", Alert.AlertType.ERROR);
        }

    }

}
