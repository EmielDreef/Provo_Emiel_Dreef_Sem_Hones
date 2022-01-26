import java.util.ArrayList;
import java.util.Collection;

public class MeerkeuzeVraag implements Vraag {
    private int vraagId;
    private String beschrijving;
    private Antwoord correctAntwoord;
    private ArrayList<Antwoord> antwoorden = new ArrayList<>();
    private int punten;

    public MeerkeuzeVraag(int vraagId, String beschrijving, Antwoord correctAntwoord, Collection<Antwoord> fouteAntwoorden, int punten){
        this.vraagId = vraagId;
        this.beschrijving = beschrijving;
        this.correctAntwoord = correctAntwoord;
        this.antwoorden.add(correctAntwoord);
        this.antwoorden.addAll(fouteAntwoorden);
        this.punten = punten;
    }
    @Override
    public String getCorrectAntwoord() {
        return correctAntwoord.getAntwoord();
    }

    @Override
    public String getBeschrijving() {
        return beschrijving;
    }

    @Override
    public void setCorrectAntwoord(Antwoord correctAntwoord) {
        this.correctAntwoord = correctAntwoord;
    }

    @Override
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }

    public int getVraagId() {
        return vraagId;
    }

    public void setVraagId(int vraagId) {
        this.vraagId = vraagId;
    }

    public String getAntwoorden() {
        String antwoordInString = "De Antwoorden zijn: ";
        for(Antwoord antwoord : this.antwoorden){
            antwoordInString += antwoord.getAntwoord() + ", ";
        }
        return antwoordInString;
    }
}
