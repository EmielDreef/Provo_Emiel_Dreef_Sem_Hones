public class LagePuntenStrategie implements PuntenTellingStrategie {
    @Override
    public int geefPunten(int punten) {
        return punten / 4;
    }
}
