package kaboom

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OverflowHeapController(val kaboomService: KaboomService) {
    val objectCollections: MutableList<LargeObject?> = mutableListOf<LargeObject?>()

    @RequestMapping("/kaboom")
    fun kaboom(@RequestParam("size") size: Int): Int {
        objectCollections.addAll(kaboomService.kaboom(size))
        return objectCollections.size
    }
}
