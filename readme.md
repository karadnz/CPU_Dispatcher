# Isletim Sistemleri Odevi - Grup 38

## Dersi verenler
- Dr.Öğr.Üyesi Abdullah SEVİN
- Prof.Dr. Ahmet ZENGİN

## Grup uyeleri - Grup 38
- 2B - G211210066 - Mustafa KARADENİZ
- 2B - G211210042 - Mustafa Haci BARAN
- 2C - G201210076 - Muhammet Efdal ŞAHİN
- 2C - G221210382 - Yetgin AKCAN
- 1B - B231210501 - Necmi ERTÜRK

## Dispatcher Nedir?

Dispatcher, işletim sisteminin bir parçası olarak, CPU'ya hangi işlem veya iş parçacığının ne zaman ve ne kadar süreyle erişeceğini kontrol eden bir sistemdir. İşletim sisteminin CPU kullanımını yöneten temel bir programdır. Dispatcher'ın ana görevleri şunlardır:

### Ana Görevler
1. **CPU Zamanlaması**: 
   - Hazır kuyruğundaki işlemler arasından bir sonraki çalıştırılacak işlemi seçer.
   - Seçim, sistemin zamanlama algoritmasına göre yapılır (örn. Round Robin, First-Come First-Served).

2. **Kontekst Değişimi**: 
   - Bir işlemin CPU kullanımını sonlandırdığında veya kesintiye uğradığında, dispatcher işlemin durumunu kaydeder ve yeni seçilen işlemin durumunu yükler.
   - Bu süreç "kontekst değişimi" olarak bilinir ve CPU'nun farklı işlemler arasında hızlı geçiş yapmasını sağlar.

3. **Kaynak Yönetimi**: 
   - İşlemci, bellek ve giriş/çıkış gibi sistem kaynaklarının verimli kullanımını sağlar.

Dispatcher, işlemcinin verimli ve etkin bir şekilde kullanılmasını sağlayarak işletim sisteminin çoklu görev kabiliyetinin temelini oluşturur. Bu, hem sistem performansını artırır hem de kullanıcılara birden fazla uygulamanın eş zamanlı olarak çalıştığını hissettirir.


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

Bizim projemizde ise zamani gelen prosesler once onceliklerine gore siralanirlar. Daha sonra ise ayni oncelige sahip olanlar arasinda az bellek isteyenden cok bellek isteyene gore siralanirlar. Boylelikle kuyruga daha fazla proses alinabilir.

## Görevlendirici tarafında kullanılan yapılar ve gerekçeleri

- **Liste ve dizi Listesi**: proseslerin bilgilerini tutmak için ve zamanı gelen prosesleri tutmak için kullanıldı.
- **Kuyruk ve bağlı liste**: gerçek zamanlı ve kullanıcı zamanlı proseslerinin “hazır” olanlarını tutmak için kullanıldı. Gerçek zamanlı kuyruktan 1 tane ve kullanıcı zamanlı proseslerden 3 tane oluşturulup kullanıldı.
- **İterator**: 3 farklı yerde kullanıldı. Kullanılmasının sebebi doğrudan liste ve kuyruklardan üzerinden eleman kaldırma işleminde eşzamanlılık hatası veriyordu.

## Program yapısının ve bireysel modüllerin tanımı ve gerekçesi

- **Proses.java**: Prosesin bilgilerini ve durumlarini yazdiran fonksiyonlari bulunduran sinif.
- **BeklemeListesi.java**: Dosyadan prosesleri okuyan ve listede tutan sinif.
- **Gorevlendirici.java**: Kaynaklari/bellekleri guncelleyen, kaynak/bellek kontrolu yapan, proseslere gereken kaynaklari/bellekleri atayan, zamani gelen prosesleri bulan ve uygun kuyruklara atayan sinif.
- **FCFS.java**: Gercek zamanli prosesleri calistiran kuyruklarin uzerinde islem yapan sinif.
- **GBG.java**: Kullanici proseslerini calistiran kuyruklarin uzerinde islem yapan sinif.
- **RR.java**: En dusuk oncelikli kuyrugu RoundRobin calistiran sinif.

## Görevlendiricinin eksiklikleri ve olası iyileştirmeler

- Bellegin yani sira kaynaklara ve calisma zamanina gore de siralama eklenebilir.
- 20sn kurali prosesin gelme suresinden ziyade cpu da gecirdigi sureye gore uygulanabilir.

## Kuyruk ozellikleri
### FCFS.java

