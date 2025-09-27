import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background rectangle
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Gray)
        )
        
        // Header section
        Header(
            onGeneralSettingsClick = {
                // Navigate to index/main screen
                // Intent navigation would be implemented here
            }
        )
        
        // Navigation bar
        NavigationBar()
    }
}

@Composable
fun Header(onGeneralSettingsClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Empty div equivalent
        Spacer(modifier = Modifier.width(16.dp))
        
        // UU Logo
        Image(
            painter = painterResource(id = R.drawable.uu_logo_1),
            contentDescription = "UU Logo",
            modifier = Modifier.size(48.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        // General Settings clickable area
        GeneralSettingsButton(onClick = onGeneralSettingsClick)
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Search component
        SearchComponent()
    }
}

@Composable
fun GeneralSettingsButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        // Icon frame with overlapping elements
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            // Base image
            Image(
                painter = painterResource(id = R.drawable.base),
                contentDescription = "Base",
                modifier = Modifier.fillMaxSize()
            )
            
            // Ellipse (circle)
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
            
            // Vector image
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "Vector",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun SearchComponent() {
    Row(
        modifier = Modifier
            .background(
                Color.LightGray,
                RoundedCornerShape(8.dp)
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Arrow backward
        Text(
            text = "􀰌",
            fontSize = 16.sp,
            modifier = Modifier.padding(end = 8.dp)
        )
        
        // Search placeholder
        Text(
            text = "| Search",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun NavigationBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp)
    ) {
        // Navigation elements positioned absolutely
        // Note: In Compose, absolute positioning is achieved differently
        // Using Box with alignment or custom layout would be needed
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ellipse elements (circles)
            repeat(6) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                )
            }
        }
        
        // Lines (would need custom drawing or vector images)
        Image(
            painter = painterResource(id = R.drawable.line_1),
            contentDescription = "Line 1",
            modifier = Modifier.align(Alignment.CenterStart)
        )
        
        Image(
            painter = painterResource(id = R.drawable.line_2),
            contentDescription = "Line 2",
            modifier = Modifier.align(Alignment.Center)
        )
        
        // Rectangles
        Box(
            modifier = Modifier
                .size(width = 20.dp, height = 8.dp)
                .background(Color.Gray)
                .align(Alignment.CenterEnd)
        )
        
        // Polygons (triangles)
        Image(
            painter = painterResource(id = R.drawable.polygon_1),
            contentDescription = "Polygon 1",
            modifier = Modifier.align(Alignment.BottomStart)
        )
        
        Image(
            painter = painterResource(id = R.drawable.polygon_2),
            contentDescription = "Polygon 2",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        
        Image(
            painter = painterResource(id = R.drawable.polygon_3),
            contentDescription = "Polygon 3",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

// Resource references that would need to be added to res/drawable/
object R {
    object drawable {
        const val uu_logo_1 = 0 // Replace with actual resource ID
        const val base = 1
        const val vector = 2
        const val line_1 = 3
        const val line_2 = 4
        const val polygon_1 = 5
        const val polygon_2 = 6
        const val polygon_3 = 7
    }
}
