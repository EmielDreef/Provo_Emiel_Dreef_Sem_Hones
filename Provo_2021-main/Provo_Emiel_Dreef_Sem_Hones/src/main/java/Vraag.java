public interface Vraag {
    String getCorrectAntwoord();
    String getBeschrijving();
    void setCorrectAntwoord(Antwoord correctAntwoord);
    void setBeschrijving(String beschrijving);
    int getPunten();
    void setPunten(int punten);
    int getVraagId() ;
    void setVraagId(int vraagId);
}
