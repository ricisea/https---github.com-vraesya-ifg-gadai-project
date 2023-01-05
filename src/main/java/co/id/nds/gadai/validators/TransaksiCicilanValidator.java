package co.id.nds.gadai.validators;

import org.springframework.beans.factory.annotation.Autowired;

import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;
import co.id.nds.gadai.models.PelangganModel;
import co.id.nds.gadai.models.TransaksiCicilanModel;

public class TransaksiCicilanValidator {

    public void nullCheckTransaksiId(String id) throws ClientException {
        if (id == null) {
            throw new ClientException("Id Transaksi dibutuhkan");
        }
    }

    public void notNullCheckTransaksiId(String id) throws ClientException {
        if (id != null) {
            throw new ClientException("Id Transaksi sudah auto generated, jangan masukkan id");
        }
    }

    public void nullCheckObject(Object o) throws NotFoundException {
        if (o == null) {
            throw new NotFoundException("Product is not found!");
        }
    }

    public void validateTransaksiId(String id) throws ClientException {
        if (id.length() != 6 || !id.startsWith("YYMM")) {
            throw new ClientException("Id transaksi tidak valid");
        }
    }

}
