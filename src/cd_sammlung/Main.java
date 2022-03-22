package cd_sammlung;

public class Main {

    public static void main(String[] args) {
        //  CD Klasse ausprobieren
        CD a = new CD("Leoniden", "Complex Happenings", 30);
        CD b = new CD("die Aerzte", "Jazz", 40);
        CD c = new CD("Faber", "Alles Gute", 20);

        System.out.println(a);
        System.out.println(a.compareTitle(b));

        //  Management Klasse ausprobieren
        Management x = new Management();
        x.Add(a);
        x.Add(b);
        x.Add(c);
        System.out.println(x.findTitle("Jazz"));
        System.out.println(x.sortTitle());
        System.out.println(x.sortTitle());

        System.out.println(x.Next());
        System.out.println(x.First());
        System.out.println(x.Next());
    }
}
