package test.mitJUnit5;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * Die Klassen m�ssen auf Test oder Tests enden, damit sie ber�cksichtigt werden.
 * z.B.: MyJUnit5Tests oder MyJUnit5Test
 * 
 */
@RunWith( JUnitPlatform.class )
@SelectPackages("test.mitJUnit5")
public class MeineTestSuite {
	
}