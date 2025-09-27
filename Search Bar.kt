import java.io.File
import java.io.IOException
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberImagePainter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun main() {
    try {
        File("globals.css").writeText("/* globals.css content */\n")
        println("globals.css created.")
    } catch (e: IOException) {
        System.err.println("Unable to create globals.css")
    }

    try {
        File("styleguide.css").writeText("/* styleguide.css content */\n")
        println("styleguide.css created.")
    } catch (e: IOException) {
        System.err.println("Unable to create styleguide.css")
    }

    try {
        File("style.css").writeText("/* style.css content */\n")
        println("style.css created.")
    } catch (e: IOException) {
        System.err.println("Unable to create style.css")
    }

    println("HTML meta tags are not directly convertible to Kotlin.")
}

fun writeHtmlFile(path: String): Boolean {
    val htmlContent = """
        <!DOCTYPE html>
        <html>
          <body>
            <div class="search-bar">
              <header class="header">
                <div class="rectangle"></div>
                <img class="UU-logo" src="img/UU-logo-1.png" />
                <div class="general-settings">
                  <div class="icon-frame">
                    <img class="base" src="img/base.svg" />
                    <div class="ellipse"></div>
                    <img class="vector" src="img/vector.svg" />
                  </div>
                </div>
                <a href="index.html"
                  ><div class="search">
                    <div class="content">
                      <div class="arrow-backward"><div class="text-wrapper">􀰌</div></div>
                      <p class="placeholder-label"><span class="span">|</span> <span class="text-wrapper-2">Search</span></p>
                    </div>
                  </div></a
                >
              
            </div>
          </body>
        </html>
    """.trimIndent()

    return try {
        val file = File(path)
        file.parentFile?.mkdirs()
        file.writeText(htmlContent)
        true
    } catch (ex: IOException) {
        System.err.println("Exception: ${ex.message}")
        false
    }
}

fun main(args: Array<String>) {
    val outPath = if (args.isNotEmpty()) args[0] else "output.html"

    if (writeHtmlFile(outPath)) {
        println("Successfully wrote HTML to: $outPath")
        println("You can open the file in your browser.")
        kotlin.system.exitProcess(0)
    } else {
        System.err.println("Failed to write HTML file.")
        kotlin.system.exitProcess(1)
    }
}


Box(
    modifier = Modifier
        .size(390.dp, 844.dp)
) {
    Image(
        painter = rememberImagePainter("PATH_TO_IMAGE"),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(0.dp))
            .alpha(0.6f)
    )
    
    Surface(
        modifier = Modifier
            .size(390.dp, 844.dp)
            .border(4.dp, Color(0.6f, 0f, 0f), RoundedCornerShape(0.dp))
    ) {}
}

