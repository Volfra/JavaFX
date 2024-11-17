package co.edu.poli.demo.controlador;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.demo.modelo.Estudiante;
import co.edu.poli.demo.servicios.OperacionImplementacion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;


public class FormularioControlador {

    @FXML
    private Button btt1;

    @FXML
    private Button btt2;

    @FXML
    private Button btt3;

    @FXML
    private Button btt4;

    @FXML
    private Button btt5;

    @FXML
    private DatePicker datePicker1;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb2;

    @FXML
    private ToggleGroup sexo;
    
    @FXML
    private ComboBox<String> cmb1;

    @FXML
    private CheckBox chkbox1;

    @FXML
    private CheckBox chkbox2;

    @FXML
    private CheckBox chkbox3;

    @FXML
    private Group GroupChkBox;

    @FXML
    private TableColumn<Estudiante, String> column1;

    @FXML
    private TableColumn<Estudiante, String> column2;

    @FXML
    private TableColumn<Estudiante, String> column3;

    @FXML
    private TableColumn<Estudiante, String> column4;

    @FXML
    private TableColumn<Estudiante, String> column5;

    @FXML
    private TableColumn<Estudiante, String> column6;

    @FXML
    private TableView<Estudiante> tblView;

    ObservableList<Estudiante> est;

    OperacionImplementacion op;

    @FXML
    public void initialize() {
        est = FXCollections.observableArrayList();
    
        op = new OperacionImplementacion();

        ObservableList<String> list = FXCollections.observableArrayList
                                    ("Ingeniería de Sistemas","Ingeniería de Software","Ingeniería de Telecomunicaciones");
        cmb1.setItems(list);  
    }    
    
    @FXML
    void press1(ActionEvent event) {

        try { 

            RadioButton rbaux = (RadioButton) sexo.getSelectedToggle();
            
            List<String> listSkill = new ArrayList<String>();

            for (Node cb: GroupChkBox.getChildren()){
                CheckBox cbx = (CheckBox) cb;
                if (cbx.isSelected())
                    listSkill.add(cbx.getText());
            }

            Estudiante e = new Estudiante(
                                    txt1.getText(), 
                                    txt2.getText(),
                                    rbaux.getText(), 
                                    datePicker1.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                    cmb1.getValue()!=null ? cmb1.getValue() : "N/A",
                                    listSkill 
                                    );

            op.create(e);
            est.add(e);

            loadTable();
    
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Mensaje");
            a.setContentText(e.getMessage());
            a.show();

        }
        
    }

    @FXML
    void press2(ActionEvent event) {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(op.serializar(op.readall(), "", "binaryfile.bin"));
        a.show();

    }

    @FXML
    void press3(ActionEvent event) {

        op.setEstudiantes(op.deserializar("", "binaryfile.bin"));
        est.clear();
        
        for (Estudiante estudiante : op.readall()) {
            if (estudiante!=null)
                est.add(estudiante);
        }

        loadTable();

    }

    @FXML
    void press4(ActionEvent event) {
    
        try{
            Estudiante olde = tblView.getSelectionModel().getSelectedItem();

            RadioButton rbaux = (RadioButton) sexo.getSelectedToggle();

            List<String> listSkill = new ArrayList<String>();

            for (Node cb: GroupChkBox.getChildren()){
                CheckBox cbx = (CheckBox) cb;
                if (cbx.isSelected())
                    listSkill.add(cbx.getText());
            }

            Estudiante e = new Estudiante(
                                    olde.getCodigo(), 
                                    txt2.getText(),
                                    rbaux.getText(), 
                                    datePicker1.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                    cmb1.getValue()!=null ? cmb1.getValue() : "N/A",
                                    listSkill 
                                    );

            op.update(olde.getCodigo(), e);
            est.set(est.indexOf(olde), e);

            loadTable();

        } catch (Exception e) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("Seleccionar un registro");
            a.show();
        }

    }

    @FXML
    void press5(ActionEvent event) {
        try {
            Estudiante e = tblView.getSelectionModel().getSelectedItem();
            op.delete(e.getCodigo());
            est.remove(e);
            loadTable();   

        } catch (Exception e) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("Seleccionar un registro");
            a.show();
        }

    }

    void loadTable() {

        column1.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getCodigo()));
        column2.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getNombres()));
        column3.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getSexo()));
        column4.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getFecNac()));
        column5.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getPrograma()));
        column6.setCellValueFactory(cell->
            new SimpleStringProperty(cell.getValue().getHabilidades().toString()!=null ? 
                cell.getValue().getHabilidades().toString(): "-"));

        tblView.setItems(est);

    }

    @FXML
    void displaySelected(MouseEvent event) {

        try {

            Estudiante person = tblView.getSelectionModel().getSelectedItem();

            txt1.setText(person.getCodigo());
            txt2.setText(person.getNombres());
            sexo.selectToggle(person.getSexo().equals("Hombre") ? rb1 : rb2);
            datePicker1.setValue(datePicker1.getConverter().fromString(person.getFecNac()));
            cmb1.setValue(person.getPrograma());

            for (Node cb: GroupChkBox.getChildren()){
                CheckBox cbx = (CheckBox) cb;
                cbx.setSelected(false);
            }

            for (String habilidad : person.getHabilidades()) {
                for (Node cb: GroupChkBox.getChildren()){
                    CheckBox cbx = (CheckBox) cb;
                    if (cbx.getText().equals(habilidad)) 
                        cbx.setSelected(true);
                }
            }

        } catch (Exception e) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("Seleccionar un registro");
            a.show();
        }

    }


}
