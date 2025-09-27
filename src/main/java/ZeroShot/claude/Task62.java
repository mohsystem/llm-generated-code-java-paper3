package ZeroShot.claude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task62 {
    public static class JsonElement {
        private String type; // "object", "array", "string", "number", "boolean", "null"
        private Object value;

        public JsonElement(String type, Object value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public Object getValue() {
            return value;
        }
    }

    public static JsonElement parseJson(String json) {
        json = json.trim();
        if (json.isEmpty()) {
            return null;
        }

        // Object
        if (json.startsWith("{")) {
            Map<String, JsonElement> map = new HashMap<>();
            if (json.length() > 2) { // Not empty object
                String content = json.substring(1, json.length() - 1);
                String[] pairs = splitTopLevel(content, ',');
                for (String pair : pairs) {
                    String[] keyValue = splitTopLevel(pair, ':');
                    String key = keyValue[0].trim();
                    key = key.substring(1, key.length() - 1); // Remove quotes
                    map.put(key, parseJson(keyValue[1].trim()));
                }
            }
            return new JsonElement("object", map);
        }

        // Array
        if (json.startsWith("[")) {
            List<JsonElement> list = new ArrayList<>();
            if (json.length() > 2) { // Not empty array
                String content = json.substring(1, json.length() - 1);
                String[] elements = splitTopLevel(content, ',');
                for (String element : elements) {
                    list.add(parseJson(element.trim()));
                }
            }
            return new JsonElement("array", list);
        }

        // String
        if (json.startsWith("\"")) {
            return new JsonElement("string", json.substring(1, json.length() - 1));
        }

        // Boolean
        if (json.equals("true")) {
            return new JsonElement("boolean", true);
        }
        if (json.equals("false")) {
            return new JsonElement("boolean", false);
        }

        // Null
        if (json.equals("null")) {
            return new JsonElement("null", null);
        }

        // Number
        try {
            return new JsonElement("number", Double.parseDouble(json));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid JSON format");
        }
    }

    private static String[] splitTopLevel(String str, char delimiter) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int nested = 0;
        boolean inString = false;

        for (char c : str.toCharArray()) {
            if (c == '"' && (current.length() == 0 || current.charAt(current.length() - 1) != '\\')) {
                inString = !inString;
            }
            if (!inString) {
                if (c == '{' || c == '[') nested++;
                if (c == '}' || c == ']') nested--;
            }
            if (c == delimiter && nested == 0 && !inString) {
                result.add(current.toString());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            result.add(current.toString());
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
                "{\"name\":\"John\", \"age\":30}",
                "[1,2,3,4,5]",
                "{\"arr\":[1,2,{\"x\":10}], \"val\":null}",
                "\"simple string\"",
                "{\"nested\":{\"array\":[1,2,3],\"bool\":true}}"
        };

        for (String test : tests) {
            try {
                JsonElement result = parseJson(test);
                System.out.println("Type: " + result.getType());
                System.out.println("Value: " + result.getValue());
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error parsing: " + e.getMessage());
            }
        }
    }
}
