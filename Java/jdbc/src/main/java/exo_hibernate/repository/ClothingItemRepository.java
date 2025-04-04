package exo_hibernate.repository;

import exo_hibernate.entity.ClothingItem;

public class ClothingItemRepository extends BaseRepository<ClothingItem> {
    @Override
    protected Class<ClothingItem> defineRepositoryType() {
        return ClothingItem.class;
    }
}
