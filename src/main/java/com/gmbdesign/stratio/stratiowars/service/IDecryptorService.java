package com.gmbdesign.stratio.stratiowars.service;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.EncryptedCoordinateListDTO;

public interface IDecryptorService {

    /**
     * Decrypt a list of encrypted coordinates of Death Star position. May the Force be with you.
     *
     * @param encryptedCoordinateListDTO encrypted coordinate list
     * @return decrypted coordinate list
     */
    DecryptedCoordinateListDTO decryptCoordinateList(EncryptedCoordinateListDTO encryptedCoordinateListDTO);
}
