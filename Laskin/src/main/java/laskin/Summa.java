package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa implements Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int edellinenTulos;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        edellinenTulos = 0; // tähän laitetaan muistiin edellinen tulos
    }

    @Override
    public void suorita() { 
        int arvo = 0;
        try {
            edellinenTulos = Integer.parseInt(tuloskentta.getText());
            arvo = Integer.parseInt(syotekentta.getText());
            sovellus.plus(arvo);
        } catch (Exception e) {

        }
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinenTulos);
        tuloskentta.setText("" + sovellus.tulos());
        undo.disableProperty().set(true);
    }

}
