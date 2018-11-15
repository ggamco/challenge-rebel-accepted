package com.gmbdesign.stratio.stratiowars.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecryptedCoordinateListDTO {

    private List<DecryptedCoordinateDTO> decryptedCoordinateDTO;
}
