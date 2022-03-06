import java.util.List;
import java.util.Scanner;

public class KennisToetsAfname implements IKennisToetsAfname{
    private static final PuntenTelling puntenTelling = new PuntenTelling();
    private static final ToetsObserver toetsObserver = new ToetsObserver();
    private static final Kennistoets kennisToets = new Kennistoets();
    private static final KennisToetsTimer vraagTimer = new KennisToetsTimer();
    private static final KennisToetsTimer toetsTimer = new KennisToetsTimer();


    public Lokaal haalBeschikbaarLokaalOp(){
        Lokaal lokaal = new Lokaal();
        return lokaal;
    }

    public static void startKennisToets(){
        List<Vraag> vragenLijst = kennisToets.getVragenLijst();
        puntenTelling.setMaxPunten(vragenLijst.size() * 5L);
        toetsTimer.start();
        for(Vraag vraag: vragenLijst) {
            if(toetsObserver.isTijdVoorbij()) {
                System.out.println("De tijd is om!");
                break;
            }
                vraagTimer.start();
                Scanner scanner = new Scanner(System.in);
                System.out.println(vraag.getBeschrijving());
                if (vraag instanceof MeerkeuzeVraag) {
                    System.out.println(((MeerkeuzeVraag) vraag).getAntwoorden());
                }
                Antwoord studentAntwoord = new Antwoord(scanner.nextLine());
                vraagTimer.stop();
                if (vraag.getCorrectAntwoord().equalsIgnoreCase(studentAntwoord.getAntwoord())) {
                    puntenTelling.voerPuntenTellingUit(vraagTimer.getVerlopenSeconden());
                } else {
                    System.out.println("Deze vraag is onjuist je krijgt geen punten.");
                }

        }
    }

    public static void toonResultaten() {
        System.out.println("Je hebt " + puntenTelling.getBehaaldePunten() + " van de " + puntenTelling.getMaxPunten() + " punten behaald");
    }

    public KennisToetsTimer getToetsTimer(){
        return vraagTimer;
    }

    public Kennistoets getKennisToets(){
        return kennisToets;
    }
}
