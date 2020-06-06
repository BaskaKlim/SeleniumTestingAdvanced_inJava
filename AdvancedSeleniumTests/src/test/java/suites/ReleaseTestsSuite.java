package suites;

import org.junit.experimental.categories.*;
import org.junit.runner.*;
import org.junit.runners.*;
import categories.*;
import test.*;

@RunWith(Categories.class)
@Categories.IncludeCategory(ReleaseTests.class)
@Suite.SuiteClasses(
        {
       DummyTests.class
        }

)
public class ReleaseTestsSuite {
    

    

}
