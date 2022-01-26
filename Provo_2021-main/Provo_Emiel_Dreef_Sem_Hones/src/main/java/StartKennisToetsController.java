import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StartKennisToetsController {
    private static final PuntenTelling puntenTelling = new PuntenTelling();
    private static long behaaldePunten = 0;
    private static long maxPunten;
    private static KennisToetsTimer vraagTimer = new KennisToetsTimer();
    private static KennisToetsTimer toetsTimer = new KennisToetsTimer();

    public static void main(String[] args){
        startKennisToets();
        toonResultaten();
    }

    private static void toonResultaten() {
        System.out.println("Je hebt " + behaaldePunten + " van de " + maxPunten + " punten behaald");
    }

    public static void startKennisToets(){
        List<Vraag> vragenLijst = new Kennistoets().getVragenLijst();
        maxPunten = vragenLijst.size() * 5L;
        toetsTimer.start();
        for(Vraag vraag: vragenLijst) {
            vraagTimer.start();
            Scanner scanner = new Scanner(System.in);
            System.out.println(vraag.getBeschrijving());
            if(vraag instanceof MeerkeuzeVraag){
                System.out.println(((MeerkeuzeVraag) vraag).getAntwoorden());
            }
            Antwoord studentAntwoord = new Antwoord(scanner.nextLine());
            vraagTimer.stop();
            if(vraag.getCorrectAntwoord().toLowerCase().equals(studentAntwoord.getAntwoord().toLowerCase())){
                behaaldePunten += puntenTelling.voerPuntenTellingUit(vraagTimer.getVerlopenSeconden());
                System.out.println("Deze vraag is juist, je krijgt: " + puntenTelling.voerPuntenTellingUit(vraagTimer.getVerlopenSeconden()) + " van de " + new HogePuntenStrategie().geefPunten() + " punten.");
            }
            else{
                System.out.println("Deze vraag is onjuist je krijgt geen punten.");
            }
            stopKennisToets();
        }
    }

    public static void stopKennisToets(){
        if(toetsTimer.getVerlopenMinuten() >= 60) {
            toetsTimer.stop();
        }
    }

    public int maakStartCode() {
        return 210532;
    }

//    public void kiesLokaal(Lokaal beschikbaarLokaal){
//
//    }
//
//    public Lokaal haalBeschikbaarLokaalOp(){
//        Lokaal lokaal = new Lokaal();
//        return lokaal;
//    }
}
