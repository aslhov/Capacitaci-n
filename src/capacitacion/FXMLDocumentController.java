/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.dao.*;
import model.pojo.*;
import model.view.*;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author wason
 */
public class FXMLDocumentController implements Initializable {

    private final TrabajadorDAO tdao = new TrabajadorDAO();
    private final CapacitacionDAO cdao = new CapacitacionDAO();
    private final Trab_Cap_DAO tcdao = new Trab_Cap_DAO();
    private final CargoDAO cgdao = new CargoDAO();
    private final GrupoDAO grupdao = new GrupoDAO();
    private final EspecialidadDAO esdao = new EspecialidadDAO();
    private final Modo_formacionDAO mdao = new Modo_formacionDAO();

    List<Trabajador> list_trabajadores;
    List<Capacitacion> list_acciones;
    List<Trabajador_Capacitacion> list_capacitacion;
    List<String> list_mdform;

    Menssager menssager = new Menssager();

    @FXML
    private JFXButton btn_list;
    @FXML
    private JFXButton btn_add;
    @FXML
    private JFXButton btn_detalles_trabajador;
    @FXML
    private JFXButton btn_editar_trabajador;
    @FXML
    private JFXButton btn_eliminar_trabajador;
    @FXML
    private JFXButton btn_editar_capacitacion;

    @FXML
    private AnchorPane h_list;
    @FXML
    private AnchorPane h_add;
    @FXML
    private AnchorPane h_update;
    @FXML
    private AnchorPane h_capac;
    @FXML
    private AnchorPane h_accion;
    @FXML
    private AnchorPane h_vinculo;
    @FXML
    private AnchorPane h_repoacc;
    @FXML
    private AnchorPane h_repoanual;
    @FXML
    private AnchorPane h_addAccion;
    @FXML
    private AnchorPane h_anual;
    @FXML
    private AnchorPane h_update_cap;

    @FXML
    private JFXComboBox cbx_buscar_trimestre;

    @FXML
    private JFXTreeTableView table_capacitacion;

    @FXML
    private JFXTreeTableView table_repotrim;

    ObservableList<ReportesView> datosrepo;

    @FXML
    private JFXButton btn_capworker;
    @FXML
    private JFXButton btn_accion;
    @FXML
    private JFXButton btn_addacc;
    @FXML
    private JFXButton btn_vincular;
    @FXML
    private JFXButton btn_repoacc;
    @FXML
    private JFXButton create_plan;
    @FXML
    private JFXButton btn_repoanual;
    @FXML
    private JFXButton btn_addaccion;
    @FXML
    private JFXComboBox cbx_grupoadd;
    @FXML
    private JFXComboBox cbx_trabajadoradd;
    @FXML
    private JFXComboBox cbx_accionadd;

    @FXML
    private Label faccion;

