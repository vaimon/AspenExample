package me.vaimon.aspenexample.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R


@OptIn(ExperimentalTextApi::class)
val hiatusFontFamily = FontFamily(
    Font(
        R.font.hiatus,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(400)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val montserratLightFontFamily = FontFamily(
    Font(
        R.font.montserrat,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(450)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val montserratRegularFontFamily = FontFamily(
    Font(
        R.font.montserrat,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(500)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val montserratBoldFontFamily = FontFamily(
    Font(
        R.font.montserrat,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(600)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val montserratExtraBoldFontFamily = FontFamily(
    Font(
        R.font.montserrat,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(700)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val figtreeLightFontFamily = FontFamily(
    Font(
        R.font.figtree,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(400)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val figtreeRegularFontFamily = FontFamily(
    Font(
        R.font.figtree,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(450)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val figtreeBoldFontFamily = FontFamily(
    Font(
        R.font.figtree,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(500)
        )
    )
)

@OptIn(ExperimentalTextApi::class)
val figtreeBlackFontFamily = FontFamily(
    Font(
        R.font.figtree,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(700)
        )
    )
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = hiatusFontFamily,
        fontSize = 116.sp,
        letterSpacing = (8.5 / 116).em,
        lineHeight = 127.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = montserratRegularFontFamily,
        fontSize = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = montserratBoldFontFamily,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = figtreeBlackFontFamily,
        fontSize = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = figtreeLightFontFamily,
        fontSize = 12.sp,
        color = DarkGray
    ),
    bodySmall = TextStyle(
        fontFamily = figtreeLightFontFamily,
        fontSize = 13.sp,
        color = Gray
    ),
)

val Typography.headlineLargeSecondary: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = montserratLightFontFamily,
            fontSize = 24.sp
        )
    }

val Typography.labelSmallVariant: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = figtreeBoldFontFamily,
            fontSize = 12.sp
        )
    }

val Typography.labelSmallChip: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = figtreeRegularFontFamily,
            fontSize = 12.sp
        )
    }