-- DELETE tx_cicilan table if exist
DROP TABLE IF EXISTS tx_cicilan;

--CREATE tx_cicilan table
CREATE TABLE tx_cicilan (
    id VARCHAR(10) PRIMARY KEY NOT NULL,
    transaksi_id VARCHAR(10) NOT NULL,
    status_cicilan VARCHAR(30) NOT NULL
)

WITH (
    OIDS=FALSE
);

--Query All data in tx_cicilan table
SELECT * FROM tx_cicilan;