# Testy automatyczne na potrzeby pracy licencjackiej napisane przez Jakub Duda
Testy napisane są w języku Javie. 
Projekt korzysta z Maven.
Użyto wzorców Page Object Pattern oraz Page Factory. 
- Klasy testujące są zlokalizowane w src > test > java
- Klasy kodu produkcyjnego są zlokalizowane w src > main > java

# Wymagania
Aby uruchomić testy automatyczne należy mieć:
- zainstalowaną jave
- zainstalowany maven
- ściągnięty chromedriver.exe (umieszczony w lokalizacji C:/Chromedriver/chromedriver.exe)

# Dane wejściowe
Dane wejściowe należy przygotować w pliku o ścieżce src > test > resources > local.properities
zgodnie z instrukcją podaną w pracy magisterskiej

# Sposób użycia
Aby uruchomić testy:
- można puścić pojedynczy test lub klasę testującą przy użyciu IDE

# Profile
W projekcie używane są profile do odpalania specyficznych konfiguracji:
- environment:  environmentQA
- test groups: allTests, non-invasiveTests, default (gdy profil niepodany odpali się default)
- browsers: chrome, firefox, remoteChrome, remoteFirefox (profil wymagany)



