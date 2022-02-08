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



![Ekran görüntüsü 2022-02-08 175614](https://user-images.githubusercontent.com/68161748/153050778-dc692132-c6c5-4b6f-a275-8ed6286547a1.png)
![Ekran görüntüsü 2022-02-08 175637](https://user-images.githubusercontent.com/68161748/153050810-beace05a-9484-4cce-8eef-a6aea3d15bc9.png)
![Ekran görüntüsü 2022-02-08 175700](https://user-images.githubusercontent.com/68161748/153050823-1102a8c5-fc1e-4b78-8d07-3afe53296ec1.png)
![Ekran görüntüsü 2022-02-08 180255](https://user-images.githubusercontent.com/68161748/153050834-498859e2-c774-4297-a5d6-c39d1499bb32.png)
![Ekran görüntüsü 2022-02-08 180336](https://user-images.githubusercontent.com/68161748/153050861-2bef5f99-db9d-4400-a179-a71f8fb3805a.png)
![Ekran görüntüsü 2022-02-08 180353](https://user-images.githubusercontent.com/68161748/153050866-4e079ebf-bece-43c2-8f2e-620aeb4f6a79.png)
![Ekran görüntüsü 2022-02-08 180425](https://user-images.githubusercontent.com/68161748/153050871-16155f0c-4993-4a60-9493-9cb2a6c02628.png)
![Ekran görüntüsü 2022-02-08 180504](https://user-images.githubusercontent.com/68161748/153051012-19168582-391c-46d1-ad44-0b76dce0f47f.png)
![Ekran görüntüsü 2022-02-08 180555](https://user-images.githubusercontent.com/68161748/153051024-cd9e9fbc-dfcb-4b73-a64f-951555fb7773.png)
![Ekran görüntüsü 2022-02-08 180628](https://user-images.githubusercontent.com/68161748/153051032-70f93dd1-7a45-4760-a7f1-244aa8dcacf0.png)
![Ekran görüntüsü 2022-02-08 180652](https://user-images.githubusercontent.com/68161748/153051041-10eda2c9-b243-4bea-92e5-8574ac519645.png)



