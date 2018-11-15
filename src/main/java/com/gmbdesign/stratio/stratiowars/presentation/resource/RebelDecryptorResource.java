package com.gmbdesign.stratio.stratiowars.presentation.resource;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.EncryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.service.IDecryptorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/coordinates")
@Api(value = "coordinates", description = "Service to decrypt coordinates of Death Star.")
public class RebelDecryptorResource {

    @Autowired
    private IDecryptorService decryptorService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get a list of decrypted coordinates", response = DecryptedCoordinateListDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Yes! we have decrypted the Death Star position. We will prepare the attack."),
            @ApiResponse(code = 400, message = "Bad request. Be careful with imperial troopers."),
            @ApiResponse(code = 500, message = "May the Force be with you.")
    })
    public ResponseEntity<DecryptedCoordinateListDTO> getCoordinatesDecrypted (@RequestBody EncryptedCoordinateListDTO encryptedCoordinateListDTO) {
        return ResponseEntity.ok(decryptorService.decryptCoordinateList(encryptedCoordinateListDTO));
    }
}
