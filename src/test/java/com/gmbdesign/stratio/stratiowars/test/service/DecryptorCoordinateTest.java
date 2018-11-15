package com.gmbdesign.stratio.stratiowars.test.service;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.EncryptedCoordinateDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.EncryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.test.service.impl.DecryptorService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DecryptorCoordinateTest {

    private IDecryptorService decryptorService;

    @Test
    public void decryptorCoordinateListTest() {
        decryptorService = new DecryptorService();
        EncryptedCoordinateDTO encryptedCoordinateDTO = new EncryptedCoordinateDTO("6f9c15fa-ef51-4415-afab-36218d76c2d9");
        List<EncryptedCoordinateDTO> encryptedCoordinateDTOList = new ArrayList<>();
        encryptedCoordinateDTOList.add(encryptedCoordinateDTO);
        EncryptedCoordinateListDTO encryptedCoordinateListDTO = new EncryptedCoordinateListDTO(encryptedCoordinateDTOList);

        DecryptedCoordinateListDTO decryptedCoordinateListDTO = decryptorService.decryptCoordinateList(encryptedCoordinateListDTO);
        DecryptedCoordinateDTO decryptedCoordinateDTO = decryptedCoordinateListDTO.getDecryptedCoordinateDTO().get(0);

        assertEquals(decryptedCoordinateDTO.getDecryptedCoordinateUUID(), "73-15-46-dc9876321");
    }
}
