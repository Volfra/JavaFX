module xxxgraphic {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens co.edu.poli.demo.vista to javafx.graphics, javafx.fxml;
	opens co.edu.poli.demo.controlador to javafx.graphics, javafx.fxml;
}
