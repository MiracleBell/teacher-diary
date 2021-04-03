package sample.control;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Team;

import java.io.IOException;

public class Controller {
    @FXML
    private TableView<Team> tableView;
    @FXML
    private TableColumn<Team, String> teamNameColumn;


    @FXML
    public void initMainTable(ObservableList<Team> teamList) {
        tableView.setItems(teamList);
        teamNameColumn = new TableColumn<>();

        teamNameColumn.setText("Название группы");
        tableView.getColumns().add(teamNameColumn);
        teamNameColumn.setCellValueFactory(cell -> cell.getValue().teamNameProperty());
    }


    @FXML
    public void addTeam() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/dialog/team/dialogAddTeam.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Добавление группы");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void removeTeam() throws IOException {
        Stage stage = new Stage();
        if (Main.getTeams().isEmpty()) {
            Parent root = FXMLLoader.load(getClass().getResource("../view/dialog/error/emptyTeamList.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Ошибка!");
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("../view/dialog/team/dialogRemoveTeam.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Удаление группы");
        }

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }


    @FXML
    public void editTeamInfo() throws IOException {
        Team selectedItem = tableView.getSelectionModel().getSelectedItem();

        //если тыкнули на пустое мето в таблице, то ничего не происходит
        if (selectedItem == null) {
            return;
        }
        Main.setCurrentTeam(selectedItem);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/teamInfo.fxml"));
        Parent root = loader.load();

        Main.getMainStage().setTitle("Группа: " + selectedItem.getTeamName());
        Main.getMainStage().setScene(new Scene(root));
        TeamInfoController controller = loader.getController();
        controller.init(selectedItem);
    }


    /*
    @FXML
    public void addStudent() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogAddStudent.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Добавление студента");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void removeStudent() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogRemoveStudent.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Удаление студента");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void addTask() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogAddTask.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Добавление задачи");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void removeTask() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogRemoveTask.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Удаление задачи");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void addRating() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogAddRating.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Добавить оценку");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void removeRating() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogAddStudent.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Удаление оценки");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void addTeam() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogAddTeam.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Добавление группы");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void removeTeam() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("view/dialogAddTeam.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Удаление группы");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }*/
}
