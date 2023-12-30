# Isletim Sistemleri Odevi

## Dersi verenler
- Abdullah
- ahmet

## Grup uyeleri
- 2B - G211210066 - MUSTAFA KARADENİZ
- 2C - G201210076 - MUHAMMET EFDAL ŞAHİN
- 2B - G211210042 - MUSTAFA HACI BARAN
- 2C - G221210382 - YETGİN AKCAN
- 1B - B231210501 - NECMİ ERTÜRK

## İşletim Sistemlerinde Bellek Tahsis Algoritmaları

İşletim sistemlerinde bellek tahsis algoritmaları, işlem ve programlara bellek kaynaklarının tahsis edilmesi ve boşaltılmasını yönetmek için kullanılan yöntemlerdir. Bu algoritmalar, uygulamaların işlev görmesi için gerekli belleğe sahip olmalarını sağlarken mevcut bellek kaynaklarının kullanımını en üst düzeye çıkarmak için hayati öneme sahiptir. İşte yaygın bellek tahsis algoritmalarından bazıları:

### 1. İlk Uygun (First-Fit) Algoritması
- **Açıklama**: İstek için yeterince büyük olan ilk bellek bloğunu tahsis eder.
- **Artıları**: Basit ve hızlıdır.
- **Eksileri**: Zamanla, kullanılamayan küçük boşluklar belleğin her tarafına dağıldıkça parçalanmaya yol açabilir.

### 2. En İyi Uygun (Best-Fit) Algoritması
- **Açıklama**: İsteği karşılayacak en küçük bloğu bulmak için tüm belleği arar.
- **Artıları**: En küçük artık bellek parçalarını üretme eğilimindedir, böylece parçalanmayı azaltır.
- **Eksileri**: Tüm blokları araştırması gerektiği için daha fazla hesaplama yoğunluğuna sahiptir ve daha küçük kullanılamaz alanlara yol açabilir.

### 3. En Kötü Uygun (Worst-Fit) Algoritması
- **Açıklama**: Tahsis için mevcut en büyük bellek bloğunu seçer.
- **Artıları**: Küçük parçalar üretme olasılığı daha düşüktür, bu nedenle boyutları çok değişken olan tahsisler için uygun olabilir.
- **Eksileri**: Belleğin büyük kısımlarının kullanılmadan kalmasına yol açabilir.

### 4. Sonraki Uygun (Next-Fit) Algoritması
- **Açıklama**: İlk uygun algoritmaya benzer, ancak aramaya belleğin başından değil, önceki tahsisin yapıldığı yerden başlar.
- **Artıları**: Belirli senaryolarda baştan başlamadığı için ilk uygun algoritmadan daha hızlı olabilir.
- **Eksileri**: İlk uygun gibi, parçalanmaya yol açabilir.

### 5. Arkadaş Sistemi (Buddy System)
- **Açıklama**: Parçalanmayı azaltmaya çalışarak belleği bölümlere ayırır. Her blok, bir boyut isteğine uyacak şekilde yarıya bölünür.
- **Artıları**: Daha az parçalanma ile belleği verimli bir şekilde yönetir.
- **Eksileri**: Uygulamak ve sürdürmek karmaşık olabilir.

### 6. Yığın Tahsis (Slab Allocation)
- **Açıklama**: Genellikle çekirdek bellek tahsisi için sabit boyutlu nesneler için kullanılır. Aynı boyuttaki nesneleri bir yığın içinde gruplar.
- **Artıları**: Aynı boyuttaki nesnelerin sık tahsis ve boşaltmaları ile ilişkili gider ve parçalanmayı azaltır.
- **Eksileri**: Daha az esnektir, esas olarak sabit boyutlu tahsisler için uygundur.

### 7. Segmentasyon
- **Açıklama**: Belleği, kod, yığın ve veri segmentleri gibi bir işlemin mantıksal bölümlerine göre segmentlere ayırır.
- **Artıları**: İşlemin yapısına özgü bellek kullanımını verimli ve esnek bir şekilde sunar.
- **Eksileri**: Dış parçalanmaya yol açabilir.

### 8. Sayfalama
- **Açıklama**: Belleği sabit boyutlu sayfalara böler. Fiziksel bellek de aynı boyutta sayfa çerçevelerine bölünür ve sayfalar bu çerçevelere yüklenir.
- **Artıları**: Dış parçalanmayı azaltır ve bellek tahsisini basitleştirir.
- **Eksileri**: İç parçalanmaya yol açabilir ve sayfa eşleme için ek donanım desteği gerektirir.



## Görevlendirici tarafından kullanılan yapıların tanımı ve tartışılması

....

## Program yapısının ve bireysel modüllerin tanımı ve gerekçesi

...

## Görevlendiricinin tartışılması (bellek ve kaynak tahsisi dahil), eksiklikler ve olası iyileştirmeler - 5 puan
...

## FCFS yüksek öncelikli sıralayıcının çalışması (FCFS.java) - 5 puan

- FCFS Gercek zamanli prosesler icin kullanildi.
- Kuyrugun basindaki proses isleme sokuldu.
- Islem bitene kadar bekledi ve islem bittikten sonra bellegi geri iade etti.

## Kullanıcı Geri Beslemeli sıralayıcının çalışması (GBG.java) - 5 puan

- Eger Gercek Zamanli kuyruk bos ise calisir.
- Bos olmayan en yuksek oncelikli siralayici calisir.
- 1sn calisir ve proses zamanini azaltir ve prosesin onceligini dusurur.

## Kullanıcı Geri Beslemeli sıralayıcının Round Robin modunda çalışması (RR.java) - 5 puan

- Eger Gercek Zamanli kuyruk ve diger kullanici kuyruklari bos ise calisir.
- Diger kuyruklara proses gelene kadar kuyruktaki prosesleri isler.
- 

## Karışık sıralayıcı çalışması - 5 puan

- 

## Kaynak tahsisi - 30 puan

## Bellek yönetimi - 30 puan

