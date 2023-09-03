# java-final


# Sağlık Turizmi Uygulaması - meliorator

Bu Spring Boot tabanlı sağlık turizmi uygulaması, hastaların sağlık hizmetlerini düzenlemelerine ve
tıbbi tedavi almak için seyahat planları yapmalarına yardımcı olmak amacıyla tasarlanmıştır. Uygulama,
Java programlama dilinde geliştirilmiş olup çeşitli Spring Boot bağımlılıklarını kullanmaktadır. Uygulama
başlatılabilir ve web tarayıcınızdan http://localhost:8082 adresinde erişebilirsiniz.

##Bağımlılıklar
Proje aşağıdaki ana bağımlılıkları kullanmaktadır:

- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- Postgresql
- Mapstruct
- Webmvc-ui
- Java-jwt
- Configuration-processor
- Spring Security
## Kurulum

Projeyi GitHub deposundan klonlayın veya indirin.

Projeyi tercih ettiğiniz Entegre Geliştirme Ortamı (IDE) kullanarak açın, örneğin IntelliJ IDEA veya Eclipse.

## Veritabanı Yapılandırması
Proje  Postgresql veritabanı kullanılarak geliştirilmiştir. Veritabanı yapılandırması,
src/main/resources dizininde bulunan application.properties dosyasında özelleştirilebilir.
Bunun için şu kodun en sonuna
spring.datasource.url=jdbc:postgresql://localhost:5432/
database adı eklemeniz yeterlidir.Eğer port ayarınız default değilse bunu da değiştirmeyi unutmayın.

## Uygulamayı Çalıştırma
Uygulamayı IDE'nizde çalıştırabilir veya projenin kök dizininde aşağıdaki komutu çalıştırarak başlatabilirsiniz:

./mvnw spring-boot:run
veya

mvn spring-boot:run
Bu komut, Spring Boot uygulamanızı başlatacaktır.

API Belgelendirmesi
API belgelendirmesine http://localhost:8082/swagger-ui.html adresinden erişilebilir. Bu belge, mevcut uç noktalar
hakkında kapsamlı bilgiler ve nasıl kullanılacakları hakkında detaylı bilgiler sunar.

Güvenlik
Proje, rol tabanlı erişim kontrolü ve güvenlik için JWT kimlik doğrulamasını içerir. Güvenlik yapılandırmasını
com.allianz.meliorator.configuration paketinde bulunan SecurityConfiguration sınıfında daha da özelleştirebilirsiniz.

Ek Özellikler
Bu proje, hastaların doktorlara atanması, hasta randevu ve sağlık hizmeti yönetimi, doktor-hasta muayene kaydı
oluşturma ve hastane ve doktor randevularına dayalı seyahat planlaması gibi çeşitli özelliklerin uygulanması için
bir temel olarak hizmet verir. Projeyi belirli gereksinimleri karşılamak için keşfetmekte ve geliştirmekte özgürsünüz.
