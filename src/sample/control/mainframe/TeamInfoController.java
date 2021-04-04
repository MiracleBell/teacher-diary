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
import sample.model.Student;
import sample.model.Team;
import sample.util.PrimaryFields;

import java.io.IOException;

public class TeamInfoController {
    @FXML
    private TableView<Student> teamTable;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, Number> totalResultColumn;
    @FXML
    private Button addStudentButton;
    @FXML
    private Button addTaskButton;
    @FXML
    private Button removeStudentButton;
    @FXML
    private Button removeTaskButton;
    @FXML
    private Button backToMainMenu;


    @FXML
    public void init(Team team) {
        teamTable.setItems(team.getStudents());

        studentNameColumn = new TableColumn<>();
        studentNameColumn.setText("ФИО студента");
        teamTable.getColumns().add(studentNameColumn);
        studentNameColumn.setCellValueFactory(cell -> cell.getValue().fullNameProperty());

        totalResultColumn = new TableColumn<>();
        totalResultColumn.setText("Общий прогресс");
        teamTable.getColumns().add(totalResultColumn);
        totalResultColumn.setCellValueFactory(cell -> cell.getValue().totalProgressProperty());
    }


    //редактируем данные конкретного студента
    @FXML
    public void editStudentInfo() throws IOException {
        Student selectedStudent = teamTable.getSelectionModel().getSelectedItem();

        //если тыкнули на пустое мето в таблице, то ничего не происходит
        if (selectedStudent == null) {
            return;
        }
        //начинаем отслеживать выбранного студента
        PrimaryFields.setCurrentStudent(selectedStudent);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../view/mainframe/studentInfo.fxml"));
        Parent root = loader.load();

        PrimaryFields.getMainStage().setTitle("Студент: " + selectedStudent.getFullName());
        PrimaryFields.getMainStage().setScene(new Scene(root));
        StudentInfoController controller = loader.getController();
        controller.init(selectedStudent);
    }

    @FXML
    public void addTask() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../view/dialog/task/dialogAddTask.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Добавление задачи");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(PrimaryFields.getMainStage());
        stage.showAndWait();
    }

    @FXML
    private void removeTask() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../view/dialog/task/dialogRemoveTask.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Удаление задачи");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(PrimaryFields.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void addStudent() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../../view/dialog/student/dialogAddStudent.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Добавление студента");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(PrimaryFields.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void removeStudent() throws IOException {
        Stage stage = new Stage();
        Parent root;
        //проверяем, есть ли вообще группы
        if (PrimaryFields.getCurrentTeam().getStudents().isEmpty()) {
            //если нет - выводим окно с ошибкой
            root = FXMLLoader.load(getClass().getResource("../../view/dialog/error/emptyStudentList.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("../../view/dialog/student/dialogRemoveStudent.fxml"));
        }

        stage.setScene(new Scene(root));
        stage.setTitle("Удаление студента");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(PrimaryFields.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void goBackToTeamList() throws IOException {
        //Возвращаемся к предыдущему окну (кнопка "к списку групп")
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../view/mainframe/teamList.fxml"));
        Parent root = loader.load();

        PrimaryFields.getMainStage().setTitle("Журнал преподавателя 1.0: Список групп");
        PrimaryFields.getMainStage().setScene(new Scene(root));
        Controller controller = loader.getController();
        controller.initMainTable(PrimaryFields.getTeams());

        //перестаем отслеживать группу
        PrimaryFields.setCurrentTeam(null);
    }
}
