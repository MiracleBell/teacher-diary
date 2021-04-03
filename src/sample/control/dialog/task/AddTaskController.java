package sample.control.dialog.task;

import control.FloatField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Student;
import sample.model.Task;

import java.io.IOException;

public class AddTaskController {
    @FXML
    private TextField taskText;
    @FXML
    private TextField taskDescription;
    @FXML
    private FloatField taskCoefficient;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void pressAccept() throws IOException {
        Task task = new Task(
                taskText.getText(),
                taskDescription.getText(),
                Float.parseFloat(taskCoefficient.getText())
        );

        if (Main.getCurrentStudent() == null) {
            //добавляется задача на всю группу
            Main.getCurrentTeam().getTasks().add(task);
            for (Student item : Main.getCurrentTeam().getStudents()) {
                item.getTasks().add(task);
            }
        } else {
            Main.getCurrentStudent().getTasks().add(task);
        }

        pressCancel();
    }

    @FXML
    public void pressCancel() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
