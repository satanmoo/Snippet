# Swap Primitive Array Elements In-Place 

```kotlin
val blocks = intArrayOf(1, 2, 3, 4, 5)

blocks[0] = blocks[1].also { blocks[1] = blocks[0] }

println(blocks.joinToString()) // Output: 2, 1, 3, 4, 5
```