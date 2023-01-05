package co.id.nds.gadai.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PelangganIdGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o) throws HibernateException {
        Connection connection = ssci.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) as seq FROM ms_pelanggan");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int seq = rs.getInt("seq") + 1;
                String code = String.format("YYMM%06d", seq);
                System.out.println("GENERATED STOCK CODE: "+code);
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
