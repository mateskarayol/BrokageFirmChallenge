package org.bfc.repository;

import java.util.List;
import org.bfc.entity.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {

    public List<Asset> findByCustomerCustomerId(Long customerId);
}
