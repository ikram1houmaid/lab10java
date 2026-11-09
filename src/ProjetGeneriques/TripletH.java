package ProjetGeneriques;

public class TripletH<A, B, C> {

    private final A premier;
    private final B second;
    private final C troisieme;

    public TripletH(A premier, B second, C troisieme) {
        this.premier = premier;
        this.second = second;
        this.troisieme = troisieme;
    }

    public A getPremier() {
        return premier;
    }

    public B getSecond() {
        return second;
    }

    public C getTroisieme() {
        return troisieme;
    }

    public void affiche() {
        System.out.println("TripletH : [" + premier + ", "
                + second + ", " + troisieme + "]");
    }
}