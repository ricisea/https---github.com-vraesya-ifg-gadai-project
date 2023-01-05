package co.id.nds.gadai.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.id.nds.gadai.entities.TransaksiCicilanEntity;
import co.id.nds.gadai.exceptions.ClientException;
import co.id.nds.gadai.models.ResponseModel;
import co.id.nds.gadai.models.TransaksiCicilanModel;
import co.id.nds.gadai.services.TransaksiCicilanService;

@RestController
@RequestMapping("/transaksi")
public class TransaksiCicilanController {
    @Autowired
    private TransaksiCicilanService transaksiCicilanService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel> postTransaksiController(@RequestBody TransaksiCicilanModel transaksiCicilanModel) {
        try {
            //request
            TransaksiCicilanEntity transaksi = transaksiCicilanService.add(transaksiCicilanModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Request successfully");
            response.setDesc("Transaksi baru telah ditambahkan di sistem");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(transaksi);
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

    @GetMapping(value = "/doSearchTransCicTetap")
    public ResponseEntity<ResponseModel> searchTransaksiController(@RequestParam String customerId) {
        try {
            //request
            List<TransaksiCicilanEntity> transaksi = transaksiCicilanService.searchTransaksi(customerId);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Request successfully");
            response.setDesc("Pencarian transaksi berhasil ditampilkan");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            response.setData(transaksi);
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

}
