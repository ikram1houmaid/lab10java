package ma.projet;

public class TestTriplet {

    public static void main(String[] args) {

        Triplet<Integer> tInt = new Triplet<>(1, 2, 3);
        tInt.affiche();

        Triplet<String> tStr = new Triplet<>("A", "B", "C");
        tStr.affiche();

        System.out.println("Premier élément : " + tInt.getPremier());
        System.out.println("Deuxième élément : " + tInt.getSecond());
        System.out.println("Troisième élément : " + tInt.getTroisieme());
    }
}