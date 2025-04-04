package exo_hibernate;

import exo_hibernate.entity.Client;
import exo_hibernate.entity.Sale;
import exo_hibernate.repository.ClientRepository;
import exo_hibernate.repository.SaleRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        var clientRepo = new ClientRepository();
//
//        List<Client> clients = clientRepo.getAll();
//        for (Client client : clients) {
//            System.out.println(client);
//        }

        var saleRepo = new SaleRepository();
        List<Sale> sales = saleRepo.getByFilter("client", 5);
//        var sales = saleRepo.getByClient(5);
//        var sales = saleRepo.getByProduct(5);
        for (Sale sale : sales) {
            System.out.println(sale);
        }

    }
}