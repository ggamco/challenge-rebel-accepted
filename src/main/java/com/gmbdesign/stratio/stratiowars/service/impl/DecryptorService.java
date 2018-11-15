package com.gmbdesign.stratio.stratiowars.service.impl;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.EncryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.service.IDecryptorService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DecryptorService implements IDecryptorService {

    private static final String SEPARATOR = "-";

    @Override
    public DecryptedCoordinateListDTO decryptCoordinateList(EncryptedCoordinateListDTO encryptedCoordinateListDTO) {

        return new DecryptedCoordinateListDTO(encryptedCoordinateListDTO.getEncryptedCoordinateDTO()
                .stream()
                .map(encryptedCoordinateDTO -> encryptedCoordinateDTO.getEncryptedCoordinateUUID().split(SEPARATOR))
                .collect(Collectors.toList())
                .stream()
                .map(coordinates ->
                        new DecryptedCoordinateDTO(new StringBuilder()
                                .append(decryptGalaxy(coordinates[0]))
                                .append(SEPARATOR)
                                .append(decryptQuadrant(coordinates[1]))
                                .append(SEPARATOR)
                                .append(decryptStarSystem(coordinates[2], coordinates[3]))
                                .append(SEPARATOR)
                                .append(decryptPlanet(coordinates[4]))
                                .toString()))
                .collect(Collectors.toList()));
    }

    /**
     *
     * @param galaxy
     * @return
     */
    private Integer decryptGalaxy(String galaxy) {
        return sumHexValue(galaxy);
    }

    /**
     *
     * @param hexValue
     * @return
     */
    private Integer sumHexValue(String hexValue){
        return hexValue
                .toLowerCase()
                .chars()
                .mapToObj(c -> Character.digit(c, 16))
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     *
     * @param quadrant
     * @return
     */
    private Integer decryptQuadrant(String quadrant) {
        return maxHexValue(quadrant);
    }

    /**
     *
     * @param hexValue
     * @return
     */
    private Integer maxHexValue(String hexValue) {
        return hexValue
                .toLowerCase()
                .chars()
                .mapToObj(c -> Character.digit(c, 16))
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     *
     * @param starSystem1
     * @param starSystem2
     * @return
     */
    private Integer decryptStarSystem(String starSystem1, String starSystem2) {
        if(maxHexValue(starSystem1) > maxHexValue(starSystem2)) {
            return sumHexValue(starSystem1);
        } else {
            return sumHexValue(starSystem2);
        }
    }

    /**
     *
     * @param planet
     * @return
     */
    private String decryptPlanet(String planet) {
        return planet
                .chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


}
