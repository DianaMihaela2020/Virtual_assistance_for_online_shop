import java.util.Scanner;

public class EdenBoutique {

    enum Bijuterii {
        INELE,
        CERCEI,
        BRATARI,
        COLIERE,
        TALISMANE
    }


    public static int catalogProduse() {
        System.out.println("***********");
        System.out.println("Bună ziua, suntem bucuroși că sunteţi interesaţi de noutățile din lumea Fashion & LifeStyle in materie de bijuterii.Cu ce va putem auta? (Va rugam sa scrieti produsul ales cu MAJUSCULE");

        for (Bijuterii optiune : Bijuterii.values()) {
            System.out.println(optiune);
        }
        System.out.println("Daca doriti sa sa iesiti din meniul afisat, va rugam sa apasati tasta 0.");
        System.out.println("Optiunea dumneavoastra aleasa este:");
        Scanner optiune = new Scanner(System.in);
        String raspunsUser = optiune.nextLine();

        switch (raspunsUser) {
            case "INELE":
                System.out.println("Pentru orice inel de argint, iti oferim acum,-50% REDUCERE.");
                marimi();
                return acceptaProdus(210);
            case "TALISMANE":
                System.out.println("Talismane Reduceri - Profita Acum De Preturi Avantajoase. Livrare Rapidă si Gratuită. Descopera Favoritele Tale Si Profita Acum!-40% Discount");
                return  acceptaProdus(310);
            case "COLIERE":
                System.out.println("Colier Swarovski Timeless Elegance, - 30 % REDUCERE");
                return acceptaProdus(510);
            case "CERCEI":
                System.out.println("Cercei din argint cu design modern și stylish - 40 & OFF");
                return acceptaProdus(250);
            case "BRATARI":
                System.out.println("Set bijuterii Emporio Armani Woman's Collection - 40% pentru Bratara Fossil Fashion");
               return acceptaProdus(300);

            case "0":
                System.out.println ("Va multumim ca ati accesat site-ul nostru. Speram sa reveniti curand!");
                return 0;
            default:
                System.out.println("Optiunea dumneavoastra nu se regaseste in catalogul nostru de produse online.");
                return catalogProduse();
        }
    }

    public static int acceptaProdus (int pretAchizitii) {
        System.out.println("Pretul comenzii dumneavoastra este de " + pretAchizitii + " RON. Apasa tasta 1 pentru a adauga produsul in cos.");
        System.out.println("Apasa tasta 2, pentru a reveni la meniul principal.");
        Scanner citeste = new Scanner(System.in);
        int raspunsUser = citeste.nextInt();
        switch (raspunsUser) {
            case 1:
                System.out.println("Produsul dumneavoastra a fost adaugat in cos.");
                return cosAchizitii(pretAchizitii) ;

            case 2:
                return catalogProduse();

            default:
                System.out.println("Optiunea tastata este invalida.");
               return acceptaProdus(pretAchizitii);

        }

    }

    public static void marimi() {
        System.out.println("***********");
        System.out.println("Vizualizati ghidul si alege cu exactitate dimensiunea corectă a inelului, apasand tasta 1, 2, 3 sau 4.");
        System.out.println("1.40.1 - 49 mm");
        System.out.println("2.49.9-54 mm");
        System.out.println("3.54-60 mm");
        System.out.println("4.60-76.2 mm");
        Scanner optiune = new Scanner(System.in);
        int raspunsUser = optiune.nextInt();
        switch (raspunsUser) {
            case 1:
                System.out.println("Marimea standard a inelului ales este S.");
                break;
            case 2:
                System.out.println("Marimea standard a inelului ales este M.");
                break;

            case 3:
                System.out.println("Marimea standard a inelului ales este L.");
                break;

            case 4:
                System.out.println("Marimea standard a inelului ales este XL.");
                break;

            default:
                System.out.println("Marimea afisata nu exista in catalogul de produse online.");
                catalogProduse();

        }

    }

    public static int cosAchizitii(int pretAchizitii) {
        if (pretAchizitii==0)
            return 0;
        System.out.println("***********");

        System.out.println("Cum doriti sa intrati in posesia produsului? Apasa tasta 1 daca doriti livrare prin curierat.");
        System.out.println("Apasa tasta 2, daca doriti sa-l ridicati personal, de la sediul nostru.");

        Scanner citeste = new Scanner(System.in);
        int raspunsUser = citeste.nextInt();
        switch (raspunsUser) {
            case 1:
                return livrare(pretAchizitii);

            case 2:
               System.out.println("Adresa sediului nostru este: Aleea Ciocolatei nr 1. Va asteptam cu drag!");
               return 0;
            default:
                System.out.println("Optiunea dumneavoastra nu este valida.");
                return cosAchizitii(pretAchizitii);
        }

    }

    public static void alegereMetodaLivrare (int pretAchizitii) {
        System.out.println("***********");
        System.out.println("Va rugam sa alegeti optiunea de livrare a comenzii:");
        System.out.println("1. FAN Courier - 20 RON");
        System.out.println("2. Cargus - 25 RON");
        Scanner citeste = new Scanner(System.in);
        int optiuneLivrare  = citeste.nextInt();
        switch (optiuneLivrare) {
            case 1:
                System.out.println("Suma totala de plata este de " + (pretAchizitii + 20 ) + " RON");
                break;

            case 2:
                System.out.println("Suma totala de plata este de " + (pretAchizitii + 25) +" RON");
                break;
            default:
                System.out.println("Optiunea dumneavoastra nu este valida.");
                alegereMetodaLivrare(pretAchizitii);

            }

    }

    public static int livrare(int pretAchizitii) {

        if (pretAchizitii==0)
            return 0;
        System.out.println("***********");
        System.out.println(" Va rog sa ne comunicati adresa de livrare a comenzii.");
        Scanner citeste = new Scanner(System.in);
        String raspunsClient = citeste.nextLine();
       alegereMetodaLivrare(pretAchizitii);

        System.out.println("Va multumim pentru comanda. Aproximam ca livrarea sa ajunga la adresa dumneavoastra: " + raspunsClient + " in cel mult 2 zile lucratoare. ");
        return 1;
    }


    public static void main(String[] args) {
        catalogProduse();

    }

}