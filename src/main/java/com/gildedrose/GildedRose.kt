package com.gildedrose

class GildedRose(
    var items: Array<Item>
) {

    fun updateQuality() {
        for (item in items) {
            typeOf(item).update(item)
        }
    }
}


