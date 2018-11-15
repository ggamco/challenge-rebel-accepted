package com.gmbdesign.stratio.stratiowars.presentation.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncryptedCoordinateListDTO {

    @ApiModelProperty(
            notes = "model of encrypted coordinate",
            name="encryptedCoordinateDTO",
            required=true,
            value="uuid coordinate")
    private List<EncryptedCoordinateDTO> encryptedCoordinateDTO;
}
