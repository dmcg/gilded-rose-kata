package com.gildedrose

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
