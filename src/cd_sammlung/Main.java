package cd_sammlung;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //  CD Klasse ausprobieren
        /*CD a = new CD("Leoniden", "Complex Happenings", 30, 7);
        CD b = new CD("die Aerzte", "Jazz", 40, 9);
        CD c = new CD("Faber", "Alles Gute", 20, 12);*/

        //  System.out.println(a);
        //  System.out.println(a.compareTitle(b));

        //  Management Klasse ausprobieren
        Management x = new Management();
        /*x.Add(a);
        x.Add(b);
        x.Add(c);*/

        //x.schreibebinaercdDatenbank();
        x.leseBinaercdDatenbank();
        System.out.println(x.toString());
    }
}
