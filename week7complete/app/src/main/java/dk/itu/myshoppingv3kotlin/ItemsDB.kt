package dk.itu.myshoppingv3kotlin

class ItemsDB private constructor(){
    public val itemsMap:ArrayList<Item> = ArrayList<Item>()

    init { fillItemsDB()}

    companion object {
        private var sItemsDB: ItemsDB? = null

        fun get(): ItemsDB {
            return sItemsDB ?: ItemsDB().also { sItemsDB = it }

        }
    }

    fun listItems(): String {
        var r = ""
        for (value in itemsMap)
            r = "$r\n ${value.what} goes in: ${value.where}"
        return r
    }

    fun size(): Int {
        return itemsMap.size
    }

    fun whereDoesItGo(item: String ) : String?{
        var lastval = ""
        for (value in itemsMap)
            if (value.what == item)
                lastval = value.where
        return lastval
    }

    fun getWhere(what: String): String? {
        var lastval = ""
        for (value in itemsMap)
            if (value.what == what)
                lastval = value.where
        return lastval
    }

    fun addItem(item: Item) {
        itemsMap.add(item)
    }

    fun thisExists(what: String): Boolean {
        var itExists = false
        for(item in itemsMap)
            if (item.what == what)
                itExists = true
        return itExists
    }

    fun removeItem(what: String) {
        for(item in itemsMap)
            if (item.what == what) itemsMap.remove(item)
    }

    private fun fillItemsDB() {
        itemsMap.add(Item("can", "Metal"))
        itemsMap.add(Item("glass", "Metal"))
        itemsMap.add(Item("titanium", "Metal"))
        itemsMap.add(Item("gold", "Metal"))
        itemsMap.add(Item("silver", "Metal"))
        itemsMap.add(Item("portuguese gold", "Metal"))
        itemsMap.add(Item("hardware", "Metal"))
        itemsMap.add(Item("most things nowadays", "Metal"))
        itemsMap.add(Item("funny biz", "Metal"))
    }
}