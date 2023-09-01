module javafxexemplo {
    requires javafx.controls;
    requires javafx.fxml;

    // Exporta seu pacote principal
    exports javafxexemplo;

    // Abre o pacote ao JavaFX para permitir a reflexão (FXML)
    opens javafxexemplo to javafx.fxml;
}
