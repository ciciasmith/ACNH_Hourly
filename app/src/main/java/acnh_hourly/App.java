/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package acnh_hourly;

import javafx.application.Application;
import javafx.stage.Stage;

public class App {
    public static void main(String[] args) {
        Application.launch(Run.class, args);
    }
    
    public static class Run extends Application {

        @Override
        public  void init() throws Exception {
    
        }
    
        @Override
        public void start(Stage stage) throws Exception {
            Player player = new Player();
            
            new Window(player);
        }
    
    }
}
