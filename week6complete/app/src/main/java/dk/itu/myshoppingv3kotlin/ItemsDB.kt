package dk.itu.myshoppingv3kotlin

class ItemsDB private constructor(){
    private val itemsMap:HashMap<String,String> = HashMap<String,String>()

    init { fillItemsDB()}

    companion object {
        private var sItemsDB: ItemsDB? = null

        fun get(): ItemsDB {
            return sItemsDB ?: ItemsDB().also { sItemsDB = it }

        }
    }

    fun listItems(): String {
        var r = ""
        for ((key, value) in itemsMap)
            r = "$r\n $key goes in: $value"
        return r
    }

    fun size(): Int {
        return itemsMap.size
    }

    fun whereDoesItGo(item: String ) : String?{
        return itemsMap.get(item)
    }

    fun getWhere(what: String): String? {
        return itemsMap[what]
    }

    fun addItem(what: String, where: String) {
        itemsMap[what] = where
    }

    fun thisExists(what: String): Boolean {
        return itemsMap[what] != null
    }

    fun removeItem(what: String) {
        if (itemsMap[what] != null) itemsMap.remove(what)
    }

    private fun fillItemsDB() {
        itemsMap.put("can", "Metal")
        itemsMap.put("glass bottle", "Glass")
        itemsMap.put("milk carton", "Plastic")
        itemsMap.put("bread", "Organic")
        itemsMap.put("butter", "Organic")
    }
}