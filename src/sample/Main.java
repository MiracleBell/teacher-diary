package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.control.mainframe.Controller;
import sample.model.*;
import sample.util.PrimaryFields;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/mainframe/teamList.fxml"));

        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.initMainTable(PrimaryFields.getTeams());

        PrimaryFields.setMainStage(primaryStage);
        primaryStage.setTitle("Журнал преподавателя 1.0: Список групп");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() throws Exception {
        super.init();
        Task[] tasks = new Task[10];
        for (int i = 0; i < 10; i++) {
            tasks[i] = new Task(
                    "Задача " + i,
                    "Описание задачи",
                    (int) ((Math.random() * 9) + 1)
            );
        }

        for (int i = 0; i < 10; i++) {
            Team team = new Team("МПБ-0" + i);

            int randomValue = (int) ((Math.random() * 8) + 1);

            for (int j = 0; j < randomValue; j++) {
                Student student = new Student("Иванов " + i + j, 0);
                team.addStudent(student);

                for (int k = 0; k < randomValue; k++) {
                    student.getRatings().add(new Rating(tasks[k]));
                }
                team.getTasks().add(tasks[j]);
            }

            PrimaryFields.getTeams().add(team);
        }
    }
}
