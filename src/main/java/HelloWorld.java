import spark.servlet.SparkApplication;

import static spark.Spark.get;

public class HelloWorld implements SparkApplication {

    private static final String HELLO_PATH = "/hello";
    private static final String HELLO_MESSAGE = "Hello World";

    public static void main(String[] args) {
        HelloWorld application = new HelloWorld();
        application.init();
    }

    @Override
    public void init() {
        get(HELLO_PATH, (request, response) -> HELLO_MESSAGE);
    }
}
