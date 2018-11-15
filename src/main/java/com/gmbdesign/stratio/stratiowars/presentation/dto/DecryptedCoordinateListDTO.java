package com.gmbdesign.stratio.stratiowars.presentation.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecryptedCoordinateListDTO {

    @ApiModelProperty(
            notes = "model of decrypted coordinate",
            name="decryptedCoordinateDTO",
            value="uuid coordinate")
    private List<DecryptedCoordinateDTO> decryptedCoordinateDTO;
}
