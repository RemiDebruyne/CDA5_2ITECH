package exo_hibernate.repository;

import exo_hibernate.entity.ElectronicItem;

public class ElectronicItemRepository extends BaseRepository<ElectronicItem> {
    @Override
    protected Class<ElectronicItem> defineRepositoryType() {
        return ElectronicItem.class;
    }
}
