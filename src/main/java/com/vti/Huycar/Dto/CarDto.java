package com.vti.Huycar.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    @JsonProperty("licensePlate")
    private String pkLicensePlate;
    @JsonProperty("repairDate")
    private String pkRepairDate;

    private String customerName ;
    private String catalog;
    private String carMaker;

}
