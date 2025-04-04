package exo_hibernate.repository;

import exo_hibernate.entity.FoodItem;

public class FoodItemRepository extends BaseRepository<FoodItem> {

    @Override
    protected Class<FoodItem> defineRepositoryType() {
        return FoodItem.class;
    }
}
