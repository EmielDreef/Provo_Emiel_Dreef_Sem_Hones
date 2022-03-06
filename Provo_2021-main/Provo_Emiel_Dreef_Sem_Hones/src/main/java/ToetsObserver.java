public class ToetsObserver implements IToetsObserver{
    public KennisToetsAfname kennisToetsAfname = new KennisToetsAfname();
    public KennisToetsTimer toetsTimer;



    public boolean isTijdVoorbij(){
        toetsTimer = kennisToetsAfname.getToetsTimer();
        return toetsTimer.getVerlopenSeconden() > kennisToetsAfname.getKennisToets().getMaxTijd();
    }
}
