package sample.control.dialog.team;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Team;

public class RemoveTeamController {
    @FXML
    private TextField teamName;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void pressAccept() {
        for (Team item : Main.getTeams()) {
            if (item.getTeamName().equals(teamName.getText())) {
                Main.getTeams().remove(item);
                break;
            }
        }
        pressCancel();
    }

    @FXML
    public void pressCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
