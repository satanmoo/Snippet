# Convert container to map

## Convert set to map

```kotlin
val set = setOf("1", "2", "3")
val map = set.withIndex().associate {
    it.index to it.value
}
```

## Convert list to map

```kotlin
val list = listOf(1, 2, 3)
val map = list.associateWith { it * it }
```

```kotlin
val list = listOf("apple", "banana", "cherry")
val map = list.associateBy { it.first() }   // {"a"="applce, "b="banana", "c"="cherry"}
```

## duplicated key

```kotlin
val people = listOf(
    "Alice" to 25,
    "Bob" to 30,
    "Alice" to 35
)
val map = people.associate { it.first to it.second } // {Alice=35, Bob=30} (Alice의 마지막 값만 유지)
```

## grouping

```kotlin
val list = listOf("apple", "banana", "cherry", "apricot", "blueberry")
val groupedMap = list.groupBy { it.first() } // {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
```
