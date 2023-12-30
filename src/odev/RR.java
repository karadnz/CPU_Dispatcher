package odev;

import java.io.IOException;
import java.util.Queue;

public class RR {
	public RR ( ) {
		
	}
	public void RR_calistir (Queue<Proses> kullanici3,BeklemeListesi BL,Gorevlendirici GRV) throws IOException, InterruptedException {
	if ( !kullanici3.isEmpty() ) {
		Proses prs = kullanici3.peek() ;
		kullanici3.poll() ;
		if ( prs.proses_zamani != 1 ) {
			System.out.println("saniye :" + Gorevlendirici.gecen_sure);
			prs.ProsesCalisiyor(Gorevlendirici.gecen_sure++, prs);
			Thread.sleep(1000);
			prs.proses_zamani--;
			kullanici3.add(prs) ;
			prs.ProsesBeklemede(Gorevlendirici.gecen_sure, prs);
			GRV.zamanArtirHepsinde (BL) ;
			GRV.zamanAsiminaUgramisProsesSonlandir (BL) ;
		} else {
			System.out.println("saniye :" + Gorevlendirici.gecen_sure);
			prs.ProsesCalisiyor(Gorevlendirici.gecen_sure++, prs);
			prs.proses_zamani--;
			prs.ProsesSonlandi(Gorevlendirici.gecen_sure, prs);
			Gorevlendirici.kullanici_zamanli_bellek += prs.Mbayt ;
			GRV.iadeEtKaynaklar(prs.kaynak);
			GRV.zamanArtirHepsinde (BL) ;
			GRV.zamanAsiminaUgramisProsesSonlandir (BL) ;
		}
	}
	}
}
