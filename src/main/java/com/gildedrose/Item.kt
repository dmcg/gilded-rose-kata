package com.gildedrose

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString() = "$name, $sellIn, $quality"
}

open class BaseItem(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {

    fun update() {
        sellIn = sellIn - aging()
        degrade()
        saturate()
    }

    protected open fun degrade() {
        if (sellIn < 0)
            quality = quality - 2
        else
            quality = quality - 1
    }

    protected open fun aging() = 1

    protected open fun saturate() {
        when {
            quality < 0 -> quality = 0
            quality > 50 -> quality = 50
        }
    }
}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun aging() = 0
    override fun degrade() {}
    override fun saturate() {}
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun degrade() {
        if (sellIn < 0)
            quality = quality + 2
        else
            quality = quality + 1
    }
}

class Pass(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun degrade() {
        quality = when {
            sellIn < 0 -> 0
            sellIn < 5 -> quality + 3
            sellIn < 10 -> quality + 2
            else -> quality + 1
        }
    }
}


