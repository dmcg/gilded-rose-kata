package com.gildedrose

open class ItemType {

    fun update(item: Item) {
        age(item)
        degrade(item)
    }

    protected open fun age(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    protected open fun degrade(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        }
    }
}

object SULFURAS : ItemType() {
    override fun age(item: Item) {}
    override fun degrade(item: Item) {}
}

object PASS : ItemType() {
    override fun degrade(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
            if (item.sellIn < 10) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
            if (item.sellIn < 5) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
        }
        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality
        }
    }
}

object BRIE : ItemType() {
    override fun degrade(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }
}

object OTHER : ItemType()

fun typeOf(item: Item) = when (item.name) {
    "Sulfuras, Hand of Ragnaros" -> SULFURAS
    "Backstage passes to a TAFKAL80ETC concert" -> PASS
    "Aged Brie" -> BRIE
    else -> OTHER
}
