package com.gildedrose

class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int,
    private val aging: () -> Int = Aging.standard,
    private val degradation: (Int, Int) -> Int = Degradation.standard,
    private val saturation: (Int) -> Int = Saturation.standard
) {
    fun update() {
        sellIn = sellIn - aging()
        quality = saturation(quality - degradation(sellIn, quality))
    }

    override fun toString() = "$name, $sellIn, $quality"
}

object Aging {
    val standard: () -> Int = { 1 }
    val none: () -> Int = { 0 }
}

object Degradation {
    val standard: (Int, Int) -> Int = { sellIn: Int, quality: Int ->
        when {
            sellIn < 0 -> 2
            else -> 1
        }
    }
    val none: (Int, Int) -> Int = { _, _ -> 0 }
}

object Saturation {
    val standard: (Int) -> Int = { quality: Int ->
        when {
            quality < 0 -> 0
            quality > 50 -> 50
            else -> quality
        }
    }

    val none: (Int) -> Int = { quality: Int -> quality }
}

fun Sulfuras(name: String, sellIn: Int, quality: Int) = Item(
    name,
    sellIn,
    quality,
    aging = Aging.none,
    degradation = Degradation.none,
    saturation = Saturation.none
)

fun Brie(name: String, sellIn: Int, quality: Int) = Item(
    name,
    sellIn,
    quality,
    degradation = Degradation.standard * -1
)

fun Pass(name: String, sellIn: Int, quality: Int) = Item(
    name,
    sellIn,
    quality,
    degradation = { currentSellIn, currentQuality ->
        when {
            currentSellIn < 0 -> currentQuality
            currentSellIn < 5 -> -3
            currentSellIn < 10 -> -2
            else -> -1
        }
    }
)

fun Conjured(name: String, sellIn: Int, quality: Int) = Item(
    name,
    sellIn,
    quality,
    degradation = Degradation.standard * 2
)

operator fun ((Int, Int) -> Int).times(multiplier: Int) = { p1: Int, p2: Int ->
    this(p1, p2) * multiplier
}



