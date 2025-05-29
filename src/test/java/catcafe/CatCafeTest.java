package catcafe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CatCafeTest {
    private CatCafe cafe;

    @BeforeEach
    void setUp() {
        cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Whiskers", 2));
        cafe.addCat(new FelineOverLord("Tiger", 5));
        cafe.addCat(new FelineOverLord("Luna", 3));
        cafe.addCat(new FelineOverLord("Simba", 7));
        cafe.addCat(new FelineOverLord("Nala", 5));
    }

    // 1. Test: Anzahl Katzen nach dem Hinzufügen
    @Test
    void getCatCountReturnsCorrectNumber() {
        assertEquals(5, cafe.getCatCount());
    }

    // 2. Test: Katze nach vorhandenem Namen suchen
    @Test
    void getCatByNameReturnsPresentOptionalIfFound() {
        Optional<FelineOverLord> cat = cafe.getCatByNameOptional("Luna");
        assertTrue(cat.isPresent());
        assertEquals("Luna", cat.get().name());
    }

    // 3. Test: Katze nach nicht vorhandenem Namen suchen
    @Test
    void getCatByNameReturnsEmptyIfNotFound() {
        Optional<FelineOverLord> cat = cafe.getCatByNameOptional("Garfield");
        assertTrue(cat.isEmpty());
    }

    // 4. Test: getCatByName mit null als Argument
    @Test
    void getCatByNameReturnsEmptyForNull() {
        Optional<FelineOverLord> cat = cafe.getCatByNameOptional(null);
        assertTrue(cat.isEmpty());
    }

    // 5. Test: Katze nach Gewicht innerhalb Bereich finden
    @Test
    void getCatByWeightReturnsPresentIfCatInRange() {
        Optional<FelineOverLord> cat = cafe.getCatByWeightOptional(4, 6);
        assertTrue(cat.isPresent());
        assertTrue(cat.get().weight() >= 4 && cat.get().weight() < 6);
    }

    // 6. Test: Katze nach Gewicht außerhalb Bereich finden (kein Ergebnis)
    @Test
    void getCatByWeightReturnsEmptyIfNoCatInRange() {
        Optional<FelineOverLord> cat = cafe.getCatByWeightOptional(8, 10);
        assertTrue(cat.isEmpty());
    }

    // 7. Test: Ungültiger Bereich bei Gewicht (min < 0)
    @Test
    void getCatByWeightReturnsEmptyIfMinWeightNegative() {
        Optional<FelineOverLord> cat = cafe.getCatByWeightOptional(-1, 5);
        assertTrue(cat.isEmpty());
    }

    // 8. Test: Ungültiger Bereich bei Gewicht (max < min)
    @Test
    void getCatByWeightReturnsEmptyIfMaxWeightLessThanMin() {
        Optional<FelineOverLord> cat = cafe.getCatByWeightOptional(5, 4);
        assertTrue(cat.isEmpty());
    }

    // 9. Test: Suche nach Katze mit gleichem Gewicht (mehrere mit Gewicht 5)
    @Test
    void getCatByWeightReturnsAnyCatIfMultipleMatch() {
        Optional<FelineOverLord> cat = cafe.getCatByWeightOptional(5, 6);
        assertTrue(cat.isPresent());
        assertEquals(5, cat.get().weight());
    }

    // 10. Test: addCat darf keine Null zulassen (erwartet Exception)
    @Test
    void addCatThrowsNullPointerExceptionIfNull() {
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }

    // 11. Test: getCatCount nach mehreren Hinzufügungen erhöht sich korrekt
    @Test
    void getCatCountIncreasesAfterAddingCat() {
        int before = (int) cafe.getCatCount();
        cafe.addCat(new FelineOverLord("Shadow", 4));
        assertEquals(before + 1, cafe.getCatCount());
    }
}
