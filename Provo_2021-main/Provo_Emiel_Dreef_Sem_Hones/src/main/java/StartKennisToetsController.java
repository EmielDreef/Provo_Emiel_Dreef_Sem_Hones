import java.util.List;
import java.util.Scanner;

public class StartKennisToetsController {
    private static final PuntenTelling puntenTelling = new PuntenTelling();

    private static final KennisToetsTimer vraagTimer = new KennisToetsTimer();
    private static final KennisToetsTimer toetsTimer = new KennisToetsTimer();

    public static void main(String[] args){
        startKennisToets();
        toonResultaten();
    }

    private static void toonResultaten() {
        System.out.println("Je hebt " + puntenTelling.getBehaaldePunten() + " van de " + puntenTelling.getMaxPunten() + " punten behaald");
    }

    public static void startKennisToets(){
        List<Vraag> vragenLijst = new Kennistoets().getVragenLijst();
        puntenTelling.setMaxPunten(vragenLijst.size() * 5L);
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
            if(vraag.getCorrectAntwoord().equalsIgnoreCase(studentAntwoord.getAntwoord())){
                puntenTelling.voerPuntenTellingUit(vraagTimer.getVerlopenSeconden());
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
