package com.example.mygitrepos.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mygitrepos.R
import com.example.mygitrepos.databinding.ItemGitRepoBinding
import com.example.mygitrepos.model.GithubResponseItem

class GitRepoAdapter(
    private val mRepoList : ArrayList<GithubResponseItem?>?,
    private val mListener : onClick
) : RecyclerView.Adapter<GitRepoAdapter.ViewHolder>() {

    private var mContext: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val binding = DataBindingUtil.inflate<ItemGitRepoBinding>(
            LayoutInflater.from(parent.context), R.layout.item_git_repo, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mBinding.tvRepoName.text = mRepoList?.get(position)?.name
        holder.mBinding.tvRepoDescription.text = mRepoList?.get(position)?.description
        holder.mBinding.ivShare.setOnClickListener {
            mRepoList?.get(position)?.let {
                mListener.onShared(it)
            }
        }
        holder.mBinding.tvRepoName.setOnClickListener {
            mRepoList?.get(position)?.let {
                mListener.onRepoClick(it)
            }
        }
        holder.mBinding.tvRepoDescription.setOnClickListener {
            holder.mBinding.tvRepoName.performClick()
        }
    }

    override fun getItemCount(): Int {
        return mRepoList?.size ?: 0
    }

    class ViewHolder(val mBinding: ItemGitRepoBinding) : RecyclerView.ViewHolder(
        mBinding.root
    )

    interface onClick{
        fun onShared(repo : GithubResponseItem)
        fun onRepoClick(repo : GithubResponseItem)
    }

}