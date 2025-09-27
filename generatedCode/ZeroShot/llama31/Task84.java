package ZeroShot.llama31;
// Java
public class Task84 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateSessionId());
        }
    }

    public static String generateSessionId() {
        java.util.UUID uuid = java.util.UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}

// Python
// def generate_session_id():
//     import uuid
//     return str(uuid.uuid4()).replace("-", "")

// if __name__ == "__main__":
//     for _ in range(5):
//         print(generate_session_id())

// C++
// #include <iostream>
// #include <uuid/uuid.h>

// std::string generateSessionId() {
//     uuid_t bin_uuid;
//     uuid_generate_random(bin_uuid);
//     char uuid[37];
//     uuid_unparse(bin_uuid, uuid);
//     return std::string(uuid).substr(0, 32); // Remove dashes
// }

// int main() {
//     for (int i = 0; i < 5; i++) {
//         std::cout << generateSessionId() << std::endl;
//     }
//     return 0;
// }

// C
// #include <stdio.h>
// #include <stdint.h>
// #include <string.h>
// #include <stdlib.h>
// #include <time.h>

// void generateUUID(char* out) {
//     uint32_t r1 = rand() % (1 << 16);
//     uint16_t r2 = rand() % (1 << 16);
//     uint16_t r3 = rand() % (1 << 16);
//     uint32_t r4 = rand() % (1 << 32);

//     sprintf(out, "%08x-%04x-%04x-%04x-%08x",
//             r1, r2, r3, (r4 & 0xFFFF), (r4 >> 16));
// }

// char* generateSessionId() {
//     static char uuid[33];
//     generateUUID(uuid);
//     uuid[8] = uuid[13] = uuid[18] = uuid[23] = '\0'; // Remove dashes
//     return uuid;
// }

// int main() {
//     srand(time(NULL)); // Seed the random number generator
//     for (int i = 0; i < 5; i++) {
//         printf("%s\n", generateSessionId());
//     }
//     return 0;
// }