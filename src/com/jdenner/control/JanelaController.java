package com.jdenner.control;

import com.jdenner.model.Contato;
import com.jdenner.model.ContatoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Juliano
 */
public class JanelaController implements Initializable {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TableView<Contato> tbContatos;

    @FXML
    private TableColumn<Contato, String> colNome;

    @FXML
    private TableColumn<Contato, String> colTelefone;

    @FXML
    private void onBtnAdicionarAction(ActionEvent ae) {

        try {
            Contato contato = new Contato();
            contato.setNome(tfNome.getText());
            contato.setTelefone(tfTelefone.getText());
            ContatoDAO.inserir(contato);
            atualizaTabela();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro ao salvar!");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao salvar!");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        atualizaTabela();
    }

    private void atualizaTabela() {

        try {
            tbContatos.setItems(ContatoDAO.listar());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao consultar!");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
