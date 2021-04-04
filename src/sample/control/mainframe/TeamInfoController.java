package sample.control.mainframe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.Student;
import sample.model.Team;
import sample.util.DialogService;
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
    private DialogService dialogService;


    @FXML
    public void init(Team team) {
        dialogService = new DialogService();
        teamTable.setItems(team.getStudents());

        studentNameColumn = new TableColumn<>();
        studentNameColumn.setText("ФИО студента");
        teamTable.getColumns().add(studentNameColumn);
        studentNameColumn.setMinWidth(200);
        studentNameColumn.setCellValueFactory(cell -> cell.getValue().fullNameProperty());

        totalResultColumn = new TableColumn<>();
        totalResultColumn.setText("Общий прогресс");
        teamTable.getColumns().add(totalResultColumn);
        totalResultColumn.setMinWidth(120);
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
        dialogService.callWindow("../view/dialog/task/dialogAddTask.fxml", "Добавление задачи");
    }

    @FXML
    private void removeTask() throws IOException {
        if (PrimaryFields.getCurrentTeam().getTasks().isEmpty()) {
            dialogService.callWindow("../view/dialog/error/emptyTaskList.fxml", "Ошибка!");
        } else {
            dialogService.callWindow("../view/dialog/task/dialogRemoveTask.fxml", "Удаление задачи");
        }
    }

    @FXML
    public void addStudent() throws IOException {
        dialogService.callWindow("../view/dialog/student/dialogAddStudent.fxml", "Добавление студента");
    }

    @FXML
    public void removeStudent() throws IOException {
        //проверяем, есть ли вообще группы
        if (PrimaryFields.getCurrentTeam().getStudents().isEmpty()) {
            //если нет - выводим окно с ошибкой
            dialogService.callWindow("../view/dialog/error/emptyStudentList.fxml", "Ошибка!");
        } else {
            dialogService.callWindow("../view/dialog/student/dialogRemoveStudent.fxml", "Удаление студента");
        }
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
