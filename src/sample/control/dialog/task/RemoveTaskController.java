package sample.control.dialog.task;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Task;

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
        if (Main.getCurrentStudent() == null) {
            for (Task item : Main.getCurrentTeam().getTasks()) {
                if (item.getTaskName().equals(taskNameField)) {
                    Main.getCurrentTeam().removeTask(item);
                    break;
                }
            }
        } else {
            for (Task item : Main.getCurrentStudent().getTasks()) {
                if (item.getTaskName().equals(taskNameField)) {
                    Main.getCurrentStudent().getTasks().remove(item);
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
