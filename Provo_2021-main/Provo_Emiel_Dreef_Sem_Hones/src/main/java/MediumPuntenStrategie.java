public class MediumPuntenStrategie implements PuntenTellingStrategie {
    @Override
    public int geefPunten(int punten) {
        return punten / 2;
    }
}
