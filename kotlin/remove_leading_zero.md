# Remove Leading Zero

## toInt() or toLong()

```kotlin
val str = "000123"
val result = str.toInt().toString()
println(result)  // output: "123"
```

## dropWhile

```kotlin
val str = "000123"
val result = str.dropWhile { it == '0' }
println(result)  // output: "123"
```