# Sağlık Turizmi Projesi

Bu proje, sağlık turizmi alanında randevu oluşturma ve rezervasyon yapma işlemlerini kolaylaştırmak için geliştirilmiş bir Spring Boot uygulamasıdır.

## Başlarken

Projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları izleyin.

### Gereksinimler

Projeyi çalıştırmak için aşağıdaki yazılımlara ihtiyacınız vardır:

- Java JDK (en az 17 sürümü)
- Maven
- Bir PostgreSQL veritabanı

### Kurulum

1. Proje deposunu klonlayın:

   ```bash
   git clone https://github.com/karakuscem/health-tourism.git
    ```
2. PostgreSQL veritabanınızı oluşturun.
3. `application.properties` dosyasını düzenleyin. Veritabanı bağlantı bilgilerinizi girin ve jwt.secret için bir değer atayın.
4. Uygulamayı çalıştırın:

   ```bash
   mvn spring-boot:run
   ```
5. Uygulamayı test etmek için Postman veya benzeri bir araç kullanın.

### Örnek Kullanım

1. Uygulamayı çalıştırdıktan sonra, `http://localhost:8080/swagger-ui.html` adresine gidin.
2. `auth-controller` altındaki `/auth/register` endpoint'ini kullanarak bir kullanıcı oluşturun.
3. `auth-controller` altındaki `/auth/login` endpoint'ini kullanarak oluşturduğunuz kullanıcı ile giriş yapın.
4. `doctor-controller` altındaki `/doctor` endpoint'ini kullanarak doktorları listeyin.

## Kullanılan Teknolojiler

- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Swagger
- Lombok

