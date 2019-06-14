package com.marlabs.corejava_test4.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestAddressBook.class,
   TestSingleAddress.class,
   TestDuplicateAddressException.class
   
})
public class TestSuite {
}
