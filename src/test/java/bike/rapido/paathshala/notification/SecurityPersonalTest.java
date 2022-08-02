package bike.rapido.paathshala.notification;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SecurityPersonalTest {

    SecurityPersonal securityPersonal;

    @Before
    public void setup() {
        securityPersonal = new SecurityPersonal();
    }

    @Test
    public void shouldKnowOwnerIsNotified() {
        String message = securityPersonal.notifyFull();

        assertThat(message, is("Security Personal informed the team about parking lot getting full."));
    }
}