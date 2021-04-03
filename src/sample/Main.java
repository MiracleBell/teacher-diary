package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.control.Controller;
import sample.model.*;

import java.util.HashMap;
import java.util.Map;


public class Main extends Application {
    //Основные поля
    private static Stage mainStage;
    private static Team currentTeam;
    private static Student currentStudent;
    private static Task currentTask;
    private static Rating currentRating;
    private static ObservableList<Team> teams = FXCollections.observableArrayList();
    private static ObservableList<Student> students = FXCollections.observableArrayList();
    private static ObservableList<Task> tasks = FXCollections.observableArrayList();
    private static Map<String, Team> teamNameToTeam;


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/teamList.fxml"));

        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.initMainTable(teams);

        mainStage = primaryStage;
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
        teamNameToTeam = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Team team = new Team("МПБ-0" + i);

            for (int j = 0; j < 7; j++) {
                Student student = new Student("Иванов " + i + j, 0);
                team.addStudent(student);

                for (int k = 0; k < 3; k++) {
                    Task task = new Task(
                            "Задача " + k,
                            "Описание задачи",
                            5
                    );
                    student.getTasks().add(task);
                    team.addTask(task);
                }
//                students.add(student);
                /*team.addStudent(new Student(
                        "name" + i,
                        0
                ));*/
            }


//            teamNameToTeam.put(team.getTeamName(), team);
            teams.add(team);
        }
        /*for (int i = 0; i < 10; i++) {


            students.add(new Student(
                    "Name" + i,
                    0
            ));
        }*/
    }


    public static Stage getMainStage() {
        return mainStage;
    }

    public static Map<String, Team> getTeamNameToTeam() {
        return teamNameToTeam;
    }

    public static ObservableList<Team> getTeams() {
        return teams;
    }

    public static ObservableList<Student> getStudents() {
        return students;
    }

    public static ObservableList<Task> getTasks() {
        return tasks;
    }

    public static Team getCurrentTeam() {
        return currentTeam;
    }

    public static void setCurrentTeam(Team currentTeam) {
        Main.currentTeam = currentTeam;
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    public static void setCurrentStudent(Student currentStudent) {
        Main.currentStudent = currentStudent;
    }

    public static Rating getCurrentRating() {
        return currentRating;
    }

    public static void setCurrentRating(Rating currentRating) {
        Main.currentRating = currentRating;
    }

    public static Task getCurrentTask() {
        return currentTask;
    }

    public static void setCurrentTask(Task currentTask) {
        Main.currentTask = currentTask;
    }
}
