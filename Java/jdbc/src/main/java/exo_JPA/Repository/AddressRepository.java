package exo_JPA.Repository;

import exo_JPA.Entity.Address;

public class AddressRepository extends BaseRepository<Address> {
    @Override
    protected Class defineRepositoryType() {
        return Address.class;
    }
}
