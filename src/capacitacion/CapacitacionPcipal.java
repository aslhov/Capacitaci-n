/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion;

import com.sun.javafx.application.LauncherImpl;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.dao.TrabajadorDAO;

/**
 *
 * @author wason
 */
public class CapacitacionPcipal extends Application {

    private static final int COUNT_LIMIT = 5;

    public static GraphicsDevice Gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static int width = Gd.getDisplayMode().getWidth();
    public static int height = Gd.getDisplayMode().getHeight();
    private final TrabajadorDAO tdao = new TrabajadorDAO();

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {

        // Perform some heavy lifting (i.e. database start, check for application updates, etc. )
        tdao.getAllTrabajador();
//        for (int i = 1; i <= COUNT_LIMIT; i++) {
//            double progress = (double) i / 5;
//            System.out.println("progress: " + progress);            
//            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
//            Thread.sleep(1000);
//        }

    }

    public static int damewidth () {
    return width;
    }
    
    public static int dameheigth () {
    return height;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LauncherImpl.launchApplication(CapacitacionPcipal.class, MyPreloader.class, args);
    }

}
