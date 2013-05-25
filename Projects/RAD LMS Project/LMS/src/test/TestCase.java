package test;

import pagecode.pages.login.*; 

import junit.framework.Test;

import org.eclipse.hyades.test.common.junit.DefaultTestArbiter;
import org.eclipse.hyades.test.common.junit.HyadesTestCase;
import org.eclipse.hyades.test.common.junit.HyadesTestSuite;

/**
 * Generated code for the test suite <b>TestCase</b> located at
 * <i>/LMS/WebContent/TestCase.testsuite</i>.
 */
public class TestCase extends HyadesTestCase {
	/**
	 * Constructor for TestCase.
	 * @param name
	 */
	
	Login_frm loginfrm;
	 
	public TestCase(String name) {
		super(name);		
		
	}

	/**
	 * Returns the JUnit test suite that implements the <b>TestCase</b>
	 * definition.
	 */
	public static Test suite() {
		HyadesTestSuite testCase = new HyadesTestSuite("TestCase");
		testCase.setArbiter(DefaultTestArbiter.INSTANCE).setId(
				"A1E04482E9595D20CA7DB13766333063");

		return testCase;
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		loginfrm=new Login_frm();
		loginfrm.loginx();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		loginfrm=null;
	}

	/**
	 * loginx
	 * @throws Exception
	 */
	public void testLoginx() throws Exception {
		loginfrm.loginx();

	}

	/**
	 * logoutx
	 * @throws Exception
	 */
	public void testLogoutx() throws Exception {
		loginfrm.logoutx();
	}

}
