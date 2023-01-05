-- DELETE ms_pelanggan table if exist
DROP TABLE IF EXISTS ms_pelanggan

--CREATE ms_pelanggan table
CREATE TABLE ms_pelanggan (
    id VARCHAR(10) PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    no_ktp VARCHAR(16) NOT NULL,
    no_hp VARCHAR(50) NULL,
    jenis_kelamin VARCHAR(1) NOT NULL,
    jenis_usaha VARCHAR(20) NOT NULL,
    max_limit_pinjaman INTEGER NOT NULL,
    deleted_date TIMESTAMP NULL,
    deleter_id INT4 NULL,
    rec_status VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)

WITH (
    OIDS=FALSE
);

--Query All data in ms_pelanggan table
SELECT * FROM ms_pelanggan;