package io.github.raulcatalinas.easynav_tab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Individual tab item in the bottom navigation bar.
 *
 * This is an internal component used by [EasyTabNav].
 *
 * Compatible with Navigation 3.x - No changes needed.
 *
 * @param tab The tab data
 * @param isSelected Whether this tab is currently selected
 * @param onClick Callback when tab is clicked
 * @param selectedColor Color to use when selected (from tab or style)
 * @param unselectedColor Color to use when not selected (from style)
 */
@Composable
internal fun TabNavigationItem(
    tab: TabItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedColor: Color,
    unselectedColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Icon(
            tab.icon,
            contentDescription = tab.label
        )
        Text(
            text = tab.label,
            color = if (isSelected) selectedColor else unselectedColor,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}