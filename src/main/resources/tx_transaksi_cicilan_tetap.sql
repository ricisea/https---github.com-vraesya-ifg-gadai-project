-- DELETE tx_transaksi_cicilan_tetap table if exist
DROP TABLE IF EXISTS tx_transaksi_cicilan_tetap;

--CREATE tx_transaksi_cicilan_tetap table
CREATE TABLE tx_transaksi_cicilan_tetap (
    id VARCHAR(10) PRIMARY KEY NOT NULL,
    total_nilai_taksiran INT4 NULL,
    ltv Float(3) NULL,
    maks_nilai_pinjaman INT4 NULL,
    nilai_pencairan INT4 NOT NULL,
    biaya_admin INT4 NULL,
    diskon_admin Float(3) NOT NULL,
    biaya_admin_akhir Float(10) NULL,
    tanggal_transaksi TIMESTAMP NULL,
    tanggal_jatuh_tempo TIMESTAMP NULL,
    biaya_jasa_penyimpanan INT4 NULL,
    biaya_jasa_penyimpanan_periode INT4 NULL,
    total_biaya_penyimpanan INT4 NULL,
    biaya_admin_tutup INT4 NULL,
    total_pengembalian INT4 NULL,
    total_nilai_pinjaman INT4 NULL,
    customer_id VARCHAR(10) NULL,
    kode_produk VARCHAR(10) NULL,
    nama_produk VARCHAR(30) NULL,
    no_ktp VARCHAR(16) NULL,
    nama_pelanggan VARCHAR(50) NULL
    
)

WITH (
    OIDS=FALSE
);

--Query All data in tx_transaksi_cicilan_tetap table
SELECT * FROM tx_transaksi_cicilan_tetap;