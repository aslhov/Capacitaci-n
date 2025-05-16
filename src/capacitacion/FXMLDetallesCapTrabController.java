/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion;

import com.jfoenix.controls.*;
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
import model.dao.Trab_Cap_DAO;
import model.pojo.Trabajador_Capacitacion;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class FXMLDetallesCapTrabController implements Initializable {

    private Trabajador_Capacitacion tc = new Trabajador_Capacitacion();
    private Trab_Cap_DAO tcdao = new Trab_Cap_DAO();

    @FXML
    private JFXTextField txt_accion;
    @FXML
    private JFXTextField txt_nombre;
    @FXML
    private JFXTextField txt_f_inicio;
    @FXML
    private JFXTextField txt_f_fin;
    @FXML
    private JFXTextField txt_grupo;
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
            Logger.getLogger(FXMLDetallesCapTrabController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void detalles() throws IOException {
        File f = new File("temp");
        Scanner scanner = new Scanner(f);
        String result = scanner.next();
        String[] id = result.split("-");
        long idC = Long.parseLong(id[1]);
        System.out.println("Id Trab: " + id[0]);
        System.out.println("Id Cap: " + id[1]);
        tc = tcdao.getCapacitacionTrabajadorxId(id[0], idC).get(0);
        txt_accion.setText(tc.getCapacitacion().getAcciones());
        txt_nombre.setText(tc.getTrabajador().getNombre());
        txt_f_inicio.setText(tc.getCapacitacion().getMes_inicio() + "/" + tc.getCapacitacion().getAnyo_inicio());
        txt_f_fin.setText(tc.getCapacitacion().getMes_fin() + "/" + tc.getCapacitacion().getAnyo_fin());
        txt_grupo.setText(tc.getTrabajador().getGrupo().getNombregrupo());
        txt_t_accion.setText(tc.getCapacitacion().getTipo_Accion());
        txt_trimestre.setText(tc.getCapacitacion().getTrimestre());
        txt_lugar.setText(tc.getCapacitacion().getLugar().getNombrelugar());
        txt_modo_formacion.setText(tc.getCapacitacion().getModo_formacion().getM_form());
        txt_responsable.setText(tc.getCapacitacion().getResponsable().getNomb_responsable());
        cbx_cumplido.setSelected(tc.getCapacitacion().isCumplimiento());
    }

    @FXML
    public void closewindow(ActionEvent event) throws IOException {

        Stage stage = (Stage) this.btn_closewindow.getScene().getWindow();
        stage.close();

    }
}
