package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #01-01, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format of"
                                                                + "Block, Street, Unit, Postal Code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+?(?=,),.+?(?=,),.+?(?=,),.+";
    public static final String ADDRESS_SPLIT_REGEX = ",";
    public static final String SEPARATOR = ", ";
    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTALCODE_INDEX = 3;
    public final String value;


    private boolean isPrivate;
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressParameters = trimmedAddress.split(ADDRESS_SPLIT_REGEX);
        this.block = new Block(addressParameters[BLOCK_INDEX], isPrivate);
        this.street = new Street(addressParameters[STREET_INDEX], isPrivate);
        this.unit = new Unit(addressParameters[UNIT_INDEX], isPrivate);
        this.postalCode = new PostalCode(addressParameters[POSTALCODE_INDEX], isPrivate);
        this.value = block.toString() + SEPARATOR + street.toString() + SEPARATOR + unit.toString()
                        + SEPARATOR + postalCode.toString();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
