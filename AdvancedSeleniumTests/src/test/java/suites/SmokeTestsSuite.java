package suites;

import org.junit.experimental.categories.*;
import org.junit.runner.*;
import org.junit.runners.*;
import categories.*;
import test.*;

@RunWith(Categories.class)
@Categories.ExcludeCategory(SmokeTests.class)
@Suite.SuiteClasses(
        {DummyTests.class,
        WaitForItTests.class
        }

)
public class SmokeTestsSuite {
    

    

}
