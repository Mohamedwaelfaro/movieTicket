package entertamaintticketbookingmanagementsystem;

import com.mysql.jdbc.PreparedStatement;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
//import static java.time.temporal.TemporalQueries.localTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController implements Initializable {

    @FXML
    private AnchorPane AddMovie_form;

    @FXML
    private AnchorPane TopForm;

    @FXML
    private Button addmovie_btn;

    @FXML
    private Button addmovie_clearbtn;
    @FXML
    private TableView<movieDatabase> addmovie_tableview;

    @FXML
    private TableColumn<movieDatabase, String> addmovie_col_movieTitle;

    @FXML
    private TableColumn<movieDatabase, String> addmovie_col_genre;

    @FXML
    private TableColumn<movieDatabase, String> addmovie_col_duration;

    @FXML
    private TableColumn<movieDatabase, String> addmovie_col_PublishedDate;
    @FXML
    private TableColumn<movieDatabase, String> addmovie_col_Image;
    @FXML
    private DatePicker addmovie_date;

    @FXML
    private Button addmovie_deletebtn;

    @FXML
    private TextField addmovie_duration;

    @FXML
    private TextField addmovie_genre;

    @FXML
    private ImageView addmovie_imageview;

    @FXML
    private Button addmovie_import;

    @FXML
    private Button addmovie_insertbtn;

    @FXML
    private TextField addmovie_moveTitle;

    @FXML
    private TextField addmovie_search;

    @FXML
    private Button addmovie_updatebtn;

    @FXML
    private AnchorPane availableMovie_Form1;

    @FXML
    private AnchorPane availableMovie_Form2;

    @FXML
    private Button availableMovie_Selectmovie;

    @FXML
    private Button availableMovie_buybtn;

    @FXML
    private Button availableMovie_clearbtn;

    @FXML
    private TableColumn<movieDatabase, String> availableMovie_col_genre;

    @FXML
    private TableColumn<movieDatabase, String> availableMovie_col_movieTitle;

    @FXML
    private TableColumn<movieDatabase, String> availableMovie_col_showingdata;

    @FXML
    private TextField availableMovie_date;

    @FXML
    private TextField availableMovie_genre;

    @FXML
    private ImageView availableMovie_imageView;

    @FXML
    private Label availableMovie_movieTitle;

    @FXML
    private TextField availableMovie_movietitle;

    @FXML
    private Label availableMovie_normalclass_price;

    @FXML
    private Spinner<Integer> availableMovie_normalclass_quantaty;

    @FXML
    private Button availableMovie_receiptbtn;

    @FXML
    private Label availableMovie_spichalclass_price;

    @FXML
    private Spinner<Integer> availableMovie_spichalclass_quantaty;

    @FXML
    private TableView<movieDatabase> availableMovie_tableView;

    @FXML
    private Label availableMovie_total;

    @FXML
    private Button availablemovie_btn;

    @FXML
    private Button clos_TopForm;

    @FXML
    private Button customer_clear;

    @FXML
    private TableView<customerData> customer_tableView;
    @FXML
    private TableColumn<customerData, String> customer_col_Ticketnumber;

    @FXML
    private TableColumn<customerData, String> customer_col_dateChecked;

    @FXML
    private TableColumn<customerData, String> customer_col_genre;

    @FXML
    private TableColumn<customerData, String> customer_col_movieTitle;

    @FXML
    private TableColumn<customerData, String> customer_col_timeChecked;

    @FXML
    private Label customer_date;

    @FXML
    private Button customer_delete;

    @FXML
    private AnchorPane customer_form;

    @FXML
    private Label customer_genre;

    @FXML
    private Label customer_movieTitle;

    @FXML
    private Label customer_numberTicket;

    @FXML
    private TextField customer_search;

    @FXML
    private Label customer_time;

    @FXML
    private Button customers_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Label dashbport_AvailableMovie;

    @FXML
    private AnchorPane dashbport_Form;

    @FXML
    private Label dashbport_TotalEarnToday;

    @FXML
    private Label dashbport_TotalSoldToday;

    @FXML
    private Button editScreening_btn;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private Label editscreening_Titile;

    @FXML
    private TableColumn<movieDatabase, String> editscreening_col_current;

    @FXML
    private TableColumn<movieDatabase, String> editscreening_col_duration;

    @FXML
    private TableColumn<movieDatabase, String> editscreening_col_genre;

    @FXML
    private TableColumn<movieDatabase, String> editscreening_col_movieTitle;

    @FXML
    private ComboBox<?> editscreening_current;

    @FXML
    private Button editscreening_delete;

    @FXML
    private ImageView editscreening_imageView;

    @FXML
    private TextField editscreening_search;

    @FXML
    private Button editscreening_update;

    @FXML
    private Button minmaze_TopForm;

    @FXML
    private Button sginOut_btn;

    @FXML
    private Label username;
    @FXML
    private AnchorPane availablemovie_anchor;
    @FXML
    private TableView<movieDatabase> editscreening_TableView;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void minimaz(ActionEvent event) {
        Stage stage = (Stage) minmaze_TopForm.getScene().getWindow();
        stage.setIconified(true);
    }
    private Image image;
    private double x = 0;
    private double y = 0;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private String[] currentList = {"Showing", "End Showing"};
    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;
    private float price1 = 0;
    private float price2 = 0;
    private float total = 0;
    private int qty1 = 0;
    private int qty2 = 0;
    private int qty = 0;
    private int num = 0;
    
    private int totalMovies;

    public void totalAvailableMovies() throws ClassNotFoundException, SQLException {
        String sql = "select count(id) from movie where current = 'showing'";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        result = prepare.executeQuery();
        if (result.next()) {
            totalMovies = result.getInt("count(id)");
        }

    }

    public void displayTotalAvailableMovies() throws ClassNotFoundException, SQLException {
        totalAvailableMovies();
        dashbport_AvailableMovie.setText(String.valueOf(totalMovies));
    }

    private double totalIncome;

    public void totalIncomeToday() throws ClassNotFoundException, SQLException {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "select sum(total) from customer where date ='"
                + String.valueOf(sqlDate) + "'";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        result = prepare.executeQuery();
        if (result.next()) {
            totalIncome = result.getDouble("sum(total)");
        }
    }

    public void displayTotalIncomeToday() throws ClassNotFoundException, SQLException {
        totalIncomeToday();
        dashbport_TotalEarnToday.setText("$" + String.valueOf(totalIncome));
    }

    private int soldTicket;

    public void countTicket() throws SQLException, ClassNotFoundException {
        String sql = "select count(id) from customer";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        result = prepare.executeQuery();
        if (result.next()) {
            soldTicket = result.getInt("count(id)");
        }

    }

    public void displayTotalSoldTicket() throws SQLException, ClassNotFoundException {
        countTicket();
        dashbport_TotalSoldToday.setText(String.valueOf(soldTicket));
    }

    public void searchCustomer() {
        FilteredList<customerData> filter = new FilteredList<>(custList, e -> true);
        customer_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateCustomer -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if (predicateCustomer.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getTitle().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getDate().toString().contains(searchKey)) {
                    return true;
                } else {

                    return false;
                }
            });

        });
        SortedList<customerData> sort = new SortedList<>(filter);
        sort.comparatorProperty().bind(customer_tableView.comparatorProperty());
        customer_tableView.setItems(sort);

    }

    public ObservableList< customerData> customerlist() throws ClassNotFoundException, SQLException {

        ObservableList<customerData> customerL = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        customerData customerD;
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        result = prepare.executeQuery();
        while (result.next()) {
            customerD = new customerData(result.getInt("id"),
                    result.getString("type"),
                    result.getString("movieTitle"),
                    result.getInt("quantity"),
                    result.getDouble("total"),
                    result.getDate("date"),
                    result.getTime("time"));

            customerL.add(customerD);
        }

        return customerL;

    }
    private ObservableList<customerData> custList;

    public void showCustuomerList() throws ClassNotFoundException, SQLException {
        custList = customerlist();
        customer_col_Ticketnumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        customer_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        customer_col_dateChecked.setCellValueFactory(new PropertyValueFactory<>("date"));
        customer_col_timeChecked.setCellValueFactory(new PropertyValueFactory<>("time"));

        customer_tableView.setItems(custList);

    }

    public void selectCustomerList() {
        customerData custD = customer_tableView.getSelectionModel().getSelectedItem();
        int num = customer_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        customer_numberTicket.setText(String.valueOf(custD.getId()));
        customer_movieTitle.setText(custD.getTitle());
        customer_date.setText(String.valueOf(custD.getDate()));
        customer_time.setText(String.valueOf(custD.getTime()));

    }

    public void deleteCustomer() throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM customer where id = '" + customer_numberTicket.getText() + "'";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        Alert alert;
        statement = connect.createStatement();
        if (customer_numberTicket.getText().isEmpty()
                || customer_movieTitle.getText().isEmpty()
                || customer_date.getText().isEmpty()
                || customer_time.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the customer first");
            alert.showAndWait();
        } else {
            statement.executeUpdate(sql);
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delet "
                    + customer_movieTitle.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == ButtonType.OK) {
                statement.executeUpdate(sql);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("INFORMATION Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully removed!");
                alert.showAndWait();
                showCustuomerList();
                clearCustomer();

            }

        }

    }

    public void clearCustomer() {
        customer_numberTicket.setText("");
        customer_movieTitle.setText("");
        customer_date.setText("");
        customer_time.setText("");
    }

    public void buy() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO customer (type, movieTitle, quantity, total, date,time) VALUES (?,?, ?, ?, ?, ?)";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        String type = "";
        if (price1 > 0 && price2 == 0) {
            type = "Special Class";
        } else if (price2 > 0 && price1 == 0) {
            type = "Normal Class";
        } else if (price2 > 0 && price1 > 0) {
            type = "Special Class & Normal Class";
        }
        Date date = new Date();
        java.sql.Date setDate = new java.sql.Date(date.getTime());

        LocalTime localtime = LocalTime.now();
        Time time = Time.valueOf(localtime);

        qty = qty1 + qty2;

        PreparedStatement prepare = (PreparedStatement) connect.prepareStatement(sql);
        prepare.setString(1, type);
        prepare.setString(2, availableMovie_movieTitle.getText());
        prepare.setString(3, String.valueOf(qty));
        prepare.setString(4, String.valueOf(total));
        prepare.setString(5, String.valueOf(setDate));
        prepare.setString(6, String.valueOf(time));

        Alert alert;
        if (availableMovie_imageView.getImage() == null
                || availableMovie_movieTitle.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();
        } else if (price1 == 0 && price2 == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please indicate the quantity of tickets you want to purchase.");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully purchased!");
            alert.showAndWait();
            prepare.executeUpdate();

            String sql2 = "SELECT MAX(id) FROM customer";
            prepare = (PreparedStatement) connect.prepareStatement(sql2);
            ResultSet result = prepare.executeQuery();
            int customerId = 0;
            if (result.next()) {
                customerId = result.getInt(1);
            }

            String sql3 = "INSERT INTO customer_info (customer_id, movieTitle, quantity, type, total) VALUES (?, ?, ?, ?, ?)";
            prepare = (PreparedStatement) connect.prepareStatement(sql3);
            prepare.setInt(1, customerId);
            prepare.setString(2, availableMovie_movieTitle.getText());
            prepare.setString(3, String.valueOf(qty));
            prepare.setString(4, type);
            prepare.setString(5, String.valueOf(total));
            prepare.execute();
            clearPurchaseTicketInfo();
        }

    }

    public void clearPurchaseTicketInfo() {
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        availableMovie_spichalclass_quantaty.setValueFactory(spinner1);
        availableMovie_normalclass_quantaty.setValueFactory(spinner2);
        availableMovie_spichalclass_price.setText("$0.0");
        availableMovie_normalclass_price.setText("$0.0");
        availableMovie_total.setText("$0.0");
        availableMovie_imageView.setImage(null);
    }

    public void showSpinnerValue() {
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        availableMovie_spichalclass_quantaty.setValueFactory(spinner1);
        availableMovie_normalclass_quantaty.setValueFactory(spinner2);
    }

    public void getSpinnerValue(MouseEvent event) {
        qty1 = availableMovie_spichalclass_quantaty.getValue();
        qty2 = availableMovie_normalclass_quantaty.getValue();
        price1 = (qty1 * 25);
        price2 = (qty2 * 10);
        total = (price1 + price2);
        availableMovie_spichalclass_price.setText("$" + String.valueOf(price1));
        availableMovie_normalclass_price.setText("$" + String.valueOf(price2));
        availableMovie_total.setText(String.valueOf("$" + String.valueOf(total)));
    }

    public ObservableList<movieDatabase> availableMovieList() throws ClassNotFoundException, SQLException {
        String sql = "select * from movie where current = 'Showing' ";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        result = prepare.executeQuery();
        movieDatabase movD;
        while (result.next()) {
            movD = new movieDatabase(result.getInt("id"),
                    result.getString("movieTitle"),
                    result.getString("genre"),
                    result.getString("duration"),
                    result.getDate("date"),
                    result.getString("image"),
                    result.getString("current"));
        }
        return ListAddmovies;
    }

    private ObservableList<movieDatabase> availableMovieList;

    public void showAvilableMovies() throws ClassNotFoundException, SQLException {
        availableMovieList = availableMovieList();
        availableMovie_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableMovie_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableMovie_col_showingdata.setCellValueFactory(new PropertyValueFactory<>("date"));
        availableMovie_tableView.setItems(availableMovieList);

    }

    public void selectAvailableMovies() {
        movieDatabase movD = availableMovie_tableView.getSelectionModel().getSelectedItem();
        int num = availableMovie_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        availableMovie_movietitle.setText(movD.getTitle());
        availableMovie_genre.setText(movD.getGenre());
        availableMovie_date.setText(String.valueOf(movD.getDate()));
        getData.path = movD.getImage();
        getData.title = movD.getTitle();
    }

    public void selectMovie() {
        Alert alert;

        if (availableMovie_movieTitle.getText().isEmpty()
                || availableMovie_genre.getText().isEmpty()
                || availableMovie_date.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();
        } else {

            String uri = "file:" + getData.path;
            image = new Image(uri, 137, 185, false, true);
            availableMovie_imageView.setImage(image);
            availableMovie_movieTitle.setText(getData.title);

            availableMovie_movietitle.setText("");
            availableMovie_genre.setText("");
            availableMovie_date.setText("");
        }
    }

    public void comboBox() {
        List<String> listCurrent = new ArrayList<>();
        for (String data : currentList) {
            listCurrent.add(data);
        }
        ObservableList listC = FXCollections.observableArrayList(listCurrent);
        editscreening_current.setItems(listC);
    }

    public void updateEditeScreening() throws ClassNotFoundException, SQLException {
        String sql = "update movie set current = '"
                + editscreening_current.getSelectionModel().getSelectedItem()
                + "' where movieTitle = '" + editscreening_Titile.getText() + "'";
        Class.forName("com.mysql.jdbc.Driver");

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        statement = connect.createStatement();
        Alert alert;
        if (editscreening_Titile.getText().isEmpty()
                || editscreening_imageView.getImage() == null
                || editscreening_current.getSelectionModel().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();
        } else {
            statement.executeUpdate(sql);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Update!");
            alert.showAndWait();
            showEditScreening();
            clearEditeScreening();
        }

    }

    public void clearEditeScreening() {
        editscreening_Titile.setText("");
        editscreening_imageView.setImage(null);
//        editscreening_current.setSelectionModel();
    }

    public void searchEditeScreeing() {
        FilteredList<movieDatabase> filter = new FilteredList(editScreeningL, e -> true);
        editscreening_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(PredicateMoviesData -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchkey = newValue.toLowerCase();
                if (PredicateMoviesData.getTitle().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (PredicateMoviesData.getGenre().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (PredicateMoviesData.getDuration().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (PredicateMoviesData.getCurrent().toLowerCase().contains(searchkey)) {
                    return true;
                }
                return false;
            });

        });
        SortedList<movieDatabase> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(editscreening_TableView.comparatorProperty());
        editscreening_TableView.setItems(sortData);

    }

    public void selectEditeScreeing() {
        movieDatabase movD = editscreening_TableView.getSelectionModel().getSelectedItem();
        int num = editscreening_TableView.getSelectionModel().getFocusedIndex();
        if ((num - 1) < -1) {
            return;
        }

        String uri = "file:" + movD.getImage();
        image = new Image(uri, 147, 182, false, true);
        editscreening_imageView.setImage(image);
        editscreening_Titile.setText(movD.getTitle());
    }

    public ObservableList<movieDatabase> editScreeningList() throws ClassNotFoundException, SQLException {
        ObservableList<movieDatabase> editList = FXCollections.observableArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        String sql = "select * from movie ";
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        result = prepare.executeQuery();
        movieDatabase movd;
        while (result.next()) {
            movd = new movieDatabase(result.getInt("id"), result.getString("movieTitle"), result.getString("genre"),
                    result.getString("duration"),
                    result.getDate("date"),
                    result.getString("image"),
                    result.getString("current"));
            editList.add(movd);
        }
        return editList;
    }
    private ObservableList<movieDatabase> editScreeningL;

    public void showEditScreening() throws ClassNotFoundException, SQLException {
        editScreeningL = editScreeningList();
        editscreening_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        editscreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editscreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editscreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));
        editscreening_TableView.setItems(editScreeningL);
    }

    public void searchAddMovies() {

        FilteredList<movieDatabase> filter = new FilteredList<>(ListAddmovies, e -> true);
        addmovie_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateMoviesData -> {

                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }

                String keySearch = newValue.toLowerCase();

                if (predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toString().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDate().toString().contains(keySearch)) {
                    return true;
                }

                return false;
            });

        });
        SortedList<movieDatabase> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(addmovie_tableview.comparatorProperty());
        addmovie_tableview.setItems(sortData);
    }

    public void importImage() {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*png", "*jpg"));

        Stage stage = (Stage) AddMovie_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {
            image = new Image(file.toURI().toString(), 164, 167, false, true);
            addmovie_imageview.setImage(image);

            getData.path = file.getAbsolutePath();
        }
    }
    private int countId;

    public void movieId() throws ClassNotFoundException, SQLException {
        String sql = "select count(id) from movie";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        prepare = (PreparedStatement) connect.prepareStatement(sql);
        result = prepare.executeQuery();
        if (result.next()) {
            getData.movieId = result.getInt("count(id)");
        }

    }

    public void inseertAddMovies() throws ClassNotFoundException, SQLException {
        String sqll = "select * from movie  where movieTitle = '"
                + addmovie_moveTitle.getText() + "'";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        statement = connect.createStatement();
        Alert alert;

        prepare = (PreparedStatement) connect.prepareStatement(sqll);
        result = prepare.executeQuery();
        if (result.next()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(addmovie_moveTitle.getText() + " Was Already Exsist!");
            alert.showAndWait();
        } else {
            if (addmovie_moveTitle.getText().isEmpty()
                    || addmovie_genre.getText().isEmpty()
                    || addmovie_duration.getText().isEmpty()
                    || addmovie_date.getValue() == null
                    || addmovie_imageview.getImage() == null) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank filds");
                alert.showAndWait();
            } else {
                String sql = "INSERT INTO movie (id,movieTitle,genre,duration,date,image,current) VALUES (?,?,?,?,?,?,?)";
                String uri = getData.path;
                uri = uri.replace("\\", "\\\\");

                movieId();
                String mID = String.valueOf(getData.movieId + 1);

                prepare = (PreparedStatement) connect.prepareStatement(sql);
                prepare.setString(1, mID);
                prepare.setString(2, addmovie_moveTitle.getText());
                prepare.setString(3, addmovie_genre.getText());
                prepare.setString(4, addmovie_duration.getText());
                prepare.setString(5, String.valueOf(addmovie_date.getValue()));
                prepare.setString(6, uri);
                prepare.setString(7, "Showing");
                prepare.execute();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully add new movie!");
                alert.showAndWait();
                clearAddMoviesList();
                showAddMovieslist();

                statement = connect.createStatement();
                result = statement.executeQuery(sqll);
            }

        }
    }

    public void updateAddMovie() throws ClassNotFoundException, SQLException {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");
        String sql = "update movie set movieTitle = '" + addmovie_moveTitle.getText()
                + "', genre = '" + addmovie_genre.getText()
                + "', duration = '" + addmovie_duration.getText()
                + "', date = '" + addmovie_date.getValue()
                + "', image = '" + uri
                + "' where id= '" + String.valueOf(getData.movieId) + "'";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        statement = connect.createStatement();
        Alert alert;
        if (addmovie_moveTitle.getText().isEmpty()
                || addmovie_genre.getText().isEmpty()
                || addmovie_duration.getText().isEmpty()
                || addmovie_date.getValue() == null
                || addmovie_imageview.getImage() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();
        } else {
            statement.executeUpdate(sql);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully updated" + addmovie_moveTitle.getText());
            alert.showAndWait();
            showAddMovieslist();
            clearAddMoviesList();
        }
    }

    public void deleteAddMoviesList() throws ClassNotFoundException, SQLException {
        String sql = "delete from movie where movieTitle = '"
                + addmovie_moveTitle.getText() + "'";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        statement = connect.createStatement();
        Alert alert;

        if (addmovie_moveTitle.getText().isEmpty()
                || addmovie_genre.getText().isEmpty()
                || addmovie_duration.getText().isEmpty()
                || addmovie_date.getValue() == null
                || addmovie_imageview.getImage() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you wont to delete "
                    + addmovie_moveTitle.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            if (ButtonType.OK.equals(option.get())) {
                statement.executeUpdate(sql);
                showAddMovieslist();

                clearAddMoviesList();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully delete!");
                alert.showAndWait();
            } else {
                return;
            }
        }

    }

    public void clearAddMoviesList() {
        addmovie_moveTitle.setText("");
        addmovie_genre.setText("");
        addmovie_duration.setText("");
        addmovie_date.setValue(null);
        addmovie_imageview.setImage(null);

    }

    public ObservableList<movieDatabase> addMovieslist() throws ClassNotFoundException, SQLException {
        ObservableList<movieDatabase> ListData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/moviebook", "root", "");
        try {
            prepare = (PreparedStatement) connect.prepareStatement(sql);
            result = prepare.executeQuery();
            movieDatabase movDB;
            while (result.next()) {
                movDB = new movieDatabase(result.getInt("id"), result.getString("movieTitle"), result.getString("genre"),
                        result.getString("duration"), result.getDate("date"), result.getString("image"),
                        result.getString("current"));
                ListData.add(movDB);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData;

    }

    private ObservableList<movieDatabase> ListAddmovies;

    public void showAddMovieslist() throws ClassNotFoundException, SQLException {

        ListAddmovies = addMovieslist();

        addmovie_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addmovie_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addmovie_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addmovie_col_PublishedDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        addmovie_tableview.setItems(ListAddmovies);

    }

    public void selectAddMoviesList() {
        movieDatabase movd = addmovie_tableview.getSelectionModel().getSelectedItem();
        int num = addmovie_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        getData.path = movd.getImage();
        getData.movieId = movd.getId();
        addmovie_moveTitle.setText(movd.getTitle());
        addmovie_genre.setText(movd.getGenre());
        addmovie_duration.setText(movd.getDuration());
        addmovie_date.setValue(LocalDate.parse(String.valueOf(movd.getDate())));
        String uri = "file:" + movd.getImage();
        image = new Image(uri, 164, 167, false, true);
        addmovie_imageview.setImage(image);
        addmovie_date.setValue(movd.getDate().toLocalDate());
    }

    public void logout() throws IOException {
        sginOut_btn.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneX();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenX() - y);

        });
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

    }

    public void switchForm(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (event.getSource() == dashboard_btn) {
            dashbport_Form.setVisible(true);
            AddMovie_form.setVisible(false);
            availablemovie_anchor.setVisible(false);
            editScreening_form.setVisible(false);
            customer_form.setVisible(false);
            dashboard_btn.setStyle("-fx-background-color: #ae2d3c;");
            addmovie_btn.setStyle("-fx-background-color: transparent");
            availablemovie_anchor.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color:transparent");
            displayTotalSoldTicket();
            displayTotalIncomeToday();
            displayTotalAvailableMovies();
        } else if (event.getSource() == addmovie_btn) {
            dashbport_Form.setVisible(false);
            AddMovie_form.setVisible(true);
            availablemovie_anchor.setVisible(false);
            editScreening_form.setVisible(false);
            customer_form.setVisible(false);

            addmovie_btn.setStyle("-fx-background-color: #ae2d3c;");
            dashboard_btn.setStyle("-fx-background-color: transparent");
            availablemovie_anchor.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color:transparent");
            showAddMovieslist();
        } else if (event.getSource() == availablemovie_btn) {
            dashbport_Form.setVisible(false);
            AddMovie_form.setVisible(false);
            availablemovie_anchor.setVisible(true);
            editScreening_form.setVisible(false);
            customer_form.setVisible(false);

            availablemovie_anchor.setStyle("-fx-background-color: #ae2d3c;");
            dashboard_btn.setStyle("-fx-background-color: transparent");
            addmovie_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color:transparent");
            showAvilableMovies();
        } else if (event.getSource() == editScreening_btn) {
            dashbport_Form.setVisible(false);
            AddMovie_form.setVisible(false);
            availablemovie_anchor.setVisible(false);
            editScreening_form.setVisible(true);
            customer_form.setVisible(false);

            editScreening_btn.setStyle("-fx-background-color: #ae2d3c;");
            dashboard_btn.setStyle("-fx-background-color: transparent");
            addmovie_btn.setStyle("-fx-background-color:transparent");
            availablemovie_anchor.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color:transparent");
            showEditScreening();
        } else if (event.getSource() == customers_btn) {
            dashbport_Form.setVisible(false);
            AddMovie_form.setVisible(false);
            availablemovie_anchor.setVisible(false);
            editScreening_form.setVisible(false);
            customer_form.setVisible(true);

            customers_btn.setStyle("-fx-background-color: #ae2d3c;");
            dashboard_btn.setStyle("-fx-background-color: transparent");
            addmovie_btn.setStyle("-fx-background-color:transparent");
            availablemovie_anchor.setStyle("-fx-background-color: transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            showCustuomerList();
        }
    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            displayUsername();
            showAddMovieslist();
            showEditScreening();
            comboBox();
            showAvilableMovies();
            showSpinnerValue();
            showCustuomerList();
            displayTotalSoldTicket();
            displayTotalIncomeToday();
            displayTotalAvailableMovies();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
