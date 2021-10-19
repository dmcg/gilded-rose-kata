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
        quality = saturation(quality - degradation(sellIn, quality))
    }

    protected open fun degradation(sellIn: Int, quality: Int) = when {
        sellIn < 0 -> 2
        else -> 1
    }

    protected open fun aging() = 1

    protected open fun saturation(quality: Int) = when {
        quality < 0 -> 0
        quality > 50 -> 50
        else -> quality
    }
}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun aging() = 0
    override fun degradation(sellIn: Int, quality: Int) = 0
    override fun saturation(quality: Int) = quality
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun degradation(sellIn: Int, quality: Int) = when {
        sellIn < 0 -> -2
        else -> -1
    }
}

class Pass(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun degradation(sellIn: Int, quality: Int) = when {
        sellIn < 0 -> quality
        sellIn < 5 -> -3
        sellIn < 10 -> -2
        else -> -1
    }
}


