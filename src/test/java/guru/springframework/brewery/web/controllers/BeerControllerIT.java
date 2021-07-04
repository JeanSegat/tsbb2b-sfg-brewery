package guru.springframework.brewery.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import guru.springframework.brewery.web.model.BeerPagedList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeerControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testList() {
        BeerPagedList beerPagedList = testRestTemplate.getForObject("api/vi/beer", BeerPagedList.class);

        assertThat(beerPagedList.getContent()).hasSize(2);
    }
}
