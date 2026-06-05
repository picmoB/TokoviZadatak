import java.io.*;
import java.util.Scanner;

public class ProvjeraPostojanja {
    public static void main(String[] args) throws FileNotFoundException {
//        String putanjaHome = System.getProperty("user.dir");      // dohvaca trenutnu lokaciju gdje se projekt nalazi!!!!

        String putanjaHome = "C:\\Users\\ivanm\\java\\Uvod\\TokoviZadatak\\dokument.txt";
        System.out.println(putanjaHome);

        Scanner sc = new Scanner(System.in);

        File file = null;   // stavljeno pod globalni opseg koda
        int odabir = 1;     // postavljeno zbog inicijalizacije (1)

        while (odabir >= 1 && odabir <= 3) {
            System.out.println("Unesite sljedeću operaciju: \n1 - Provjera postojanja\n2 - Kopiranje datoteke\n3 - Brisanje datoteke");
            odabir = sc.nextInt();
            sc.nextLine();          // bitno da se ne događa preskakanje sljedećeg inputa!

            if (odabir == 1) {
                System.out.println("Unesite putanju do originalne datoteke: ");
                String putanja = sc.nextLine();
                System.out.println("Unesite naziv te datoteke: ");
                String naziv = sc.nextLine();

                file = new File("C:\\Users\\ivanm\\java\\Uvod\\TokoviZadatak\\dokument.txt");

                if (putanja.equals(putanjaHome)) {
                    System.out.println("Putanja postoji!");
                    if (naziv.equals(file.getName())) {
                        System.out.println("Naziv postoji!");
                    } else {
                        System.err.println("Naziv ne postoji!");
                    }
                } else {
                    System.err.println("Putanja ne postoji!");
                }
            } else if (odabir == 2) {
                try (FileInputStream fis = new FileInputStream(file);
                     FileOutputStream fos = new FileOutputStream("izlazFOS.txt");) {
                    int c;
                    while ((c = fis.read()) != -1) {
                        fos.write(c);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else if (odabir == 3) {
                File noviFile = new File("izlazFOS.txt");

                if (noviFile.exists()) {
                    System.out.println("Nova datoteka postoji - brišem!");
                    noviFile.delete();
                } else {
                    System.out.println("Nova datoteka NE postoji!");
                }
            } else {
                System.out.println("Operacija je završena!");
                break;
            }
        }
    }
}
