/**
 * @author hyz
 * @create 2019-12-15 19:52
 */
interface Foo{
    public void sayHello();
}
public class day02 {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("************hello*********");
            }
        };
        foo.sayHello();


        Foo foo2 = () -> {
            System.out.println("************hello*********1111111");
        };
        foo2.sayHello();
    }
}