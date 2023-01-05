package co.id.nds.gadai.controllers;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.id.nds.gadai.entities.TransaksiBarangEntity;
import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.exceptions.NotFoundException;
import co.id.nds.gadai.models.ResponseModel;
import co.id.nds.gadai.models.TransaksiBarangModel;
import co.id.nds.gadai.services.TransaksiBarangService;

@RestController
@RequestMapping("/barang")
public class TransaksiBarangController {
    @Autowired
    private TransaksiBarangService transaksiBarangService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel> postBarangController(@RequestBody TransaksiBarangModel transaksiBarangModel){
        try {
            //request
            TransaksiBarangEntity barang = transaksiBarangService.add(transaksiBarangModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Barang berhasil ditambahkan");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setDesc("Sukses menambahkan barang");
            response.setData(barang);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseModel> putBarangController(@RequestBody TransaksiBarangModel transaksiBarangModel) {
        try {
            //request
            TransaksiBarangEntity barang = transaksiBarangService.edit(transaksiBarangModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Barang berhasil diubah");
            response.setDesc("Suksess merubah data");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(barang);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        
        } catch (NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {
             ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseModel> deleteBarangControlle(@RequestBody TransaksiBarangModel transaksiBarangModel) {
        try {
            //request
            TransaksiBarangEntity barang = transaksiBarangService.delete(transaksiBarangModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Barang berhasil dihapus");
            response.setDesc("Suksess menghapus data");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(barang);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        
        } catch (NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {
             ResponseModel response = new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
