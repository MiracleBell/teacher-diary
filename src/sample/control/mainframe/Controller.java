package sample.control.mainframe;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.Team;
import sample.util.DialogService;
import sample.util.PrimaryFields;

import java.io.IOException;

public class Controller {
    @FXML
    private TableView<Team> tableView;
    @FXML
    private TableColumn<Team, String> teamNameColumn;
    private DialogService dialogService;


    @FXML
    public void initMainTable(ObservableList<Team> teamList) {
        dialogService = new DialogService();
        tableView.setItems(teamList);
        teamNameColumn = new TableColumn<>();

        teamNameColumn.setText("Название группы");
        tableView.getColumns().add(teamNameColumn);
        teamNameColumn.setCellValueFactory(cell -> cell.getValue().teamNameProperty());
    }


    @FXML
    public void addTeam() throws IOException {
        dialogService.callWindow("../view/dialog/team/dialogAddTeam.fxml", "Добавление группы");
    }

    @FXML
    public void removeTeam() throws IOException {
        if (PrimaryFields.getTeams().isEmpty()) {
            dialogService.callWindow("../view/dialog/error/emptyTeamList.fxml", "Ошибка!");
        } else {
            dialogService.callWindow("../view/dialog/team/dialogRemoveTeam.fxml", "Удаление группы");
        }
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
        loader.setLocation(getClass().getResource("../../view/mainframe/teamInfo.fxml"));
        Parent root = loader.load();

        PrimaryFields.getMainStage().setTitle("Группа: " + selectedItem.getTeamName());
        PrimaryFields.getMainStage().setScene(new Scene(root));
        TeamInfoController controller = loader.getController();
        controller.init(selectedItem);
    }
}
