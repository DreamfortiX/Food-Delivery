import android.content.Context
import android.graphics.Bitmap
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap

fun Drawable.applyBlur(context: Context, radius: Float = 70f): Drawable {
    // Convert Drawable to Bitmap
    val bitmap = this.toBitmap()
    val paint = Paint().apply {
        isAntiAlias = true
        maskFilter = BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
    }

    // Create a blurred version of the Bitmap
    val blurredBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
    Canvas(blurredBitmap).apply {
        drawBitmap(bitmap, 0f, 0f, paint)
    }

    // Return a BitmapDrawable created from the blurred Bitmap
    return BitmapDrawable(context.resources, blurredBitmap)
}
