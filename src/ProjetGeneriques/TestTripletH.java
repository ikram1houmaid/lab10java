package ProjetGeneriques;

public class TestTripletH {

    public static void main(String[] args) {

        TripletH<Integer, String, Double> th =
                new TripletH<>(42, "Answer", 3.14);

        th.affiche();

        TripletH<String, Integer, Boolean> th2 =
                new TripletH<>("Alice", 30, true);

        th2.affiche();

        System.out.println("Premier élément : " + th.getPremier());
        System.out.println("Deuxième élément : " + th.getSecond());
        System.out.println("Troisième élément : " + th.getTroisieme());
    }
}