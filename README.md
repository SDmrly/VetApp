# VetApp
Spring, Jpa, Maven, Thymeleaf kullanılarak hazırlanmış basit veteriner uygulamasıdır. Windows ortamda JDK 17 sürümü kullanılarak geliştirilmiştir. 
Gerekli JDK sürümü kullanıldığı taktirde Ubuntu ortamlarda rahatlıkla geliştirilmeye çalıştırılmaya devam edilebilmektir.

##Kurulum

VetApp java kullanılarak geliştirilmiş bir uygulamadır. Çalıştırma ve geliştirmek için sisteminizde JDK ve JRE kurulu olmalıdır. Minimum Java SE 11 kullanılmalıdır.
Veritabanı olarak PostgreSQL kullandım ve veritabanı yedeğini `VetApp_PostgreSql_Backup` içerisinde verdim. Farklı bir veri tabanı kullanılmak istenirse 
`src/main/resources/application.properties` düzenleyebilirsiniz.

VetApp bağımlılıkların yönetilmesi ve inşa için Apache Maven kullanir. Kök dizindeki `mvnw` isimli betik projeyi çalışır hale getirmek için kullanilabilir.
`pom.xml` dosyasının bulunduğu kök dizin yoluna gidin. Örn: `cd C:\Users\Sinan Demiralay\Desktop\VetApp`

Windows ortamda derlemek için:

```
mvn package
```

Ubuntu ortamda derlemek için:

```
./mvnw package
```

Bu komut `pom.xml` dosyasini okuyarak bağımlılıkları indirir projeyi derler ve paketler ve aşağıdaki komutla çalıştırır:

Windows ortamda çalıştırmak için:

```
mvn spring-boot:run
```

Ubuntu ortamda çalıştırmak için:

```
./mvnw spring-boot:run
```

Programı çalıştırdıktan sonra tarayıcının adress çubuğuna `http://localhost:8080/` yazarak VetApp uygulamasını kullanıma başlanabilir.

## Uygulamanin Ozellikleri

Her bir kullanıcı sisteme kayıt olmalıdır ve iletişim bilgilerini doldurup güncelleyebilir,
n adet hayvan tanımı yapabilir hayvan bilgilerini güncelleyip silebilir.
Yönetici hakklarına sahip kullanıcılar kullanıcı bilgilerini güncelleyebilir kullanıcıları silebilir,
kullanıcıların tanımlamış oldukları hayvanları güncelleyebilir silebilir,
mevcut kullanıcı kayıtlarını kullanıcı adı, isim ve ya soyisim ile arama yapabilir,
mevcut hayvan kayıtlarını hayvan ismi, hayvan sahibi adı ve ya soyadı ile arama yapabilir.

Eğer PostgreSql veritabanı yedeğini kullanırsanır sisteme giriş için yönetici kullanıcı adı : `admin` ve şifre: `admin`



