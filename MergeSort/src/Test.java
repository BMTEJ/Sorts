import java.util.HashMap;
import java.util.Map;

public class Test {
    TestClass root;
    private class TestClass{
        private Map<Integer,Integer> test;
        private int test1;
        TestClass(){
            test = new HashMap<>();
            test1 = 4;
        }
    }

    Test(){
        root = new TestClass();
    }

    public int test(){
        return root.test1;
    }

    public static void main(String[] args) {
        Test implement = new Test();
        System.out.println(implement.test());
    }
}
