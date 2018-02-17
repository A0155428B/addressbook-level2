package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {

    private final AddressBook addressBook = new AddressBook();
    private final TypicalPersons td = new TypicalPersons();
    private List<ReadOnlyPerson> sortedList = Arrays.asList(td.amy, td.bill, td.candy, td.dan);

    @Test
    public void execute_sort() throws UniquePersonList.DuplicatePersonException {
        assertSortCommandBehavior();
    }

    /**
     * Executes the sort command on an unsorted list of typical person
     * the result matches the sortedList exactly.
     */
    private void assertSortCommandBehavior() throws UniquePersonList.DuplicatePersonException {
        SortCommand command = createSortCommand();
        command.addressBook.addPerson(td.dan);
        command.addressBook.addPerson(td.bill);
        command.addressBook.addPerson(td.amy);
        command.addressBook.addPerson(td.candy);
        CommandResult result = command.execute();
        assertEquals(Command.getMessageForPersonListShownSummary(sortedList), result.feedbackToUser);
    }
    /**
     * Helper function that creates a sort command for testing
     * @return A sort command with an empty addressBook.
     */
    private SortCommand createSortCommand() {
        SortCommand command = new SortCommand();
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