    ObservableList<CapacitacionView> datosa;
    ObservableList<Trabajador_CapacitacionView> datoscap;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_list) {
            h_list.setVisible(true);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        } else if (event.getSource() == btn_add) {
            h_list.setVisible(false);
            h_add.setVisible(true);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == btn_capworker) {
            h_capac.setVisible(true);
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }

        if (event.getSource() == btn_accion) {
            h_capac.setVisible(false);
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_accion.setVisible(true);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
//            cbx_mes_inicioE = new JFXComboBox();
//            cbx_mes_finE = new JFXComboBox();
//            cbx_lugarE = new JFXComboBox();
//            cbx_responsableE = new JFXComboBox();
//            cbx_modo_formacionE = new JFXComboBox();
//            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == btn_vincular) {
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(true);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == btn_repoacc) {
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(true);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == btn_repoanual) {
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(true);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == create_plan) {
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(true);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == btn_editar_trabajador) {
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(true);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(false);
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == btn_addaccion) {
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(true);
            h_update_cap.setVisible(false);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
            cbx_mes_inicioE = new JFXComboBox();
            cbx_mes_finE = new JFXComboBox();
            cbx_lugarE = new JFXComboBox();
            cbx_responsableE = new JFXComboBox();
            cbx_modo_formacionE = new JFXComboBox();
            cbx_trimestreE = new JFXComboBox();
        }
        if (event.getSource() == btn_editar_c) {
            h_list.setVisible(false);
            h_add.setVisible(false);
            h_capac.setVisible(false);
            h_accion.setVisible(false);
            h_vinculo.setVisible(false);
            h_repoacc.setVisible(false);
            h_repoanual.setVisible(false);
            h_anual.setVisible(false);
            h_update.setVisible(false);
            h_addAccion.setVisible(false);
            h_update_cap.setVisible(true);
            cbx_cargoE = new JFXComboBox();
            cbx_grupoE = new JFXComboBox();
            cbx_especialidadE = new JFXComboBox();
            cbx_municipioE = new JFXComboBox();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        h_capac.setVisible(false);
        h_accion.setVisible(false);
        h_vinculo.setVisible(false);
        h_repoacc.setVisible(false);
        h_repoanual.setVisible(false);
        h_anual.setVisible(false);
        h_addAccion.setVisible(false);
        h_update_cap.setVisible(false);
        h_list.setVisible(true);

        btn_detalles_trabajador.setDisable(true);
        btn_editar_trabajador.setDisable(true);
        btn_eliminar_trabajador.setDisable(true);

        llenarlistaGrupo();
        llenarlistaCargo();
        llenarlistaEspecialidad();
        llenarlistaMunicipio();
        llenarlistaAccion();
        llenarlistaTrimestre();
        llenarlistaLugar();
        llenarlistaResponsable();
        llenarlistaModoFormacion();
        llenarlistaMes();

        // tABLA TRABAJADORES
        TreeTableColumn id_trab = new TreeTableColumn("ID del Trabajador");
        TreeTableColumn nombre = new TreeTableColumn("Nombre del Trabajador");
        TreeTableColumn ci_trab = new TreeTableColumn("N. de Identidad");
        TreeTableColumn grupo = new TreeTableColumn("Grupo");
        TreeTableColumn cargo = new TreeTableColumn("Cargo");

        table_trabajadores.getColumns().addAll(id_trab, nombre, ci_trab, grupo, cargo);

        id_trab.setCellValueFactory(new TreeItemPropertyValueFactory("id"));
        nombre.setPrefWidth(300);
        nombre.setCellValueFactory(new TreeItemPropertyValueFactory("nombre"));
        ci_trab.setCellValueFactory(new TreeItemPropertyValueFactory("NroIdentidad"));
        grupo.setPrefWidth(150);
        grupo.setCellValueFactory(new TreeItemPropertyValueFactory("grupo"));
        cargo.setPrefWidth(250);
        cargo.setCellValueFactory(new TreeItemPropertyValueFactory("cargo"));

        llenarTablaTrabajador(getList_trabajadores());

        //TABLA ACCIONES
        TreeTableColumn acc = new TreeTableColumn("Acción");
        TreeTableColumn m_ini = new TreeTableColumn("Mes de inicio");
        TreeTableColumn a_ini = new TreeTableColumn("Año de inicio");
        TreeTableColumn m_fin = new TreeTableColumn("Mes final");
        TreeTableColumn a_fin = new TreeTableColumn("Año final");
        TreeTableColumn tipacc = new TreeTableColumn("Tipo de Acción");
        TreeTableColumn trim = new TreeTableColumn("Trimestre");
        TreeTableColumn lugar = new TreeTableColumn("Lugar");
        TreeTableColumn mform = new TreeTableColumn("Modo de formación");
        TreeTableColumn resp = new TreeTableColumn("Responsable");
        TreeTableColumn cump = new TreeTableColumn("Cumplimiento");

        table_acciones.getColumns().addAll(acc, m_ini, a_ini, m_fin, a_fin, tipacc, trim, lugar, mform, resp, cump);

        acc.setPrefWidth(250);
        acc.setCellValueFactory(new TreeItemPropertyValueFactory("acciones"));
        m_ini.setPrefWidth(100);
        m_ini.setCellValueFactory(new TreeItemPropertyValueFactory("mes_inicio"));
        a_ini.setPrefWidth(100);
        a_ini.setCellValueFactory(new TreeItemPropertyValueFactory("anyo_inicio"));
        m_fin.setPrefWidth(100);
        m_fin.setCellValueFactory(new TreeItemPropertyValueFactory("mes_fin"));
        a_fin.setPrefWidth(100);
        a_fin.setCellValueFactory(new TreeItemPropertyValueFactory("anyo_fin"));
        tipacc.setPrefWidth(100);
        tipacc.setCellValueFactory(new TreeItemPropertyValueFactory("tipo_Accion"));
        trim.setPrefWidth(100);
        trim.setCellValueFactory(new TreeItemPropertyValueFactory("trimestre"));
        lugar.setPrefWidth(100);
        lugar.setCellValueFactory(new TreeItemPropertyValueFactory("lugar"));
        mform.setPrefWidth(200);
        mform.setCellValueFactory(new TreeItemPropertyValueFactory("modo_formacion"));
        resp.setPrefWidth(100);
        resp.setCellValueFactory(new TreeItemPropertyValueFactory("responsable"));
        cump.setPrefWidth(100);
        cump.setCellValueFactory(new TreeItemPropertyValueFactory("cumplimiento"));

        llenarTablaAcciones(getList_acciones());

        //TABLA CAPACITACION
        TreeTableColumn grup = new TreeTableColumn("Grupo");
        TreeTableColumn trabaj = new TreeTableColumn("Trabajador");
        TreeTableColumn acccp = new TreeTableColumn("Acción");
        TreeTableColumn m_inicp = new TreeTableColumn("Mes de inicio");
        TreeTableColumn a_inicp = new TreeTableColumn("Año de inicio");
        TreeTableColumn m_fincp = new TreeTableColumn("Mes final");
        TreeTableColumn a_fincp = new TreeTableColumn("Año final");
        TreeTableColumn tipacccp = new TreeTableColumn("Tipo de Acción");
        TreeTableColumn trimcp = new TreeTableColumn("Trimestre");
        TreeTableColumn lugarcp = new TreeTableColumn("Lugar");
        TreeTableColumn mformcp = new TreeTableColumn("Modo de formación");
        TreeTableColumn respcp = new TreeTableColumn("Responsable");
        TreeTableColumn cumpcp = new TreeTableColumn("Cumplimiento");

        table_capacitacion.getColumns().addAll(grup, trabaj, acccp, m_inicp, a_inicp, m_fincp, a_fincp, tipacccp, trimcp, lugarcp, mformcp, respcp, cumpcp);

        grup.setPrefWidth(250);
        grup.setCellValueFactory(new TreeItemPropertyValueFactory("grupo"));
        trabaj.setPrefWidth(250);
        trabaj.setCellValueFactory(new TreeItemPropertyValueFactory("nombre"));
        acccp.setPrefWidth(250);
        acccp.setCellValueFactory(new TreeItemPropertyValueFactory("acciones"));
        m_inicp.setPrefWidth(100);
        m_inicp.setCellValueFactory(new TreeItemPropertyValueFactory("mes_inicio"));
        a_inicp.setPrefWidth(100);
        a_inicp.setCellValueFactory(new TreeItemPropertyValueFactory("anyo_inicio"));
        m_fincp.setPrefWidth(100);
        m_fincp.setCellValueFactory(new TreeItemPropertyValueFactory("mes_fin"));
        a_fincp.setPrefWidth(100);
        a_fincp.setCellValueFactory(new TreeItemPropertyValueFactory("anyo_fin"));
        tipacccp.setPrefWidth(100);
        tipacccp.setCellValueFactory(new TreeItemPropertyValueFactory("tipo_Accion"));
        trimcp.setPrefWidth(100);
        trimcp.setCellValueFactory(new TreeItemPropertyValueFactory("trimestre"));
        lugarcp.setPrefWidth(100);
        lugarcp.setCellValueFactory(new TreeItemPropertyValueFactory("lugar"));
        mformcp.setPrefWidth(200);
        mformcp.setCellValueFactory(new TreeItemPropertyValueFactory("modo_formacion"));
        respcp.setPrefWidth(100);
        respcp.setCellValueFactory(new TreeItemPropertyValueFactory("responsable"));
        cumpcp.setPrefWidth(100);
        cumpcp.setCellValueFactory(new TreeItemPropertyValueFactory("cumplimiento"));

        llenarTablaCapacitacion(getList_capacitacion());

        //tabla reportes
        TreeTableColumn num = new TreeTableColumn("No");
        TreeTableColumn mdform = new TreeTableColumn("Modo de Formación");
        TreeTableColumn accplan = new TreeTableColumn("Acciones Plan");
        TreeTableColumn accreal = new TreeTableColumn("Acciones Real");
        TreeTableColumn gradplan = new TreeTableColumn("Graduados Plan");
        TreeTableColumn gradreal = new TreeTableColumn("Graduados Real");

        table_repotrim.getColumns().addAll(num, mdform, accplan, accreal, gradplan, gradreal);
        num.setPrefWidth(50);
        num.setCellValueFactory(new TreeItemPropertyValueFactory("num")); // AQUI VA LOS MISMOS NOMBRES QUE EN LA CLASE VIEW
        mdform.setPrefWidth(250);
        mdform.setCellValueFactory(new TreeItemPropertyValueFactory("modForm"));
        accplan.setPrefWidth(100);
        accplan.setCellValueFactory(new TreeItemPropertyValueFactory("accplan"));
        accreal.setPrefWidth(100);
        accreal.setCellValueFactory(new TreeItemPropertyValueFactory("accreal"));
        gradplan.setPrefWidth(100);
        gradplan.setCellValueFactory(new TreeItemPropertyValueFactory("gradplan"));
        gradreal.setPrefWidth(100);
        gradreal.setCellValueFactory(new TreeItemPropertyValueFactory("gradreal"));

    }

    ///////////////////////////////MODULO TRABAJADOR////////////////////////////
    ///////////////////////////////MOSTRAR TRABAJADOR///////////////////////////
    @FXML
    private JFXTreeTableView table_trabajadores;
    ObservableList<TrabajadorView> datos;

    public void llenarTablaTrabajador(List<Trabajador> trabajadores) {
        List<TrabajadorView> tv = new ArrayList();
        for (Trabajador t : trabajadores) {
            tv.add(new TrabajadorView(t.getId(), t.getNombre(), t.getNroIdentidad(),
                    t.getGrupo().getNombregrupo(), t.getcargo().getCargo(), t.getdireccion(),
                    t.getEspecialidad().getNomb_especialidad(), t.getmunicipio()));
        }
        datos = FXCollections.observableArrayList(tv);
        final TreeItem<TrabajadorView> root = new RecursiveTreeItem<>(datos, RecursiveTreeObject::getChildren);
        table_trabajadores.setRoot(root);
        table_trabajadores.setShowRoot(false);
    }

    @FXML
    public void selectIdTable() throws FileNotFoundException, IOException {
        if (table_trabajadores.getSelectionModel().getSelectedItem() != null) {
            btn_detalles_trabajador.setDisable(false);
            btn_editar_trabajador.setDisable(false);
            btn_eliminar_trabajador.setDisable(false);

            TreeItem<TrabajadorView> tview = (TreeItem<TrabajadorView>) table_trabajadores.getSelectionModel().getSelectedItem();
            String idt = tview.getValue().getId();
            System.out.println(idt);
            File f = new File("temp");
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.write(idt);
                f.createNewFile();
            }
        } else {
            btn_detalles_trabajador.setDisable(true);
            btn_editar_trabajador.setDisable(true);
            btn_eliminar_trabajador.setDisable(true);

        }

    }

    ///////////////////////////////AÑADIR TRABAJADOR////////////////////////////
    @FXML
    private JFXTextField txt_idtrabajador;
    @FXML
    private JFXTextField txt_nombre;
    @FXML
    private JFXTextField txt_ci;
    @FXML
    private JFXTextArea txt_direccion;
    @FXML
    private JFXComboBox cbx_grupo;
    @FXML
    private JFXComboBox cbx_cargo;
    @FXML
    private JFXComboBox cbx_municipio;
    @FXML
    private JFXComboBox cbx_especialidad;

    @FXML
    public void guardarDatos() {
        System.out.println(cbx_grupo.getSelectionModel().getSelectedItem());
        if (cbx_grupo.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el grupo", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (txt_idtrabajador.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el ID del trabajador", Alert.AlertType.ERROR);
//            txt_idtrabajador.setFocusColor("");
        } else if (txt_nombre.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el nombre del trabajador", Alert.AlertType.ERROR);
//            txt_nombre.setFocusColor("");

        } else if (txt_ci.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el CI del trabajador", Alert.AlertType.ERROR);
//            txt_ci.setFocusColor("");

        } else if (cbx_cargo.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el cargo", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (cbx_especialidad.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar la especialidad", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (txt_direccion.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir la dirección del trabajador", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (cbx_municipio.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el municipio", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else {
            List<Long> cargoid = cgdao.getCargoid(cbx_cargo.getSelectionModel().getSelectedItem().toString());
            List<Long> grupoid = grupdao.getGrupoid(cbx_grupo.getSelectionModel().getSelectedItem().toString());
            List<Long> especialidadid = esdao.getEspecialidadid(cbx_especialidad.getSelectionModel().getSelectedItem().toString());
            String id = txt_idtrabajador.getText();
            String nombre_trab = txt_nombre.getText();
            String nro_identidad = txt_ci.getText();
            String direccion = txt_direccion.getText();
            Grupo g = new Grupo(grupoid.get(0), cbx_grupo.getSelectionModel().getSelectedItem().toString());           //new Grupo(cbx_grupo.getSelectionModel().getSelectedItem().toString());
            String municipio = cbx_municipio.getSelectionModel().getSelectedItem().toString();
            Cargo c = new Cargo(cargoid.get(0), cbx_cargo.getSelectionModel().getSelectedItem().toString());         //new Cargo(cbx_cargo.getSelectionModel().getSelectedItem().toString());
            Especialidad e = new Especialidad(especialidadid.get(0), cbx_especialidad.getSelectionModel().getSelectedItem().toString());          //new Especialidad(cbx_especialidad.getSelectionModel().getSelectedItem().toString());
            Trabajador t = new Trabajador(id, nombre_trab, g, nro_identidad, direccion, municipio, c, e);

            if (tdao.AddTrabajador(t)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
                list_trabajadores = tdao.getTrabajador();
                llenarTablaTrabajador(list_trabajadores);
                txt_idtrabajador.setText(null);
                txt_nombre.setText(null);
                txt_ci.setText(null);
                txt_direccion.setText(null);
                cbx_cargo.getSelectionModel().select(0);
                cbx_grupo.getSelectionModel().select(0);
                cbx_especialidad.getSelectionModel().select(0);
                cbx_municipio.getSelectionModel().select(0);
            }
        }

    }

    @FXML
    public void reset() {
        txt_idtrabajador.setText(null);
        txt_nombre.setText(null);
        txt_ci.setText(null);
        txt_direccion.setText(null);
        cbx_cargo.getSelectionModel().select(0);
        cbx_grupo.getSelectionModel().select(0);
        cbx_especialidad.getSelectionModel().select(0);
        cbx_municipio.getSelectionModel().select(0);
        txt_nombre_accion.setText(null);
        txt_anyo_inicio.setText(null);
        txt_anyo_fin.setText(null);
        txt_tipo_accion.setText(null);
        cbx_mes_inicio.getSelectionModel().select(0);
        cbx_mes_fin.getSelectionModel().select(0);
        cbx_lugar.getSelectionModel().select(0);
        cbx_responsable.getSelectionModel().select(0);
        cbx_modo_formacion.getSelectionModel().select(0);
        cbx_trimestre.getSelectionModel().select(0);
        cbx_cumplido.setSelected(false);
    }

    ObservableList<String> data;

    @FXML
    public void llenarlistaGrupo() {
        GrupoDAO gdao = new GrupoDAO();
        List<String> grupos = gdao.getGrupoNombre();
        grupos.add(0, "--Seleccionar grupo--");
        data = FXCollections.observableArrayList(grupos);
        cbx_grupo.setItems(data);
    }

    @FXML
    public void llenarlistaCargo() {
        CargoDAO cdao = new CargoDAO();
        List<String> cargos = cdao.getCargoNombre();
        cargos.add(0, "--Seleccionar cargo--");
        data = FXCollections.observableArrayList(cargos);
        cbx_cargo.setItems(data);

    }

    @FXML
    public void llenarlistaEspecialidad() {
        EspecialidadDAO edao = new EspecialidadDAO();
        List<String> especialidades = edao.getEspecialidadNombre();
        especialidades.add(0, "--Seleccionar especialidad--");
        data = FXCollections.observableArrayList(especialidades);
        cbx_especialidad.setItems(data);
    }

    public void llenarlistaMunicipio() {
        cbx_municipio.getItems().add("--Seleccionar municipio--");
        cbx_municipio.getItems().add("Cabaiguán");
        cbx_municipio.getItems().add("Fomento");
        cbx_municipio.getItems().add("Jatibonico");
        cbx_municipio.getItems().add("La Sierpe");
        cbx_municipio.getItems().add("Sancti Spíritus");
        cbx_municipio.getItems().add("Taguasco");
        cbx_municipio.getItems().add("Trinidad");
        cbx_municipio.getItems().add("Yaguajay");
    }

    @FXML
    public void showGRUP() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddGRUP.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showESP() throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddESP.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void showCARG() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddCARG.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    ////////////////////////////////MODIFICAR TRABAJADOR////////////////////////
    @FXML
    private JFXTextField txt_idtrabajadorE;
    @FXML
    private JFXTextField txt_nombreE;
    @FXML
    private JFXTextField txt_ciE;
    @FXML
    private JFXTextArea txt_direccionE;
    @FXML
    private JFXComboBox cbx_grupoE;
    @FXML
    private JFXComboBox cbx_cargoE;
    @FXML
    private JFXComboBox cbx_municipioE;
    @FXML
    private JFXComboBox cbx_especialidadE;

    @FXML
    public void Cancelar() {
        h_list.setVisible(true);
        h_add.setVisible(false);
        h_capac.setVisible(false);
        h_accion.setVisible(false);
        h_vinculo.setVisible(false);
        h_repoacc.setVisible(false);
        h_repoanual.setVisible(false);
        h_anual.setVisible(false);
        h_update.setVisible(false);
        cbx_cargoE = new JFXComboBox();
        cbx_grupoE = new JFXComboBox();
        cbx_especialidadE = new JFXComboBox();
        cbx_municipioE = new JFXComboBox();
    }

    public void datosEditarTrabajador() {
        if (table_trabajadores.getSelectionModel().getSelectedItem() != null) {
            TreeItem<TrabajadorView> tview = (TreeItem<TrabajadorView>) table_trabajadores.getSelectionModel().getSelectedItem();
            txt_idtrabajadorE.setText(tview.getValue().getId());
            txt_nombreE.setText(tview.getValue().getNombre());
            txt_ciE.setText(tview.getValue().getNroIdentidad());
            txt_direccionE.setText(tview.getValue().getDireccion());

            CargoDAO cdao = new CargoDAO();
            List<String> cargos = cdao.getCargoNombre();
            GrupoDAO gdao = new GrupoDAO();
            List<String> grupos = gdao.getGrupoNombre();
            EspecialidadDAO edao = new EspecialidadDAO();
            List<String> especialidades = edao.getEspecialidadNombre();
            cbx_cargoE.getItems().add("--Seleccionar cargo--");
            for (int idx = 0; idx < cargos.size(); idx++) {
                cbx_cargoE.getItems().add(cargos.get(idx));
            }
            cbx_cargoE.getSelectionModel().select(tview.getValue().getCargo());
            cbx_grupoE.getItems().add("--Seleccionar grupo--");
            for (int i = 0; i < grupos.size(); i++) {
                cbx_grupoE.getItems().add(grupos.get(i));
            }
            cbx_grupoE.getSelectionModel().select(tview.getValue().getGrupo());
            cbx_especialidadE.getItems().add("--Seleccionar especialidad--");
            for (int i = 0; i < especialidades.size(); i++) {
                cbx_especialidadE.getItems().add(especialidades.get(i));
            }
            cbx_especialidadE.getSelectionModel().select(tview.getValue().getEspecialidad());
            cbx_municipioE.getItems().add("--Seleccionar municipio--");
            cbx_municipioE.getItems().add("Cabaiguán");
            cbx_municipioE.getItems().add("Fomento");
            cbx_municipioE.getItems().add("Jatibonico");
            cbx_municipioE.getItems().add("La Sierpe");
            cbx_municipioE.getItems().add("Sancti Spíritus");
            cbx_municipioE.getItems().add("Taguasco");
            cbx_municipioE.getItems().add("Trinidad");
            cbx_municipioE.getItems().add("Yaguajay");

            cbx_municipioE.getSelectionModel().select(tview.getValue().getMunicipio());
        }
    }

    @FXML
    private void update() {
        List<Trabajador> list;
        if (cbx_grupoE.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el grupo", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (txt_idtrabajadorE.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el ID del trabajador", Alert.AlertType.ERROR);
//            txt_idtrabajador.setFocusColor("");
        } else if (txt_nombreE.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el nombre del trabajador", Alert.AlertType.ERROR);
//            txt_nombre.setFocusColor("");

        } else if (txt_ciE.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el CI del trabajador", Alert.AlertType.ERROR);
//            txt_ci.setFocusColor("");

        } else if (cbx_cargoE.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el cargo", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (cbx_especialidadE.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar la especialidad", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (txt_direccionE.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir la dirección del trabajador", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (cbx_municipioE.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el municipio", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else {
            String id = txt_idtrabajadorE.getText();
            String nombre_trab = txt_nombreE.getText();
            String nro_identidad = txt_ciE.getText();
            String direccion = txt_direccionE.getText();
            Grupo g = grupdao.getNombreGrupo(cbx_grupoE.getSelectionModel().getSelectedItem().toString()).get(0);
            String municipio = cbx_municipioE.getSelectionModel().getSelectedItem().toString();
            Cargo c = cgdao.getNombreCargo(cbx_cargoE.getSelectionModel().getSelectedItem().toString()).get(0);
            Especialidad e = esdao.getNombreEspecialidad(cbx_especialidadE.getSelectionModel().getSelectedItem().toString()).get(0);
            Trabajador t = new Trabajador(id, nombre_trab, g, nro_identidad, direccion, municipio, c, e);
            if (tdao.updateTrabajador(t)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
                list = tdao.getTrabajador();
                llenarTablaTrabajador(list);
                h_list.setVisible(true);
                h_add.setVisible(false);
                h_capac.setVisible(false);
                h_accion.setVisible(false);
                h_vinculo.setVisible(false);
                h_repoacc.setVisible(false);
                h_repoanual.setVisible(false);
                h_anual.setVisible(false);
                h_update.setVisible(false);
                h_addAccion.setVisible(false);
                h_update_cap.setVisible(false);
                cbx_cargoE = new JFXComboBox();
                cbx_grupoE = new JFXComboBox();
                cbx_especialidadE = new JFXComboBox();
                cbx_municipioE = new JFXComboBox();

            }
        }
    }

    ////////////////////////////////DETALLES TRABAJADOR////////////////////////
    @FXML
    public void detallesTrabajador() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDetallesTrabajador.fxml"));
//        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    ////////////////////////////////ELIMINAR TRABAJADOR////////////////////////    
    @FXML
    private void eliminarTrabajador(ActionEvent event) {
        if (table_trabajadores.getSelectionModel().getSelectedItem() != null) {
            TreeItem<TrabajadorView> tview = (TreeItem<TrabajadorView>) table_trabajadores.getSelectionModel().getSelectedItem();
            if (menssager.showMessajeCONFIRMATION(null, "WARNING", "Seguro que quiere eliminar a " + tview.getValue().getNombre())) {
                Trabajador t = tdao.getTrabajadorPorID(tview.getValue().getId()).get(0);
                if (tdao.deleteTrabajador(t)) {
                    List<Trabajador> list = tdao.getTrabajador();
                    llenarTablaTrabajador(list);
                    menssager.showMessajeINFORMATION("", "", "Se eliminaron los datos correctamente", Alert.AlertType.INFORMATION);
                } else {
                    menssager.showMessajeINFORMATION(null, "Error", "Error al eliminar", Alert.AlertType.ERROR);
                }
            }
        }

    }

    ////////////////////////////////BUSCAR TRABAJADOR///////////////////////////
    @FXML
    private JFXTextField txt_buscar_nombre;
    @FXML
    private JFXTextField txt_buscar_ci;

    @FXML
    public void buscar() {
        list_trabajadores = tdao.getTrabajadorPorNombre(txt_buscar_nombre.getText());
        if (!(txt_buscar_nombre.getText().isEmpty())) {
            llenarTablaTrabajador(list_trabajadores);
        } else {
            llenarTablaTrabajador(getList_trabajadores());
        }
    }

    @FXML
    public void buscarxCI() {
        list_trabajadores = tdao.getTrabajadorPorCI(txt_buscar_ci.getText());

        if (!(txt_buscar_ci.getText().isEmpty())) {
            llenarTablaTrabajador(list_trabajadores);
        } else {
            llenarTablaTrabajador(getList_trabajadores());
        }
    }

    ///////////////////////////////MODULO ACCIÓN////////////////////////////
    ///////////////////////////////AÑADIR ACCIÓN////////////////////////////
    @FXML
    private JFXTextField txt_nombre_accion;
    @FXML
    private JFXComboBox cbx_mes_inicio;
    @FXML
    private JFXComboBox cbx_mes_fin;
    @FXML
    private JFXTextField txt_anyo_inicio;
    @FXML
    private JFXTextField txt_anyo_fin;
    @FXML
    private JFXTextField txt_tipo_accion;
    @FXML
    private JFXComboBox cbx_lugar;
    @FXML
    private JFXComboBox cbx_responsable;
    @FXML
    private JFXComboBox cbx_modo_formacion;
    @FXML
    private JFXComboBox cbx_trimestre;
    @FXML
    private JFXCheckBox cbx_cumplido;

    @FXML
    public void llenarlistaLugar() {
        LugarDAO ldao = new LugarDAO();
        List<String> lugares = ldao.getLugar();
        lugares.add(0, "--Seleccionar lugar--");
        data = FXCollections.observableArrayList(lugares);
        cbx_lugar.setItems(data);
    }

    @FXML
    public void llenarlistaResponsable() {
        ResponsableDAO rdao = new ResponsableDAO();
        List<String> responsables = rdao.getNombreResponsable();
        responsables.add(0, "--Seleccionar responsable--");
        data = FXCollections.observableArrayList(responsables);
        cbx_responsable.setItems(data);
    }

    @FXML
    public void llenarlistaModoFormacion() {
        Modo_formacionDAO mfdao = new Modo_formacionDAO();
        List<String> formaciones = mfdao.getModo_formacion();
        formaciones.add(0, "--Seleccionar modo de formación--");
        data = FXCollections.observableArrayList(formaciones);
        cbx_modo_formacion.setItems(data);
    }

    @FXML
    public void llenarlistaTrimestre() {
        cbx_trimestre.getItems().add("--Seleccionar trimestre--");
        cbx_trimestre.getItems().add("Primer Trimestre");
        cbx_trimestre.getItems().add("Segundo Trimestre");
        cbx_trimestre.getItems().add("Tercer Trimestre");
        cbx_trimestre.getItems().add("Cuarto Trimestre");

    }

    @FXML
    public void llenarlistaMes() {
        cbx_mes_inicio.getItems().add("--Seleccionar mes--");
        cbx_mes_inicio.getItems().add("Enero");
        cbx_mes_inicio.getItems().add("Febrero");
        cbx_mes_inicio.getItems().add("Marzo");
        cbx_mes_inicio.getItems().add("Abril");
        cbx_mes_inicio.getItems().add("Mayo");
        cbx_mes_inicio.getItems().add("Junio");
        cbx_mes_inicio.getItems().add("Julio");
        cbx_mes_inicio.getItems().add("Agosto");
        cbx_mes_inicio.getItems().add("Septiembre");
        cbx_mes_inicio.getItems().add("Octubre");
        cbx_mes_inicio.getItems().add("Noviembre");
        cbx_mes_inicio.getItems().add("Diciembre");

        cbx_mes_fin.getItems().add("--Seleccionar mes--");
        cbx_mes_fin.getItems().add("Enero");
        cbx_mes_fin.getItems().add("Febrero");
        cbx_mes_fin.getItems().add("Marzo");
        cbx_mes_fin.getItems().add("Abril");
        cbx_mes_fin.getItems().add("Mayo");
        cbx_mes_fin.getItems().add("Junio");
        cbx_mes_fin.getItems().add("Julio");
        cbx_mes_fin.getItems().add("Agosto");
        cbx_mes_fin.getItems().add("Septiembre");
        cbx_mes_fin.getItems().add("Octubre");
        cbx_mes_fin.getItems().add("Noviembre");
        cbx_mes_fin.getItems().add("Diciembre");
    }

    @FXML
    public void showLUGAR() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddLugar.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showResponsable() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddResponsable.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showModoFormacion() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddModo_Formacion.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private Lugar l = new Lugar();
    private Responsable r = new Responsable();
    private Modo_formacion mf = new Modo_formacion();
    private LugarDAO ldao = new LugarDAO();
    private ResponsableDAO rdao = new ResponsableDAO();
    private Modo_formacionDAO mfdao = new Modo_formacionDAO();
    private Capacitacion c = new Capacitacion();

    @FXML
    public void AddAccion() {
        if ((cbx_mes_inicio.getSelectionModel().getSelectedItem() == null
                || cbx_mes_inicio.getSelectionModel().getSelectedItem().equals("--Seleccionar mes--"))
                || (cbx_mes_fin.getSelectionModel().getSelectedItem() == null
                || cbx_mes_fin.getSelectionModel().getSelectedItem().equals("--Seleccionar mes--"))) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el mes", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (txt_nombre_accion.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir la acción", Alert.AlertType.ERROR);
//            txt_idtrabajador.setFocusColor("");
        } else if (txt_anyo_inicio.getPromptText().isEmpty() || txt_anyo_fin.getPromptText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el año", Alert.AlertType.ERROR);
//            txt_nombre.setFocusColor("");
        } else if (txt_tipo_accion.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el tipo de acción", Alert.AlertType.ERROR);
//            txt_ci.setFocusColor("");
        } else if (cbx_lugar.getSelectionModel().getSelectedItem() == null
                || cbx_lugar.getSelectionModel().getSelectedItem().equals("--Seleccionar lugar--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el lugar", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (cbx_responsable.getSelectionModel().getSelectedItem() == null
                || cbx_responsable.getSelectionModel().getSelectedItem().equals("--Seleccionar responsable--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el responsable", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (cbx_modo_formacion.getSelectionModel().getSelectedItem() == null
                || cbx_modo_formacion.getSelectionModel().getSelectedItem().equals("--Seleccionar modo de formación--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el modo de formación", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (cbx_trimestre.getSelectionModel().getSelectedItem() == null
                || cbx_trimestre.getSelectionModel().getSelectedItem().equals("--Seleccionar trimestre--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el trimestre", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else {
            l = ldao.getNombreLugar(cbx_lugar.getSelectionModel().getSelectedItem().toString()).get(0);
            r = rdao.getNombreResponsable(cbx_responsable.getSelectionModel().getSelectedItem().toString()).get(0);
            mf = mfdao.getNombreModo_formacion(cbx_modo_formacion.getSelectionModel().getSelectedItem().toString()).get(0);
            String trimestre = cbx_trimestre.getSelectionModel().getSelectedItem().toString();
            c.setAcciones(txt_nombre_accion.getText());
            if (isNumeric(txt_anyo_fin.getText()) && isNumeric(txt_anyo_inicio.getText())) {
                c.setAnyo_fin(Integer.parseInt(txt_anyo_fin.getText()));
                c.setAnyo_inicio(Integer.parseInt(txt_anyo_inicio.getText()));
            } else {
                menssager.showMessajeINFORMATION(null, "Error", "Inserte el año correctamente", Alert.AlertType.ERROR);
            }
            c.setCumplimiento(cbx_cumplido.isSelected());
            c.setLugar(l);
            c.setMes_fin(cbx_mes_fin.getSelectionModel().getSelectedItem().toString());
            c.setMes_inicio(cbx_mes_inicio.getSelectionModel().getSelectedItem().toString());
            c.setModo_formacion(mf);
            c.setResponsable(r);
            c.setTrimestre(trimestre);
            c.setTipo_Accion(txt_tipo_accion.getText());

            if (cdao.AddCapacitacion(c)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
                list_acciones = cdao.getCapacitacion();
                llenarTablaAcciones(list_acciones);
                txt_nombre_accion.setText(null);
                txt_anyo_inicio.setText(null);
                txt_anyo_fin.setText(null);
                txt_tipo_accion.setText(null);
                cbx_mes_inicio.getSelectionModel().select(0);
                cbx_mes_fin.getSelectionModel().select(0);
                cbx_lugar.getSelectionModel().select(0);
                cbx_responsable.getSelectionModel().select(0);
                cbx_modo_formacion.getSelectionModel().select(0);
                cbx_trimestre.getSelectionModel().select(0);
                cbx_cumplido.setSelected(false);
            }
        }

    }
    

    ///////////////////////////TABLA CAPACITACIÓN//////////////////////
    @FXML
    private JFXTreeTableView table_acciones;

    ObservableList<CapacitacionView> datosc;

    public void llenarTablaAcciones(List<Capacitacion> capacitacion) {
        List<CapacitacionView> cv = new ArrayList();
        for (Capacitacion c : capacitacion) {
            cv.add(new CapacitacionView(c.getId(),
                    c.getAcciones(), c.getMes_inicio(), c.getAnyo_inicio(),
                    c.getMes_fin(), c.getAnyo_fin(), c.getTipo_Accion(),
                    c.getTrimestre(), c.getLugar().getNombrelugar(),
                    c.getModo_formacion().getM_form(),
                    c.getResponsable().getNomb_responsable(), c.isCumplimiento()));
        }
        datosc = FXCollections.observableArrayList(cv);
        final TreeItem<CapacitacionView> root = new RecursiveTreeItem<>(datosc, RecursiveTreeObject::getChildren);
        table_acciones.setRoot(root);
        table_acciones.setShowRoot(false);
    }

    @FXML
    private JFXButton btn_detalles_c;
    @FXML
    private JFXButton btn_editar_c;
    @FXML
    private JFXButton btn_eliminar_c;

    @FXML
    public void selectIdTableC() throws FileNotFoundException, IOException {
        if (table_acciones.getSelectionModel().getSelectedItem() != null) {
            btn_detalles_c.setDisable(false);
            btn_editar_c.setDisable(false);
            btn_eliminar_c.setDisable(false);
            TreeItem<CapacitacionView> cview = (TreeItem<CapacitacionView>) table_acciones.getSelectionModel().getSelectedItem();
            long idc = cview.getValue().getId();
            System.out.println(idc);
            File f = new File("temp");
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.write(String.valueOf(idc));
                f.createNewFile();
            }
        } else {
            btn_detalles_c.setDisable(true);
            btn_editar_c.setDisable(true);
            btn_eliminar_c.setDisable(true);

        }

    }
    ////////////////////////DETALLES CAPACITACIÓN//////////////////////////
    @FXML
    public void detallesCapacitacion() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDetallesCapacitacion.fxml"));
//        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
    
    ///////////////////////////BUSCAR CAPACITACIÓN//////////////////////
    @FXML
    private JFXTextField txt_buscar_accion;
    @FXML
    private JFXTextField txt_buscar_m_formacion;

    @FXML
    public void buscarAccion() {
        list_acciones = cdao.getAccion(txt_buscar_accion.getText());
        if (!(txt_buscar_accion.getText().isEmpty())) {
            llenarTablaAcciones(list_acciones);
        } else {
            llenarTablaAcciones(getList_acciones());
        }
    }

    @FXML
    public void buscarM_Formacion() {
        list_acciones = cdao.getModoFormacion(txt_buscar_m_formacion.getText());

        if (!(txt_buscar_m_formacion.getText().isEmpty())) {
            llenarTablaAcciones(list_acciones);
        } else {
            llenarTablaAcciones(getList_acciones());
        }
    }

    ///////////////////////////EDITAR CAPACITACIÓN//////////////////////
    @FXML
    private JFXTextField txt_nombre_accionE;
    @FXML
    private JFXComboBox cbx_mes_inicioE;
    @FXML
    private JFXComboBox cbx_mes_finE;
    @FXML
    private JFXTextField txt_anyo_inicioE;
    @FXML
    private JFXTextField txt_anyo_finE;
    @FXML
    private JFXTextField txt_tipo_accionE;
    @FXML
    private JFXTextField txt_idE;
    @FXML
    private JFXComboBox cbx_lugarE;
    @FXML
    private JFXComboBox cbx_responsableE;
    @FXML
    private JFXComboBox cbx_modo_formacionE;
    @FXML
    private JFXComboBox cbx_trimestreE;
    @FXML
    private JFXCheckBox cbx_cumplidoE;

    @FXML
    public void CancelarEditar() {
        h_capac.setVisible(false);
        h_list.setVisible(false);
        h_add.setVisible(false);
        h_accion.setVisible(true);
        h_vinculo.setVisible(false);
        h_repoacc.setVisible(false);
        h_repoanual.setVisible(false);
        h_anual.setVisible(false);
        h_update.setVisible(false);
        h_addAccion.setVisible(false);
        h_update_cap.setVisible(false);
        
    }

    public void datosEditarCapacitacion() {
        if (table_acciones.getSelectionModel().getSelectedItem() != null) {
            TreeItem<CapacitacionView> cview = (TreeItem<CapacitacionView>) table_acciones.getSelectionModel().getSelectedItem();
            txt_idE.setText(String.valueOf(cview.getValue().getId()));
            txt_nombre_accionE.setText(cview.getValue().getAcciones());
            txt_anyo_inicioE.setText(String.valueOf(cview.getValue().getAnyo_inicio()));
            txt_anyo_finE.setText(String.valueOf(cview.getValue().getAnyo_fin()));
            txt_tipo_accionE.setText(cview.getValue().getTipo_Accion());

            List<String> lugares = ldao.getLugar();
            List<String> responsables = rdao.getNombreResponsable();
            List<String> modos = mfdao.getModo_formacion();
            cbx_lugarE.getItems().add("--Seleccionar lugar--");
            for (int idx = 0; idx < lugares.size(); idx++) {
                cbx_lugarE.getItems().add(lugares.get(idx));
            }
            cbx_lugarE.getSelectionModel().select(cview.getValue().getLugar());
            cbx_responsableE.getItems().add("--Seleccionar responsable--");
            for (int i = 0; i < responsables.size(); i++) {
                cbx_responsableE.getItems().add(responsables.get(i));
            }
            cbx_responsableE.getSelectionModel().select(cview.getValue().getResponsable());
            cbx_modo_formacionE.getItems().add("--Seleccionar especialidad--");
            for (int i = 0; i < modos.size(); i++) {
                cbx_modo_formacionE.getItems().add(modos.get(i));
            }
            cbx_modo_formacionE.getSelectionModel().select(cview.getValue().getModo_formacion());
            cbx_trimestreE.getItems().add("--Seleccionar trimestre--");
            cbx_trimestreE.getItems().add("Primer Trimestre");
            cbx_trimestreE.getItems().add("Segundo Trimestre");
            cbx_trimestreE.getItems().add("Tercer Trimestre");
            cbx_trimestreE.getItems().add("Cuarto Trimestre");

            cbx_trimestreE.getSelectionModel().select(cview.getValue().getTrimestre());

            cbx_mes_inicioE.getItems().add("--Seleccionar mes--");
            cbx_mes_inicioE.getItems().add("Enero");
            cbx_mes_inicioE.getItems().add("Febrero");
            cbx_mes_inicioE.getItems().add("Marzo");
            cbx_mes_inicioE.getItems().add("Abril");
            cbx_mes_inicioE.getItems().add("Mayo");
            cbx_mes_inicioE.getItems().add("Junio");
            cbx_mes_inicioE.getItems().add("Julio");
            cbx_mes_inicioE.getItems().add("Agosto");
            cbx_mes_inicioE.getItems().add("Septiembre");
            cbx_mes_inicioE.getItems().add("Octubre");
            cbx_mes_inicioE.getItems().add("Noviembre");
            cbx_mes_inicioE.getItems().add("Diciembre");

            cbx_mes_inicioE.getSelectionModel().select(cview.getValue().getMes_inicio());

            cbx_mes_finE.getItems().add("--Seleccionar mes--");
            cbx_mes_finE.getItems().add("Enero");
            cbx_mes_finE.getItems().add("Febrero");
            cbx_mes_finE.getItems().add("Marzo");
            cbx_mes_finE.getItems().add("Abril");
            cbx_mes_finE.getItems().add("Mayo");
            cbx_mes_finE.getItems().add("Junio");
            cbx_mes_finE.getItems().add("Julio");
            cbx_mes_finE.getItems().add("Agosto");
            cbx_mes_finE.getItems().add("Septiembre");
            cbx_mes_finE.getItems().add("Octubre");
            cbx_mes_finE.getItems().add("Noviembre");
            cbx_mes_finE.getItems().add("Diciembre");

            cbx_mes_finE.getSelectionModel().select(cview.getValue().getMes_fin());

            cbx_cumplidoE.setSelected(cview.getValue().isCumplimiento());
        }
    }

    @FXML
    private void updateCapacitacion() {
        
        if ((cbx_mes_inicioE.getSelectionModel().getSelectedItem() == null
                || cbx_mes_inicioE.getSelectionModel().getSelectedItem().equals("--Seleccionar mes--"))
                || (cbx_mes_finE.getSelectionModel().getSelectedItem() == null
                || cbx_mes_finE.getSelectionModel().getSelectedItem().equals("--Seleccionar mes--"))) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el mes", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (txt_nombre_accionE.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir la acción", Alert.AlertType.ERROR);
//            txt_idtrabajador.setFocusColor("");
        } else if (txt_anyo_inicioE.getPromptText().isEmpty() || txt_anyo_fin.getPromptText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el año", Alert.AlertType.ERROR);
//            txt_nombre.setFocusColor("");
        } else if (txt_tipo_accionE.getText().isEmpty()) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe introducir el tipo de acción", Alert.AlertType.ERROR);
//            txt_ci.setFocusColor("");
        } else if (cbx_lugarE.getSelectionModel().getSelectedItem() == null
                || cbx_lugarE.getSelectionModel().getSelectedItem().equals("--Seleccionar lugar--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el lugar", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (cbx_responsableE.getSelectionModel().getSelectedItem() == null
                || cbx_responsableE.getSelectionModel().getSelectedItem().equals("--Seleccionar responsable--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el responsable", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (cbx_modo_formacionE.getSelectionModel().getSelectedItem() == null
                || cbx_modo_formacionE.getSelectionModel().getSelectedItem().equals("--Seleccionar modo de formación--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el modo de formación", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else if (cbx_trimestreE.getSelectionModel().getSelectedItem() == null
                || cbx_trimestreE.getSelectionModel().getSelectedItem().equals("--Seleccionar trimestre--")) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el trimestre", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");
        } else {
            c = cdao.getCapacitacion(Long.parseLong(txt_idE.getText())).get(0);
            l = ldao.getNombreLugar(cbx_lugarE.getSelectionModel().getSelectedItem().toString()).get(0);
            r = rdao.getNombreResponsable(cbx_responsableE.getSelectionModel().getSelectedItem().toString()).get(0);
            mf = mfdao.getNombreModo_formacion(cbx_modo_formacionE.getSelectionModel().getSelectedItem().toString()).get(0);
            String trimestre = cbx_trimestreE.getSelectionModel().getSelectedItem().toString();
            c.setAcciones(txt_nombre_accionE.getText());
            if (isNumeric(txt_anyo_finE.getText()) && isNumeric(txt_anyo_inicioE.getText())) {
                c.setAnyo_fin(Integer.parseInt(txt_anyo_finE.getText()));
                c.setAnyo_inicio(Integer.parseInt(txt_anyo_inicioE.getText()));
            } else {
                menssager.showMessajeINFORMATION(null, "Error", "Inserte el año correctamente", Alert.AlertType.ERROR);
            }
            c.setCumplimiento(cbx_cumplidoE.isSelected());
            c.setLugar(l);
            c.setMes_fin(cbx_mes_finE.getSelectionModel().getSelectedItem().toString());
            c.setMes_inicio(cbx_mes_inicioE.getSelectionModel().getSelectedItem().toString());
            c.setModo_formacion(mf);
            c.setResponsable(r);
            c.setTrimestre(trimestre);
            c.setTipo_Accion(txt_tipo_accionE.getText());

            if (cdao.updateCapacitacion(c)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);
                list_acciones = cdao.getCapacitacion();
                llenarTablaAcciones(list_acciones);
                h_capac.setVisible(false);
                h_list.setVisible(false);
                h_add.setVisible(false);
                h_accion.setVisible(true);
                h_vinculo.setVisible(false);
                h_repoacc.setVisible(false);
                h_repoanual.setVisible(false);
                h_anual.setVisible(false);
                h_update.setVisible(false);
                h_addAccion.setVisible(false);
                h_update_cap.setVisible(false);
                cbx_mes_inicioE = new JFXComboBox();
                cbx_mes_finE = new JFXComboBox();
                cbx_lugarE = new JFXComboBox();
                cbx_responsableE = new JFXComboBox();
                cbx_modo_formacionE = new JFXComboBox();
                cbx_trimestreE = new JFXComboBox();

            }
        }
    }
    @FXML
    private void eliminarCapacitacion(ActionEvent event) {
            if (table_capacitacion.getSelectionModel().getSelectedItem() != null) {
            TreeItem<CapacitacionView> cview = (TreeItem<CapacitacionView>) table_capacitacion.getSelectionModel().getSelectedItem();
            if (menssager.showMessajeCONFIRMATION(null, "WARNING", "Seguro que quiere eliminar esta capacitación ")) {
                Capacitacion t = cdao.getCapacitacion(cview.getValue().getId()).get(0);
                if (cdao.eliminarCapacitacion(t)) {
                    List<Capacitacion> list = cdao.getCapacitacion();
                    llenarTablaAcciones(list);
                    menssager.showMessajeINFORMATION("", "", "Se eliminaron los datos correctamente", Alert.AlertType.INFORMATION);
                } else {
                    menssager.showMessajeINFORMATION(null, "Error", "Error al eliminar", Alert.AlertType.ERROR);
                }
            }
        }

    }
/////////////////////////////////CAPACITACIÓN - TRABAJADOR//////////////////////
///////////////////////////TABLA CAPACITACIÓN - TRABAJADOR//////////////////////
    public void llenarTablaCapacitacion(List<Trabajador_Capacitacion> cap) {
        List<Trabajador_CapacitacionView> tv = new ArrayList();

        for (int i = 0; i < cap.size(); i++) {
            tv.add(new Trabajador_CapacitacionView(cap.get(i).getTrabajador().getId(),
                    cap.get(i).getCapacitacion().getId(),
                    cap.get(i).getTrabajador().getNombre(),
                    cap.get(i).getTrabajador().getGrupo().getNombregrupo(),
                    cap.get(i).getCapacitacion().getAcciones(),
                    cap.get(i).getCapacitacion().getMes_inicio(),
                    cap.get(i).getCapacitacion().getAnyo_inicio(),
                    cap.get(i).getCapacitacion().getMes_fin(),
                    cap.get(i).getCapacitacion().getAnyo_fin(),
                    cap.get(i).getCapacitacion().getTipo_Accion(),
                    cap.get(i).getCapacitacion().getTrimestre(),
                    cap.get(i).getCapacitacion().getLugar().getNombrelugar(),
                    cap.get(i).getCapacitacion().getModo_formacion().getM_form(),
                    cap.get(i).getCapacitacion().getResponsable().getNomb_responsable(),
                    cap.get(i).getCapacitacion().isCumplimiento()));

        }
        datoscap = FXCollections.observableArrayList(tv);
        final TreeItem<Trabajador_CapacitacionView> root = new RecursiveTreeItem<>(datoscap, RecursiveTreeObject::getChildren);
        table_capacitacion.setRoot(root);
        table_capacitacion.setShowRoot(false);
    }

    @FXML
    private JFXButton btn_detalles_ct;

    @FXML
    public void selectIdTableCT() throws FileNotFoundException, IOException {
        if (table_capacitacion.getSelectionModel().getSelectedItem() != null) {
            btn_detalles_ct.setDisable(false);
            TreeItem<Trabajador_CapacitacionView> tcview = (TreeItem<Trabajador_CapacitacionView>) table_capacitacion.getSelectionModel().getSelectedItem();
            String idt = tcview.getValue().getIdT();
            long idc = tcview.getValue().getIdC();
            System.out.println(idt);
            File f = new File("temp");
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.write(idt + "-" + idc);
                f.createNewFile();
            }
        } else {
            btn_detalles_ct.setDisable(true);

        }

    }

    ////////////////////////DETALLES CAPACITACIÓN - TRABAJADOR//////////////////
    @FXML
    public void detallesCapacitacionTrabajador() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDetallesCapTrab.fxml"));
//        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    //////////////////////BUSCAR CAPACITACIÓN - TRABAJADOR//////////////////////
    @FXML
    private JFXTextField txt_buscar_nombre1;
    @FXML
    private JFXTextField txt_buscar_accion1;

    @FXML
    public void buscarTrabajador() {
        list_capacitacion = tcdao.getNombreTrabajador(txt_buscar_nombre1.getText());

        if (!(txt_buscar_nombre1.getText().isEmpty())) {
            llenarTablaCapacitacion(list_capacitacion);
        } else {
            llenarTablaCapacitacion(getList_capacitacion());
        }
    }

    @FXML
    public void buscarAccionCT() {
        list_capacitacion = tcdao.getAccion(txt_buscar_accion1.getText());
        if (!(txt_buscar_accion1.getText().isEmpty())) {
            llenarTablaCapacitacion(list_capacitacion);
        } else {
            llenarTablaCapacitacion(getList_capacitacion());
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    @FXML
    public void llenarlistaTrabajador() {
        TrabajadorDAO tdao = new TrabajadorDAO();
        String nomb_grupo = cbx_grupoadd.getSelectionModel().getSelectedItem().toString();
        List<String> trabajadores = tdao.getNombreTrabajador(nomb_grupo);
        trabajadores.add(0, "--Seleccionar trabajador--");
        data = FXCollections.observableArrayList(trabajadores);
        cbx_trabajadoradd.setItems(data);

    }

    public void llenarlistaAccion() {
        CapacitacionDAO cdao = new CapacitacionDAO();
        List<String> capacitacion = cdao.getCapacitacionName();
        for (String capacit : capacitacion) {
            cbx_accionadd.getItems().add(capacit);

        }
    }

    @FXML
    public void llenarfAccion() {
        CapacitacionDAO cdao = new CapacitacionDAO();
        String toString = cbx_accionadd.getSelectionModel().getSelectedItem().toString();
        List<Capacitacion> capacitacion = cdao.getCapacPorNombre(toString);
        String mes_inicio = capacitacion.get(0).getMes_inicio();
        Object anyo_inicio = capacitacion.get(0).getAnyo_inicio();
        String cad = mes_inicio.concat("/").concat(anyo_inicio.toString());
        faccion.setText(cad);
    }

    //////////////GETERS Y SETERS////////////////////
    public List<Trabajador> getList_trabajadores() {
        return list_trabajadores = tdao.getTrabajador();
    }

    public List<Capacitacion> getList_acciones() {
        return list_acciones = cdao.getCapacitacion();
    }

    public List<Trabajador_Capacitacion> getList_capacitacion() {
        return list_capacitacion = tcdao.getALLCapacitacionxTrabajador();
    }

    public List<String> getList_mdformacion() {
        return list_mdform = mdao.getModo_formacion();
    }

    @FXML
    public void VincularDatos() {
        System.out.println(cbx_grupoadd.getSelectionModel().getSelectedItem());
        if (cbx_grupoadd.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el grupo", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (cbx_trabajadoradd.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar el cargo", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else if (cbx_accionadd.getSelectionModel().getSelectedItem() == null) {
            menssager.showMessajeINFORMATION(null, "Error", "Debe seleccionar la acción", Alert.AlertType.ERROR);
//            txt_direccion.setFocusColor("");

        } else {

            String nomb_pers = cbx_trabajadoradd.getSelectionModel().getSelectedItem().toString();
            String acciones = cbx_accionadd.getSelectionModel().getSelectedItem().toString();

            if (tcdao.insertar(nomb_pers, acciones)) {
                menssager.showMessajeINFORMATION("", "", "Se guardaron los datos correctamente", Alert.AlertType.INFORMATION);

                llenarTablaCapacitacion(tcdao.getALLCapacitacionxTrabajador());

                llenarTablaCapacitacion(getList_capacitacion());
                cbx_grupoadd.getSelectionModel().clearSelection();
                cbx_trabajadoradd.getSelectionModel().clearSelection();
                cbx_accionadd.getSelectionModel().clearSelection();

            }
        }

    }

    @FXML
    protected void minimize(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void onCBFather(ActionEvent event) {
        if (event.getEventType().toString() != null) {
            //System.out.println("ActionEvent - CBFather - Fired = "+event.getEventType().toString());
            System.out.println(cbx_trimestre.getSelectionModel().getSelectedItem().toString());
            System.out.println(event.getEventType().toString());
            if (cbx_trimestre.getSelectionModel().getSelectedItem().toString() != null) {
                llenarTablarepotrim();
            }
        }
    }

    public void llenarTablarepotrim() {
        List<ReportesView> repv = new ArrayList();
        List<Long> acc_plan = new ArrayList<>();
        List<Long> acc_real = new ArrayList<>();
        List<Long> grad_plan = new ArrayList<>();
        List<Long> grad_real = new ArrayList<>();
        int cont_acc_plan = 0;
        int cont_acc_real = 0;
        int cont_grad_plan = 0;
        int cont_grad_real = 0;

        String trimestre = cbx_trimestre.getSelectionModel().getSelectedItem().toString();
        List<String> listm_form = mdao.getModo_formacion();

        for (int i = 0; i < listm_form.size(); i++) {
            String x = listm_form.get(i);
            cdao.getmdoForm(x);
            acc_plan = cdao.getContAccionesplan(trimestre, cdao.getmdoForm(x));
            cont_acc_plan += acc_plan.get(0);
            acc_real = cdao.getContAccionesAll(trimestre, cdao.getmdoForm(x));
            cont_acc_real += acc_real.get(0);
            grad_plan = tcdao.getContTrabajador(trimestre, listm_form.get(i));
            cont_grad_plan += grad_plan.get(0);
            grad_real = tcdao.getContTrabCumpl(trimestre, listm_form.get(i));
            cont_grad_real += grad_real.get(0);
            int first = i + 1;
            repv.add(new ReportesView(first, listm_form.get(i), acc_plan.get(0), acc_real.get(0), grad_plan.get(0), grad_real.get(0)));
        }

        datosrepo = FXCollections.observableArrayList(repv);
        final TreeItem<ReportesView> root = new RecursiveTreeItem<>(datosrepo, RecursiveTreeObject::getChildren);
        table_repotrim.setRoot(root);
        table_repotrim.setShowRoot(false);

    }

    @FXML
    private void reporteButton() {

        JFileChooser guardado = new JFileChooser();
        FileNameExtensionFilter type1 = new FileNameExtensionFilter("Libro de Excel(*.xlsx)", ".xlsx");
        FileNameExtensionFilter type2 = new FileNameExtensionFilter("Libro de Excel 97-2003 (*.xls)", ".xls");
        guardado.addChoosableFileFilter(type1);
        guardado.addChoosableFileFilter(type2);
        guardado.setMultiSelectionEnabled(false);
        guardado.setAcceptAllFileFilterUsed(false);
        //este es el nombre que sale en file name
        guardado.setSelectedFile(new File("Reporte"));
        int result = guardado.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            String ruta = guardado.getSelectedFile().getAbsolutePath();
//                Excel.ContarTareas();
//                Excel.CrearReporte(ruta);
        }

    }

    public boolean isNumeric(String cadena) {

        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        boolean resultado;
        try {
            nf.parse(cadena);
            resultado = true;
        } catch (ParseException ex) {
            resultado = false;
        }

        return resultado;

    }
}
