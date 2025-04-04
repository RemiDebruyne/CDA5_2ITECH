package exo_hibernate.repository;

import exo_hibernate.entity.Client;

public class ClientRepository extends BaseRepository<Client> {
    @Override
    protected Class<Client> defineRepositoryType() {
        return Client.class;
    }
}
