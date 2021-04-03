package sample.control.dialog.student;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.model.Student;
import sample.model.Task;
import sample.util.PrimaryFields;

public class AddStudentController {
    @FXML
    private TextField fullName;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;


    @FXML
    public void pressAccept() {
        //создаем нового студента и даем ему все задачи, которые на данный момент выданы группе
        Student student = new Student(fullName.getText());
        for (Task item : PrimaryFields.getCurrentTeam().getTasks()) {
            student.getRatings().add(new Rating(item));
        }
        //добавляем студента в группу
        PrimaryFields.getCurrentTeam().addStudent(student);

        pressCancel();
    }

    @FXML
    public void pressCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
