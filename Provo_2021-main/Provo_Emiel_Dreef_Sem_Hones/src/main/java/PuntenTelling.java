public class PuntenTelling {
    private static final long SNELLE_TIJD = 5;
    private static final long MEDIUM_TIJD = 10;
    private static final long LATE_TIJD = 20;
    private static final long EIND_TIJD = 60;
    private PuntenTellingStrategie strategie = new LagePuntenStrategie();
    private long behaaldePunten = 0;
    private long maxPunten = 0;

    private PuntenTellingStrategie berekenStrategie(long tijd){
        Long[] alleTijden = { SNELLE_TIJD, MEDIUM_TIJD, EIND_TIJD };
        PuntenTellingStrategie[] alleStrategiën = { new HogePuntenStrategie(), new MediumPuntenStrategie(), new LagePuntenStrategie()};
        int index = 0;

        while(index < alleTijden.length) {
            if(tijd < alleTijden[index]){
                strategie = alleStrategiën[index];
                break;
            }
            index++;
        }
        return strategie;
    }

    public void voerPuntenTellingUit(long tijd, Vraag vraag){
        strategie = berekenStrategie(tijd);
        behaaldePunten += strategie.geefPunten(vraag.getPunten());
        System.out.println("Deze vraag is juist, je krijgt: " + strategie.geefPunten(vraag.getPunten()) + " van de " + new HogePuntenStrategie().geefPunten(vraag.getPunten()) + " punten.");
    }

    public long getBehaaldePunten(){
        return behaaldePunten;
    }

    public long getMaxPunten(){
        return maxPunten;
    }

    public void setBehaaldePunten(long nieuweBehaaldPunten){
        behaaldePunten = nieuweBehaaldPunten;
    }

    public void setMaxPunten(long nieuweMaxPunten){
        maxPunten = nieuweMaxPunten;
    }
}
