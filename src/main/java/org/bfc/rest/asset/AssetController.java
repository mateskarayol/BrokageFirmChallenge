package org.bfc.rest.asset;

import java.util.List;
import org.bfc.domain.AssetDTO;
import org.bfc.rest.response.AssetResponse;
import org.bfc.rest.response.BfcResponse;
import org.bfc.service.asset.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssetController {

    @Autowired
    AssetService assetService;

    @GetMapping("api/v1/asset/listAssetsByCustomerId")
    public ResponseEntity<BfcResponse> listAssetsByCustomerId(@RequestParam("customerId") Long customerId) {
        List<AssetDTO> assetDTOList = assetService.listAssetsByCustomerId(customerId);
        return new ResponseEntity<>(new BfcResponse(new AssetResponse(assetDTOList)), HttpStatus.OK);
    }
}
