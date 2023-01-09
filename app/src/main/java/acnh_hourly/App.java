/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package acnh_hourly;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Player player = new Player();
        
        new Window(player);
    }

    public static void main(String[] args) {
        try {
            launch(args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
