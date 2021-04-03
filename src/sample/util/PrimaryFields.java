package sample.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.model.Student;
import sample.model.Task;
import sample.model.Team;

public class PrimaryFields {
    private static Stage mainStage;
    private static Team currentTeam;
    private static Student currentStudent;
    private static Task currentTask;
    private static Rating currentRating;
    private static ObservableList<Team> teams = FXCollections.observableArrayList();

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        PrimaryFields.mainStage = mainStage;
    }

    public static Team getCurrentTeam() {
        return currentTeam;
    }

    public static void setCurrentTeam(Team currentTeam) {
        PrimaryFields.currentTeam = currentTeam;
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    public static void setCurrentStudent(Student currentStudent) {
        PrimaryFields.currentStudent = currentStudent;
    }

    public static Task getCurrentTask() {
        return currentTask;
    }

    public static void setCurrentTask(Task currentTask) {
        PrimaryFields.currentTask = currentTask;
    }

    public static Rating getCurrentRating() {
        return currentRating;
    }

    public static void setCurrentRating(Rating currentRating) {
        PrimaryFields.currentRating = currentRating;
    }

    public static ObservableList<Team> getTeams() {
        return teams;
    }

    public static void setTeams(ObservableList<Team> teams) {
        PrimaryFields.teams = teams;
    }
}
