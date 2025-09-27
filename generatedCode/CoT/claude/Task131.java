package CoT.claude;

import java.io.*;
import java.util.Base64;

class Task131 {
    public static Object deserializeData(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        try {
            // Validate input format (Base64)
            if (!data.matches("^[A-Za-z0-9+/]*={0,2}$")) {
                throw new IllegalArgumentException("Invalid Base64 format");
            }

            // Decode Base64
            byte[] serializedData = Base64.getDecoder().decode(data);
            
            // Set up secure deserialization
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
            ObjectInputStream ois = new ObjectInputStream(bais) {
                @Override
                protected Class<?> resolveClass(ObjectStreamClass desc) 
                        throws IOException, ClassNotFoundException {
                    // Whitelist of allowed classes
                    String className = desc.getName();
                    if (className.startsWith("java.lang.") || 
                        className.startsWith("java.util.")) {
                        return super.resolveClass(desc);
                    }
                    throw new SecurityException("Unauthorized class: " + className);
                }
            };

            Object obj = ois.readObject();
            ois.close();
            return obj;

        } catch (IOException | ClassNotFoundException | IllegalArgumentException e) {
            throw new SecurityException("Deserialization failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "rO0ABXQABEpvaG4=",  // Serialized "John"
            "",                  // Empty string
            "invalid-base64!",   // Invalid Base64
            null,               // Null input
            "rO0ABXQACEhlbGxvISEh" // Serialized "Hello!!!"
        };

        for (String test : testCases) {
            try {
                Object result = deserializeData(test);
                System.out.println("Success: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
