# Buffered I/O

```kotlin
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            reader.readLine()   // input
            writer.write("Hello World!")
            writer.flush()
        }
    }
}

private fun BufferedWriter.writeLine(str: String) {
    write(str)
    this.newLine()
}

```