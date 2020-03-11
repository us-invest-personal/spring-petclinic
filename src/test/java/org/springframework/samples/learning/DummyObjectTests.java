package org.springframework.samples.learning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DummyObjectTests {

    public Customer createDummyCustomer() {
        Customer customer = new Customer("John", "Doe", "Seville, ES");
        return customer;
    }

    @Test
    public void addCustomerTest() {
        Customer dummy = createDummyCustomer();
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        assertEquals(1, addressBook.getNumberOfCustomers());
    }

    @Test
    public void addNullCustomerTest() {
        Customer dummy = null;
        AddressBook addressBook = new AddressBook();
        assertThrows(Exception.class, () -> addressBook.addCustomer(dummy));
    }

    @Test
    public void addCustomerWithDummyTest() {
        Customer dummy = mock(Customer.class);
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        assertEquals(1, addressBook.getNumberOfCustomers());
    }

}