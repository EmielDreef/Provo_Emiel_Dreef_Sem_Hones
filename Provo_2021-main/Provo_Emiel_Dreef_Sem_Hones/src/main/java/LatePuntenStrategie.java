public class LatePuntenStrategie implements PuntenTellingStrategie {
    @Override
    public int geefPunten(int punten) { return punten / 3;}
}
