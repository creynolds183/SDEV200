import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SetClockTime extends Application{
    
    private class ClockPane extends Pane{

        private int hour;
        private int minute;
        private int second;

        public ClockPane() {
            Calendar calendar = new GregorianCalendar();

            this.hour = calendar.get(Calendar.HOUR_OF_DAY);
            this.minute = calendar.get(Calendar.MINUTE);
            this.second = calendar.get(Calendar.SECOND);
        }


        public int getHour() {
            return hour;
        }

        public void setHour(int hour){
            this.hour = hour;
            paintClock();
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute){
            this.minute = minute;
            paintClock();
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second){
            this.second = second;
            paintClock();
        }


        private void paintClock() {
            double clockRadius = 100;
            double centerX = getWidth() / 2;
            double centerY = getHeight() / 2;

            Circle circle = new Circle(centerX, centerY, clockRadius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
            Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
            Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
            Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

            double slength = clockRadius * 0.8;
            double secondX = centerX + slength * Math.sin(second * (2 * Math.PI / 60));
            double secondY = centerY - slength * Math.cos(second * (2 * Math.PI / 60));
            Line sLine = new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);

            double mlength = clockRadius * 0.65;
            double minuteX = centerX + mlength * Math.sin(minute * (2 * Math.PI / 60));
            double minuteY = centerY - mlength * Math.cos(minute * (2 * Math.PI / 60));
            Line mLine = new Line(centerX, centerY, minuteX, minuteY);
            mLine.setStroke(Color.BLUE);

            double hlength = clockRadius * 0.5;
            double hourX = centerX + hlength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            double hourY = centerY - hlength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            Line hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);

            getChildren().clear();
            getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
        }
        
        @Override
        public void setWidth(double width){
            super.setWidth(width);
            paintClock();
        }

        @Override
        public void setHeight(double height){
            super.setHeight(height);
            paintClock();
        }
    }
    
        private class clockChanger extends HBox{
            public clockChanger(ClockPane clock){
                getChildren().add(hourChanger(clock));
                getChildren().add(minuteChanger(clock));
                getChildren().add(secondChanger(clock));
                setAlignment(Pos.CENTER);
            }

            private HBox hourChanger(ClockPane clock){
                HBox pane = new HBox();

                pane.setPadding(new Insets(5, 5, 5, 5));
                pane.getChildren().add(new Label("Hour"));

                TextField tf = new TextField();
                pane.getChildren().add(tf);
                pane.setAlignment(Pos.CENTER);

                tf.setOnAction(event -> {
                    int hour = Integer.parseInt(tf.getText());
                    
                    clock.setHour(hour);
                });
                return pane;
            }

            private HBox minuteChanger(ClockPane clock){
                HBox pane = new HBox();

                pane.setPadding(new Insets(5, 5, 5, 5));
                pane.getChildren().add(new Label("Minute"));

                TextField tf = new TextField();
                pane.getChildren().add(tf);
                pane.setAlignment(Pos.CENTER);

                tf.setOnAction(event -> {
                    int minute = Integer.parseInt(tf.getText());
                    
                    clock.setMinute(minute);
                });
                return pane;
            }

            private HBox secondChanger(ClockPane clock){
                HBox pane = new HBox();

                pane.setPadding(new Insets(5, 5, 5, 5));
                pane.getChildren().add(new Label("Second"));

                TextField tf = new TextField();
                pane.getChildren().add(tf);
                pane.setAlignment(Pos.CENTER);

                tf.setOnAction(event -> {
                    int second = Integer.parseInt(tf.getText());
                    
                    clock.setSecond(second);
                });
                return pane;
            }
        }

    @Override
    public void start(Stage primaryStage){
        ClockPane clock = new ClockPane();
        Pane clockChanger = new clockChanger(clock);

        BorderPane pane = new BorderPane();
        clock.setPadding(new Insets(5, 0, 5, 0));
        clockChanger.setPadding(new Insets(0, 5, 0, 0));
        pane.setCenter(clock);
        pane.setBottom(clockChanger);
        BorderPane.setAlignment(clockChanger, Pos.CENTER);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Set Clock Time");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
