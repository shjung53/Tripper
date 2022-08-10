package com.example.tripper.ui.main.home
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tripper.FeedData
import com.example.tripper.R
import com.example.tripper.databinding.ItemFeedBinding

class HomeFeedRVAdapter(val context: Context) : ListAdapter<FeedData, HomeFeedRVAdapter.ViewHolder>(diffUtil) {

    interface FeedClickListener{
        fun profileClick(holder: ViewHolder)
        fun feedClick(holder: ViewHolder)
        fun likeClick(holder: ViewHolder)
    }

    private lateinit var feedClickListener: FeedClickListener

    fun setFeedClickListener(pFeedClickListener: FeedClickListener){
        feedClickListener = pFeedClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFeedBinding = ItemFeedBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeFeedRVAdapter.ViewHolder, position: Int) {
        val feedData = getItem(position) as FeedData
        holder.bind(feedData)
        feedClickListener.likeClick(holder)
    }


    inner class ViewHolder(private val binding: ItemFeedBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(feedData: FeedData){

//            뷰홀더 세팅
            binding.itemFeedTitleTv.text = feedData.title
            binding.itemFeedIdTv.text = feedData.nickName
            Glide.with(binding.itemFeedPictureIv).load(feedData.thumImgUrl)
                .apply(RequestOptions.centerCropTransform()).into(binding.itemFeedPictureIv)
            Glide.with(binding.itemFeedProfileCiv).load(feedData.profileImgUrl)
                .apply(RequestOptions.centerCropTransform()).into(binding.itemFeedProfileCiv)
            binding.itemFeedHashtagTv.text = feedData.travelHashtag
            when (feedData.travelScore) {
                "별로에요" -> {
                    binding.itemFeedScoreIv.setImageResource(R.drawable.ic_verybad_29dp)
                    binding.itemFeedScoreTv.text = "별로에요"
                    binding.itemFeedScoreTv.setTextColor(ContextCompat.getColor(context, R.color.main))
                }
                "도움되지 않았어요" -> {
                    binding.itemFeedScoreIv.setImageResource(R.drawable.ic_bad_29dp)
                    binding.itemFeedScoreTv.text = "도움되지 않았어요"
                    binding.itemFeedScoreTv.setTextColor(ContextCompat.getColor(context, R.color.main))
                }
                "그저 그래요" -> {
                    binding.itemFeedScoreIv.setImageResource(R.drawable.ic_nomal_29dp)
                    binding.itemFeedScoreTv.text = "그저 그래요"
                    binding.itemFeedScoreTv.setTextColor(ContextCompat.getColor(context, R.color.main))
                }
                "도움되었어요!" -> {
                    binding.itemFeedScoreIv.setImageResource(R.drawable.ic_good_29dp)
                    binding.itemFeedScoreTv.text = "도움되었어요!"
                    binding.itemFeedScoreTv.setTextColor(ContextCompat.getColor(context, R.color.main))
                }
                "최고의 여행!" -> {
                    binding.itemFeedScoreIv.setImageResource(R.drawable.ic_verygood_29dp)
                    binding.itemFeedScoreTv.text = "최고의 여행!"
                    binding.itemFeedScoreTv.setTextColor(ContextCompat.getColor(context, R.color.main))
                }
            }

            if (feedData.myLikeStatus == "좋아요 하는중"){
                binding.itemFeedHeartOffIv.visibility = View.GONE
                binding.itemFeedHeartOnIv.visibility = View.VISIBLE
            } else {
                binding.itemFeedHeartOffIv.visibility = View.VISIBLE
                binding.itemFeedHeartOnIv.visibility = View.GONE
            }

//            뷰홀더 클릭리스너
            binding.itemFeedProfileCiv.setOnClickListener{
                feedClickListener.profileClick(this)
            }
            binding.itemFeedCv.setOnClickListener{
                feedClickListener.feedClick(this)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FeedData>() {

            //            같은 아이템인지 체크
            override fun areItemsTheSame(oldItem: FeedData, newItem: FeedData): Boolean {
                return oldItem.createdAt == newItem.createdAt
            }

            //            같은 내용인지 체크 위에서 true로 통과하면 실행
            override fun areContentsTheSame(oldItem: FeedData, newItem: FeedData): Boolean {
                return oldItem == newItem
            }
        }

    }

}