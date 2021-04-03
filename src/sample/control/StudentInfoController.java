package sample.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.control.dialog.AddRatingController;
import sample.model.Rating;
import sample.model.Student;
import sample.model.Task;

import java.io.IOException;
import java.util.Collections;

public class StudentInfoController {
    @FXML
    private TableView<Task> ratingTable;
    @FXML
    private TableColumn<Task, String> taskNameColumn;
    @FXML
    private TableColumn<Task, Number> taskProgressColumn;
    @FXML
    private TableColumn<Task, String> taskDescriptionColumn;
    @FXML
    private Button addTaskButton;
    @FXML
    private Button addRatingButton;


    @FXML
    public void init(Student student) {
        ratingTable.setItems(student.getTasks());

        taskNameColumn = new TableColumn<>();
        taskNameColumn.setText("Название/номер задачи");
        ratingTable.getColumns().add(taskNameColumn);
        taskNameColumn.setCellValueFactory(cell -> cell.getValue().taskNameProperty());
        taskNameColumn.setMinWidth(150);

        taskProgressColumn = new TableColumn<>();
        taskProgressColumn.setText("Прогресс, %");
        ratingTable.getColumns().add(taskProgressColumn);
        taskProgressColumn.setCellValueFactory(cell -> cell.getValue().progressProperty());
        taskProgressColumn.setMinWidth(70);

        taskDescriptionColumn = new TableColumn<>();
        taskDescriptionColumn.setText("Описание задания");
        ratingTable.getColumns().add(taskDescriptionColumn);
        taskDescriptionColumn.setCellValueFactory(cell -> cell.getValue().taskDescriptionProperty());
        taskDescriptionColumn.setMinWidth(360);
    }

    @FXML
    public void addTask() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/dialog/task/dialogAddTask.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Добавление задачи");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void addRating() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/dialogAddRating.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Добавление оценки");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }


    @FXML
    public void editRating() throws IOException {
        Task selectedTask = ratingTable.getSelectionModel().getSelectedItem();

        //если тыкнули на путое место в таблице, то ничего не происходит
        if (selectedTask == null) {
            return;
        }
        Main.setCurrentTask(selectedTask);

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/ratingInfo.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Добавление задачи");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.getMainStage());
        stage.showAndWait();
    }


    @FXML
    public void goBackToTeamInfo() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/teamInfo.fxml"));
        Parent root = loader.load();

        Main.getMainStage().setTitle("Группа: " + Main.getCurrentTeam().getTeamName());
        Main.getMainStage().setScene(new Scene(root));
        TeamInfoController controller = loader.getController();
        controller.init(Main.getCurrentTeam());
        Main.setCurrentStudent(null);
    }
}
