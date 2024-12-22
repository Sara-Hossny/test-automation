package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JsonManager {
    private final String filePath;
    private Map<String, Object> data;
    private final ObjectMapper objectMapper;

    /**
     * Constructor to initialize JsonManager with the path to a JSON file.
     *
     * @param filePath Path to the JSON file to load and manage.
     * @throws IOException If there is an error reading the JSON file.
     */
    public JsonManager(String filePath) throws IOException {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        this.data = loadJson();
    }

    /**
     * Load JSON data from the specified file.
     *
     * @return A map representing the JSON data.
     * @throws IOException If the file is not found or JSON is invalid.
     */
    private Map<String, Object> loadJson() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("JSON file not found at path: " + filePath);
        }

        return objectMapper.readValue(file, new TypeReference<Map<String, Object>>() {});
    }

    /**
     * Save the current data back to the JSON file.
     *
     * @throws IOException If there is an error writing to the JSON file.
     */
    public void saveJson() throws IOException {
        File file = new File(filePath);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        System.out.println("Data successfully saved to " + filePath);
    }

    /**
     * Retrieve the value associated with a key in the JSON data.
     *
     * @param key The key to retrieve from the JSON data.
     * @param <T> The type of the value.
     * @return The value associated with the key, or null if the key does not exist.
     */
    public <T> T getValue(String key) {
        return (T) data.get(key);
    }

    /**
     * Update the value for a specific key in the JSON data.
     *
     * @param key   The key to update.
     * @param value The new value to assign to the key.
     * @throws IOException If there is an error saving the JSON file.
     */
    public void updateValue(String key, Object value) throws IOException {
        data.put(key, value);
        System.out.println("Updated key '" + key + "' with value: " + value);
        saveJson();
    }

    /**
     * Add a new entry to a list in the JSON data.
     *
     * @param key      The key where the list is located.
     * @param newEntry The new data to append to the list.
     * @throws IOException If there is an error saving the JSON file.
     */
    public void addEntry(String key, Object newEntry) throws IOException {
        if (!data.containsKey(key)) {
            data.put(key, new java.util.ArrayList<>());
        }

        Object value = data.get(key);
        if (value instanceof List) {
            List<Object> list = (List<Object>) value;
            list.add(newEntry);
            System.out.println("Added new entry to '" + key + "': " + newEntry);
            saveJson();
        } else {
            throw new IllegalArgumentException("The key '" + key + "' does not contain a list.");
        }
    }

    /**
     * Delete a key from the JSON data.
     *
     * @param key The key to delete.
     * @throws IOException If there is an error saving the JSON file.
     */
    public void deleteEntry(String key) throws IOException {
        if (data.containsKey(key)) {
            data.remove(key);
            System.out.println("Deleted key '" + key + "' from data.");
            saveJson();
        } else {
            System.out.println("Key '" + key + "' not found in data.");
        }
    }

    /**
     * Filter entries in a list under a specific key based on a condition.
     *
     * @param key       The key containing the list.
     * @param condition A condition (predicate) to filter the list.
     * @return The filtered list of entries.
     * @throws IllegalArgumentException If the key does not contain a list.
     */
    public List<Object> filterList(String key, Predicate<Object> condition) {
        if (!data.containsKey(key) || !(data.get(key) instanceof List)) {
            throw new IllegalArgumentException("The key '" + key + "' does not contain a list.");
        }

        List<Object> list = (List<Object>) data.get(key);
        return list.stream().filter(condition).collect(Collectors.toList());
    }

    /**
     * Retrieve validation inputs from a specific key in the JSON data.
     * This method is designed for retrieving input values in validation scenarios.
     *
     * @param key The key where validation data is stored (e.g., "first_name_validation").
     * @return A list of input values for validation.
     * @throws IllegalArgumentException If the key doesn't contain a list of maps with "input" fields.
     */
    public List<String> getValidationInputs(String key) throws IllegalArgumentException {
        // Retrieve the validation list based on the key
        List<Map<String, String>> validationValues = (List<Map<String, String>>) getValue(key);

        if (validationValues == null) {
            throw new IllegalArgumentException("The key '" + key + "' does not contain validation data.");
        }

        // Extract the "input" values from each map in the list
        return validationValues.stream()
                .filter(item -> item.containsKey("input"))
                .map(item -> item.get("input"))
                .collect(Collectors.toList());
    }
}
