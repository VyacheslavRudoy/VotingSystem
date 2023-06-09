package ru.topjava.voting;

import ru.topjava.voting.model.Dish;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static ru.topjava.voting.model.AbstractEntity.START_SEQ;

public class DishTestData {
    public static final int DISH1_ID = START_SEQ + 6;
    private static final int DISH2_ID = START_SEQ + 7;
    private static final int DISH3_ID = START_SEQ + 8;
    private static final int DISH4_ID = START_SEQ + 9;
    private static final int DISH5_ID = START_SEQ + 10;
    private static final int DISH6_ID = START_SEQ + 11;
    private static final int DISH7_ID = START_SEQ + 12;

    public static final Dish DISH1 = new Dish(DISH1_ID, "Dish1(Rest1)", of(2023, Month.MAY, 1), 750);
    public static final Dish DISH2 = new Dish(DISH2_ID, "Dish2(Rest1)", of(2023, Month.MAY, 1), 500);
    public static final Dish DISH3 = new Dish(DISH3_ID, "Dish3(Rest1)", of(2023, Month.MAY, 1), 1200);
    static final Dish DISH4 = new Dish(DISH4_ID, "Dish4(Rest2)", LocalDate.now(), 345);
    static final Dish DISH5 = new Dish(DISH5_ID, "Dish5(Rest2)", LocalDate.now(), 399);
    static final Dish DISH6 = new Dish(DISH6_ID, "Dish6(Rest3)", LocalDate.now(), 678);
    static final Dish DISH7 = new Dish(DISH7_ID, "Dish7(Rest3)", LocalDate.now(), 270);


    static final Dish DISH_NEW = new Dish(START_SEQ + 8, "New", of(2023, Month.MAY, 1), 100);

    static {
        DISH_NEW.setRestaurant(RestaurantTestData.RESTAURANT1);
    }

    public static Dish getCreated() {
        return new Dish("NewDish", of(2023, Month.MAY, 1), 100);
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID, "DISH1_NewName", DISH1.getDate(), DISH1.getPrice(), DISH1.getRestaurant());
    }

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurant").isEqualTo(expected);
    }

    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "dateTime");
    }

}
