import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery.OnboardingItem
import com.example.food_delivery.R
import com.google.android.material.button.MaterialButton

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
        private val bottomButton: MaterialButton = itemView.findViewById(R.id.bottomButton)

        fun bind(item: OnboardingItem, position: Int) {
            onboardingImage.setImageResource(item.image)
            onboardingImage.setImageResource(item.image)
            onboardingTitle.text = item.title
            onboardingDescription1.text = item.description1
            onboardingDescription2.text = item.description2
            onboardingDescription3.text = item.description3
            onboardingDescriptionDetail.text = item.detailDescription

            bottomButton.text = if (position == items.size - 1) "Next" else "Get Started"
            bottomButton.setOnClickListener {
                if (position < items.size - 1) {
                    onPageChange(position + 1) // Notify the activity to go to the next page
                } else {
                    // Handle the completion of onboarding (e.g., start a new activity)
                    // For example:
                    // startActivity(Intent(context, MainActivity::class.java))
                    // finish()
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
