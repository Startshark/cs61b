import java.lang.reflect.Constructor; // 访问构造函数
import java.lang.reflect.Field; // 访问调用方法
import java.lang.reflect.Method; // 访问属性

public class reflection {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Person.class;
        
        // 创建对象
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object person = constructor.newInstance("John", 30);
        
        // 调用方法
        Field nameField = clazz.getDeclaredField("name"); // 所有声明的字段, 包括私有的
        nameField.setAccessible(true);
        System.out.println("Name: " + nameField.get(person));

        // 修改字段
        nameField.set(person, "Tom");
        System.out.println("Updated Name: " + nameField.get(person));

        // 调用方法
        Method greetMethod = clazz.getDeclaredMethod("greet", String.class);
        greetMethod.invoke(person, "Hello World!");
    }
}


class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void greet(String message){
        System.out.println(name + " says: " + message);
    }
}
