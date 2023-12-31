package odev;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Gorevlendirici {
	
	//gerçek zamanlı proses kuyruğu
	public Queue<Proses> gercek_zamanli = new LinkedList<Proses> () ;
	
	//kullanıcı zamanlı proses kuyrukları
	public Queue<Proses> kullanici1 = new LinkedList<Proses> () ;
	public Queue<Proses> kullanici2 = new LinkedList<Proses> () ;
	public Queue<Proses> kullanici3 = new LinkedList<Proses> () ;
	
	public FCFS fcfs = new FCFS ();
	
	public GBG gbg = new GBG () ;
	
	//prosesin kaynaklarının uygun olup olmadığını ölçmek için referanslar
	static int MAX_gercek_zamanli_bellek = 64 ;
	static int MAX_kullanici_zamanli_bellek = 960 ;
	static int [] MAX_kaynak = { 2,1,1,2 } ;
	
	//gecen süreyü tutan ve boş kaynakları tutan değerler
	static int gecen_sure = 0 ;
	static int gercek_zamanli_bellek = 64 ;
	static int kullanici_zamanli_bellek = 960 ;
	
	static int[] kaynak = {2, 1, 1, 2};
	
	//kaynaklar ve bellek uygunsa bos kaynaklardan kullanılacak kaynaklar çıkartılır
	public void KaynakGuncelle (int [] cikarilacak_kaynak ) {
	    for (int i = 0; i < cikarilacak_kaynak.length; i++) {
	    	kaynak[i] -= cikarilacak_kaynak[i];
	    }
	}
	
	//kuyruğa, uygun prosesi ekleme
	public void ekle ( BeklemeListesi BL ) throws IOException {
		List<Proses> yeniListe = new ArrayList<Proses>();
		
		System.out.println("Saniye :" + Gorevlendirici.gecen_sure);
		
		//çakışmaların önlenmesi için iterator ile yapılması gerekti ( Hata veriyor yoksa )
		Iterator<Proses> iterator = BL.prosesler.iterator();
		while (iterator.hasNext()) {
		    Proses proses = iterator.next();
		    
		    //varış zamanı gelenler ile ilgilen
		    if (proses.varis_zamani <= gecen_sure) {
		    	
		    	//kaynak ve bellek MAX değerlerini aşarsa onu listeden kaldırırız yoksa şuan anda kuyruklarda olmayan listeyi tutan listeye atarız
		        if (!maxKaynakVeBellekBak(proses)) {
		            proses.ProsesSilindi(gecen_sure, proses);
		            iterator.remove();
		        } else {
		            yeniListe.add(proses);
		        }
		    }
		}
	    
		//listeyi önce en yüksek önceliğe göre sıralar sonra sıralanan kümeler arasında en az belleğe ihtiyaç duyana göre sıralar
		//böylelikle daha çok prosesi belleğe koyarız. ( ben bu tarz da yaptım farklı tarzlarda uygulanabilir )
        Collections.sort(yeniListe, 
        	    Comparator.comparingInt((Proses proses) -> proses.oncelik)
        	              .thenComparingInt(proses -> proses.Mbayt));
        
        //kaynağı ve belleği uygun olan prosesi kuyruğuna yerleştirir
        for (Proses proses : yeniListe) {
        	if(proses.KaynagaBak (kaynak) ) {
        		int Poncelik = proses.oncelik ;
        	    switch (Poncelik) {
                case 0:
                	
                	//geğer Mbaytı büyükse bellek uygun değildir. boş olana kadar beklemesi lazım
                	if(proses.Mbayt > gercek_zamanli_bellek) { continue ; }
                	//uygun kuyruğa ekler
                	gercek_zamanli.add(proses);
                	//boş bellekten ihtiyacımız olan bellek miktarı çıkartılır
                	gercek_zamanli_bellek -= proses.Mbayt ;
                	//kaynaklar ayırtılır
                	KaynakGuncelle (proses.kaynak) ;
                	//uygun mesaj verilir
                	proses.ProsesHazir(gecen_sure, proses);
                	//proses bilgilerinin tutulduğu listeden çıkartılır ki bir daha bakılmasın
                	prosesCikar(BL, proses);
                    break;
                case 1:
                	if(proses.Mbayt > kullanici_zamanli_bellek) { continue ; }
                	kullanici1.add(proses);
                	KaynakGuncelle(proses.kaynak) ;
                	kullanici_zamanli_bellek -= proses.Mbayt ;
                	proses.ProsesHazir(gecen_sure, proses);
                	prosesCikar(BL, proses);
                	break;
                case 2:
                	if(proses.Mbayt > kullanici_zamanli_bellek) { continue ; }
                	kullanici2.add(proses);
                	KaynakGuncelle(proses.kaynak) ;
                	kullanici_zamanli_bellek -= proses.Mbayt ;
                	proses.ProsesHazir(gecen_sure, proses);
                	prosesCikar(BL, proses);
                	break;
                default:
                	if(proses.Mbayt > kullanici_zamanli_bellek) { continue ; }
                	kullanici3.add(proses);
                	KaynakGuncelle(proses.kaynak) ;
                	kullanici_zamanli_bellek -= proses.Mbayt ;
                	proses.ProsesHazir(gecen_sure, proses);
                	prosesCikar(BL, proses);
                	break;
            }
        	} else {
        		continue ;
        	}
        }
	}
	
	//MAX kaynak ve belleğe göre uygunluğuna bakar
	private boolean maxKaynakVeBellekBak(Proses prs) {
		if ( prs.oncelik != 0 ) {
			if ( prs.Mbayt > MAX_kullanici_zamanli_bellek ) {
				System.out.println("HATA - kullanici zamanli proses 960 MB dan fazla bellek istiyor.");
				return false ;
			}
			if ( !prs.KaynagaBak(MAX_kaynak) ) {
				System.out.println("HATA - kullanici zamanli proses fazla kaynak talep ediyor.");
				return false ;
			}
			return true ;
		} else {
			if ( prs.Mbayt > MAX_gercek_zamanli_bellek ) {
				System.out.println("HATA - gercek zamanli proses 64 MB den fazla bellek istiyor.");
				return false ;
			}
			if ( !prs.KaynagaBak(MAX_kaynak) ) {
				System.out.println("HATA - gercek zamanli proses kaynak talep ediyor.");
				return false ;
			}
			return true ;
		}
	}

	//çalıştırma fonksiyonu
	public void calistir ( BeklemeListesi BL,Gorevlendirici GRV ) throws IOException, InterruptedException {
		
		//eğer herhangi bir kuyruk boş değilse gecen sürey, çalıştırma işleminin sonunda ekrana verir
		if ( !gercek_zamanli.isEmpty() || !kullanici1.isEmpty() || !kullanici2.isEmpty() || !kullanici3.isEmpty() ) {
			//System.out.println(Gorevlendirici.gecen_sure);
		//eğer proses bulunan herhangi bir kuytuk yoksa o zaman sadece zaman artırılır
		} else {
			System.out.println("Saniye :" + Gorevlendirici.gecen_sure);
			System.out.println("gorevlendirici islemi yok");
			Thread.sleep(1000);
			Gorevlendirici.gecen_sure++ ;
			zamanArtirHepsinde (BL) ;
			zamanAsiminaUgramisProsesSonlandir (BL) ;
		}
		
		//gerçek zamanlı kuyruk boş değilse her zaman burayı çalıştırır
		if (!gercek_zamanli.isEmpty()) {
			fcfs.FCFS_calistir(gercek_zamanli, BL, GRV);
		//kullanıcı kuyruk kısmı
		} else if ( !kullanici1.isEmpty() || !kullanici2.isEmpty() || !kullanici3.isEmpty() )  {
			gbg.GBG_calistir(kullanici1, kullanici2, kullanici3,BL, GRV);
		}
	}
	
	public void yazdir () {
		
	}
	
	//kaynak ayırma
	public void kaynakAyirt (int[] talepEdilenKaynaklar) {
        for (int i = 0; i < talepEdilenKaynaklar.length; i++) {
            if (Gorevlendirici.kaynak[i] < talepEdilenKaynaklar[i]) {
            	continue ;
            }
            Gorevlendirici.kaynak[i] -= talepEdilenKaynaklar[i];
        }
	}
	
	public void bellekAyirt () {
		
	}
	
	public Gorevlendirici () {
		
	}
	
	public void kuyruklariYazdir() {
		if ( !gercek_zamanli.isEmpty() ) {
			yazdirKuyruk("Gercek Zamanli", gercek_zamanli);
		}
		if ( !kullanici1.isEmpty() ) {
			yazdirKuyruk("Kullanici 1", kullanici1);
		}
		if ( !kullanici2.isEmpty() ) {
			yazdirKuyruk("Kullanici 2", kullanici2);
		}
		if ( !kullanici3.isEmpty() ) {
			yazdirKuyruk("Kullanici 3", kullanici3);
		}
	}

	private void yazdirKuyruk(String kuyrukAdi, Queue<Proses> kuyruk) {
	    System.out.println(kuyrukAdi + " Kuyrugu:");
	    for (Proses proses : kuyruk) {
	        System.out.println("Proses ID: " + proses.proses_id);
	    }
	    System.out.println();
	}
	
	public void prosesCikar(BeklemeListesi BL, Proses proses) {
	    BL.prosesler.remove(proses);
	}
	
    public void iadeEtKaynaklar(int[] iadeKaynaklar) {
        for (int i = 0; i < iadeKaynaklar.length; i++) {
            Gorevlendirici.kaynak[i] += iadeKaynaklar[i];
        }
    }
    
    public void zamanAsiminaUgramisProsesSonlandir ( BeklemeListesi BL ) throws IOException {
		if ( !gercek_zamanli.isEmpty() ) {
			zamanAsimiVarmi (gercek_zamanli) ;
		}
		if ( !kullanici1.isEmpty() ) {
			zamanAsimiVarmi (kullanici1) ;
		}
		if ( !kullanici2.isEmpty() ) {
			zamanAsimiVarmi (kullanici2) ;
		}
		if ( !kullanici3.isEmpty() ) {
			zamanAsimiVarmi (kullanici3) ;
		}
		Iterator<Proses> iterator = BL.prosesler.iterator() ;
		while ( iterator.hasNext() ) {
			Proses proses = iterator.next() ;
			if (proses.toplam_gecirilen_zaman > 20 ) {
				System.out.print("Zaman asimi var :: ");
				proses.ProsesSonlandi(gecen_sure, proses);
				iterator.remove(); 
			}	
		}
    }
    
    public void zamanAsimiVarmi(Queue<Proses> kuyruk) throws IOException {
        Iterator<Proses> iterator = kuyruk.iterator();
        while (iterator.hasNext()) {
            Proses prs = iterator.next();
            if (prs.toplam_gecirilen_zaman > 20) {
                System.out.print("zaman asimindan ::");
                prs.ProsesSonlandi(gecen_sure, prs);
                
                if (!(prs.oncelik == 0)) {
                    kullanici_zamanli_bellek += prs.Mbayt;
                    iadeEtKaynaklar(prs.kaynak);
                } else {
                    gercek_zamanli_bellek += prs.Mbayt;
                }

                // Iterator'un remove() metodunu kullanarak elemanı güvenli bir şekilde kuyruktan kaldır
                iterator.remove();
            }
        }
    }
    
    public void zamanArtirHepsinde ( BeklemeListesi BL ) throws IOException {
		if ( !gercek_zamanli.isEmpty() ) {
			zamanArtir (gercek_zamanli) ;
		}
		if ( !kullanici1.isEmpty() ) {
			zamanArtir (kullanici1) ;
		}
		if ( !kullanici2.isEmpty() ) {
			zamanArtir (kullanici2) ;
		}
		if ( !kullanici3.isEmpty() ) {
			zamanArtir (kullanici3) ;
		}
		for ( Proses proses : BL.prosesler ) {
			if (proses.varis_zamani <= gecen_sure) {
				proses.toplam_gecirilen_zaman++ ;
			}	
		}
    }
    
    public void zamanArtir ( Queue<Proses> kuyruk ) throws IOException {
        for (Proses prs : kuyruk) {
        	prs.toplam_gecirilen_zaman++ ;
        }
    }
    
    public boolean kuyruklarHepsiBosMu () {
    	return gercek_zamanli.isEmpty()&&kullanici1.isEmpty()&&kullanici2.isEmpty()&&kullanici3.isEmpty() ;
    }
}
