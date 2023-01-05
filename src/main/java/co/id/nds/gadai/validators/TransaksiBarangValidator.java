package co.id.nds.gadai.validators;

import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;

public class TransaksiBarangValidator {
    public void nullCheckBarangId(Integer id) throws ClientException {
        if (id == null) {
            throw new ClientException("Id Barang dibutuhkan!");
        }
    }

    public void notNullCheckBarangId(Integer id) throws ClientException {
        if (id != null) {
            throw new ClientException("Id Barang sudah auto generated, jangan masukkan id");
        }
    }

    public void nullCheckName(String namaBarang) throws ClientException {
        if (namaBarang == null) {
            throw new ClientException("Nama Barang tidak boleh kosong");
        }
    }

    public void nullCheckJml(Integer jumlah) throws ClientException{
        if (jumlah == null) {
            throw new ClientException("Jumlah barang tidak boleh kosong");
        }
    }

    public void nullCheckHarga(Float hargaSatuan) throws ClientException {
        if (hargaSatuan == null) {
            throw new ClientException("harga barang satuan tidak boleh kosong");
        }
    }

    public void nullCheckObject(Object o) throws NotFoundException{
        if (o == null) {
            throw new NotFoundException("Barang is not found!");
        }
    }

    public void validateBarangId(Integer id) throws ClientException {
        if (id <= 0) {
            throw new ClientException("Id barang is invalid");
        }
    }

    public void validateName(String namaBarang) throws ClientException {
        if(namaBarang.trim().equalsIgnoreCase("")) {
            throw new ClientException("Nama Barang is required");
        }
    }

    public void validateJml(Integer jumlah) throws ClientException {
        if(jumlah < 0) {
            throw new ClientException("Jumlah barang harus bernilai positif");
        }
    }

    public void validateHarga(Float hargaSatuan) throws ClientException{
        if(hargaSatuan < 0) {
            throw new ClientException("Harga satuan barang harus bernilai positif");
        }
    }

    public void validateTotal(Float total) throws ClientException {
        throw new ClientException("Total tidak boleh diisi");
    }
}
