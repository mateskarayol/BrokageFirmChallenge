package org.bfc.service.asset;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bfc.domain.AssetDTO;
import org.bfc.entity.Asset;
import org.bfc.repository.AssetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Asset getAssetByAssetId(Long assetId) {
        Optional<Asset> assetOptional = assetRepository.findById(assetId);
        if (assetOptional.isPresent()) {
            return assetOptional.get();
        }
        throw new RuntimeException("Asset not found");
    }

    @Override
    public List<AssetDTO> listAssetsByCustomerId(Long customerId) {
        List<Asset> assetList = assetRepository.findByCustomerCustomerId(customerId);
        return assetList.stream().map(asset -> modelMapper.map(asset, AssetDTO.class)).collect(Collectors.toList());
    }
}
