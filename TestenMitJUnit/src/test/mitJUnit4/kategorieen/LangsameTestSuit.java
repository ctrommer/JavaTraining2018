package test.mitJUnit4.kategorieen;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(KategorieLangsameTests.class)
@SuiteClasses({ KomplettLangsam.class, TeilweiseLangsam.class })
public class LangsameTestSuit {
	
}
