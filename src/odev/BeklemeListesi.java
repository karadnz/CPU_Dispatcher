package odev;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader; 

public class BeklemeListesi {

	//txt den okunan prosesleri tutar
	public List<Proses> prosesler = new ArrayList<Proses>();
	public static int toplam_sure = 0 ;
	
	//ilk oluşturulduğu an proses bilgilerini tutmaya yarar
	public BeklemeListesi () throws IOException, InterruptedException {
		File file = new File ("giris.txt") ;
		int id = 0 ;
		
		FileReader fileReader = new FileReader (file) ;
		String line ;
		BufferedReader bufferedReader = new BufferedReader (fileReader) ;
		
		while ( ( line = bufferedReader.readLine() ) != null ) {
			
			String [] dizi = line.split (", ") ;
			
			for ( int i = 0; i < dizi.length; i++ ) {
				
				//dosyadan proses bilgilerini alır
				Proses proses = new Proses () ;
				proses.proses_id = id++ ;
				proses.toplam_gecirilen_zaman = 0 ;
				proses.varis_zamani = Integer.parseInt( dizi [ i ] ) ;
				proses.oncelik = Integer.parseInt( dizi [ ++i ] ) ;
				proses.proses_zamani = Integer.parseInt( dizi[++i] ) ;
				proses.Mbayt = Integer.parseInt( dizi[++i] ) ;
				proses.renk = RandomRenk () ;
				for ( int j = 0; j < 4; j++ ) {
					proses.kaynak [ j ] = Integer.parseInt( dizi[++i] ) ; 
				}
				
				//prosesler listesine ekler
				prosesler.add(proses);
			}
		}
		bufferedReader.close();
	}
	
	public int RandomRenk ( ) {
        Random random = new Random();

        return random.nextInt(8);
    }
	
}
