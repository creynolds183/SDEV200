
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayImages extends Application{
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setHgap(5.0);
        pane.setVgap(5.0);
        try {
            FileInputStream inputStream1 = new FileInputStream("images\\flag2.gif");
            Image image = new Image(inputStream1);
            pane.add(new ImageView(image), 0, 0);

            FileInputStream inputStream2 = new FileInputStream("images\\flag7.gif");
            Image image2 = new Image(inputStream2);
            pane.add(new ImageView(image2), 1, 0);

            FileInputStream inputStream3 = new FileInputStream("images\\flag6.gif");
            Image image3 = new Image(inputStream3);
            pane.add(new ImageView(image3), 0, 1);

            FileInputStream inputStream4 = new FileInputStream("images\\flag1.gif");
            Image image4 = new Image(inputStream4);
            pane.add(new ImageView(image4), 1, 1);

            Scene scene = new Scene(pane);
            primaryStage.setTitle("ShowImage");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

