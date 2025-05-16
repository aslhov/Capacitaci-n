/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author wason
 */
public class Menssager {
    public boolean showMessajeCONFIRMATION(String header, String title, String contentMesaje) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText(null);
        a.setTitle(title);
        a.setContentText(contentMesaje);
        Optional<ButtonType> action = a.showAndWait();
        if (action.get() == ButtonType.OK) {
            System.out.println("sel presiono aceptar");
            return true;
        } else {
            System.out.println("se presiono cancelar");
            return false;
        }
    }

    public void showMessajeINFORMATION(String header, String title,String contentMesaje, AlertType alertType) {
        Alert a = new Alert(alertType);
        a.setHeaderText(header);
        a.setTitle(title);
        a.setContentText(contentMesaje);
        a.show();
    }
}
