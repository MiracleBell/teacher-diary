package sample.control.dialog.student;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.model.Student;
import sample.model.Task;
import sample.util.PrimaryFields;

import java.io.IOException;

public class AddStudentController {
    @FXML
    private TextField fullName;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;


    @FXML
    public void pressAccept() throws IOException {
        if (fullName.getText().trim().isEmpty()) {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../../../view/dialog/error/emptyStudentName.fxml"));

            stage.setScene(new Scene(root));
            stage.setTitle("Ошибка!");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(PrimaryFields.getMainStage());
            stage.showAndWait();
        } else {

            //создаем нового студента и даем ему все задачи, которые на данный момент выданы группе
            Student student = new Student(fullName.getText().trim());
            for (Task item : PrimaryFields.getCurrentTeam().getTasks()) {
                student.getRatings().add(new Rating(item));
            }
            //добавляем студента в группу
            PrimaryFields.getCurrentTeam().addStudent(student);

            pressCancel();
        }
    }

    @FXML
    public void pressCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
