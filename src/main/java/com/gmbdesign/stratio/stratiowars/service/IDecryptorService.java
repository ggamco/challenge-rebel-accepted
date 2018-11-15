package com.gmbdesign.stratio.stratiowars.service;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;

public interface IDecryptorService {

    /**
     * Decrypt a list of encrypted coordinates of Death Star position. May the Force be with you.
     *
     * @param encryptedCoordinates encrypted coordinate list
     * @return decrypted coordinate list
     */
    DecryptedCoordinateListDTO decryptCoordinates(String encryptedCoordinates);
}
