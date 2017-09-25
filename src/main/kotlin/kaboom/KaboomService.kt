package kaboom

import org.springframework.stereotype.Component

@Component
class KaboomService() {
    fun kaboom(size: Int): Array<LargeObject?> {
        val objects: Array<LargeObject?> = arrayOfNulls<LargeObject>(size)
        val rt = Runtime.getRuntime()

        (0..(size-1)).forEach { i ->
            objects[i] = LargeObject(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L,
                11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L,
                21L, 22L, 23L, 24L, 25L, 26L, 27L, 28L, 29L, 30L
            );

            if (i % 5000 == 0) {
                val freeMemory = rt.freeMemory() / 1000000000.0
                val totalMemory = (rt.totalMemory() - freeMemory) / 1000000000.0

                println("------------------------")
                println("Iteration $i")
                println("Free memory: $freeMemory GB")
                println("Used memory: $totalMemory GB")
                println("------------------------")
            }
        }

        return objects

    }
}
