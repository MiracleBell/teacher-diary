package sample.control.mainframe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.model.Student;
import sample.util.DialogService;
import sample.util.PrimaryFields;

import java.io.IOException;


public class StudentInfoController {
    @FXML
    private TableView<Rating> ratingTable;
    @FXML
    private TableColumn<Rating, String> taskNameColumn;
    @FXML
    private TableColumn<Rating, Number> taskCoefficientColumn;
    @FXML
    private TableColumn<Rating, Number> taskProgressColumn;
    @FXML
    private TableColumn<Rating, String> taskDescriptionColumn;

    @FXML
    private Button addTaskButton;
    @FXML
    private Button addRatingButton;
    private DialogService dialogService;


    @FXML
    public void init(Student student) {
        dialogService = new DialogService();
        ratingTable.setItems(student.getRatings());

        taskNameColumn = new TableColumn<>();
        taskNameColumn.setText("Название/номер задачи");
        ratingTable.getColumns().add(taskNameColumn);
        taskNameColumn.setCellValueFactory(cell -> cell.getValue().getTask().taskNameProperty());
        taskNameColumn.setMinWidth(150);

        taskCoefficientColumn = new TableColumn<>();
        taskCoefficientColumn.setText("Коэффициент");
        ratingTable.getColumns().add(taskCoefficientColumn);
        taskCoefficientColumn.setCellValueFactory(cell -> cell.getValue().getTask().taskCoefficientProperty());

        taskProgressColumn = new TableColumn<>();
        taskProgressColumn.setText("Прогресс, %");
        ratingTable.getColumns().add(taskProgressColumn);
        taskProgressColumn.setCellValueFactory(cell -> cell.getValue().ratingProperty());
        taskProgressColumn.setMinWidth(70);

        taskDescriptionColumn = new TableColumn<>();
        taskDescriptionColumn.setText("Описание задания");
        ratingTable.getColumns().add(taskDescriptionColumn);
        taskDescriptionColumn.setCellValueFactory(cell -> cell.getValue().getTask().taskDescriptionProperty());
        taskDescriptionColumn.setMinWidth(300);
    }

    @FXML
    public void addTask() throws IOException {
        dialogService.callWindow("../view/dialog/task/dialogAddTask.fxml", "Добавление задачи");
    }

    @FXML
    public void removeRating() throws IOException {
        dialogService.callWindow("../view/dialog/task/dialogRemoveTask.fxml", "Удаление задачи");
    }


    @FXML
    public void editRating() throws IOException {
        Rating selectedTask = ratingTable.getSelectionModel().getSelectedItem();

        //если тыкнули на путое место в таблице, то ничего не происходит
        if (selectedTask == null) {
            return;
        }

        //Отслеживаем выбранное задание
        PrimaryFields.setCurrentRating(selectedTask);
        dialogService.callWindow("../view/mainframe/ratingInfo.fxml", "Добавление задачи");
    }


    @FXML
    public void goBackToTeamInfo() throws IOException {
        //Возвращаемся к предыдущему окну (кнопка "к списку групп")
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../view/mainframe/teamInfo.fxml"));
        Parent root = loader.load();

        PrimaryFields.getMainStage().setTitle("Группа: " + PrimaryFields.getCurrentTeam().getTeamName());
        PrimaryFields.getMainStage().setScene(new Scene(root));
        TeamInfoController controller = loader.getController();
        controller.init(PrimaryFields.getCurrentTeam());

        //перстаем отслеживать конкретного студента
        PrimaryFields.setCurrentStudent(null);
    }
}
