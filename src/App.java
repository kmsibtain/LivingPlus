import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/livingplus";
		String username = "root";
		String password = "1234";
		System.out.println("Connecting database");
		Connection connection = null;
		try  {
			connection = DriverManager.getConnection(url, username, password);
					System.out.println("Database connected!");
					Statement s = connection.createStatement();
					
					ResultSet rs = s.executeQuery("Select * from hello");
					
					while(rs.next()) {
						String name = rs.getString("name");
						System.out.println(name);
					}
					
					connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
        launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OwnerHomePage.fxml"));
        Parent root = loader.load();
        
        primaryStage.setTitle("Owner Home Page");
        Scene scene = new Scene(root, 1080, 720);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("OwnerHomePageStyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}