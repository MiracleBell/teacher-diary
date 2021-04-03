package sample.control.mainframe;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.model.Team;
import sample.util.PrimaryFields;

import java.io.IOException;

public class Controller {
    @FXML
    private TableView<Team> tableView;
    @FXML
    private TableColumn<Team, String> teamNameColumn;


    @FXML
    public void initMainTable(ObservableList<Team> teamList) {
        tableView.setItems(teamList);
        teamNameColumn = new TableColumn<>();

        teamNameColumn.setText("Название группы");
        tableView.getColumns().add(teamNameColumn);
        teamNameColumn.setCellValueFactory(cell -> cell.getValue().teamNameProperty());
    }


    @FXML
    public void addTeam() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/dialog/team/dialogAddTeam.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Добавление группы");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(PrimaryFields.getMainStage());
        stage.showAndWait();
    }

    @FXML
    public void removeTeam() throws IOException {
        Stage stage = new Stage();
        if (PrimaryFields.getTeams().isEmpty()) {
            Parent root = FXMLLoader.load(getClass().getResource("../view/dialog/error/emptyTeamList.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Ошибка!");
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("../view/dialog/team/dialogRemoveTeam.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Удаление группы");
        }

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(PrimaryFields.getMainStage());
        stage.showAndWait();
    }


    @FXML
    public void editTeamInfo() throws IOException {
        Team selectedItem = tableView.getSelectionModel().getSelectedItem();

        //если тыкнули на пустое мето в таблице, то ничего не происходит
        if (selectedItem == null) {
            return;
        }
        PrimaryFields.setCurrentTeam(selectedItem);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/mainframe/teamInfo.fxml"));
        Parent root = loader.load();

        PrimaryFields.getMainStage().setTitle("Группа: " + selectedItem.getTeamName());
        PrimaryFields.getMainStage().setScene(new Scene(root));
        TeamInfoController controller = loader.getController();
        controller.init(selectedItem);
    }
}
