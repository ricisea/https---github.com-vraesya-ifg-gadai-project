package co.id.nds.gadai.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import co.id.nds.gadai.entities.PelangganEntity;
import co.id.nds.gadai.globals.GlobalConstant;
import co.id.nds.gadai.models.PelangganModel;

public class PelangganSpec implements Specification<PelangganEntity>{

    private PelangganModel pelangganModel;

    public PelangganSpec(PelangganModel pelangganModel) {
        super();
        this.pelangganModel = pelangganModel;
    }

    @Override
    public Predicate toPredicate(Root<PelangganEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        
        Predicate p = cb.disjunction();

        //id criteria
        if (pelangganModel.getId() != null && pelangganModel.getId() != "") {
            p.getExpressions().add(cb.equal(root.get("id"), pelangganModel.getId()));
        }

        //name criteria
        if (pelangganModel.getName() != null && pelangganModel.getName().length() > 0) {
            p.getExpressions().add(cb.like(cb.lower(root.get("name")), "%" + pelangganModel.getName().toLowerCase() + "%"));
        }

        // rec_status_criteria
        if (pelangganModel.getRecStatus() != null && (pelangganModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_ACTIVE) || pelangganModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE))) {
            p.getExpressions().add(cb.equal(cb.upper(root.get("recStatus")), pelangganModel.getRecStatus().toUpperCase()));
        }

        cq.orderBy(cb.asc(root.get("id")));
        return p;
    }
    
}
