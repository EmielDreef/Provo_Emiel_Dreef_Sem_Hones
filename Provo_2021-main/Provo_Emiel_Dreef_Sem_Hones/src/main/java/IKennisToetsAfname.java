public interface IKennisToetsAfname {

    Lokaal haalBeschikbaarLokaalOp();

    static void startKennisToets() {
    }

    static void toonResultaten() {
    }

    KennisToetsTimer getToetsTimer();

    Kennistoets getKennisToets();
}
