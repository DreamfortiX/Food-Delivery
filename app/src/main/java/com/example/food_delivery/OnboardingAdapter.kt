import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery.MainActivity
import com.example.food_delivery.OnboardingItem
import com.example.food_delivery.R

class OnboardingAdapter(
    private val items: List<OnboardingItem>,
    private val onPageChange: (Int) -> Unit // Function to notify page changes
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val onboardingImage: ImageView = itemView.findViewById(R.id.onboardingImage)
        private val onboardingTitle: TextView = itemView.findViewById(R.id.onboardingTitle)
        private val onboardingDescription1: TextView = itemView.findViewById(R.id.onboardingDescription1)
        private val onboardingDescription2: TextView = itemView.findViewById(R.id.onboardingDescription2)
        private val onboardingDescription3: TextView = itemView.findViewById(R.id.onboardingDescription3)
        private val onboardingDescriptionDetail: TextView = itemView.findViewById(R.id.onboardingDescriptionDetail)
        private val bottomButton: AppCompatButton = itemView.findViewById(R.id.bottomButton)
        private val backButton: AppCompatButton = itemView.findViewById(R.id.backButton)
        private val desLayout: LinearLayout = itemView.findViewById(R.id.des_layout)
        private val view: View = itemView.findViewById(R.id.view)

        fun bind(item: OnboardingItem, position: Int) {
            onboardingImage.setImageResource(item.image)
            onboardingTitle.text = item.title
            onboardingDescription1.text = item.description1
            onboardingDescription2.text = item.description2
            onboardingDescription3.text = item.description3
            onboardingDescriptionDetail.text = item.detailDescription

            // Set button text and visibility
            bottomButton.text = when (position) {
                0 -> "Get Started"
                1 -> "Next"
                else -> "Get Started"
            }

            // Control visibility based on position (only show details and buttons on the second screen)
            if (position == 1) {
                desLayout.visibility = View.GONE
                onboardingDescription1.visibility = View.GONE
                onboardingDescription2.visibility = View.GONE
                onboardingDescription3.visibility = View.GONE
                onboardingDescriptionDetail.visibility = View.VISIBLE
                backButton.visibility = View.VISIBLE
                view.visibility = View.GONE
                bottomButton.visibility = View.VISIBLE
            }

            if (position == 0) {
                onboardingDescriptionDetail.textSize = 22f
            }

            if (position == 2) {
                desLayout.visibility = View.GONE
                onboardingDescription1.visibility = View.GONE
                onboardingDescription2.visibility = View.GONE
                onboardingDescription3.visibility = View.GONE
                onboardingDescriptionDetail.visibility = View.VISIBLE
                bottomButton.visibility = View.VISIBLE
                view.visibility = View.GONE
            }

            // Set button click actions
            bottomButton.setOnClickListener {
                if (position < items.size - 1) {
                    onPageChange(position + 1)
                } else {
                    // Navigate to MainActivity
                    val context = itemView.context // Get context from the itemView
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
            }

            backButton.setOnClickListener {
                if (position > 0) {
                    onPageChange(position - 1)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
}
