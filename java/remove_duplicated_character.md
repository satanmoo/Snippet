# Removes the duplicate characters from the given string

## SOL1

```java
public static String removeDuplicateCharacters(String s) {
    if (s == null || s.isEmpty()) {
        return "";
    }

    StringBuilder sb = new StringBuilder(s.length());
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
        if (set.add(s.charAt(i))) {
            sb.append(s.charAt(i));
        }
    }

    return sb.toString();
}
```

## SOL2

```java
public static String removeDuplicateCharactersV2(String s) {
    if (s == null || s.isEmpty()) {
        return "";
    }

    StringBuilder sb = new StringBuilder(s.length());

    for (int i = 0; i < s.length(); i++) {
        if (sb.indexOf(String.valueOf(s.charAt(i))) == -1) {
            sb.append(s.charAt(i));
        }
    }

    return sb.toString();
}
```

## SOL3

```java
public static String removeDuplicateCharactersV3(String s) {
    if (s == null || s.isEmpty()) {
        return "";
    }

    return s.chars().distinct().collect(StringBuffer::new, StringBuffer::appendCodePoint, StringBuffer::append).toString();
}
```

### Type Inference and Lambda Expression Matching in Java’s Collect Method

// TODO

## SOL4

```java
public static String removeDuplicateCharactersV4(String s) {
    if (s == null || s.isEmpty()) {
        return "";
    }

    return Arrays.stream(s.split(""))
            .distinct()
            .collect(Collectors.joining());
}
```

