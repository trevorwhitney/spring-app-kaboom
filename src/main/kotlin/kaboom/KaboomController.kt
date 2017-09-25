package kaboom

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OverflowHeapController(val kaboomService: KaboomService) {
    private final val logger = LoggerFactory.getLogger(OverflowHeapController::class.java)
    val objectCollections: MutableList<LargeObject?> = mutableListOf<LargeObject?>()

    @RequestMapping("/kaboom")
    fun kaboom(@RequestParam("size") size: Int): Int {
        if (logger.isDebugEnabled) {
            logger.debug("Processing kaboom request for size: $size")
        }
        objectCollections.addAll(kaboomService.kaboom(size))
        return objectCollections.size
    }
}
