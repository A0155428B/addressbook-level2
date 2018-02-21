package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void isAnyNull() throws Exception {
        // only one null object
        assertHasNull((Object) null);
        assertHasNull("a", null);
        assertHasNull(1, 2, null);
        assertHasNull(1, null, 2);

        // multiple null objects
        assertHasNull(null, null);
        assertHasNull(null, "a", "b", null);
        assertHasNull(1, null, 2, null);

        // no null objects
        assertNoNull(1, 2, 3);
        assertNoNull("a", "b", "c");

    }

    private void assertNoNull(Object... objects) { assertFalse(Utils.isAnyNull(objects));}
    private void assertHasNull(Object... objects) { assertTrue(Utils.isAnyNull(objects));}
}
