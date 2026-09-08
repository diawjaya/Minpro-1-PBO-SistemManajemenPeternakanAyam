Filenya berada di branch master

# Sistem Manajemen Peternakan Ayam

Program sederhana berbasis Java untuk mengelola data peternakan ayam. Program menggunakan beberapa class, yaitu Kandang, JenisAyam, Pakan, dan PemberianPakan. Data
disimpan menggunakan ArrayList dan dikelola melalui menu yang tersedia pada program.

Data Kandang dan Jenis Ayam merupakan data awal yang hanya dapat ditampilkan, sedangkan data Pakan dan Pemberian Pakan dapat ditambah, ditampilkan, diubah, dan
dihapus. Program juga menyediakan fitur penghitungan total ayam, kapasitas kandang, stok pakan, jumlah pemberian pakan, dan sisa pakan.

# Alur Penggunaan

### Fitur dan Alur Penggunaan Program

Program memiliki beberapa fitur utama yang dapat digunakan melalui menu utama:

1. **Data Kandang**
   Menampilkan data kandang yang sudah tersedia, seperti ID kandang, nama kandang, kapasitas, jumlah ayam, jenis ayam, dan kebutuhan pakan. Data kandang merupakan data awal sehingga hanya dapat dilihat oleh pengguna dan tidak dapat ditambah, diubah, maupun dihapus.

2. **Data Jenis Ayam**
   Menampilkan data jenis ayam yang tersedia beserta ID jenis, nama jenis, dan umur panen. Data ini merupakan data awal dan bersifat read-only sehingga pengguna hanya dapat melihat informasi yang tersedia.

3. **Data Pakan**
   Fitur ini digunakan untuk mengelola persediaan pakan yang digunakan dalam peternakan. Pada menu ini terdapat beberapa operasi:

   * **Tambah**, digunakan untuk memasukkan data pakan baru dengan mengisi ID pakan, nama pakan, dan jumlah stok.
   * **Tampilkan**, digunakan untuk melihat seluruh data pakan yang tersimpan beserta ID, nama, dan jumlah stok dalam kilogram.
   * **Ubah**, digunakan untuk mengubah nama pakan dan jumlah stok berdasarkan ID pakan yang dipilih. ID pakan tidak diubah agar tetap menjadi identitas data.
   * **Hapus**, digunakan untuk menghapus data pakan berdasarkan ID pakan.

   Setiap data pakan yang ditambahkan akan disimpan ke dalam `ArrayList` dan dapat dikelola kembali melalui menu yang tersedia.

4. **Pemberian Pakan**
   Fitur ini digunakan untuk mencatat dan mengelola aktivitas pemberian pakan kepada ayam. Data yang dicatat meliputi ID pemberian, jumlah pakan, tanggal pemberian, dan waktu pemberian. Pada menu ini terdapat beberapa operasi:

   * **Tambah**, digunakan untuk mencatat pemberian pakan baru dengan memasukkan ID, jumlah pakan dalam kilogram, tanggal, dan waktu pemberian.
   * **Tampilkan**, digunakan untuk melihat seluruh riwayat pemberian pakan yang telah tersimpan.
   * **Ubah**, digunakan untuk memperbarui jumlah pakan, tanggal, atau waktu pemberian berdasarkan ID pemberian.
   * **Hapus**, digunakan untuk menghapus catatan pemberian pakan berdasarkan ID pemberian.

   Dengan fitur ini, pengguna dapat menyimpan beberapa catatan pemberian pakan dan mengelolanya sesuai kebutuhan.

5. **Penghitungan**
   Fitur ini digunakan untuk menghitung dan menampilkan ringkasan data peternakan berdasarkan data yang tersimpan. Program melakukan beberapa perhitungan, yaitu:

   * **Total Ayam**, menghitung jumlah seluruh ayam dari semua kandang.
   * **Total Kapasitas**, menghitung jumlah kapasitas dari seluruh kandang yang tersedia.
   * **Total Stok Pakan**, menghitung seluruh stok pakan dari setiap data pakan.
   * **Total Pemberian Pakan**, menghitung seluruh jumlah pakan yang tercatat pada data pemberian pakan.
   * **Sisa Pakan**, menghitung sisa pakan dengan mengurangi total stok pakan dengan total pemberian pakan.

   Hasil penghitungan ditampilkan secara langsung ketika pengguna memilih menu Penghitungan.

6. **Keluar Program**
   Digunakan untuk mengakhiri program. Setelah pengguna memilih menu keluar, program akan berhenti dan kembali ke sistem.
