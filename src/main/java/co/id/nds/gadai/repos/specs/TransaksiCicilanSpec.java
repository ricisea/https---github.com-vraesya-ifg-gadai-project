package co.id.nds.gadai.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import co.id.nds.gadai.entities.TransaksiCicilanEntity;
import co.id.nds.gadai.models.TransaksiCicilanModel;

public class TransaksiCicilanSpec implements Specification<TransaksiCicilanEntity>{

    private TransaksiCicilanModel transaksiCicilanModel;

    public TransaksiCicilanSpec(TransaksiCicilanModel transaksiCicilanModel) {
        super();
        this.transaksiCicilanModel = transaksiCicilanModel;
    }

    @Override
    public Predicate toPredicate(Root<TransaksiCicilanEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        
        Predicate p = cb.disjunction();

        //id criteria
        if (transaksiCicilanModel.getId() != null && transaksiCicilanModel.getId() != "") {
            p.getExpressions().add(cb.equal(root.get("id"), transaksiCicilanModel.getId()));
        }

        //name criteria
        if (transaksiCicilanModel.getNamaProduk() != null && transaksiCicilanModel.getNamaProduk().length() > 0) {
            p.getExpressions().add(cb.like(cb.lower(root.get("name")), "%" + transaksiCicilanModel.getNamaProduk().toLowerCase() + "%"));
        }

        cq.orderBy(cb.asc(root.get("id")));

        return p;
    }
}
