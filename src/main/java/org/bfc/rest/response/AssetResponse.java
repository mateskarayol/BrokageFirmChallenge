package org.bfc.rest.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bfc.domain.AssetDTO;

@Getter
@Setter
public class AssetResponse {

    List<AssetDTO> assetDTOList;

    public AssetResponse(List<AssetDTO> assetDTOList) {
        this.assetDTOList = assetDTOList;
    }
}
