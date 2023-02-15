
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {
        List<Integer>sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println("\n ******");
        tekBirFazlaPrint(sayi);
        System.out.println("\n ******");
        maxElBul(sayi);
        System.out.println("\n ******");
        structuredMaxElBul(sayi);
        System.out.println("\n ******");
        ciftKareMaxPrint(sayi);
        System.out.println("\n ******");
        elTopla(sayi);
        System.out.println("\n ******");
        ciftCarp(sayi);
        System.out.println("\n ******");
        minBul(sayi);
        System.out.println("\n ******");
        bestenBykTekKck(sayi);
        System.out.println("\n ******");
        ciftKareKbSortPrint(sayi);




    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer>sayi){
        sayi.stream().
                filter(Lambda01::ciftBul).//akisdaki cift sayillari filtrelledim , 4,2,6
                map(t ->t*t).  //16,4,36 -- stream icerisindeki elemanlari baska degere donusturur
                forEach(Lambda01::yazdir);
    }
    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekBirFazlaPrint(List<Integer>sayi){
        sayi.
                stream(). //(4,2,6,11,-5,7,3,15
                filter(t ->t %2 !=0). //11,-5,7,3,15
                map(t ->(t*t*t)+1). //1332 -124 344 28 3376
                forEach(Lambda01::yazdir);

    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKokrint(List<Integer>sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). // double
                forEach(t -> System.out.println(t+ " "));
    }
    // Task-4 : 1.Yol. list'in en buyuk elemanini yazdiriniz
    public static void maxElBul (List<Integer>sayi){
       Optional<Integer> maxSayi =sayi.
                stream().
                reduce(Math::max);// eger benim resultim tek bir deger ise ozaman reduce terminal opt. kullanilr
        System.out.println(maxSayi);
    }
    // 2.Yol. Structured yapi ie cozelim
    public static void structuredMaxElBul(List<Integer>sayi){
        int max =Integer.MIN_VALUE;
        System.out.println("max = " + max);// max.soutv otomatik getiriyo
        for (int i = 0; i <sayi.size() ; i++) {
            if (sayi.get(i)>max) max = sayi.get(i);
            
        }
        System.out.println("en buyuk sayi :" + max);
    }
    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer>sayi){
        System.out.println( sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t ->t*t).
                reduce(Math::max));// "Integer::max" Math::max 'a gore daha hizli calisir  //reduce sadece bir deger icin kullanillir
    }
    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer>sayi){
       int toplam = sayi.// (4, 2, 6, 11, -5, 7, 3, 15)
               stream().
               reduce(0,(a,b)->a+b);
        System.out.println("toplam =" + toplam);

        /*
           * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
             bu örnekte 0 oluyor
           * b degerini her zamana  stream()'dan akısdan alır
           * a ilk degerinden sonraki her değeri action(işlem)'dan alır

*/
    }
    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer>sayi){
        System.out.println(sayi.
                         stream().
                         filter(Lambda01::ciftBul).
                         reduce(Math::multiplyExact)); // method refrance



        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)->(a*b))); //lambda exception

    }
    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer>sayi){
        //1.YOL : method refrence
        System.out.println(sayi.
                stream().
                reduce(Integer::min)); //Math::min

        //2.YOL : method refrance
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMiracMin));
    }
    public static int byMiracMin(int a , int b){

        return a<b ? a : b ; //byMiracMin(4,9)
    }
    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykTekKck(List<Integer>sayi){
        System.out.println( sayi.
                stream().
                filter(t -> (t > 5) && (t % 2 != 0)).
                reduce(Lambda02::byMiracMin));
    }
    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbSortPrint(List<Integer>sayi){
        sayi.
                stream(). //akisi baslattik
                filter(Lambda01::ciftBul). //akis icindeki cift sayilari aldim
                map(t->t*t).// sayilarin karesi ile yeni bir akis olusturdum
                sorted().//akis icindeki sayilari natural-order oarak siraladim
                forEach(Lambda01::yazdir);// akisdaki , sayiari ekrana yazdim
    }



}
