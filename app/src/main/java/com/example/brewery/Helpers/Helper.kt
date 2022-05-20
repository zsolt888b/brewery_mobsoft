package com.example.brewery.Helpers

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Stable
fun Modifier.visible(visibility: Boolean): Modifier {
    if (visibility) {
        return this.then(alpha(1f))
    }
    return this.then(alpha(0f))
}