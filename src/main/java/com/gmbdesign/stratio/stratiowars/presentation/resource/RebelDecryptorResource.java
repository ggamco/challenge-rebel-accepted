package com.gmbdesign.stratio.stratiowars.presentation.resource;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.service.IDecryptorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/coordinates")
@Api(value = "coordinates", description = "Service to decrypt coordinates of Death Star.")
public class RebelDecryptorResource {

    @Autowired
    private IDecryptorService decryptorService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/{uuids}")
    @ApiOperation(value = "Get a list of decrypted coordinates", response = DecryptedCoordinateListDTO.class)

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Yes! we have decrypted the Death Star position. We will prepare the attack."),
            @ApiResponse(code = 400, message = "Bad request. Be careful with imperial troopers."),
            @ApiResponse(code = 500, message = "May the Force be with you.")
    })
    public DecryptedCoordinateListDTO getCoordinatesDecrypted (
            @ApiParam(
                    name = "uuids",
                    required = true,
                    value = "is possible to concat with ' ; ' few uuids to be processed.",
                    example = "6f9c15fa-ef51-4415-afab-36218d76c2d9;2952410b-0a94-446b-8bcb-448dc6e30b08;2ab81c9b-1719-400c-a676-bdba976150eb"
            )
            @PathVariable(name = "uuids") String encryptedCoordinates) {

        return decryptorService.decryptCoordinates(encryptedCoordinates);

    }
}
