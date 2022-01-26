public class KortAntwoordVraag implements Vraag {
    private int vraagId;
    private String beschrijving;
    private Antwoord correctAntwoord;
    private int punten;

    public KortAntwoordVraag(int vraagId, String beschrijving, Antwoord correctAntwoord, int punten){
        this.vraagId = vraagId;
        this.beschrijving = beschrijving;
        this.correctAntwoord = correctAntwoord;
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
}
