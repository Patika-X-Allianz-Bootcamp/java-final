package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.model.enums.CountryEnum;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

@Data
public class AddressResponseDTO extends BaseDTO {
    CountryEnum country;
    String city;
    String address;
}
