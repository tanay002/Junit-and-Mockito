package com.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArrayCompareTest.class, QuickBeforeAfterTest.class, StringHelperTest.class })
public class OrganizeTestCasesUsingSuits {

}
