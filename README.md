#Zadanie:    
  
1. Stworzyć 3 widgety jak na [img.png] Nazywają się `OrderWidget` i wewnętrznie rozpoznają swój rozmiar, wykorzystaj go i wyświetl ten, który należy  
2. Long press na widgetcie zaznacza go, tworzy do dookoła niego czarny border o szerokości 2.dp, informacja o tym powinna trafic do Viewmodelu  
3. Ikonka (i) ma dwa stany, ma informacje lub nie - wykorzystaj Materialowe ikonki, które będą pasować, jedną filled, drugą outlined  

#Wskazówki
- Jeśli jakieś elementy miałyby zająć Ci za dużo czasu - pomiń je, omówimy je później.  
- Skup się najpierw na jednym wariancie (najlepiej tym z prawej strony), potem dodaj kolejne  
- Font możesz użyć domyślny  
- Nie jest konieczne ukończenie wszystkiego - mnie interesuje to jak pracujesz, jeśli zrobisz wszystko to dobrze, jeśli nie, opowiesz dlaczego.  
- Wykonanie elementu na samym preview też jest ok, pod warunkiem, że będzie uwzględniał potrzeby viewmodelu (select trzymany w viewmodelu)  
- W każdym miejscu gdzie brakuje jakichś assetów lub rozmiarów zrób tak żeby wyglądało w miare ok korzystając z tego co masz  
- Możesz wykorzystać domyślny theme, zamiast jasnego zielonego możesz użyć accent, czy co innego będzie względnie czytelne
- Walutę możesz trzymać zawsze z tej samej strony, najlepiej zgodnie z wybranym Locale Twojeg urządzenia

Zadanie sklecone na szybko, w razie problemów proszę o kontakt od razu, spróbujemy naprawić.

#Poniżej specyfikacja UI:

##Wymiary:
Duży : 327x202
Średni: 254x136
Mały: 393x59

##Widget duży i średni - padding sekcji górnej
- 10.dp do krawędzi
- Nazwa orderu wycentrowana pomiędzy górną sekcją z danymi orderu a dolną jej krawędzią
- Cena wycentrowana w dolnej części
- Wszystkie teksty mają max 1 linijke
- Marginesy między elementami (jeśli są) - Horizontal 5.dp, vertical 8.dp

###Mały widget:
- lewa sekcja padding do krawędzi 8.dp
- Marginesy między elementami (jeśli są) - Horizontal 5.dp, vertical 8.dp


##Fonty:
Duży widget:
Male teksty 16.sp, bold
Duże 24.sp, bold

##Średni widget
Małe teksty: 14.sp, bold
Duże 24.sp, bold

##Mały widget
Lewa sekcja:
Duży: 20.sp, bold
Mały: 14.sp, Medium
Prawa sekcja:
Duży: 20.sp, Medium
Mały: 12.sp, Medium