package sample.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.model.Student;
import sample.model.Task;
import sample.model.Team;

import java.util.Map;

public class PrimarySingleFields {
    private static Stage mainStage;
    private static Team currentTeam;
    private static Student currentStudent;
    private static Task currentTask;
    private static Rating currentRating;
    private static ObservableList<Team> teams = FXCollections.observableArrayList();
    private static ObservableList<Student> students = FXCollections.observableArrayList();
    private static ObservableList<Task> tasks = FXCollections.observableArrayList();
    private static Map<String, Team> teamNameToTeam;

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        PrimarySingleFields.mainStage = mainStage;
    }

    public static Team getCurrentTeam() {
        return currentTeam;
    }

    public static void setCurrentTeam(Team currentTeam) {
        PrimarySingleFields.currentTeam = currentTeam;
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    public static void setCurrentStudent(Student currentStudent) {
        PrimarySingleFields.currentStudent = currentStudent;
    }

    public static Task getCurrentTask() {
        return currentTask;
    }

    public static void setCurrentTask(Task currentTask) {
        PrimarySingleFields.currentTask = currentTask;
    }

    public static Rating getCurrentRating() {
        return currentRating;
    }

    public static void setCurrentRating(Rating currentRating) {
        PrimarySingleFields.currentRating = currentRating;
    }

    public static ObservableList<Team> getTeams() {
        return teams;
    }

    public static void setTeams(ObservableList<Team> teams) {
        PrimarySingleFields.teams = teams;
    }

    public static ObservableList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ObservableList<Student> students) {
        PrimarySingleFields.students = students;
    }

    public static ObservableList<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(ObservableList<Task> tasks) {
        PrimarySingleFields.tasks = tasks;
    }

    public static Map<String, Team> getTeamNameToTeam() {
        return teamNameToTeam;
    }

    public static void setTeamNameToTeam(Map<String, Team> teamNameToTeam) {
        PrimarySingleFields.teamNameToTeam = teamNameToTeam;
    }
}
