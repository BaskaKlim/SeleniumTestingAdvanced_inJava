package suites;

import org.junit.experimental.categories.*;
import org.junit.runner.*;
import org.junit.runners.*;
import categories.*;
import test.*;

//v JUnit4 su to categories v JUnit Jupiter teda 5 su to tags
@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTests.class)
@Suite.SuiteClasses(
        {DummyTests.class,
        WaitForItTests.class
        }

)
public class SmokeTestsSuite {
    

    

}
