package com.gmbdesign.stratio.stratiowars.service;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.service.impl.DecryptorService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DecryptorCoordinateTest {

    private final String[] EXPECTED_COORDINATES = {"73-15-46-dc9876321","34-10-42-edcb86430","64-9-16-edba976510"};
    private IDecryptorService decryptorService;

    @Test
    public void decryptorCoordinateListTest() {
        decryptorService = new DecryptorService();
        DecryptedCoordinateListDTO decryptedCoordinateListDTO = decryptorService.decryptCoordinates("6f9c15fa-ef51-4415-afab-36218d76c2d9;2952410b-0a94-446b-8bcb-448dc6e30b08;2ab81c9b-1719-400c-a676-bdba976150eb");
        List<DecryptedCoordinateDTO> decryptedCoordinateDTO = decryptedCoordinateListDTO.getDecryptedCoordinateDTO();

        for (int i = 0; i < decryptedCoordinateDTO.size(); i++) {
            assertEquals(decryptedCoordinateListDTO.getDecryptedCoordinateDTO().get(i).getDecryptedCoordinateUUID(), EXPECTED_COORDINATES[i]);
        }
    }
}
