/**
 * Provides utility functions for converting common Kotlin collections (Set/List) to Maps
 * in various ways (withIndex, associate, groupBy, handling duplicates, etc.).
 */
object ConvertContainerToMap {

    /**
     * Converts a [Set] of [String] to a [Map] whose keys are the 0-based index
     * and values are the corresponding elements from the Set.
     *
     * Example:
     * ```
     * val set = setOf("1", "2", "3")
     * // returns {0=1, 1=2, 2=3}
     * ```
     */
    fun fromSetWithIndex(set: Set<String>): Map<Int, String> {
        return set.withIndex().associate { it.index to it.value }
    }


    /**
     * Converts a [List] of [Int] to a [Map] such that each element is mapped to its square.
     *
     * Example:
     * ```
     * val list = listOf(1, 2, 3)
     * // returns {1=1, 2=4, 3=9}
     * ```
     */
    fun fromListToSquareMap(list: List<Int>): Map<Int, Int> {
        return list.associateWith { it * it }
    }


    /**
     * Converts a [List] of [String] to a [Map] by using the first character of each string as the key,
     * and the string itself as the value.
     *
     * If there are duplicate first characters, **the last one in the list** will overwrite the previous entries.
     *
     * Example:
     * ```
     * val fruits = listOf("apple", "banana", "cherry")
     * // returns {a=apple, b=banana, c=cherry}
     * ```
     */
    fun fromListAssociateByFirstChar(list: List<String>): Map<Char, String> {
        return list.associateBy { it.first() }
    }


    /**
     * Demonstrates how to handle duplicate keys by associating a pair (String, Int) list to a map.
     * If keys are duplicated, the last one in the list takes precedence.
     *
     * Example:
     * ```
     * val people = listOf(
     *     "Alice" to 25,
     *     "Bob" to 30,
     *     "Alice" to 35
     * )
     * // returns {Alice=35, Bob=30}
     * // (Alice's last value 35 overwrote 25)
     * ```
     */
    fun fromListWithDuplicateKey(people: List<Pair<String, Int>>): Map<String, Int> {
        return people.associate { it.first to it.second }
    }


    /**
     * Groups a [List] of [String] by the first character of each string,
     * resulting in a [Map] where each key is a Char and the value is a List of Strings.
     *
     * Example:
     * ```
     * val list = listOf("apple", "banana", "cherry", "apricot", "blueberry")
     * // returns {
     * //   a=[apple, apricot],
     * //   b=[banana, blueberry],
     * //   c=[cherry]
     * // }
     * ```
     */
    fun groupByFirstChar(list: List<String>): Map<Char, List<String>> {
        return list.groupBy { it.first() }
    }
}
