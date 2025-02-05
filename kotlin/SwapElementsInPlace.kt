/**
 * Provides utility functions to swap elements of a primitive array (in-place) without using extra space.
 */
object SwapElementsInPlace {

    /**
     * Swaps the elements at [i] and [j] in the given [IntArray] using an in-place technique.
     *
     * Example:
     * ```
     * val blocks = intArrayOf(1, 2, 3, 4, 5)
     * swap(blocks, 0, 1)  // swaps elements at index 0 and 1
     * println(blocks.joinToString()) // Output: "2, 1, 3, 4, 5"
     * ```
     *
     * @param arr the array in which the swap will occur
     * @param i the first index
     * @param j the second index
     */
    fun swap(arr: IntArray, i: Int, j: Int) {
        arr[i] = arr[j].also { arr[j] = arr[i] }
    }

    /**
     * An alternative method demonstrating the usual temp variable approach.
     *
     * Example:
     * ```
     * val blocks = intArrayOf(1, 2, 3, 4, 5)
     * swapWithTemp(blocks, 0, 1)
     * println(blocks.joinToString()) // Output: "2, 1, 3, 4, 5"
     * ```
     *
     * @param arr the array in which the swap will occur
     * @param i the first index
     * @param j the second index
     */
    fun swapWithTemp(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}
