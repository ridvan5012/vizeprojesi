import java.io.*;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class menu extends Main{

    public static int menu (){
        gir:
        System.out.println("*********************");
        System.out.println("ÜYE İŞLEMLERİ MENÜSÜ");
        System.out.println("1-Elit üye ekleme");
        System.out.println("2-Genel üye ekleme");
        System.out.println("3-Mail gönderme");
        System.out.println("*********************");
        System.out.print("Hangi işlemi gerçekleştirmek istersiniz? : ");
        Scanner scan =new Scanner(System.in);
        int karar=scan.nextInt();
        if(karar>=1 &&karar<=3)
            return karar;
        else{
            System.out.println("menudeki işlemlerin başındaki sayıları kullan(1,2,3) !!!");
            menu();
        }
        return karar;
    }

}
class elitemail  {
    public static String gonderenmail;
    public static String gonderenpassword;
    public static String metinmail;

    public elitemail(String gonderenmail, String gonderenpassword,String metinmail){//constructer
        this.gonderenmail=gonderenmail;
        this.gonderenpassword=gonderenpassword;
        this.metinmail=metinmail;
    }

    public static void mailgonder() throws Exception {
        File f = new File("elitkullanıcılar.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        String dosyaAdi = "elitkullanıcılar.txt";
        String[] epostaDizi;
        List<String> epostaListesi = new ArrayList<>();
        Pattern desen = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
        Matcher matcher;
        try {
            FileReader fileReader = new FileReader(dosyaAdi);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                matcher = desen.matcher(satir);
                while (matcher.find()) {
                    String eposta = matcher.group();
                    if (!epostaListesi.contains(eposta)) {
                        epostaListesi.add(eposta);
                    }
                }
            }
            fileReader.close();
            epostaDizi = new String[epostaListesi.size()];
            epostaDizi = epostaListesi.toArray(epostaDizi);
            System.out.println("gönderilcek epostalar:");
            for (String eposta : epostaDizi) {

                System.out.println(eposta);
            }
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp-mail.outlook.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(gonderenmail, gonderenpassword);
                        }
                    });

            for (String email : epostaListesi) {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(gonderenmail, "NoReply"));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                msg.setSubject("Welcome To Java Mail API");
                msg.setText(metinmail);
                Transport.send(msg);
                System.out.println(email + " adresine e-posta gönderildi.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }







    }


}
class genelemail {
    public static String gonderenmail;
    public static String gonderenpassword;
    public static String metinmail;
    public genelemail(String gonderenmail, String gonderenpassword,String metinmail){//constructer
        this.gonderenmail=gonderenmail;
        this.gonderenpassword=gonderenpassword;
        this.metinmail=metinmail;
    }

    public static void mailgonder() throws Exception {
        File f = new File("genelkullanıcılar.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        String dosyaAdi = "genelkullanıcılar.txt";
        String[] epostaDizi;
        List<String> epostaListesi = new ArrayList<>();
        Pattern desen = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
        Matcher matcher;
        try {
            FileReader fileReader = new FileReader(dosyaAdi);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                matcher = desen.matcher(satir);
                while (matcher.find()) {
                    String eposta = matcher.group();
                    if (!epostaListesi.contains(eposta)) {
                        epostaListesi.add(eposta);
                    }
                }
            }
            fileReader.close();
            epostaDizi = new String[epostaListesi.size()];
            epostaDizi = epostaListesi.toArray(epostaDizi);
            System.out.println("gönderilcek epostalar:");
            for (String eposta : epostaDizi) {

                System.out.println(eposta);
            }
            Properties props = new Properties();;
            props.put("mail.smtp.host", "smtp-mail.outlook.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(gonderenmail, gonderenpassword);
                        }
                    });

            for (String email : epostaListesi) {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(gonderenmail, "NoReply"));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                msg.setSubject("Welcome To Java Mail API");
                msg.setText(metinmail);

                Transport.send(msg);
                System.out.println(email + " adresine e-posta gönderildi.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }


}
class MailGondermeMenu extends menu{
    public static int mailgonderme() {
        System.out.println("*********************");
        System.out.println("ÜYE İŞLEMLERİ MENÜSÜ");
        System.out.println("1-Elit üyelere mail");
        System.out.println("2-Genel üyelere mail");
        System.out.println("3-tüm üyelere mail");
        System.out.println("*********************");
        System.out.print("Hangi işlemi gerçekleştirmek istersiniz? : ");
        Scanner scan = new Scanner(System.in);
        int karar = scan.nextInt();
        if (karar >= 1 && karar <= 3)
            return karar;
        else {
            System.out.println("menudeki işlemlerin başındaki sayıları kullan(1,2,3) !!!");
            menu.menu();
        }
        return karar;
    }
}
public class Main {


    public static String KullanıcıBilgileriiAlma() {
        Scanner scan = new Scanner(System.in);
        System.out.print("kullanıcı ad:");
        String name = scan.next();
        System.out.print("kullanıcı soyadı:");
        String surname = scan.next();
        System.out.print("kullancıcı maili: ");
        String mail = scan.next();
        String kullanıcı = name + "    " + surname + "    " + mail;
        return kullanıcı;

    }

    public static void dosya1(String newkullanıcı) throws IOException {
        int i;
        File f = new File("elitkullanıcılar.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fwriter = new FileWriter(f, true);
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        FileReader freader = new FileReader(f);
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

    public static void dosya2(String newkullanıcı) throws IOException {
        int i;
        String line;
        File f2 = new File("genelkullanıcılar.txt");
        if (!f2.exists()) {
            f2.createNewFile();
        }
        FileWriter fWriter = new FileWriter(f2, true);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        FileReader fReader = new FileReader(f2);
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
        int karar;
        Scanner scan = new Scanner(System.in);
        String newkullanıcı;
        String from, sifre, mailmetin;
        karar = MailGondermeMenu.menu();
        switch (karar) {
            case 1:
                newkullanıcı = KullanıcıBilgileriiAlma();
                dosya1(newkullanıcı);
                break;
            case 2:
                newkullanıcı = KullanıcıBilgileriiAlma();
                dosya2(newkullanıcı);
                break;
            case 3:
                int karar2 = MailGondermeMenu.mailgonderme();
                switch (karar2) {
                    case 1:
                        System.out.print("gönderici mail: ");
                        from = scan.next();
                        System.out.print("gönderici sifre: ");
                        sifre = scan.next();
                        System.out.println("mail metni nedir:");
                        mailmetin = scan.next();
                        elitemail em = new elitemail(from, sifre, mailmetin);
                        elitemail.mailgonder();
                        break;
                    case 2:
                        System.out.print("gönderici mail: ");
                        from = scan.next();
                        System.out.print("gönderici sifre: ");
                        sifre = scan.next();
                        System.out.println("mail metni nedir:");
                        mailmetin = scan.next();
                        genelemail gm = new genelemail(from, sifre, mailmetin);
                        genelemail.mailgonder();
                        break;
                    case 3:
                        System.out.print("gönderici mail: ");
                        from = scan.next();
                        System.out.print("gönderici sifre: ");
                        sifre = scan.next();
                        System.out.println("mail metni nedir:");
                        mailmetin = scan.next();
                        elitemail em1 = new elitemail(from, sifre, mailmetin);
                        elitemail.mailgonder();
                        genelemail gm1 = new genelemail(from, sifre, mailmetin);
                        genelemail.mailgonder();
                        break;
                }
                break;
        }
    }
}