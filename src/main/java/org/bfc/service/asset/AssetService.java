package org.bfc.service.asset;

import java.util.List;
import org.bfc.domain.AssetDTO;
import org.bfc.entity.Asset;

public interface AssetService {

    Asset getAssetByAssetId(Long assetId);

    List<AssetDTO> listAssetsByCustomerId(Long customerId);

}
