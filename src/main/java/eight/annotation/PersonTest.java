package eight.annotation;

public class PersonTest {
    @Hint("hint1")
    @Hint("hint2")
    interface Person1 {}

    public static void main(String[] args) {
        Hint hint = Person1.class.getAnnotation(Hint.class);
        System.out.println(hint);                   // null

       // Hints hints1 = Person1.class.getAnnotation(Hints.class);
       // System.out.println(hints1.value().length);  // 2

        Hint[] hints2 = Person1.class.getAnnotationsByType(Hint.class);

        System.out.println(hints2);
        System.out.println(hints2.length);          // 2
    }

}
