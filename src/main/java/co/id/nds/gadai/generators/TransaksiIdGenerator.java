package co.id.nds.gadai.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TransaksiIdGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o) throws HibernateException {
        Connection connection = ssci.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) as seq FROM tx_transaksi_cicilan_tetap");

            ResultSet rs = ps.executeQuery();
            DateFormat dateFormat = new SimpleDateFormat("yyddmm");
            Date date = new Date();
            if (rs.next()) {
                int seq = rs.getInt("seq") + 1;
                String code = String.format("YYMM%02d", seq);
                String ctr = String.valueOf(dateFormat.format(date));
                System.out.println("GENERATED STOCK CODE: "+code+" "+ctr);
                return code;
            }

            else {
                throw new HibernateException("Generator is failed to generate id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return null;
    }
    
}

