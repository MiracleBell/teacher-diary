package sample.control.dialog.task;

import control.FloatField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.model.Student;
import sample.model.Task;
import sample.util.PrimaryFields;

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

        if (PrimaryFields.getCurrentStudent() == null) {
            //добавляется задача на всю группу
            PrimaryFields.getCurrentTeam().getTasks().add(task);
            for (Student item : PrimaryFields.getCurrentTeam().getStudents()) {
                item.getRatings().add(new Rating(task));
            }
        } else {
            //добавляется задача только конкретному студенту
            PrimaryFields.getCurrentStudent().getRatings().add(new Rating(task));
        }

        pressCancel();
    }

    @FXML
    public void pressCancel() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
