package bike.rapido.paathshala.notification;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OwnerTest {

    Owner owner;

    @Before
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void shouldKnowOwnerIsNotified() {
        String message = owner.notifyFull();

        assertThat(message, is("Owner showed vehicle park full sign."));
    }
}