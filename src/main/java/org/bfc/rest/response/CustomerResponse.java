package org.bfc.rest.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bfc.entity.Asset;

@Getter
@Setter
public class CustomerResponse<T> {

    List<Asset> assetList;

}
