package sample.control.dialog.student;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Student;

import java.io.IOException;

public class RemoveStudentController {
    @FXML
    private TextField fullNameField;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void pressAccept() throws IOException {
        for (Student item : Main.getCurrentTeam().getStudents()) {
            if (item.getFullName().equals(fullNameField)) {
                Main.getCurrentTeam().getStudents().remove(item);
                break;
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
