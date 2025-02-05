class ArrayShiftInPlace {
    /**
     * Shifts all non-zero elements to the left in-place and pushes zeros to the right.
     * Preserves the relative order of non-zero elements.
     *
     * Example:
     * ```
     * [0, 1, 0, 2, 0, 0] -> [1, 2, 0, 0, 0, 0]
     * ```
     *
     * @param arr The array to be modified in-place
     */
    fun shiftNonZeroLeftInPlace(arr: IntArray) {
        var lastPos = -1
        for (i in arr.indices) {
            if (arr[i] != 0) lastPos = i
            else {
                var p = lastPos
                do {
                    ++p
                } while (p < arr.size && arr[p] == 0)
                // no blank anymore
                if (p >= arr.size) break
                // pull non zero block
                arr[i] = arr[p]
                arr[p] = 0
                lastPos = p
            }
        }
    }

    /**
     * Shifts all non-zero elements to the right in-place and pushes zeros to the left.
     * Preserves the relative order of non-zero elements.
     *
     * Example:
     * ```
     * [0, 1, 0, 2, 0, 0] -> [0, 0, 0, 0, 1, 2]
     * ```
     *
     * @param arr The array to be modified in-place
     */
    fun shiftNonZeroRightInPlace(arr: IntArray) {
        var lastPos = arr.size
        for (i in arr.size - 1 downTo 0) {
            if (arr[i] != 0) lastPos = i
            else {
                var p = lastPos
                do {
                    --p
                } while (p >= 0 && arr[p] == 0)
                // no blank anymore
                if (p < 0) break
                // pull non zero block
                arr[i] = arr[p]
                arr[p] = 0
                lastPos = p
            }
        }
    }
}
