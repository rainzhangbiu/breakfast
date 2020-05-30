package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Addresses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressesRepositoryTest {
    @Autowired
    private AddressesRepository addressesRepository;

    @Test
    void test() {
        List<Addresses> addressesList = addressesRepository.findAll();
        for (Addresses address : addressesList) {
            System.out.println(address);
        }
    }
}