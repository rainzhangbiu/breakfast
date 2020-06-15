package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class AddressRepositoryTest {
    @Autowired
    private AddressesRepository addressesRepository;

    @Test
    void test() {
        List<Address> addressList = addressesRepository.findAll();
        for (Address address : addressList) {
            System.out.println(address);
        }
    }
}