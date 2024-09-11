package org.bfc.service.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.bfc.domain.AssetDTO;
import org.bfc.domain.Currency;
import org.bfc.entity.Asset;
import org.bfc.entity.Customer;
import org.bfc.repository.AssetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class AssetServiceTest {

    @Mock
    AssetRepository assetRepository;

    @Mock
    ModelMapper mapper;

    AssetService assetService;

    Asset asset;

    @BeforeEach
    void init() {
        asset = new Asset();
        asset.setAssetId(1L);
        asset.setCustomer(new Customer(1L, 1_000L, Currency.TL, new HashSet<>()));

        assetService = new AssetServiceImpl(assetRepository, mapper);
    }


    @Test
    void test_getAssetByAssetId() {

        when(assetRepository.findById(1L)).thenReturn(Optional.of(asset));

        Asset asset = assetService.getAssetByAssetId(1L);

        verify(assetRepository).findById(1L);
        assertNotNull(asset.getAssetId());
        assertEquals(1L, asset.getAssetId());

    }

}