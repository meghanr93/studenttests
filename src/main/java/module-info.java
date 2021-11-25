module ryan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens ryan.studenttest to javafx.fxml;
    exports ryan.studenttest;
}