package io.github.raulcatalinas.easynav_tab

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents a tab in the bottom navigation bar.
 *
 * @param route Unique identifier for this tab
 * @param label Text displayed below the icon
 * @param icon Optional icon displayed in the navigation bar
 * @param screen Composable content for this tab
 */
data class TabItem(
    val route: String,
    val label: String,
    val icon: ImageVector? = null,
    val screen: @Composable () -> Unit
)
