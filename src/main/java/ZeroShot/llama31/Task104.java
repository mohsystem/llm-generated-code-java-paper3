package ZeroShot.llama31;
// Java Section
public class Task104 {
    public static void main(String[] args) {
        testCases();
    }

    public static void secureInput(String input, int bufferSize) {
        if (input.length() > bufferSize) {
            System.out.println("Input exceeds buffer size. Truncating input.");
            input = input.substring(0, bufferSize);
        }
        System.out.println("Input: " + input);
    }

    public static void testCases() {
        secureInput("Hello", 10);
        secureInput("This is a very long input", 10);
        secureInput("Short", 10);
        secureInput("Another long input that will be truncated", 10);
        secureInput("Just right", 10);
    }
}

// Python Section (Cannot be combined directly with Java)
/*
class Task104:
    @staticmethod
    def secure_input(input_str, buffer_size):
        if len(input_str) > buffer_size:
            print("Input exceeds buffer size. Truncating input.")
            input_str = input_str[:buffer_size]
        print("Input:", input_str)

    @staticmethod
    def test_cases():
        Task104.secure_input("Hello", 10)
        Task104.secure_input("This is a very long input", 10)
        Task104.secure_input("Short", 10)
        Task104.secure_input("Another long input that will be truncated", 10)
        Task104.secure_input("Just right", 10)

if __name__ == "__main__":
    Task104.test_cases()
*/

// C++ Section (Cannot be combined directly with Java)
/*
#include <iostream>
#include <string>

class Task104 {
public:
    static void secureInput(const std::string& input, int bufferSize) {
        if (input.length() > bufferSize) {
            std::cout << "Input exceeds buffer size. Truncating input." << std::endl;
            std::string truncatedInput = input.substr(0, bufferSize);
            std::cout << "Input: " << truncatedInput << std::endl;
        } else {
            std::cout << "Input: " << input << std::endl;
        }
    }

    static void testCases() {
        secureInput("Hello", 10);
        secureInput("This is a very long input", 10);
        secureInput("Short", 10);
        secureInput("Another long input that will be truncated", 10);
        secureInput("Just right", 10);
    }
};

int main() {
    Task104::testCases();
    return 0;
}
*/

// C Section (Cannot be combined directly with Java)
/*
#include <stdio.h>
#include <string.h>

void secureInput(const char* input, int bufferSize) {
    if (strlen(input) > bufferSize) {
        printf("Input exceeds buffer size. Truncating input.\n");
        char truncatedInput[bufferSize + 1];
        strncpy(truncatedInput, input, bufferSize);
        truncatedInput[bufferSize] = '\0';
        printf("Input: %s\n", truncatedInput);
    } else {
        printf("Input: %s\n", input);
    }
}

void testCases() {
    secureInput("Hello", 10);
    secureInput("This is a very long input", 10);
    secureInput("Short", 10);
    secureInput("Another long input that will be truncated", 10);
    secureInput("Just right", 10);
}

int main() {
    testCases();
    return 0;
}
*/