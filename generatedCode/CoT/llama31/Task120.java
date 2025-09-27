package CoT.llama31;
// Task120.java

interface Handler {
    void handleRequest(String input);
    void setNextHandler(Handler nextHandler);
}

class ConsoleHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(String input) {
        System.out.println("Displaying input on console: " + input);
        if (nextHandler != null) {
            nextHandler.handleRequest(input);
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class WebHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(String input) {
        System.out.println("Displaying input on web page: " + input);
        if (nextHandler != null) {
            nextHandler.handleRequest(input);
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

public class Task120 {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        WebHandler webHandler = new WebHandler();

        consoleHandler.setNextHandler(webHandler);

        // Test cases
        consoleHandler.handleRequest("Hello, World!");
        consoleHandler.handleRequest("This is a test.");
        consoleHandler.handleRequest("User-supplied input.");
        consoleHandler.handleRequest("Another test case.");
        consoleHandler.handleRequest("Final test case.");
    }
}