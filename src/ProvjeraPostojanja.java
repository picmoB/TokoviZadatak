import java.io.*;
import java.util.Scanner;

public class ProvjeraPostojanja {
    public static void main(String[] args) throws FileNotFoundException {
//        String putanjaHome = System.getProperty("user.dir");      // dohvaca trenutnu lokaciju gdje se projekt nalazi!!!!

        String putanjaHome = "C:\\Users\\ivanm\\java\\Uvod\\TokoviZadatak\\dokument.txt";
        System.out.println(putanjaHome);

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite putanju do originalne datoteke: ");
        String putanja = sc.nextLine();
        System.out.println("Unesite naziv te datoteke: ");
        String naziv = sc.nextLine();

        File file = new File("C:\\Users\\ivanm\\java\\Uvod\\TokoviZadatak\\dokument.txt");

        if (putanja.equals(putanjaHome)) {
            System.out.println("Putanja postoji!");
            if (naziv.equals(file.getName())) {
                System.out.println("Naziv postoji!");
            } else {
                throw new FileNotFoundException();
            }
        } else {
            throw new RuntimeException("Putanja ne postoji!");
        }

        try(FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream("izlazFOS.txt");) {
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File noviFile = new File("izlazFOS.txt");

        if (noviFile.exists()) {
            System.out.println("Nova datoteke postoji!");
        } else {
            System.out.println("Nova datoteke NE postoji!");
        }
    }
}
