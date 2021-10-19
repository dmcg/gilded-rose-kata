package com.gildedrose


class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items = items.map { it.updated() }
    }
}
