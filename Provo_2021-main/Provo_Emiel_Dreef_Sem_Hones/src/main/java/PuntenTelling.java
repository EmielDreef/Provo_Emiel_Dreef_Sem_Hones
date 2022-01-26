public class PuntenTelling {
    private static final long SNELLE_TIJD = 5;
    private static final long MEDIUM_TIJD = 10;
    private static final long LATE_TIJD = 20;
    private static final long EIND_TIJD = 60;
    private PuntenTellingStrategie strategie;

    public PuntenTellingStrategie berekenStrategie(long tijd){
        Long[] alleTijden = { SNELLE_TIJD, MEDIUM_TIJD, EIND_TIJD };
        PuntenTellingStrategie[] allePunten = { new HogePuntenStrategie(), new MediumPuntenStrategie(), new LagePuntenStrategie()};
        PuntenTellingStrategie puntenTelling = new LagePuntenStrategie();
        int index = 0;

        while(index < alleTijden.length) {
            if(tijd < alleTijden[index]){
                puntenTelling = allePunten[index];
                break;
            }
            index++;
        }
        return puntenTelling;
    }

    public int voerPuntenTellingUit(long tijd){
        strategie = berekenStrategie(tijd);
        return strategie.geefPunten();
    }
}
