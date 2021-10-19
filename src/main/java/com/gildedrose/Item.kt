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
    quality: Int,
    private val aging: () -> Int = { 1 },
    private val degradation: (Int, Int) -> Int = { sellIn: Int, quality: Int ->
        when {
            sellIn < 0 -> 2
            else -> 1
        }
    },
    private val saturation: (Int) -> Int = { quality: Int ->
        when {
            quality < 0 -> 0
            quality > 50 -> 50
            else -> quality
        }
    }
) : Item(name, sellIn, quality) {

    fun update() {
        sellIn = sellIn - aging()
        quality = saturation(quality - degradation(sellIn, quality))
    }

}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(
    name,
    sellIn,
    quality,
    aging = { 0 },
    degradation = { _, _ -> 0 },
    saturation = { it }
) {
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(
    name,
    sellIn,
    quality,
    degradation = { sellIn, _ ->
        when {
            sellIn < 0 -> -2
            else -> -1
        }
    }
) {
}

class Pass(name: String, sellIn: Int, quality: Int) : BaseItem(
    name,
    sellIn,
    quality,
    degradation = { sellIn, quality ->
        when {
            sellIn < 0 -> quality
            sellIn < 5 -> -3
            sellIn < 10 -> -2
            else -> -1
        }
    }
) {
}


