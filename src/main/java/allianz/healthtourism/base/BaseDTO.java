package allianz.healthtourism.base;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class BaseDTO {

    private Long id;
    private UUID uuid;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Date updatedDate;
}
