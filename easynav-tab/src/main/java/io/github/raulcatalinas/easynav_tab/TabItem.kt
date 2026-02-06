package io.github.raulcatalinas.easynav_tab

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents a tab in the bottom navigation bar.
 *
 * @param route Unique identifier for this tab
 * @param label Text displayed below the icon
 * @param icon Icon displayed in the navigation bar
 * @param selectedTint Optional color when tab is selected (uses theme default if null)
 * @param screen Composable content for this tab
 */
data class TabItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val selectedTint: Color? = null,
    val screen: @Composable () -> Unit
)
