package odev;

import java.awt.Color;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Proses {
	
	//olması gereken özellikler
	public int varis_zamani ;
	public int oncelik ;
	public int proses_zamani ;
	public int Mbayt;
	public int[] kaynak = new int [4];
	
	//20 saniyeden fazla kuyrukta bulunan kaynağını ve belleğini serbest bırakır
	public int toplam_gecirilen_zaman ;
	
	public int proses_id ;
	public String[] renkler = new String[] {"\u001B[31m", "\u001B[32m", "\u001B[33m","\u001B[34m","\u001B[35m","\u001B[36m","\u001B[38m","\u001B[39m"};
	public int renk ;
	
	//bir yerde kullandım mı emin değilim
	public int OncelikGetir () {
		return this.oncelik ;
	}
	
	//proses herhangi bir kuyruğa girdiğinde mesajını verir
	public void ProsesHazir ( int saniye, Proses proses ) throws IOException {
		
		System.out.println(renkler[renk]+"proses id = " + proses.proses_id + ", " +"proses varis = "+", " + proses.varis_zamani+ "proses MB = " + proses.Mbayt +", " + "proses kaynaklari = " + proses.kaynak[0]+" "+ proses.kaynak[1]+" " + proses.kaynak[2]+" "+ proses.kaynak[3]+" proses durumu : " +"hazir"+"\u001B[0m");
	}
	
	//proses herhangi bir kuyrukta çalışıyorsa mesajını verir 
	public void ProsesCalisiyor ( int saniye, Proses proses ) throws IOException {
		
		System.out.println(renkler[renk]+"proses id = " + proses.proses_id+ ", " +"proses varis = "+ proses.varis_zamani+ ", " + "proses MB = " + proses.Mbayt + " ," + "proses kaynaklari = " + proses.kaynak[0]+" "+ proses.kaynak[1]+" " + proses.kaynak[2]+" "+ proses.kaynak[3]+" proses durumu : " +"calisiyor"+"\u001B[0m");
		
	}
	
	//proses herhangi bir kuyrukta çalışması kesintiye uğradıysa mesajını verir
	public void ProsesBeklemede ( int saniye, Proses proses ) throws IOException, InterruptedException {
		
		System.out.println(renkler[renk]+"proses id = " + proses.proses_id+ ", " +"proses varis = "+ proses.varis_zamani+ ", " + "proses MB = " + proses.Mbayt+ ", "  + "proses kaynaklari = " + proses.kaynak[0]+" "+ proses.kaynak[1]+" " + proses.kaynak[2]+" "+ proses.kaynak[3]+" proses durumu : " +"beklemede"+"\u001B[0m");
		
	}
	
	//proses herhangi bir kuyrukta çalışması sonlandıysa mesajını verir
	public void ProsesSonlandi ( int saniye, Proses proses ) throws IOException {
		
		System.out.println(renkler[renk]+"proses id = " + proses.proses_id+ ", " +"proses varis = "+ proses.varis_zamani+ ", " + "proses MB = " + proses.Mbayt+ ", " + "proses kaynaklari = " + proses.kaynak[0]+" "+ proses.kaynak[1]+" " + proses.kaynak[2]+" "+ proses.kaynak[3]+" proses durumu : " +"Sonlandi"+"\u001B[0m");
		
	}
	
	//kaynağın uygunluğuna bakar ( genelde boş kaynaklarla karşılaştırıyor ama MAX kaynaklada karşılaştırılıp çalışıp çalışmayacağı kontrol ediliyor )
	public Boolean KaynagaBak ( int [] kaynak ) {
	    for (int i = 0; i < kaynak.length; i++) {
	        if ( this.kaynak[i] > kaynak[i]) {
	            return false;
	        }
	    }
	    return true ;
	}
}