- FCFS Gercek zamanli prosesler icin kullanildi.
- Kuyrugun basindaki proses isleme sokuldu.
- Islem bitene kadar bekledi ve islem bittikten sonra bellegi geri iade etti.

### GBG.java

- Eger Gercek Zamanli kuyruk bos ise calisir.
- Bos olmayan en yuksek oncelikli siralayici calisir.
- 1sn calisir ve proses zamanini azaltir ve prosesin onceligini dusurur.

### RR.java

- Eger Gercek Zamanli kuyruk ve diger kullanici kuyruklari bos ise calisir.
- Diger kuyruklara proses gelene kadar kuyruktaki prosesleri isler.

## Diger Isletim sistemleriyle karsilastirma

Hem Linux hem de Windows'ta, işletim sisteminin çekirdeği, daha sonra hangi işlemin yürütüleceğini seçmekten sorumlu olan bir görevlendirici içerir. Bir işlem çalışmaya hazır olduğunda, hazır işlemler kuyruğuna alınır. Görevlendirici, kuyruğun önündeki işlemi seçer ve CPU'yu bu işleme tahsis eder. Bu işlem, yürütmeyi bitirene veya bazı kaynakları beklerken bloke edilene kadar devam eder. İşlem yürütmeyi bitirdiğinde veya bloke edildiğinde, dağıtıcı kuyruktaki bir sonraki işlemi seçer ve CPU'yu buna tahsis eder.
Linux ve Windows çekirdekleri arasındaki temel farklardan biri, Linux'un tamamen önleyici bir zamanlayıcı kullanmasıdır; bu, çekirdeğin, CPU'yu farklı bir işleme vermek için herhangi bir zamanda çalışan bir işlemi kesebileceği anlamına gelir. Buna karşılık, Windows çekirdeği yalnızca kısmen önleyicidir, yani bir işlemi yalnızca belirli koşullar altında, örneğin
işlemin bir sistem çağrısını engellemesi veya işlemin kendisine ayrılan zaman dilimini kullanması durumunda kesintiye uğratabileceği anlamına gelir.
Linux ve Windows tarafından kullanılan zamanlama algoritmalarında da farklılıklar vardır. Linux, Tamamen Adil Zamanlayıcı (CFS) ve Round Robin Zamanlayıcı dahil olmak üzere çeşitli zamanlama algoritmaları kullanırken Windows, önceliğe dayalı zamanlama ve zaman dilimlemenin bir kombinasyonunu kullanır.
Bununla beraber bizim yazdığımız Dispatcher sınıfı, varış zamanı geçen süreye eşit ya da daha az olan proseslerin kaynaklarına ve belleğine bakıyor eğer donanımın herhangi bir prosese kaynak ayırmamış halindeki kaynaktan daha büyükse prosesi iptal ediyor. ama eğer MAX kaynak ve bellekten daha az ise ama mevcut kaynak ve bellek boş değilse o zaman kaynağın boşalmasını bekleyecek. eğer gerçek zamanlı bir proses ise sadece bellek uygunluğuna bakılır ve herhangi bir kaynağa ihtiyaç duymaz.kaynak ve bellek yeterliyse öncelliğine göre ilgili kuyruğa eklenir.
kuyrukların çalışmasında bir hiyerarşi mevcuttur. eğer gerçek zamanlı proseslerin tutulduğu kuyruk boş değil ise her zaman burası çalışır, eğer mevcut çalışan kullanıcı zamanlı proses varsa kesintiye uğrarar ve gerçek zamanlı kuyruktaki prosesin bitmesini bekler. gerçek zamanlı prosesler, proses bitene kadar çalışır. 
kullanıcı zamanlı kuyrukda da önceliğe göre 3 kuyruğa ayrılmıştır. kuyruklardaki prosesler 1 saniye çalışır ve eğer bitmişse kaynakları ve belleği iade edilir. eğer bitmediyse önceliği ve çalışma süresi 1 azaltılır. eğer  kullanıcı zamanlı 1 ve 2 öncelikli kuyruk boş ise ve kullanıcı zamanlı 3 öncellikli kuyruk dolu ise o zaman burada basit bir çevrimsel RR çalışır. 1 saniye prosesi işler ve kuyruğun sonuna atar. eğer daha yüksek öncelikli bir kuyruğa proses gelirse o zaman öncelikli kuyruk çalışır.
varış zamanı ile birlikte aktif olan bulunma zamanı 20 saniyeyi aşarsa proses iptal edilir ve eğer kaynakları ve bellekleri varsa iade edilir.
tüm kuyruklar boş ve kuyruğa yerleşmeyen prosesleri tutan liste boş olursa görevlendirici sonlanır

