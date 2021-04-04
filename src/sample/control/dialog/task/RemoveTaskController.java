package sample.control.dialog.task;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.model.Task;
import sample.util.PrimaryFields;

import java.io.IOException;

public class RemoveTaskController {
    @FXML
    private TextField taskNameField;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;


    @FXML
    public void pressAccept() throws IOException {
        if (PrimaryFields.getCurrentStudent() == null) {
            //удаяем у всей группы студентов
            for (Task item : PrimaryFields.getCurrentTeam().getTasks()) {
                if (item.getTaskName().equals(taskNameField.getText())) {
                    PrimaryFields.getCurrentTeam().removeTask(item);
                    break;
                }
            }
        } else {
            for (Rating item : PrimaryFields.getCurrentStudent().getRatings()) {
                if (item.getTask().getTaskName().equals(taskNameField.getText())) {
                    PrimaryFields.getCurrentStudent().getRatings().remove(item);
                    break;
                }
            }
        }
        pressCancel();
    }

    @FXML
    public void pressCancel() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
