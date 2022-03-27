package cd_sammlung;

import java.io.*;
import java.util.ArrayList;

public class Management {
    //  Array List
    private ArrayList<CD> cdCollectionArrayList;
    private int pointer;
    File file1 = new File("C:\\Users\\Noah\\Documents\\SWD_CD\\file1.txt");

    public void schreibeBinaer(String x) throws IOException {
        String y = this.leseBinaer();
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file1));
        y += x + "\n";
        dos.writeBytes(y);
    }

    public void schreibebinaercdDatenbank() throws IOException {
        for ( CD cd : cdCollectionArrayList) {
            schreibeBinaer(cd.toString());
        }
    }

    public void leseBinaercdDatenbank() throws IOException {
        String[] a = this.leseBinaer().split("\n");
        for (String cd: a) {
            String[] b = cd.split("; ");
            System.out.println(cd);
            var x = new CD(b[0], b[1], Integer.parseInt(b[2]), Integer.parseInt(b[3]));
            this.Add(x);
            System.out.println(x);
        }
    }

    public String leseBinaer() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file1));
        int x = 0;
        String y = "";
        do {
            x = dis.read();
            y += (char)x;
        }while (x != -1);
        return y.substring(0, y.length() -1);
    }

    public Management(){
        cdCollectionArrayList = new ArrayList<>();
        pointer = 0;
    }

    //  CDs zur Sammlung hinzufügen
    public void Add(CD a){
        this.cdCollectionArrayList.add(a);
    }

    //  toString
    @Override
    public String toString() {
        String collectionList = "";
        for (int i = 0; i < this.cdCollectionArrayList.size() ; i++){
            collectionList += this.cdCollectionArrayList.get(i).getTitle() + "; ";
        }
        return collectionList;
    }

    // Sammlung nach Titel durchsuchen
    public CD findTitle(String title){
        for (int i = 0; i < this.cdCollectionArrayList.size(); i++){
            if (this.cdCollectionArrayList.get(i).getTitle() == title){
                return this.cdCollectionArrayList.get(i);
            }
        }
        return null;
    }

    // Sammlung nach Interpret durchsuchen
    public CD findArtist(String artist){
        for (int i = 0; i < this.cdCollectionArrayList.size(); i++){
            if (this.cdCollectionArrayList.get(i).getArtist().equals(artist)){
                return this.cdCollectionArrayList.get(i);
            }
        }
        return null;
    }

    //  Sammlung nach Titeln sortieren
    public String sortTitle(){
        //  neue Arraylist, um alte nicht zu zerstören
        ArrayList<CD> sortedList = new ArrayList<>();
        for (int i = 0; i < this.cdCollectionArrayList.size(); i++){
            sortedList.add(this.cdCollectionArrayList.get(i));
        }

        //  sortieren
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i <= sortedList.size() -2; i++){
                if (sortedList.get(i).compareTitle(sortedList.get(i+1)) > 0){
                    CD tmp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(i+1));
                    sortedList.set(i+1, tmp);
                    changed = true;
                }
            }
        } while (changed);

        //  sortierte Liste ausgeben
        String newList = "";
        for (int i = 0; i < sortedList.size(); i++){
            newList += sortedList.get(i).getTitle() + "; ";
        }
        return newList;
    }

    //  Sammlung nach Interpreten sortieren
    public String sortArtist(){
        //  neue Arraylist, um alte nicht zu zerstören
        ArrayList<CD> sortedList = new ArrayList<>();
        for (int i = 0; i < this.cdCollectionArrayList.size(); i++){
            sortedList.add(this.cdCollectionArrayList.get(i));
        }

        //  sortieren
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i <= sortedList.size() -2; i++){
                if (sortedList.get(i).compareArtist(sortedList.get(i+1)) > 0){
                    CD tmp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(i+1));
                    sortedList.set(i+1, tmp);
                    changed = true;
                }
            }
        } while (changed);

        //  sortierte Liste ausgeben
        String newList = "";
        for (int i = 0; i < sortedList.size(); i++){
            newList += sortedList.get(i).getTitle() + "; ";
        }
        return newList;
    }

    // nächstes Album auswählen
    public CD Next(){
        if (this.pointer == this.cdCollectionArrayList.size() -1){
            this.pointer = 0;
        }
        else{
            this.pointer += 1;
        }
        return this.cdCollectionArrayList.get(pointer);
    }

    // erstes Album auswählen
    public CD First(){
        this.pointer = 0;
        return this.cdCollectionArrayList.get(pointer);
    }

    //  bestimmtes Album auswählen
    public CD getCD(int index){
        return this.cdCollectionArrayList.get(index);
    }

    // bestimmtes Album löschen
    public void deleteCD(int index){
        this.cdCollectionArrayList.remove(index);
    }
}
