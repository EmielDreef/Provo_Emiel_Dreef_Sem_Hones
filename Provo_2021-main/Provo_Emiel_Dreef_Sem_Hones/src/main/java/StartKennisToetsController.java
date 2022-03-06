public class StartKennisToetsController {
    private static final KennisToetsAfname kennisToetsAfname = new KennisToetsAfname();

    public static void main(String[] args){
        kennisToetsAfname.startKennisToets();
        kennisToetsAfname.toonResultaten();
    }

    public int maakStartCode() {
        return 210532;
    }

    public void kiesLokaal(Lokaal beschikbaarLokaal){

    }
}
