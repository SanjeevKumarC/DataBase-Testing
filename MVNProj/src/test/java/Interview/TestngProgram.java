package Interview;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestngProgram {
	@BeforeClass
	void bc() {
		System.out.println("bc");
	}
	@BeforeMethod
	void bm() {
		System.out.println("bm");
	}

	@Test
	void test() {
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(2+4==3);
		sf.assertAll();
		System.out.println("test");
	}
	@AfterMethod
	void am() {
		System.out.println("am");
	}
	@AfterSuite
	void as() {
		System.out.println("as");
	}
	@AfterGroups
	void ag() {
		System.out.println("ag");
	}
}
