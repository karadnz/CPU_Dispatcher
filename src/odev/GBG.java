package odev;

import java.io.IOException;
import java.util.Queue;

public class GBG {
	
	public RR rr = new RR () ;
	
	public void GBG_calistir (Queue<Proses> kullanici1,Queue<Proses> kullanici2,Queue<Proses> kullanici3,BeklemeListesi BL,Gorevlendirici GRV ) throws IOException, InterruptedException {
	if ( !kullanici1.isEmpty() ) {
		Proses prs = kullanici1.peek() ;
		kullanici1.poll() ;
		//kalan zamanı 1 değilse 1 saniye çalıştırma kısmı
		if( prs.proses_zamani != 1 ) {
			System.out.println("saniye :" + Gorevlendirici.gecen_sure);
			prs.ProsesCalisiyor(Gorevlendirici.gecen_sure++, prs);
			Thread.sleep(1000);
			prs.proses_zamani-- ;
			kullanici2.add(prs);
			prs.oncelik++ ;
			prs.ProsesBeklemede(Gorevlendirici.gecen_sure, prs);
			GRV.zamanArtirHepsinde (BL) ;
			GRV.zamanAsiminaUgramisProsesSonlandir (BL) ;
		//eğer son 1 saniye kalmışsa çalıştırılıp sonladırılır ve kaynakları iade edilir
		} else {
			System.out.println("saniye :" + Gorevlendirici.gecen_sure);
			prs.ProsesCalisiyor(Gorevlendirici.gecen_sure++, prs);
			prs.proses_zamani-- ;
			prs.ProsesSonlandi(Gorevlendirici.gecen_sure, prs);
			Gorevlendirici.kullanici_zamanli_bellek += prs.Mbayt ;
			GRV.iadeEtKaynaklar(prs.kaynak);
			GRV.zamanArtirHepsinde (BL) ;
			GRV.zamanAsiminaUgramisProsesSonlandir (BL) ;
		}
	} else if ( !kullanici2.isEmpty() ) {
		Proses prs = kullanici2.peek() ;
		kullanici2.poll() ;
		if( prs.proses_zamani != 1 ) {
			System.out.println("saniye :" + Gorevlendirici.gecen_sure);
			prs.ProsesCalisiyor(Gorevlendirici.gecen_sure++, prs);
			Thread.sleep(1000);
			prs.proses_zamani-- ;
			kullanici3.add(prs);
			prs.oncelik++ ;
			prs.ProsesBeklemede(Gorevlendirici.gecen_sure, prs);
			GRV.zamanArtirHepsinde (BL) ;
			GRV.zamanAsiminaUgramisProsesSonlandir (BL) ;
		} else {
			System.out.println("saniye :" + Gorevlendirici.gecen_sure);
			prs.ProsesCalisiyor(Gorevlendirici.gecen_sure++, prs);
			prs.proses_zamani-- ;
			prs.ProsesSonlandi(Gorevlendirici.gecen_sure, prs);
			Gorevlendirici.kullanici_zamanli_bellek += prs.Mbayt ;
			GRV.iadeEtKaynaklar(prs.kaynak);
			GRV.zamanArtirHepsinde (BL) ;
			GRV.zamanAsiminaUgramisProsesSonlandir (BL) ;
		}
		// round robin tarzı çalışan kuyruk
	} else if ( !kullanici3.isEmpty() ) {
		rr.RR_calistir(kullanici3, BL, GRV);
	}
}


}