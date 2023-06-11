 package entertamaintticketbookingmanagementsystem;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.compile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLDocumentController {

    @FXML
    private Hyperlink sign_up_account;

    @FXML
    private Button sign_up_btn;

    @FXML
    private Button sign_up_close;

    @FXML
    private TextField siginup_emailaddress;

    @FXML
    private Button sign_up_min;

    @FXML
    private PasswordField siginup_pass;

    @FXML
    private TextField siginup_username;

    @FXML
    private Button sign_in_close;

    @FXML
    private Hyperlink sign_in_forget;

    @FXML
    private Button sign_in_login;

    @FXML
    private Button sign_in_min;
    @FXML
    private Hyperlink siginup_dohave;
    @FXML
    private Hyperlink sign_in_createAccount;
    @FXML
    private PasswordField sign_in_password;
    @FXML
    private AnchorPane sign_in_Form;
    @FXML
    private AnchorPane sign_up_;
    @FXML
    private TextField sign_in_username;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public boolean vaildEmail() {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher match = pattern.matcher(siginup_username.getText());
        Alert alert;
        if (match.find() && match.group().matches(siginup_emailaddress.getText())) {
            return true;
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invaild email");
            alert.showAndWait();
            return false;
        }
    }

    public void signUp() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        String sql = "INSERT INTO admin (email,username,password)VALUES(?,?,?)";
        String sqll = "SELECT username FROM admin";
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        prepare.setString(1, siginup_emailaddress.getText());
        prepare.setString(2, siginup_username.getText());
        prepare.setString(3, siginup_pass.getText());
        Alert alert;
        if (siginup_emailaddress.getText().isEmpty() || siginup_username.getText().isEmpty() || siginup_pass.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank filds");
            alert.showAndWait();
        } else if (siginup_pass.getText().length() < 8) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invaild Password");
            alert.showAndWait();
        } else {

            prepare.execute();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Create an Account!");
            alert.showAndWait();
            siginup_emailaddress.setText("");
            siginup_username.setText("");
            siginup_pass.setText("");

        }

    }
    private double x = 0;
    private double y = 0;
    public void signIn() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        String sql = "SELECT * FROM admin WHERE username=? and password=?";
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        prepare.setString(1, sign_in_username.getText());
        prepare.setString(2, sign_in_password.getText());
        Alert alert;
        result = prepare.executeQuery();
        if (sign_in_username.getText().isEmpty() || sign_in_password.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("pls fill all blank fields");
            alert.showAndWait();

        } else {
            if (result.next()) {
                getData.username = sign_in_username.getText();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Login!");
                alert.showAndWait();
                sign_in_login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Dashbort.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                root.setOnMousePressed((MouseEvent event)->{
                x = event.getSceneX();
                y = event.getSceneY();
            });
                
                root.setOnMouseDragged((MouseEvent event)->{
                stage.setX(event.getScreenX()-x);
                stage.setY(event.getScreenY()-y);
            });
                
                stage.initStyle(StageStyle.TRANSPARENT);
                
                stage.setScene(scene);
                stage.show();

            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("wrong Username/Password");
                alert.showAndWait();
            }
        }
    }

    public void switshForm(ActionEvent event) {
        if (event.getSource() == sign_in_createAccount) {
            sign_in_Form.setVisible(false);
            sign_up_.setVisible(true);
        } else if (event.getSource() == siginup_dohave) {
            sign_in_Form.setVisible(true);
            sign_up_.setVisible(false);
        }
    }

    public void signIn_close() {
        System.exit(0);
    }

    public void signIn_minmaz() {
        Stage stage = (Stage) sign_in_Form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void signUp_close() {
        System.exit(0);
    }

    public void signUp_minmaz() {
        Stage stage = (Stage) sign_up_.getScene().getWindow();
        stage.setIconified(true);
    }

}
