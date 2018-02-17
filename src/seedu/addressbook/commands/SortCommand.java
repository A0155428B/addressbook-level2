package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


/**
 * Sorts all persons in the address book alphabetically and lists to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book alphabetically as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = new ArrayList<>(addressBook.getAllPersons().immutableListView());
        Comparator<ReadOnlyPerson> nameComparator = new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                String name = o1.getName().toString();
                String otherName = o2.getName().toString();
                return name.compareTo(otherName);
            }
        };
        allPersons.sort(nameComparator);
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
