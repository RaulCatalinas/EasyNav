package io.github.raulcatalinas.easynav_tab

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * Individual tab item in the bottom navigation bar.
 *
 * This is an internal component used by [EasyTabNav].
 * Supports tabs with or without icons.
 *
 * @param tab The tab data
 * @param isSelected Whether this tab is currently selected
 * @param onClick Callback when tab is clicked
 * @param selectedColor Color to use when selected (from tab or style)
 * @param unselectedColor Color to use when not selected (from style)
 * @param modifier Optional modifier
 */
@Composable
internal fun TabNavigationItem(
    tab: TabItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedColor: Color,
    unselectedColor: Color,
    modifier: Modifier = Modifier
) {
    val color = if (isSelected) selectedColor else unselectedColor
    val interactionSource = remember { MutableInteractionSource() }

    CompositionLocalProvider(LocalContentColor provides color) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .selectable(
                    selected = isSelected,
                    onClick = onClick,
                    enabled = true,
                    role = Role.Tab,
                    interactionSource = interactionSource,
                    indication = ripple()
                )
                .padding(vertical = 8.dp, horizontal = 4.dp)
                .height(64.dp)
        ) {
            tab.icon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = tab.label,
                    tint = color
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

            Text(
                text = tab.label,
                color = color,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}