package com.allianz.healthtourismagency.database.specification;

import com.allianz.healthtourismagency.database.entity.AppointmentEntity;
import com.allianz.healthtourismagency.database.entity.DoctorEntity;
import com.allianz.healthtourismagency.util.BaseSpecification;
import com.allianz.healthtourismagency.util.SearchCriteria;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorSpecification extends BaseSpecification<DoctorEntity> {
    private List<SearchCriteria> criteriaList;

    public List<SearchCriteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public Predicate toPredicate(Root<DoctorEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : criteriaList) {

            Predicate predicate = null;

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                predicate = criteriaBuilder.greaterThan(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                predicate = criteriaBuilder.lessThan(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase(">=")) {
                predicate = criteriaBuilder.greaterThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
                predicate = criteriaBuilder.lessThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("=")) {
                if (criteria.getKey().equals("appointment")){
                    Join<AppointmentEntity, DoctorEntity> joinCategory = root.join("appointmentList");
                    predicate= criteriaBuilder.equal(joinCategory.get("date"), criteria.getValue());
                }else{
                    predicate = criteriaBuilder.equal(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
                }
            } else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    predicate = criteriaBuilder.like(
                            criteriaBuilder.lower(
                                    root.<String>get(criteria.getKey())), "%" +
                                    criteria.getValue().toString().toLowerCase() + "%"
                    );
                } else {
                    predicate = criteriaBuilder.equal(
                            root.<String>get(criteria.getKey()), criteria.getValue().toString());
                }
            } else {
                continue;
            }

            predicates.add(predicate);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    }
}
