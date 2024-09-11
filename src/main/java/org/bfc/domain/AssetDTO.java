package org.bfc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssetDTO {

    private Long assetId;

    private Long customerId;

    private String assetName;

    private Integer size;

    private Integer usableSize;
}
