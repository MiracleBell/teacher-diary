package sample.control.dialog.team;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Team;

public class AddTeamController {
    @FXML
    private TextField teamName;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;

    @FXML
    public void pressAccept() {
        Team team = new Team(teamName.getText());
        Main.getTeams().add(team);
//        Main.getTeamNameToTeam().put(team.getTeamName(), team);
        pressCancel();
    }

    @FXML
    public void pressCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}