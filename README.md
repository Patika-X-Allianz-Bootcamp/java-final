# Sağlık Turizmi Uygulaması

Bu projede, Spring Boot kullanarak bir sağlık turizmi uygulaması geliştirdik. Bu uygulama, hastaların sağlık hizmetleri almak için farklı ülkelere veya bölgelere seyahat etmelerini kolaylaştırmayı amaçlar. Aşağıda, projenin temel bileşenlerini, kurulum talimatlarını ve kullanım yönergelerini bulacaksınız.

## Proje Oluşturma ve Temel Yapılandırma

Gerekli bağımlılıklar projeye eklenmiştir, bunlar arasında Web, JPA (Java Persistence API), PostgreSql driver, lombok ve spring security bulunmaktadır.
## Veritabanı Modelleme

Uygulama için temel varlıklar JPA kullanılarak modelleme yapıldı. Bu varlıklar şunları içerir: hastalar, doktorlar, oteller, otel odaları, otel odası rezervasyonları, uçuş bilgileri(flight), randevular(appointment) vb.

Varlıklar arasındaki ilişkiler, JPA ilişki annotasyonları kullanılarak tanımlandı.

## RESTful API Oluşturma

Controller sınıfları oluşturularak API endpoint'leri tanımlandı. Bu endpoint'ler, CRUD temel işlevlerini sağlar.

Servis sınıflarında JPA kullanılarak veritabanı işlemleri gerçekleştirildi.

Service sınıfları, iş mantığını controller'dan ayırarak oluşturuldu, Reservation ve Appointment servisi için 10dk içerisinde onaylama zorunluluğu @Schedule anotasyonu ile eklendi, 10dk içerisinde ödenmiştir veya onaylanmıştır bilgisi gelmez ise yaratılan rezervasyon ve appointment kendi kendini otomatik silecektir.

## Güvenlik ve Yetkilendirme
Spring Security kullanılarak kullanıcı kimlik doğrulaması ve yetkilendirme işlemleri gerçekleştirildi. JWT token tabanlı kimlik doğrulama kullanıldı.

Rol bazlı erişim kontrolü sağlamak için güvenlik konfigürasyonları oluşturuldu.

Kullanıcı rolleri tanımlandı, Admin, User, Patient kullanıcıları tanımlandı

- User: otel, otel odası, uçak bilgileri, hastane ve doktor bilgilerine erişebilir
- Patient: ayrıca reservation ve appointment metodlarına erişebilir
şekilde konfigüre edildi.

## Kurulum

Proje yerel geliştirme ortamınızda çalıştırmak için aşağıdaki adımları izleyin:

Projeyi bilgisayarınıza klonlayın: 
```
git clone https://github.com/sizin-proje-repo-linkiniz.git
```

Projeyi IDE'nizde açın.

Veritabanı bağlantı ayarlarınızı yapılandırın.

Uygulamayı çalıştırmak için IDE'nizin çalıştırma komutunu kullanın veya aşağıdaki komutu terminalde çalıştırın:
```
shell
Copy code
mvn spring-boot:run
```

Uygulama başarıyla çalıştığında, tarayıcınızdan ***[link]http://localhost:8080*** adresine giderek uygulamayı kullanabilirsiniz.