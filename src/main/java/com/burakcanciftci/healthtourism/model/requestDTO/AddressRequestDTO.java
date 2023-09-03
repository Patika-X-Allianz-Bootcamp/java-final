package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.model.enums.CountryEnum;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {
    CountryEnum country;
    String city;
    String address;
}
