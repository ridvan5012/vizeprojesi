import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class konsol extends Main{

    public static int konsol (){
        System.out.println("*********************");
        System.out.println("ÜYE İŞLEMLERİ MENÜSÜ");
        System.out.println("1-Elit üye ekleme");
        System.out.println("2-Genel üye ekleme");
        System.out.println("*********************");
        System.out.print("Hangi işlemi gerçekleştirmek istersiniz? : ");
        Scanner scan =new Scanner(System.in);
        int secilen=scan.nextInt();
        if(secilen>=1 &&secilen<=2)
            return secilen;
        else{
            System.out.println("konsoldaki işlemlerin başındaki sayıları kullan(1,2) !!!");
            menu();
        }
        return secilen;
    }

}

public class Main {




    public static String KullanıcıBilgileriiAlma() {
        Scanner scan = new Scanner(System.in);
        System.out.print("kullanıcı ad:");
        String ad = scan.next();
        System.out.print("kullanıcı soyisim:");
        String soyisim = scan.next();
        System.out.print("kullancıcı maili: ");
        String mail = scan.next();
        String kullanıcı = ad + "    " + soyisim + "    " + mail;
        return kullanıcı;
        //Kullanıcı eklemek için bu fonksiyonu kullandım
    }

    public static void d1(String newkullanıcı) throws IOException {
      //Elit kullanıcı eklerken dosya işlemlerini halleden fonksiyon
        File fi = new File("elitkullanıcılar.txt");
        if (!fi.exists()) {
            fi.createNewFile();
        }
        FileWriter fwriter = new FileWriter(fi, true);
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        FileReader freader = new FileReader(fi);
        String line;
        BufferedReader breader = new BufferedReader(freader);

        while ((line = breader.readLine()) != null) {
            System.out.println(line);
        }
        bwriter.newLine();
        bwriter.append(newkullanıcı);
        bwriter.close();
        System.out.println("\n yeni kullanıcı eklendikten sonraki liste:");
        while ((line = breader.readLine()) != null) {
            System.out.println(line);
        }
        breader.close();


    }

    public static void d2(String newkullanıcı) throws IOException {
        //Genel kullanıcı eklerken dosya işlemlerinin yapıldığı yer
        String line;
        File f = new File("genelkullanıcılar.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fWriter = new FileWriter(f, true);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        FileReader fReader = new FileReader(f);
        BufferedReader bReader = new BufferedReader(fReader);
        while ((line = bReader.readLine()) != null) {
            System.out.println(line);

        }
        bWriter.newLine();
        bWriter.append(newkullanıcı);
        bWriter.close();
        System.out.println("\n yeni kullanıcı eklendikten sonraki liste:");
        while ((line = bReader.readLine()) != null) {
            System.out.println(line);

        }
        bReader.close();
    }


    public static void main(String[] args) throws Exception {
        int secilen;
        int a=0;
        while(a==0) {
            Scanner scan = new Scanner(System.in);
            String newkullanıcı;//Kullanıcı bilgileri alma fonksiyonundan return yapılan kullanıcı bilgilerini buraya atadım
            secilen = konsol.konsol();//Konsolda kullanıcının kararını bu değişkene atadım
            switch (secilen) {
                case 1:
                    //Elit kullanıcı eklemek için kullanıcı bilgileri alma fonksiyonunu çağırdım ve o kullanıcıyı eklenmesi gereken dosyaya eklemek için d1 fonksiyonunu çağırdım
                    newkullanıcı = KullanıcıBilgileriiAlma();
                    d1(newkullanıcı);
                    break;
                case 2:
                    //Genel kullanıcı eklemek için kullanıcı bilgileri alma fonksiyonunu çağırdım ve o kullanıcıyı eklenmesi gereken dosyaya eklemek için d2 fonksiyonunu çağırdım
                    newkullanıcı = KullanıcıBilgileriiAlma();
                    d2(newkullanıcı);
                    break;
            }
        }
    }
}
