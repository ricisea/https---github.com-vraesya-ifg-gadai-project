-- DELETE tx_transaksi_barang table if exist
DROP TABLE IF EXISTS tx_transaksi_barang;

--CREATE tx_transaksi_barang table
CREATE TABLE tx_transaksi_barang (
    id SERIAL PRIMARY KEY NOT NULL,
    nama_barang VARCHAR(30) NOT NULL,
    deskripsi VARCHAR(100) NULL,
    jumlah INT4 NOT NULL,
    harga_satuan Float(10) NOT NULL,
    total Float(10) NOT NULL
)

WITH (
    OIDS=FALSE
);

--Query All data in tx_transaksi_barang table
SELECT * FROM tx_transaksi_barang;