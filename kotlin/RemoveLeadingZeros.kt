/**
 * Provides utility functions to remove leading zeros from a string.
 */
object RemoveLeadingZeros {

    /**
     * Removes leading zeros by converting the string to an Int and back to a string.
     *
     * Note: If the string could be very large (bigger than Int range),
     * consider using Long or BigInteger accordingly.
     *
     * Example:
     * ```
     * "000123" -> "123"
     * ```
     * If the string is all zeros, e.g. "0000", it becomes "0".
     */
    fun removeByParsing(str: String): String {
        // If all zeros or empty, toInt() will return 0, so result is "0"
        return str.toInt().toString()
    }

    /**
     * Removes leading zeros by dropping characters while they are '0'.
     * If the string is composed only of zeros or is empty, it returns an empty string.
     *
     * Example:
     * ```
     * "000123" -> "123"
     * "0000" -> "" (not "0")
     * ```
     */
    fun removeByDropWhile(str: String): String {
        return str.dropWhile { it == '0' }
    }
}
