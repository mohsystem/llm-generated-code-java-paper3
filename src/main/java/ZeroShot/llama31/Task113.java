package ZeroShot.llama31;
// Java code
public class Task113 {
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "Hello", "World", "!",
            "This", "is", "a", "test",
            "Concatenate", "these", "strings",
            "Java", "is", "fun",
            "String", "concatenation", "example"
        };

        for (int i = 0; i < testCases.length; i += 3) {
            String result = concatenateStrings(testCases[i], testCases[i + 1], testCases[i + 2]);
            System.out.println(result);
        }
    }

    public static String concatenateStrings(String str1, String str2, String str3) {
        return str1 + " " + str2 + " " + str3;
    }
}

// Python code (cannot be combined directly, but shown here for completeness)
/*
class Task113:
    def concatenate_strings(self, str1, str2, str3):
        return str1 + " " + str2 + " " + str3

def main():
    task = Task113()
    # Test cases
    test_cases = [
        ["Hello", "World", "!"],
        ["This", "is", "a", "test"],
        ["Concatenate", "these", "strings"],
        ["Python", "is", "fun"],
        ["String", "concatenation", "example"]
    ]

    for testCase in test_cases:
        result = task.concatenate_strings(*testCase[:3])
        print(result)

if __name__ == "__main__":
    main()
*/

// C++ code
/*
#include <iostream>
#include <string>

class Task113 {
public:
    std::string concatenateStrings(const std::string& str1, const std::string& str2, const std::string& str3) {
        return str1 + " " + str2 + " " + str3;
    }
};

int main() {
    Task113 task;
    // Test cases
    std::string testCases[][3] = {
        {"Hello", "World", "!"},
        {"This", "is", "a"},
        {"Concatenate", "these", "strings"},
        {"C++", "is", "fun"},
        {"String", "concatenation", "example"}
    };

    for (int i = 0; i < 5; ++i) {
        std::string result = task.concatenateStrings(testCases[i][0], testCases[i][1], testCases[i][2]);
        std::cout << result << std::endl;
    }

    return 0;
}
*/

// C code
/*
#include <stdio.h>
#include <string.h>

void concatenateStrings(char* dest, const char* str1, const char* str2, const char* str3) {
    strcpy(dest, str1);
    strcat(dest, " ");
    strcat(dest, str2);
    strcat(dest, " ");
    strcat(dest, str3);
}

int main() {
    char result[1024];
    // Test cases
    const char* testCases[][3] = {
        {"Hello", "World", "!"},
        {"This", "is", "a"},
        {"Concatenate", "these", "strings"},
        {"C", "is", "fun"},
        {"String", "concatenation", "example"}
    };

    for (int i = 0; i < 5; ++i) {
        concatenateStrings(result, testCases[i][0], testCases[i][1], testCases[i][2]);
        printf("%s\n", result);
    }

    return 0;
}
*/