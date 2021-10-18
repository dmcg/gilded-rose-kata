package com.gildedrose


class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item is BaseItem)
                item.update()
            else
                error("Item is not a BaseItem")
        }
    }
}
