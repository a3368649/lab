package lab1;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import lab1.lab1;
@RunWith(Parameterized.class)
public class test {
	private int a;
	private int b;
	private int c;
	private int expected;	
	public test(int expected,int a, int b,int c)
	{
		this.expected = expected;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
		new lab1();
	}
	@After
	public void tearDown() throws Exception {
	}
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] object = {
					{-1,1,1,-1},
					{-1,0,1,1},
					{1,2,2,2},
					{2,2,2,3},
					{3,2,4,3},
				};	
		return Arrays.asList(object);
		}
	@Test
	public void test1() {
		assertEquals(this.expected, lab1.a(a, b, c));
	}
}