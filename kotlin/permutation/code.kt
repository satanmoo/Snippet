fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
            val (n, k) = reader.readLine().split(" ").map { it.toInt() }

            fun getPermutation(start: Int, end: Int, size: Int) {
                val visited = BooleanArray(end + 1) { false }
                val dq = ArrayDeque<Int>()

                fun getPermutationRecursive(currentSize: Int) {
                    if (currentSize == size) {
                        dq.forEach { writer.write("$it ") }
                        writer.writeLine("")
                        return
                    }

                    for (num in start..end) {
                        if (!visited[num]) {
                            visited[num] = true
                            dq.addLast(num)
                            getPermutationRecursive(currentSize + 1)
                            visited[num] = false
                            dq.removeLast()
                        }
                    }
                }

                getPermutationRecursive(0)
            }

            getPermutation(start = 1, end = n, size = k)
        }
    }
}

private fun BufferedWriter.writeLine(v: Any) {
    this.write("$v")
    this.newLine()
}
