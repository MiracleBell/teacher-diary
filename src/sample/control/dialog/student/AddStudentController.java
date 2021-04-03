package sample.control.dialog.student;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Student;

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
        student.getTasks().addAll(Main.getCurrentTeam().getTasks());

//        Main.getStudents().add(student);
        Main.getCurrentTeam().addStudent(student);
        pressCancel();
    }

    @FXML
    public void pressCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
