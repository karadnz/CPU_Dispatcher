package odev;

import java.io.IOException;
import java.util.Queue;

public class FCFS {
	
	public void FCFS_calistir ( Queue<Proses> gercek_zamanli,BeklemeListesi BL,Gorevlendirici GRV ) throws IOException, InterruptedException {
		//kuyruğun başınki prosesi alır
		Proses prs = gercek_zamanli.peek() ;
		//kuyruktan prosesi çıkartır
		gercek_zamanli.poll() ;
		//gerçek zamanlı olduğu için proses sonlana kadar çalışır ve uygun mesaj verilir
		for (; prs.proses_zamani > 0; prs.proses_zamani-- ) {
			System.out.println("saniye :" + Gorevlendirici.gecen_sure);
			prs.ProsesCalisiyor(Gorevlendirici.gecen_sure++, prs);
			Thread.sleep(1000);
			//kuyruklardaki bütün proseslerin gecirilen zamanı artırılır ve 20 saniye yi gecen varsa sonlandırılır
			GRV.zamanArtirHepsinde (BL) ;
			GRV.zamanAsiminaUgramisProsesSonlandir (BL) ;
		}
		//biten proses sonlandırılır ve kaynaklar iade edilir
		prs.ProsesSonlandi(Gorevlendirici.gecen_sure, prs);
		Gorevlendirici.gercek_zamanli_bellek += prs.Mbayt ;
	}
}
