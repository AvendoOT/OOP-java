package zi2018.zad3;

import java.time.Instant;

public class Logger {
    private StringBuilder sb = new StringBuilder();
    private Instant lastChange = Instant.now();
    /* creates a file with name in it's filename */
    public Logger(String name) {/* ... */}
    public void log(String entry) {
        /* Instant.now() returns the current time */
        /* and Instant.toString() returns a string */
        /* similar to 2018-02-02T09:00:00.000Z */
        lastChange = Instant.now();
        sb.append(lastChange.toString())
                .append(":")
                .append(entry)
                .append(System.lineSeparator());
    }
    /* flushes the entries into a file */
    public void flush() { /* ... */ }
}
