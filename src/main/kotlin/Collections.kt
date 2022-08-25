import kotlinx.coroutines.runBlocking


fun main() = runBlocking {

    val list = mutableListOf<Invetory>(
        Invetory(Type.NONE, ItemsType.Classical, listOf(DurationType.ONE, DurationType.TWO, DurationType.THREE)),
        Invetory(Type.NONE, ItemsType.Classical, listOf(DurationType.ONE, DurationType.TWO, DurationType.THREE)),
        Invetory(Type.NONE, ItemsType.Classical, listOf(DurationType.TWO, DurationType.TWO, DurationType.THREE)),
        Invetory(Type.NEW, ItemsType.Rock, listOf(DurationType.THREE, DurationType.TWO, DurationType.THREE)),
        Invetory(Type.OLD, ItemsType.Pop, listOf(DurationType.THREE, DurationType.THREE, DurationType.THREE)),
        Invetory(Type.NONE, ItemsType.Classical, listOf(DurationType.ONE, DurationType.ONE, DurationType.ONE)),
        Invetory(Type.NONE, ItemsType.Rock, listOf(DurationType.ONE, DurationType.TWO, DurationType.THREE))
    )

    list.size

    println("toList ${listOf(DurationType.ONE, DurationType.TWO, DurationType.THREE).toString().hashCode()}")

//    val res = list.sortedByDescending { item.type }
//        .distinctBy { item.type to it.itemsType }
    val res = list.distinctBy { it.type to it.itemsType to it.duration}
//    val res = list.toSet()

    res.forEach {
        println("ListItem: $it")
    }

    val set = list.toSet()
    set.forEachIndexed { index, v ->
        println("SetItem: index: $index value: $v")
    }
}

data class Invetory(
    val type: Type,
    val itemsType: ItemsType,
    val duration: List<DurationType>
)

enum class Type() {
    NEW,
    OLD,
    NONE
}

enum class DurationType {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVe
}

enum class ItemsType {
    Classical,
    Rock,
    Pop
}

data class A(val id: Int)