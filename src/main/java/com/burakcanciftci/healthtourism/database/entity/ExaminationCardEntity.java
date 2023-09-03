package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "examinationCard_uuid"
        )
)
@Data
public class ExaminationCardEntity extends BaseEntity {
    String diagnosis;
    String note;
}
