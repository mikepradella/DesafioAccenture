package pages;

import java.util.Random;

public class ContextoCompartilhado {

    public static String userName = new Random().ints(8, 'a', 'z' + 1).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
}