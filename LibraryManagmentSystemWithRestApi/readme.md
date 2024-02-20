## API Endpointleri

| Endpoint                     | Method | Açıklama                                       | Örnek Kullanım                                              |
|------------------------------|--------|------------------------------------------------|-------------------------------------------------------------|
| /api/authors                 | GET    | Tüm yazarları listeler.                        | GET http://localhost:8080/v1/authors?page=0&pageSize=10       |
| /api/authors/{id}            | GET    | Belirli bir yazarın detaylarını getirir.      | GET http://localhost:8080/v1/authors/1                      |
| /api/authors                 | POST   | Yeni bir yazar ekler.                          | POST http://localhost:8080/v1/authors                       |
| /api/authors/{id}            | PUT    | Belirli bir yazarın bilgilerini günceller.    | PUT http://localhost:8080/v1/authors/1                      |
| /api/authors/{id}            | DELETE | Belirli bir yazarı siler.                      | DELETE http://localhost:8080/v1/authors/1                   |
| /api/books                   | GET    | Tüm kitapları listeler.                        | GET http://localhost:8080/v1/books?page=0&pageSize=10        |
| /api/books/{id}              | GET    | Belirli bir kitabın detaylarını getirir.      | GET http://localhost:8080/v1/books/1                       |
| /api/books                   | POST   | Yeni bir kitap ekler.                          | POST http://localhost:8080/v1/books                        |
| /api/books/{id}              | PUT    | Belirli bir kitabın bilgilerini günceller.    | PUT http://localhost:8080/v1/books/1                       |
| /api/books/{id}              | DELETE | Belirli bir kitabı siler.                      | DELETE http://localhost:8080/v1/books/1                    |
| /api/bookborrowings          | GET    | Tüm kitap ödünç işlemlerini listeler.         | GET http://localhost:8080/v1/bookborrowings?page=0&pageSize=10 |
| /api/bookborrowings/{id}     | GET    | Belirli bir kitap ödünç işleminin detaylarını getirir. | GET http://localhost:8080/v1/bookborrowings/1          |
| /api/bookborrowings          | POST   | Yeni bir kitap ödünç işlemi oluşturur.        | POST http://localhost:8080/v1/bookborrowings              |
| /api/bookborrowings/{id}     | PUT    | Belirli bir kitap ödünç işleminin bilgilerini günceller. | PUT http://localhost:8080/v1/bookborrowings/1         |
| /api/bookborrowings/{id}     | DELETE | Belirli bir kitap ödünç işlemini siler.       | DELETE http://localhost:8080/v1/bookborrowings/1           |
| /api/publishers              | GET    | Tüm yayınevlerini listeler.                    | GET http://localhost:8080/v1/publishers?page=0&pageSize=10   |
| /api/publishers/{id}         | GET    | Belirli bir yayınevinin detaylarını getirir.  | GET http://localhost:8080/v1/publishers/1                 |
| /api/publishers              | POST   | Yeni bir yayınevi ekler.                       | POST http://localhost:8080/v1/publishers                   |
| /api/publishers/{id}         | PUT    | Belirli bir yayınevinin bilgilerini günceller.| PUT http://localhost:8080/v1/publishers/1                  |
| /api/publishers/{id}         | DELETE | Belirli bir yayınevini siler.                  | DELETE http://localhost:8080/v1/publishers/1               |
| /api/categories              | GET    | Tüm kategorileri listeler.                     | GET http://localhost:8080/v1/categories?page=0&pageSize=10   |
| /api/categories/{id}         | GET    | Belirli bir kategorinin detaylarını getirir.   | GET http://localhost:8080/v1/categories/1                 |
| /api/categories              | POST   | Yeni bir kategori ekler.                       | POST http://localhost:8080/v1/categories                   |
| /api/categories/{id}         | PUT    | Belirli bir kategorinin bilgilerini günceller.| PUT http://localhost:8080/v1/categories/1                  |
| /api/categories/{id}         | DELETE | Belirli bir kategoriyi siler.                  | DELETE http://localhost:8080/v1/categories/1               |
