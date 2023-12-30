package odev;

import java.io.IOException;

public class niam {
	
	static int Gecen_Sure = 0 ;//kullanırım diye koydum ama kullanmadım
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//BL txt den verileri okuyup onların verilerini kaydediyor 
		BeklemeListesi BL = new BeklemeListesi () ;
		
		//görevlendiricimizi oluşturuyoruz
		Gorevlendirici GRV = new Gorevlendirici () ;
		
		//listedeki tüm prosesler tamamlanmış mı ona bakıyor
		 do {
			System.out.println("*******************************************************************************************");
			//zamanı gelen proseslere bakıp uygunsa kuyruklara ekliyor
			GRV.ekle(BL);
			
			//kuyruklardaki prosesleri yazdırıyor
			GRV.kuyruklariYazdir();
			
			//prosesi kuyruğa göre işliyor
			GRV.calistir(BL,GRV);
			System.out.println("-------------------------------------------------------------------------------------------");
		} while ( !(BL.prosesler.isEmpty() && GRV.kuyruklarHepsiBosMu()) ) ;
		
		// bittiği zaman bitti yazıyor
		System.out.print("bitti");
	}

}
