//package test.java;
//
//import org.jdbi.v3.core.Jdbi;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class raidersTest {
//    Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost/imbokodo?username=justin&password=Justine123");
////
//    @BeforeEach
//    void beforeEach() {
//        jdbi.withHandle(h -> {
//            h.execute("delete from users");
//            return null;
//        });
//    }
//
//    @Test
//    public void shouldBeAbleToConnectToPostgreSQL() {
//
//        int count = jdbi.withHandle(h -> h.createQuery("select count(*) from users")
//                .mapTo(int.class)
//                .findOnly());
//
//        assertTrue(count >= 0);
//
//    }
//
//    @Test
//    public void shouldBeAbleToCleanTable() {
//
//        int count = jdbi.withHandle(h -> {
//            return h.createQuery("select count(*) from users")
//                    .mapTo(int.class)
//                    .findOnly();
//        });
//        assertEquals(0, count);
//    }
//
//    @Test
//    public void shouldBeAbleToInsertPerson() {
//
//        int counter = jdbi.withHandle(h -> {
//            h.execute("insert into users(first_name, last_name, email) values (?, ?, ?)",
//                    "Justin",
//                    "Gama",
//                    "Justin@email.com");
//
//            int count = h
//                    .createQuery("select count(*) from users where first_name = ?")
//                    .bind(0, "Justin")
//                    .mapTo(int.class)
//                    .findOnly();
//
//            return count;
//        });
//        assertEquals(1, counter);
//    }
//
//}
//
