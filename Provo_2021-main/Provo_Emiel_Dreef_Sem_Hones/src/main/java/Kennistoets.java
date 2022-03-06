import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Kennistoets {

    private int kennistoetsId;
    private String naam;

    public int getMaxTijd() {
        return maxTijd;
    }

    public void setMaxTijd(int maxTijd) {
        this.maxTijd = maxTijd;
    }

    private int maxTijd = 5;
    private Collection<Antwoord> lijstMetDrieFouteAntwoorden = new ArrayList<>();

    private List<Vraag> vragenLijst = new ArrayList<>();
    Vraag kav1 = new KortAntwoordVraag(1,"Wat is je favoriete kleur?",new Antwoord("Rood"),5);
    Vraag kav2 = new KortAntwoordVraag(2,"Wat is je favoriete melk?",new Antwoord("Wit"),3);
    Vraag kav3 = new KortAntwoordVraag(3,"Wat is je favoriete hond?",new Antwoord("Hond"),12);
    Vraag mkv1;
    Vraag mkv2;

    private void setFouteAntwoorden(){
        lijstMetDrieFouteAntwoorden.add(new Antwoord("Blauwe kaas"));
        lijstMetDrieFouteAntwoorden.add(new Antwoord("Jonge kaas"));
        lijstMetDrieFouteAntwoorden.add(new Antwoord("Geen kaas"));

        mkv1 = new MeerkeuzeVraag(4,"Wat is je favoriete kaas?",new Antwoord("Oude Kaas"), lijstMetDrieFouteAntwoorden,8);
        mkv2 = new MeerkeuzeVraag(5,"Wat is je favoriete beer?",new Antwoord("Brother Bear"),lijstMetDrieFouteAntwoorden, 10);
    }

    public Kennistoets(){
        setFouteAntwoorden();
        vragenLijst.add(kav1);
        vragenLijst.add(kav2);
        vragenLijst.add(kav3);
        vragenLijst.add(mkv1);
        vragenLijst.add(mkv2);
    }

    public void setVragenLijst(List<Vraag> vragenLijst){
        this.vragenLijst = vragenLijst;
    }

    public List<Vraag> getVragenLijst(){
        return vragenLijst;
    }
}
